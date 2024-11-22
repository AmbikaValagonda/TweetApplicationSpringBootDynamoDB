package com.ambikav.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ambikav.tweet.entity.Tweet;
import com.ambikav.tweet.service.TweetService;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
    private TweetService tweetService;

    @PostMapping("/post")
    public String postTweet(@RequestParam String userId, @RequestParam String content) {
        tweetService.postTweet(userId, content);
        return "Tweet posted successfully!";
    }
    
    @GetMapping("/user/{userId}")
    public List<Tweet> getUserTweets(@PathVariable String userId) {
        return tweetService.getUserTweets(userId);
    }

    @GetMapping("/all")
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets();
    }


}
