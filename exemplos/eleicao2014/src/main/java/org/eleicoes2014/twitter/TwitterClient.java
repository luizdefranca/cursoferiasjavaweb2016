package org.eleicoes2014.twitter;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eleicoes2014.config.Configuration;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/*
 https://apps.twitter.com/app/6292053

 Application settings
 Your application's API keys are used to authenticate requests
 to the Twitter Platform.
 Access level	 Read-only (modify app permissions)
 API key	 436yfREpwRhs9eoqjjr59VPLt (manage API keys)
 Callback URL	None
 Sign in with Twitter	No
 App-only authentication	https://api.twitter.com/oauth2/token
 Request token URL	https://api.twitter.com/oauth/request_token
 Authorize URL	https://api.twitter.com/oauth/authorize
 Access token URL	https://api.twitter.com/oauth/access_token

 API key	436yfREpwRhs9eoqjjr59VPLt
 API secret	zqcU8EFj5ylb3UIAs1LlC0BmF4lnXr5V4Jj0TMuptj2tLjJPrh
 */

public class TwitterClient {

	private static  Configuration config;

	private Twitter twitter;

	public TwitterClient() throws TwitterException, IOException {

		config = Configuration.getInstance();

		login();
	}

	public boolean isAuthenticated() throws TwitterException {
		User user2 = twitter.verifyCredentials();

		return user2 != null;
	}

	public List<Status> listTweets() throws TwitterException {

		return twitter.getUserTimeline();
	}

	public List<Status> listTweets(String usuario) throws TwitterException {

		return twitter.getUserTimeline(usuario);
	}

	public List<Status> listTweets(String... filters) throws TwitterException {

		StringBuilder stringQuery = new StringBuilder();

		for (String filter : filters) {
			stringQuery.append(filter);
			stringQuery.append(" ");
		}

	    Query query = new Query(stringQuery.toString());
	    QueryResult result = twitter.search(query);

		return result.getTweets();
	}

	public List<Status> listTweets(Supplier<String> supplier) throws TwitterException {

		Query query = new Query(supplier.get());
		QueryResult result = twitter.search(query);

		return result.getTweets();
	}

	public void login() throws TwitterException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(config.getConsumerkey())
				.setOAuthConsumerSecret(config.getConsumerSecret())
				.setOAuthAccessToken(config.getAccessToken())
				.setOAuthAccessTokenSecret(config.getAccessTokenSecret());

		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}
}
