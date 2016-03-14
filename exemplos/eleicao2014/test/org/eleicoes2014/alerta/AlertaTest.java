package org.eleicoes2014.alerta;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlertaTest {

	@Test
	public void test() {
		
		Alerta alerta = 
			new Alerta();
		
		alerta.setWords("copa");
		
		String tweet = 
		 "\"Dilma aposta em sucesso da Copa para melhorar imagem\", comentário no @jornaldacbn. http://bit.ly/1kRiezk ";
		
		boolean casou = alerta.containFilters(tweet);
		
		assertTrue("Nao encontrou a palavra", casou);
	}

}
