package edu.pessoa.api.repository;

import edu.pessoa.api.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByAtivoTrue(Pageable paginacao);
    Pessoa findByIdAndAtivoTrue (Long id);
}
