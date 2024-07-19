package com.xillinha.meuslivros.model;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, String> {

    public Categoria findByNome(String nome);

}
