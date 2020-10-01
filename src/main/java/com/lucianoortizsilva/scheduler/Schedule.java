package com.lucianoortizsilva.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Schedule {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	private static final long UM_MINUTO = 60000;

	@Scheduled(fixedRate = UM_MINUTO)
	public void scheduleInputProdutos() throws Exception {
		final JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		this.jobLauncher.run(job, jobParameters);
	}

}