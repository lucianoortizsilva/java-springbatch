package com.lucianoortizsilva.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucianoortizsilva.cadastro.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}