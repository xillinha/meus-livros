package com.xillinha.meuslivros.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroAcervoRepository extends CrudRepository<LivroAcervo, String> {

}
