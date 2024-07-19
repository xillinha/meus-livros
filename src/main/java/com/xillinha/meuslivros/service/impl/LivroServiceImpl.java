package com.xillinha.meuslivros.service.impl;

import com.xillinha.meuslivros.model.*;
import com.xillinha.meuslivros.service.GoogleBooksService;
import com.xillinha.meuslivros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroAcervoRepository livroAcervoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @Autowired
    private GoogleBooksService googleBooksService;

    @Override
    public List<LivroAcervo> buscarTitulo(String titulo) {

        LivroDTO livroDTO = googleBooksService.consultarTitulo(titulo);

        List<LivroAcervo> livros = new ArrayList<>();

        for (Item item : livroDTO.getItems()) {
            LivroAcervo livro = new LivroAcervo();

            livro.setId(item.getId());
            livro.setTitulo(item.getVolumeInfo().getTitle());
            if (item.getVolumeInfo().getSubtitle() != null)
                livro.setSubtitulo(item.getVolumeInfo().getSubtitle());
            if (item.getVolumeInfo().getDescription() != null)
                livro.setDescricao(item.getVolumeInfo().getDescription());
            if (item.getVolumeInfo().getPageCount() != null)
                livro.setQtdePaginas(item.getVolumeInfo().getPageCount());
            if (item.getVolumeInfo().getPublisher() != null)
                livro.setEditora(new Editora(item.getVolumeInfo().getPublisher()));

            if (item.getVolumeInfo().getIndustryIdentifiers() != null) {
                for (IndustryIdentifier iden : item.getVolumeInfo().getIndustryIdentifiers()) {
                    if (iden.getType().equals("ISBN_10")) {
                        livro.setIsbn10(iden.getIdentifier());
                    } else if (iden.getType().equals("ISBN_13")) {
                        livro.setIsbn13(iden.getIdentifier());
                    }

                }
            }

            List<Autor> autores = null;

            if (item.getVolumeInfo().getAuthors() != null) {
                autores = new ArrayList<>();

                for (String nomeAutor : item.getVolumeInfo().getAuthors()) {


                    autores.add(new Autor(nomeAutor));

                }
            }

            livro.setAutores(autores);

            List<Categoria> categorias = null;

            if (item.getVolumeInfo().getCategories() != null) {
                categorias = new ArrayList<>();

                for (String nomeCategoria : item.getVolumeInfo().getCategories()) {
                    categorias.add(new Categoria(nomeCategoria));
                }
            }

            livro.setCategorias(categorias);

            livros.add(livro);
        }

        return livros;
    }

    @Override
    public void inserirDoGoogle(String id) {
        InfoLivro infoLivro = googleBooksService.consultarPorId(id);

        LivroAcervo livro = new LivroAcervo();

        livro.setId(infoLivro.getId());
        livro.setTitulo(infoLivro.getVolumeInfo().getTitle());
        if (infoLivro.getVolumeInfo().getSubtitle() != null)
            livro.setSubtitulo(infoLivro.getVolumeInfo().getSubtitle());
        if (infoLivro.getVolumeInfo().getDescription() != null)
            livro.setDescricao(infoLivro.getVolumeInfo().getDescription());
        if (infoLivro.getVolumeInfo().getPageCount() != null)
            livro.setQtdePaginas(infoLivro.getVolumeInfo().getPageCount());
        if (infoLivro.getVolumeInfo().getPublisher() != null) {
            String nomeEditora = infoLivro.getVolumeInfo().getPublisher();
            Editora editora = editoraRepository.findByNome(nomeEditora);
            if (editora == null) {
                editora = new Editora(nomeEditora);
                editoraRepository.save(editora);
            }

            livro.setEditora(editora);
        }

        if (infoLivro.getVolumeInfo().getIndustryIdentifiers() != null) {
            for (IndustryIdentifier iden : infoLivro.getVolumeInfo().getIndustryIdentifiers()) {
                if (iden.getType().equals("ISBN_10")) {
                    livro.setIsbn10(iden.getIdentifier());
                } else if (iden.getType().equals("ISBN_13")) {
                    livro.setIsbn13(iden.getIdentifier());
                }

            }
        }

        List<Autor> autores = null;

        if (infoLivro.getVolumeInfo().getAuthors() != null) {
            autores = new ArrayList<>();

            for (String nomeAutor : infoLivro.getVolumeInfo().getAuthors()) {
                Autor autor = autorRepository.findByNome(nomeAutor);
                if (autor == null) {
                    autor = new Autor(nomeAutor);
                    autorRepository.save(autor);
                }

                autores.add(autor);
            }
        }

        livro.setAutores(autores);

        List<Categoria> categorias = null;

        if (infoLivro.getVolumeInfo().getCategories() != null) {
            categorias = new ArrayList<>();

            for (String nomeCategoria : infoLivro.getVolumeInfo().getCategories()) {
                Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
                if (categoria == null) {
                    categoria = new Categoria(nomeCategoria);
                    categoriaRepository.save(categoria);
                }

                categorias.add(categoria);
            }
        }

        livro.setCategorias(categorias);

        livroAcervoRepository.save(livro);
    }

    @Override
    public void inserir(LivroAcervo livro) {
        livroAcervoRepository.save(livro);
    }

    @Override
    public Iterable<LivroAcervo> buscarTodos() {
        return livroAcervoRepository.findAll();
    }

    @Override
    public LivroAcervo buscarPorId(String id) {
        Optional<LivroAcervo> livro = livroAcervoRepository.findById(id);
        return livro.get();
    }

    @Override
    public void atualizar(String id, LivroAcervo livro) {
        Optional<LivroAcervo> livroLocalizado = livroAcervoRepository.findById(id);
        if (livroLocalizado.isPresent()) {
            inserir(livro);
        }
    }

    @Override
    public void deletar(String id) {
        livroAcervoRepository.deleteById(id);
    }
}
