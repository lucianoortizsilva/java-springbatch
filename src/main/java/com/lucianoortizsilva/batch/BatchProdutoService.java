package com.lucianoortizsilva.batch;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucianoortizsilva.batch.entity.BatchOutputProduto;
import com.lucianoortizsilva.batch.enumeration.Status;
import com.lucianoortizsilva.batch.repository.BatchOutputProdutoRepository;

@Service
public class BatchProdutoService {

	@Autowired
	private BatchOutputProdutoRepository repository;

	public List<BatchOutputProduto> findByStatusAguardando() {
		return this.repository.findByStatus(Status.AGUARDANDO.name());
	}

	@Transactional
	public void atualizarStatusBatchOutputProduto(final List<BatchOutputProduto> batchs) {
		batchs.stream().forEach(batch -> batch.setStatus(Status.FINALIZADO.name()));
		this.repository.saveAll(batchs);
	}

}