package com.lucianoortizsilva.produto.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lucianoortizsilva.produto.cadastro.ProdutoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Schedule {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Autowired
	private ProdutoService produtoService;

	private static final long _UM_MINUTO = 60000;
	private static final long _10_SEGUNDOS = 10000;

	@Scheduled(fixedRate = _UM_MINUTO)
	public void executarBatch() throws Exception {
		log.info(" Schedule executarBatch() disparado com sucesso");
		final JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		this.jobLauncher.run(job, jobParameters);
	}

	@Scheduled(fixedRate = _UM_MINUTO, initialDelay = _10_SEGUNDOS)
	public void cadastrarProduto() throws Exception {
		log.info(" Schedule cadastrarProduto() disparado com sucesso");
		this.produtoService.cadastrarProdutos();
	}

}