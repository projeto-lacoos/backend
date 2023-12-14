package br.com.lacoos.api.controller;

import br.com.lacoos.api.request.PagamentoRequest;
import br.com.lacoos.service.PagamentoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pag")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PostMapping("/sign-up/pag")
    public ResponseEntity<Void> signUpPag(@RequestBody @Valid PagamentoRequest pagamentoRequest){
        return pagamentoService.signUpPag(pagamentoRequest);
    }

}