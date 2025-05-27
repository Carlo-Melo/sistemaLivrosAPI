package com.carlos.sistemaLivros.service;

import com.carlos.sistemaLivros.entity.Emprestimo;
import com.carlos.sistemaLivros.entity.Livro;
import com.carlos.sistemaLivros.repository.EmprestimoRepository;
import com.carlos.sistemaLivros.repository.LivroRepository;
import com.carlos.sistemaLivros.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private LivroRepository livroRepository;
    private UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo.getLivro() == null || emprestimo.getUsuario() == null) {
            throw new IllegalArgumentException("Livro e Usuário devem ser informados.");
        }
        emprestimo.setStatus(true);
        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Optional<Emprestimo> buscarPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public Emprestimo finalizarEmprestimo(Long id) {
        Optional<Emprestimo> optional = emprestimoRepository.findById(id);
        if (optional.isPresent()) {
            Emprestimo emprestimo = optional.get();
            emprestimo.setStatus(false); // marca como devolvido
            return emprestimoRepository.save(emprestimo);
        } else {
            throw new RuntimeException("Empréstimo não encontrado");
        }
    }

    public void deletar(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
