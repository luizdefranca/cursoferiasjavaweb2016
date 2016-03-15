package com.company.speedment.test.twitter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.company.speedment.test.twitter.db0.twitter.tweets.Tweets;
import com.speedment.Manager;
import com.speedment.Speedment;

public class Main {

	public static void main(String[] args) {
		
		Speedment speedment = 
			new TwitterApplication().build();
		
		Manager<Tweets> managerTweets = speedment.managerOf(Tweets.class);
		
		Tweets tweets = managerTweets.newInstance()
			.setCreatedAt(new Timestamp(1l))
			.setInReplyToScreenName("Miguel Angelo")
			.setInReplyToStatusId(3)
			.setSource("aaaaaaaaaaaaaa")
			.setText("asdasdasdasdasdasdasdasdasd")
			.setUser("migueluxo")
			.setIsTruncated("s")
			.setIsFavorited("n")
			.persist();
		
		List<Tweets> listTweets = 
				managerTweets.stream()
				.filter(t -> t.getCreatedAt().before(new Date()))
				.collect(Collectors.toList());
		
		listTweets.stream()
		.map(Tweets::toJson)
		.forEach(System.out::println);
	
	}
}
