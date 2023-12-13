package br.com.lacoos.api.controller;

import br.com.lacoos.api.request.FormRequest;
import br.com.lacoos.service.FormService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/form")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class FormController {

    // private final UserService userService;
    private final FormService formService;

    @PostMapping("/sign-up/form")
    public ResponseEntity<Void> signUp(@RequestBody @Valid FormRequest formRequest) {
        return formService.signUpForm(formRequest);
    }
}