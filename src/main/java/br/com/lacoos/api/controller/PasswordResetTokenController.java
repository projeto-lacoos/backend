package br.com.lacoos.api.controller;

import br.com.lacoos.service.PasswordResetTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/password-reset-token")
@AllArgsConstructor
@Slf4j
public class PasswordResetTokenController {

    private final PasswordResetTokenService passwordResetTokenService;

    @GetMapping("/is-valid/{token}")
    public ResponseEntity<Boolean> isTokenValid(@RequestParam String token){
        log.info("Check if token is valid: {}", token);
        return passwordResetTokenService.isTokenValid(token);
    }

}