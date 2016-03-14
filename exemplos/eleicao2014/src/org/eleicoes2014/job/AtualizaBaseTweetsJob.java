package org.eleicoes2014.job;

import org.eleicoes2014.controlador.TwitterControlador;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AtualizaBaseTweetsJob  implements Job  {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		TwitterControlador controlador = new TwitterControlador();
		
		try {
			controlador.autalizarBaseTweets();
		} catch (Exception e) {
			throw new JobExecutionException(e);
		}
	}

}
