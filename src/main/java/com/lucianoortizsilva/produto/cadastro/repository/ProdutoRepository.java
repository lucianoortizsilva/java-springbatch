package com.lucianoortizsilva.produto.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucianoortizsilva.produto.cadastro.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}