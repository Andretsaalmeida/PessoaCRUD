package edu.pessoa.api.domain.endereco;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DadosEndereco(
        @NotBlank
        @Size(min = 3) // Adiciona validação para o logradouro não ser apenas espaços
        String logradouro,
        @Positive
        Integer numero,
        @NotBlank
        @Pattern(regexp = "\\d{2}[.]\\d{3}[-]\\d{3}")
        String cep,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank

        String estado,
        @Nullable //Indica que o complemento é opcional e pode ser omitido
        String complemento) {
}
