package edu.pessoa.api.domain;

import edu.pessoa.api.model.Pessoa;

public record DadosListagemPessoa(Long id, String nome){
    public DadosListagemPessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome());
    }
}

