package com.lucianoortizsilva.produto.batch.step;

import org.springframework.batch.item.ItemProcessor;

import com.lucianoortizsilva.produto.batch.dto.BatchInputProduto;
import com.lucianoortizsilva.produto.batch.entity.BatchOutputProduto;
import com.lucianoortizsilva.produto.batch.enumeration.Status;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoProcessor implements ItemProcessor<BatchInputProduto, BatchOutputProduto> {

	@Override
	public BatchOutputProduto process(final BatchInputProduto item) throws Exception {
		final BatchOutputProduto output = new BatchOutputProduto();
		try {
			output.setEan(item.getEan());
			output.setCategoria(item.getCategoria());
			output.setDescricao(item.getDescricao().toUpperCase());
			output.setStatus(Status.AGUARDANDO.name());
		} catch (final Exception e) {
			output.setStatus(Status.ERRO.name());
		}
		log.info("Produto processado: " + output);
		return output;
	}

}