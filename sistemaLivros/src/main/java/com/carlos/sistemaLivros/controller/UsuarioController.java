package com.carlos.sistemaLivros.controller;

import com.carlos.sistemaLivros.entity.Usuario;
import com.carlos.sistemaLivros.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Long id, @RequestBody String nome, Long matricula, String curso) {
        Usuario atualizarUsuario = usuarioService.atualizarUsuario(id, nome, matricula, curso);
        return new ResponseEntity<>(atualizarUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteProduto(@PathVariable Usuario usuario) {
        usuarioService.deletarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
