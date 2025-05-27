package com.carlos.sistemaLivros.service;

import com.carlos.sistemaLivros.entity.Usuario;
import com.carlos.sistemaLivros.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(Long id, String nome, Long matricula, String curso) {
        Usuario usuario = buscarPorId(id);
        usuario.setCurso(curso);
        usuario.setNome(nome);
        usuario.setMatricula(matricula);
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
