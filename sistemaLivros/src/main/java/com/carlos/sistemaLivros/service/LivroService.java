package com.carlos.sistemaLivros.service;


import com.carlos.sistemaLivros.entity.Livro;
import com.carlos.sistemaLivros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;


    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
    }

    public Livro atualizarLivro(Long id, String titulo, String autor, String anoPublicacao, String editora ) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(anoPublicacao);
        livro.setEditora(editora);
        return livroRepository.save(livro);
    }

    public void deletarLivro(Livro livro) {
        livroRepository.delete(livro);
    }
}
