package com.lucianoortizsilva.batch.step;

import org.springframework.batch.item.ItemProcessor;

import com.lucianoortizsilva.batch.dto.ProdutoInput;
import com.lucianoortizsilva.batch.dto.ProdutoOutput;
import com.lucianoortizsilva.batch.enumeration.Categoria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoProcessor implements ItemProcessor<ProdutoInput, ProdutoOutput> {

	@Override
	public ProdutoOutput process(final ProdutoInput item) throws Exception {
		final Categoria categoria = Categoria.getByCodigo(item.getCategoria());

		final ProdutoOutput output = new ProdutoOutput(categoria);
		output.setEan(item.getEan());
		output.setCategoria(categoria);
		output.setDescricao(item.getDescricao());

		log.info("Produto processado: " + output);
		return output;
	}

}