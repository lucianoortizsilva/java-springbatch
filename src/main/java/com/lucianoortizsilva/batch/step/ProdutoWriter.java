package com.lucianoortizsilva.batch.step;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.lucianoortizsilva.batch.model.ProdutoOutput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoWriter extends JdbcBatchItemWriter<ProdutoOutput> implements ItemWriter<ProdutoOutput> {

	@Autowired
	public ProdutoWriter(final DataSource dataSource) {
		this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ProdutoOutput>());
		this.setSql("INSERT INTO PRODUTO_OUTPUT (descricao, ean, categoria, status) VALUES (:descricao, :ean, :categoria, :status)");
		this.setDataSource(dataSource);
	}

	@Override
	public void write(List<? extends ProdutoOutput> items) throws Exception {
		for (final ProdutoOutput output : items) {
			log.info("Produto escrito: " + output);
		}
		super.write(items);
	}

}