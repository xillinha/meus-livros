package com.xillinha.meuslivros.service.impl;

import com.xillinha.meuslivros.model.InfoLivro;
import com.xillinha.meuslivros.model.LivroDTO;
import com.xillinha.meuslivros.service.GoogleBooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleBooksServiceImpl implements GoogleBooksService {

    @Override
    public LivroDTO consultarTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + titulo + "&maxResults=40";

        //buscando os 40 primeiros livros localzidos
        ResponseEntity<LivroDTO> responseEntity = restTemplate.getForEntity(endereco, LivroDTO.class );

        return responseEntity.getBody();
    }

    @Override
    public InfoLivro consultarPorId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String endereco = "https://www.googleapis.com/books/v1/volumes/" + id;

        //buscando o livro do id
        ResponseEntity<InfoLivro> responseEntity = restTemplate.getForEntity(endereco, InfoLivro.class );

        return responseEntity.getBody();
    }

}
