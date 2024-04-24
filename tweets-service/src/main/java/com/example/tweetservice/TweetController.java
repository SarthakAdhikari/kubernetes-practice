package com.example.tweetservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;


    @PostMapping("/create")
    public ResponseEntity<?> createTweet(@RequestBody TweetRequest request) {
        User user = userService.findUserByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found with email: " + request.getEmail());
        }
        Tweet tweet = new Tweet();
        tweet.setContent(request.getTweetContent());
        tweet.setUser(user);
        Tweet savedTweet = tweetService.createTweet(tweet);
        return ResponseEntity.ok(savedTweet);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listTweetsForUser(@RequestParam(required = false) String email) {
        if (email != null && !email.isEmpty()) {
            User user = userService.findUserByEmail(email);
            if (user == null) {
                return ResponseEntity.badRequest().body("User not found with email: " + email);
            }
            List<Tweet> tweets = tweetService.findTweetsByUser(user);
            return ResponseEntity.ok(tweets);
        } else {
            // Logic for when no email is provided, e.g., list all tweets or return a different response
            List<Tweet> allTweets = tweetService.findAllTweets(); // Assuming this method exists
            return ResponseEntity.ok(allTweets);
        }
    }
}
