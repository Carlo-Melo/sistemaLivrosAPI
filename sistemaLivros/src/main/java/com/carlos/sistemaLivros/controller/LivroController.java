package com.carlos.sistemaLivros.controller;

import com.carlos.sistemaLivros.entity.Livro;
import com.carlos.sistemaLivros.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return livroService.cadastrarLivro(livro);
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(Long id) {
        return livroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable("id") @RequestBody Long id, String titulo, String autor, String anoPublicacao, String editora ) {
        Livro atualizarLivro = livroService.atualizarLivro(id, titulo, autor , anoPublicacao, editora);
        return new ResponseEntity<>(atualizarLivro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deleteProduto(@PathVariable Livro livro) {
        livroService.deletarLivro(livro);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }






}
