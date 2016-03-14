package org.eleicoes2014.persistencia;

import static org.junit.Assert.*;

import org.eleicoes2014.modelo.Tweet;
import org.junit.Test;

public class TwitterDAOTest {

	@Test
	public void testInsert() throws Exception {
		TwitterDAO dao = new TwitterDAO();
		
		Tweet tweet = criarTweetDadosFicticios();
		
		dao.insert(tweet);
		
		Tweet tweetVindoBanco = dao.get(tweet.getId());
		assertNotNull("Nao pode ser nulo!",tweetVindoBanco);
		assertTrue(tweet.getId() == tweetVindoBanco.getId());
	}

	private Tweet criarTweetDadosFicticios() {
		return new Tweet();
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

}
