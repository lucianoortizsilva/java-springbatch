package com.lucianoortizsilva.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucianoortizsilva.batch.BatchProdutoService;
import com.lucianoortizsilva.batch.entity.BatchOutputProduto;
import com.lucianoortizsilva.cadastro.entity.Categoria;
import com.lucianoortizsilva.cadastro.entity.Produto;
import com.lucianoortizsilva.cadastro.repository.ProdutoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private BatchProdutoService batchProdutoService;
	
	
	
	@Transactional
	public void cadastrarProdutos() {
		final List<BatchOutputProduto> batchs = this.batchProdutoService.findByStatusAguardando();
		log.info("Quantidade de BATCH_OUTPUT_PRODUTO com status 'AGUARDANDO': {}", batchs.size());
		if (existemProdutosParaCadastrar(batchs)) {
			final List<Produto> produtos = new ArrayList<>();
			for (final BatchOutputProduto batch : batchs) {
				produtos.add(create(batch));
			}
			this.produtoRepository.saveAll(produtos);
			this.batchProdutoService.atualizarStatusBatchOutputProduto(batchs);
		}
	}

	
	
	private static boolean existemProdutosParaCadastrar(final List<BatchOutputProduto> batchs) {
		return CollectionUtils.isNotEmpty(batchs);
	}

	
	
	private static Produto create(final BatchOutputProduto batch) {
		final Produto produto = new Produto();
		produto.setEan(batch.getEan());
		produto.setDescricao(batch.getDescricao());
		produto.setCategoria(Categoria.getByCodigo(batch.getCategoria()));
		return produto;
	}

}