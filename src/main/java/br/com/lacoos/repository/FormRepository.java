package br.com.lacoos.repository;

import br.com.lacoos.model.FormModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<FormModel, Long> {
}