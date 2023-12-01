package br.com.lacoos.api.controller;

import br.com.lacoos.api.request.EmailRequest;
import br.com.lacoos.api.request.PasswordRecoverRequest;
import br.com.lacoos.api.response.DefaultMessageResponse;
import br.com.lacoos.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/recover-password")
    public ResponseEntity<String> recoverPassword(@RequestBody EmailRequest emailRequest){
        log.info("Recover password for email: {}", emailRequest.getEmail());
        return userService.recoverPassword(emailRequest.getEmail());
    }

    @PatchMapping("/reset-password/{token}")
    public ResponseEntity<DefaultMessageResponse> resetPassword(@PathVariable String token, @RequestBody PasswordRecoverRequest password){
        log.info("Reset password for token: {}", token);
        return userService.resetPassword(token, password);
    }

}