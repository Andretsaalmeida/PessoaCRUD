package edu.pessoa.api.domain;

import edu.pessoa.api.model.Endereco;
import edu.pessoa.api.model.Pessoa;

public record DadosDetalhamentoPessoa(Long id, String nome, String cpf, Endereco endereco){

    public DadosDetalhamentoPessoa(Pessoa pessoa) {
        this(pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getEndereco());
    }
}
