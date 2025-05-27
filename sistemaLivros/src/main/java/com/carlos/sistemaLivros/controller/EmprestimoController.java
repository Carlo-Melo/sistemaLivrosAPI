package com.carlos.sistemaLivros.controller;

import com.carlos.sistemaLivros.entity.Emprestimo;
import com.carlos.sistemaLivros.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Emprestimo> buscarPorId(@PathVariable Long id) {
        return emprestimoService.buscarPorId(id);
    }

    @PostMapping
    public Emprestimo cadastrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.cadastrarEmprestimo(emprestimo);
    }

    @PutMapping("/{id}")
    public Emprestimo finalizarEmprestimo(@PathVariable Long id) {
        return emprestimoService.finalizarEmprestimo(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
    }
}
