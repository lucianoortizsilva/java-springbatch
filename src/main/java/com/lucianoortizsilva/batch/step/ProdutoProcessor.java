package com.lucianoortizsilva.batch.step;

import org.springframework.batch.item.ItemProcessor;

import com.lucianoortizsilva.batch.dto.ProdutoInput;
import com.lucianoortizsilva.batch.enumeration.Status;
import com.lucianoortizsilva.batch.model.ProdutoOutput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoProcessor implements ItemProcessor<ProdutoInput, ProdutoOutput> {

	@Override
	public ProdutoOutput process(final ProdutoInput item) throws Exception {
		final ProdutoOutput output = new ProdutoOutput();
		output.setEan(item.getEan());
		output.setCategoria(item.getCategoria());
		output.setDescricao(item.getDescricao().toUpperCase());
		output.setStatus(Status.AGUARDANDO.name());
		log.info("Produto processado: " + output);
		return output;
	}

}