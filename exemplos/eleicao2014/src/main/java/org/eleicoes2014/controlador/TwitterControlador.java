package org.eleicoes2014.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eleicoes2014.config.Configuration;
import org.eleicoes2014.modelo.Tweet;
import org.eleicoes2014.persistencia.TwitterDAO;
import org.eleicoes2014.twitter.TwitterClient;

import com.mysql.fabric.xmlrpc.base.Array;

import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterControlador {

	public void autalizarBaseTweets() throws Exception {

		TwitterClient twitterClient = new TwitterClient();

		TwitterDAO twitterDAO = new TwitterDAO();

		List<String> usuariosSeguidos =
				Configuration.getInstance().getUsuariosSeguidos();

		for (String usuario : usuariosSeguidos) {

			List<Status> statusList =
				twitterClient.listTweets(usuario);

			List<Tweet> tweetList =
				convertStatusListToTweetList(statusList);

			for (Tweet tweet : tweetList) {
				twitterDAO.insert(tweet);
			}
		}
	}

	private List<Tweet> convertStatusListToTweetList(List<Status> statusList) {

		List<Tweet> tweetList = new ArrayList<>();

		for (Status status : statusList) {
			tweetList.add(convertStatusToTweet(status));
		}

		return tweetList;
	}

	private Tweet convertStatusToTweet(Status status) {

		Tweet tweet = new Tweet();

		tweet.setCreatedAt(status.getCreatedAt());
		tweet.setFavorited(status.isFavorited());
		tweet.setId(status.getId());
		tweet.setInReplyToScreenName(status.getInReplyToScreenName());
		tweet.setInReplyToStatusId(status.getInReplyToStatusId());
		tweet.setInReplyToUserId(status.getInReplyToUserId());
		tweet.setSource(status.getSource());
		tweet.setText(status.getText());
		tweet.setTruncated(status.isTruncated());
		tweet.setUser(status.getUser().getName());

		return tweet;
	}
}
