package br.com.lacoos.service;

import br.com.lacoos.api.request.LoginRequest;
import br.com.lacoos.api.request.PasswordRecoverRequest;
import br.com.lacoos.api.request.UserRequest;
import br.com.lacoos.api.response.DefaultMessageResponse;
import br.com.lacoos.api.response.TokenResponse;
import br.com.lacoos.infra.exceptions.InvalidParamsException;
import br.com.lacoos.model.PasswordResetTokenModel;
import br.com.lacoos.model.UserModel;
import br.com.lacoos.repository.PasswordResetTokenRepository;
import br.com.lacoos.repository.UserRepository;
import br.com.lacoos.utils.ApplicationUtils;
import br.com.lacoos.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final AuthenticationManager manager;
    private final TokenService tokenService;
    private PasswordResetTokenRepository passwordResetTokenRepository;
    private final EmailService emailService;

    public ResponseEntity<Void> signUp(UserRequest userRequest) {
        log.info("Save user: {}", userRequest);
        if (userRepository.existsByEmailOrCpf(userRequest.getEmail(), userRequest.getCpf())) {
            log.error("Email or CPF already exists");
            throw new InvalidParamsException("Email or CPF already exists");
        }
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userRequest, user);
        user.setBirthDate(DateUtils.parseLocalDate(userRequest.getBirthDate()));
        user.setPassword(encoder.encode(userRequest.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<TokenResponse> login(LoginRequest loginRequest) {
        log.info("Login user: {}", loginRequest);
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication auth = manager.authenticate(userToken);
        String token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(new TokenResponse(token));
    }

    public ResponseEntity<String> recoverPassword(String email) {
        log.info("Recover password for email: {}", email);
        Optional<UserModel> user = userRepository.byEmail(email);
        if (user.isPresent()) {
            log.info("User found: {}", user.get());
            PasswordResetTokenModel passwordResetToken = PasswordResetTokenModel.builder()
                    .token(UUID.randomUUID().toString())
                    .user(user.get())
                    .expiryDate(LocalDateTime.now())
                    .build();
            passwordResetTokenRepository.save(passwordResetToken);
            emailService.sendEmail(user.get(), "http://localhost:3000/resetar-senha/#/" + passwordResetToken.getToken());
            return ResponseEntity.ok().build();
        }
        log.error("User not found for email: {}", email);
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<DefaultMessageResponse> resetPassword(String token, PasswordRecoverRequest password) {
        log.info("Reset password for token: {}", token);
        Optional<PasswordResetTokenModel> passwordResetToken = passwordResetTokenRepository.findByToken(token);
        if (passwordResetToken.isPresent()) {
            //  && !passwordResetToken.get().getUsed() => TIREI DO IF - FUNFOU
            log.info("Token found: {}", passwordResetToken.get());
            LocalDateTime tokenCreationTime = passwordResetToken.get().getExpiryDate();
            LocalDateTime expirationTime = tokenCreationTime.plusHours(24);
            if (expirationTime.isBefore(LocalDateTime.now())) {
                log.error("Token expired");
                return ResponseEntity.badRequest().body(new DefaultMessageResponse("Token expired"));
            }
            if (!password.getPassword().equals(password.getConfirmPassword())) {
                log.error("Password and confirm password not match");
                return ResponseEntity.badRequest().body(new DefaultMessageResponse("Password and confirm password not match"));
            }
            UserModel user = passwordResetToken.get().getUser();
            user.setPassword(encoder.encode(password.getPassword()));
            userRepository.save(user);
            passwordResetToken.get().setUsed(true);
            return ResponseEntity.ok().body(new DefaultMessageResponse("Password updated successfully"));
        }
        log.error("Token not found");
        return ResponseEntity.badRequest().body(new DefaultMessageResponse("Recover password token not found"));
    }

    public Optional<UserModel> getUserById(Long id){
        log.info("Usuário encontrado, {}", id);
        return userRepository.findById(id);
    }

}