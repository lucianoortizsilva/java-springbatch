package com.lucianoortizsilva.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lucianoortizsilva.batch.dto.ProdutoInput;
import com.lucianoortizsilva.batch.listener.JobCompletionNotificationListener;
import com.lucianoortizsilva.batch.model.ProdutoOutput;
import com.lucianoortizsilva.batch.step.ProdutoProcessor;
import com.lucianoortizsilva.batch.step.ProdutoReader;
import com.lucianoortizsilva.batch.step.ProdutoWriter;



@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private DataSource dataSource;

	@Bean
	public Job jobInputProdutos(final JobCompletionNotificationListener listener, final Step step1) {
		return jobBuilderFactory.get("jobInputProdutos")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<ProdutoInput, ProdutoOutput>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public FlatFileItemReader<ProdutoInput> reader() {
		return new ProdutoReader();
	}

	@Bean
	public ProdutoProcessor processor() {
		return new ProdutoProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<ProdutoOutput> writer() {
		return new ProdutoWriter(this.dataSource);
	}

}