package com.ambikav.tweet.service;

import org.springframework.stereotype.Service;

import com.ambikav.tweet.entity.Tweet;
import com.ambikav.tweet.repository.TweetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TweetService {
	 @Autowired
	    private TweetRepository tweetRepository;

	    public void postTweet(String userId, String content) {
	        Tweet tweet = new Tweet();
	        tweet.setUserId(userId);
	        tweet.setTweetId(UUID.randomUUID().toString());
	        tweet.setContent(content);
	        tweet.setTimestamp(LocalDateTime.now());
	        tweetRepository.save(tweet);
	    }

	    public List<Tweet> getUserTweets(String userId) {
	        return tweetRepository.findByUserId(userId);
	    }

	    public List<Tweet> getAllTweets() {
	        return tweetRepository.findAll();
	    }


}
