package com.lucianoortizsilva.batch.step;

import java.util.Objects;

import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.lucianoortizsilva.batch.dto.ProdutoInput;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProdutoReader extends FlatFileItemReader<ProdutoInput> {

	private static final String FILENAME = "produtos.csv";
	@Autowired
	public ProdutoReader() {
		setName("produtoReader");
		setLinesToSkip(1);
		setResource(new ClassPathResource(FILENAME));
		setLineMapper(new DefaultLineMapper<ProdutoInput>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { ProdutoInput.Fields.descricao, ProdutoInput.Fields.ean, ProdutoInput.Fields.categoria });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<ProdutoInput>() {
					{
						setTargetType(ProdutoInput.class);
					}
				});
			}
		});
	}

	@Override
	public ProdutoInput read() throws Exception, UnexpectedInputException, ParseException {
		final ProdutoInput input = super.read();
		if(!Objects.isNull(input)) {
			log.info("Produto Lido: " + input);
		}
		return input;
	}

}