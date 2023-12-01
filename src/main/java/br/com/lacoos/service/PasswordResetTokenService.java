package br.com.lacoos.service;

import br.com.lacoos.model.PasswordResetTokenModel;
import br.com.lacoos.repository.PasswordResetTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Slf4j
@Service
public class PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public ResponseEntity<Boolean> isTokenValid(String token){
        log.info("Check if token is valid: {}", token);
        PasswordResetTokenModel passwordResetTokenModel = passwordResetTokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Token not found"));
        LocalDateTime tokenCreationTime = passwordResetTokenModel.getExpiryDate();
        LocalDateTime expirationTime = tokenCreationTime.plusHours(24);
        if (expirationTime.isBefore(LocalDateTime.now())){
            log.error("Token expired!");
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

}