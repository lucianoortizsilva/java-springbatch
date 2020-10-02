package com.lucianoortizsilva.batch.step;

import org.springframework.batch.item.ItemProcessor;

import com.lucianoortizsilva.batch.dto.BatchInputProduto;
import com.lucianoortizsilva.batch.entity.BatchOutputProduto;
import com.lucianoortizsilva.batch.enumeration.Status;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoProcessor implements ItemProcessor<BatchInputProduto, BatchOutputProduto> {

	@Override
	public BatchOutputProduto process(final BatchInputProduto item) throws Exception {
		final BatchOutputProduto output = new BatchOutputProduto();
		output.setEan(item.getEan());
		output.setCategoria(item.getCategoria());
		output.setDescricao(item.getDescricao().toUpperCase());
		output.setStatus(Status.AGUARDANDO.name());
		log.info("Produto processado: " + output);
		return output;
	}

}