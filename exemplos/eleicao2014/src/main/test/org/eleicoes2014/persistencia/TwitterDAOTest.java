package org.eleicoes2014.persistencia;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Date;

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
		Tweet tweet = new Tweet();
		
		tweet.setCreatedAt(new Date());
		tweet.setFavorited(true);
		tweet.setInReplyToScreenName("Miguel Angelo");
		tweet.setInReplyToStatusId(3L);
		tweet.setInReplyToUserId(2L);
		tweet.setSource("asdasdasdasdasdasdasdasdasdasdasdasdas");
		tweet.setText("asdasdasdasdasdasdasdasdasd");
		tweet.setTruncated(false);
		tweet.setUser("@lucianohuk");
		
		return tweet;
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
