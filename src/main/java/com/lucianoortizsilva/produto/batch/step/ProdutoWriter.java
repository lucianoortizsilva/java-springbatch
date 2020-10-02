package com.lucianoortizsilva.produto.batch.step;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucianoortizsilva.produto.batch.entity.BatchOutputProduto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoWriter extends JdbcBatchItemWriter<BatchOutputProduto> implements ItemWriter<BatchOutputProduto> {

	@Autowired
	public ProdutoWriter(final DataSource dataSource) {
		this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<BatchOutputProduto>());
		this.setSql("INSERT INTO BATCH_OUTPUT_PRODUTO (descricao, ean, categoria, status) VALUES (:descricao, :ean, :categoria, :status)");
		this.setDataSource(dataSource);
	}

	@Override
	public void write(List<? extends BatchOutputProduto> items) throws Exception {
		for (final BatchOutputProduto output : items) {
			log.info("Produto escrito: " + output);
		}
		super.write(items);
	}

}