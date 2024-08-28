package edu.pessoa.api.controller;

import edu.pessoa.api.domain.DadosAtualizacaoPessoa;
import edu.pessoa.api.domain.DadosCadastroPessoa;
import edu.pessoa.api.model.Pessoa;
import edu.pessoa.api.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;


    // Método para criar uma nova pessoa
    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody DadosCadastroPessoa dados) {
        Pessoa pessoaCriada = pessoaService.create(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCriada);
    }

    // Método para listar todas as pessoas
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    // Método para buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

   // Método para atualizar uma pessoa pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody DadosAtualizacaoPessoa dados) {
        Pessoa pessoaAtualizada = pessoaService.update(id, dados);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    // Método para deletar uma pessoa pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
