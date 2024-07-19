package com.xillinha.meuslivros.service;

import com.xillinha.meuslivros.model.InfoLivro;
import com.xillinha.meuslivros.model.LivroDTO;

public interface GoogleBooksService {

    LivroDTO consultarTitulo(String titulo);

    InfoLivro consultarPorId(String id);
}
