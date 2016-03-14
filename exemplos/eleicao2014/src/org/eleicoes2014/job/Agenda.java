package org.eleicoes2014.job;

import java.io.IOException;

import org.eleicoes2014.config.Configuration;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Agenda {
	
	private Scheduler scheduler;
	private Configuration configuration;

	public Agenda() throws SchedulerException, IOException {
		scheduler = new StdSchedulerFactory().getScheduler();
		configuration = Configuration.getInstance();
	}
	
	public void inicia() throws Exception {
	
	
	agendarJob("AtualizarBaseTweets", 
			   configuration.getJobAtualizaTweetsCronExpression(), 
			   AtualizaBaseTweetsJob.class);
/*	
	agendarJob("ExecutaAlertas", 
			   configuration.getJobExecutaAlertasCronExpression(), 
			   ExecutaAlertasJob.class);	
*/	
	
	scheduler.start();

}

	private void agendarJob(String identity,
			String jobAtualizaTweetsCronExpression,
			Class<? extends Job> jobClass) throws SchedulerException {
		JobDetail job = JobBuilder
							.newJob(jobClass)
							.withIdentity(identity)
							.build();
		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(identity)
				.withSchedule(CronScheduleBuilder.cronSchedule(
						jobAtualizaTweetsCronExpression))
				.build();

		// Agenda e voa l�!
		scheduler.scheduleJob(job, trigger);
	}


}
