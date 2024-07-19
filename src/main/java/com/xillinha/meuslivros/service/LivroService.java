package com.xillinha.meuslivros.service;

import com.xillinha.meuslivros.model.LivroAcervo;

import java.util.List;

public interface LivroService {

    List<LivroAcervo> buscarTitulo(String titulo);

    void inserirDoGoogle(String id);

    void inserir(LivroAcervo livro);

    Iterable<LivroAcervo> buscarTodos();

    LivroAcervo buscarPorId(String id);

    void atualizar(String id, LivroAcervo livro);

    void deletar(String id);
}
