package com.ambikav.tweet.repository;

import org.springframework.stereotype.Repository;

import com.ambikav.tweet.entity.Tweet;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.List;

@Repository
public class TweetRepository {

	 private final DynamoDbTable<Tweet> tweetTable;

	    public TweetRepository(DynamoDbEnhancedClient enhancedClient) {
	        this.tweetTable = enhancedClient.table("TweetTable", TableSchema.fromBean(Tweet.class));
	    }

	    public void save(Tweet tweet) {
	        tweetTable.putItem(tweet);
	    }

	    public List<Tweet> findByUserId(String userId) {
	        return tweetTable.query(QueryConditional.keyEqualTo(k -> k.partitionValue(userId)))
	                .items()
	                .stream()
	                .toList();
	    }

	    public List<Tweet> findAll() {
	        return tweetTable.scan()
	                .items()
	                .stream()
	                .toList();
	    }

}
