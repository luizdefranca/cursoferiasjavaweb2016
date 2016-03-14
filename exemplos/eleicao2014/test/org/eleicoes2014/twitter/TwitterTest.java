package org.eleicoes2014.twitter;

import static org.eleicoes2014.alerta.GerenciadorAlertas.newGerenciadorAlertas;
import static org.junit.Assert.*;

import java.util.List;

import org.eleicoes2014.alerta.GerenciadorAlertas;
import org.eleicoes2014.config.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterTest {

	TwitterClient twitterClient  = null;
	
	
	@Before
	public void setUp() throws Exception {
		twitterClient  =
			new TwitterClient("gallindo@gmail.com", "senha");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() throws TwitterException {
		
		boolean sucesso = twitterClient.isAuthenticated();
		
		assertTrue("Deveria ser true",sucesso);
	}
	
	@Test
	public void testPesquisaTweetsUsuarioLogado() throws Exception {

		List<Status> tweets = twitterClient.listTweets();
		
		assertNotNull("Devem existir mais de o tweets",tweets);
		assertTrue("Devem existir mais de o tweets", tweets.size() > 0);
	}

	@Test
	public void testPesquisaTweetsUsuarioQualquer() throws Exception {

		List<String> usuarios = 
				Configuration.getInstance().getUsuariosSeguidos();		
		
		for (String usuario : usuarios) {
			List<Status> tweets = twitterClient.listTweets(usuario);
			
			assertNotNull("Devem existir mais de o tweets",tweets);
			assertTrue("Devem existir mais de o tweets", 
					tweets.size() > 0);
		}
		
	}

	@Test(expected=TwitterException.class)
	public void testPesquisaTweetsUsuarioInexistente() throws Exception {
		String joaoNinguem = "@anbm";
		List<Status> tweets = 
			twitterClient.listTweets(joaoNinguem);
	}
	
	@Test
	public void testPesquisaTweetsPalavraChave() throws Exception {

		List<Status> tweets = twitterClient.listTweets("from:BoechatBandNews","COPA");
		
		assertNotNull("Devem existir mais de o tweets",tweets);
		assertTrue("Devem existir mais de o tweets", 
				tweets.size() > 0);
		
		for (Status status : tweets) {
			System.out.println(status.getText());
			System.out.println();
		}
	}	
	
	@Test
	public void aplicarAlertaTweet() throws Exception {
	
		GerenciadorAlertas gerenciadorAlertas = 
				newGerenciadorAlertas();
		
		List<String> usuarios = 
				Configuration.getInstance().getUsuariosSeguidos();		
		
		for (String usuario : usuarios) {
			List<Status> tweets = twitterClient.listTweets(usuario);
			
			for (Status tweet : tweets) {
				System.out.println(tweet.getText());
				System.out.println(gerenciadorAlertas.containFilters(tweet.getText()));
			}

		}
	}

}
