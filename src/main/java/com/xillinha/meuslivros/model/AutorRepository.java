package com.xillinha.meuslivros.model;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, String> {

    public Autor findByNome(String nome);
}
