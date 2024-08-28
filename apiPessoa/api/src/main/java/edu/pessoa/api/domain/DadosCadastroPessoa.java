package edu.pessoa.api.domain;
import edu.pessoa.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(

        @NotBlank
        String nome,
        @NotBlank
        String cpf,

        @NotNull @Valid DadosEndereco endereco) {
}

