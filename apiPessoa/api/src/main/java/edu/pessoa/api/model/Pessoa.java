package edu.pessoa.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.pessoa.api.domain.DadosAtualizacaoPessoa;
import edu.pessoa.api.domain.DadosCadastroPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @NotBlank
    private String cpf;
    @Embedded
    private Endereco endereco;
    @JsonIgnore
    private Boolean ativo;

   /* @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<contato> contatos = new ArrayList<>();*/


    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.cpf= dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public Pessoa(String nome) {
    }

    public void atualizarInformacoes(DadosAtualizacaoPessoa dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if( dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}

