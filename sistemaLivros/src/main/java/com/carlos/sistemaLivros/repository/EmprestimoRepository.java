package com.carlos.sistemaLivros.repository;

import com.carlos.sistemaLivros.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
