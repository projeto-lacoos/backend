package br.com.lacoos.service;

import br.com.lacoos.api.request.FormRequest;
import br.com.lacoos.model.FormModel;
import br.com.lacoos.repository.FormRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FormService {

    private final FormRepository formRepository;

    public ResponseEntity<Void> signUpForm(FormRequest formRequest){
        log.info("Save form: {}", formRequest);
        FormModel formModel = new FormModel();
        BeanUtils.copyProperties(formRequest, formModel);
        formRepository.save(formModel);
        return ResponseEntity.ok().build();
    }


}