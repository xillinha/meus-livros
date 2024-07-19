package com.xillinha.meuslivros.controller;

import com.xillinha.meuslivros.model.LivroAcervo;
import com.xillinha.meuslivros.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Operation(
            summary = "Buscar livro na base do Google Books",
            description = "Buscar os 40 primeiros registros na base do Google Books por título")
    @GetMapping("/google/{titulo}")
    public ResponseEntity<List<LivroAcervo>> buscarTitulosGoogle(@PathVariable String titulo) {
        return ResponseEntity.ok(livroService.buscarTitulo(titulo));
    }

    @Operation(
            summary = "Inserir livro",
            description = "Inserir um livro da base do Google Books no acervo pessoal")
    @PostMapping("/{id}")
    public ResponseEntity<Void> inserir(@PathVariable String id) {
        livroService.inserirDoGoogle(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Listar todos os livros",
            description = "Listar todos os livros cadastrados no acervo pessoal")
    @GetMapping
    public ResponseEntity<Iterable<LivroAcervo>> buscarTodos() {
        return ResponseEntity.ok(livroService.buscarTodos());
    }

    @Operation(
            summary = "Buscar livro por id",
            description = "Buscar livro por id no acervo pessoal")
    @GetMapping("/{id}")
    public ResponseEntity<LivroAcervo> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @Operation(
            summary = "Atualizar livro",
            description = "Atualizar livro no acervo pessoal")
    @PutMapping("/{id}")
    public ResponseEntity<LivroAcervo> atualizar(@PathVariable String id, @RequestBody LivroAcervo livro) {
        livroService.atualizar(id, livro);
        return ResponseEntity.ok(livro);
    }

    @Operation(
            summary = "Apagar livro",
            description = "Apagar livro no acervo pessoal")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
