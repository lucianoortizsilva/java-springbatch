package com.lucianoortizsilva.batch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucianoortizsilva.batch.entity.BatchOutputProduto;

@Repository
public interface BatchOutputProdutoRepository extends JpaRepository<BatchOutputProduto, Long> {

	List<BatchOutputProduto> findByStatus(String status);

}