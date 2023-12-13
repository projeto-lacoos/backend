package br.com.lacoos.service;

import br.com.lacoos.model.FormModel;
import br.com.lacoos.model.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TokenService {

    private String password = "SENHASUPERSECRETA";

    public String generateToken(UserModel userModel){
        try {
            var algoritimo = Algorithm.HMAC256(password);
            return JWT.create()
                    .withIssuer("Lacoos")
                    .withClaim("id", userModel.getId())
                    .withClaim("name", userModel.getName())
                    .withClaim("email", userModel.getEmail())
                    .withClaim("phone", userModel.getPhone())
                    // .withClaim("birth_date", userModel.getBirthDate()
                    .withExpiresAt(expirationDate())
                    .sign(algoritimo);
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar o token jwt", e);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256(password);
            return JWT.require(algorithm)
                    .withIssuer("Lacoos")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Token Invalido ou Expirado");
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    
}
