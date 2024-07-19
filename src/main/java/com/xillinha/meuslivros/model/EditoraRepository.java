package com.xillinha.meuslivros.model;

import org.springframework.data.repository.CrudRepository;

public interface EditoraRepository extends CrudRepository<Editora, String> {

    public Editora findByNome(String nome);

}
