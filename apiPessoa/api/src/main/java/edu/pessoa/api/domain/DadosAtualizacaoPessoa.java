package edu.pessoa.api.domain;


import edu.pessoa.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPessoa(

        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco){
}

