package br.com.lacoos.service;

import br.com.lacoos.api.request.PagamentoRequest;
import br.com.lacoos.model.PagamentoModel;
import br.com.lacoos.repository.PagamentoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    public ResponseEntity<Void> signUpPag(PagamentoRequest pagamentoRequest){
        log.info("Save pag: {}", pagamentoRequest);
        PagamentoModel pagamentoModel = new PagamentoModel();
        BeanUtils.copyProperties(pagamentoRequest, pagamentoModel);
        pagamentoRepository.save(pagamentoModel);
        return ResponseEntity.ok().build();
    }
}