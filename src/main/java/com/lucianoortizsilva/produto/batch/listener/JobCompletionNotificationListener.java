package com.lucianoortizsilva.produto.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		if (BatchStatus.STARTED == jobExecution.getStatus()) {
			log.info("########### JOB iniciado com sucesso ########### ");

		}
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (BatchStatus.COMPLETED == jobExecution.getStatus()) {
			log.info("########### JOB finalizado com sucesso ########### ");
		}
	}

}