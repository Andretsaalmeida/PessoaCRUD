package edu.pessoa.api.service;


import edu.pessoa.api.domain.DadosAtualizacaoPessoa;
import edu.pessoa.api.domain.DadosCadastroPessoa;
import edu.pessoa.api.model.Pessoa;
import edu.pessoa.api.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa create(DadosCadastroPessoa dados) {
        Pessoa pessoa = new Pessoa(dados);
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> findAll() {return pessoaRepository.findAll();}

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
    }
    // A classe `EntityNotFoundException` está disponível no Spring Data.


    public void deleteById(Long id) {
        pessoaRepository.deleteById(id);
    }


    public Pessoa update(Long id, DadosAtualizacaoPessoa dados) {
        Pessoa pessoa = findById(id);
        pessoa.atualizarInformacoes(dados);
        return pessoaRepository.save(pessoa);
    }

}

