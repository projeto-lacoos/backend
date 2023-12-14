package br.com.lacoos.repository;

import br.com.lacoos.model.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long> {
}
