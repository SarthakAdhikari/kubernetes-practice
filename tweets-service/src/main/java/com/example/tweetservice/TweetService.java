package com.example.tweetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;
    public Tweet createTweet(Tweet tweet){
        return tweetRepository.save(tweet);
    }

    public List<Tweet> findTweetsByUser(User user){
        return tweetRepository.findTweetsByUser(user);
    }

    public List<Tweet> findAllTweets() {
        return tweetRepository.findAll();
    }
}
