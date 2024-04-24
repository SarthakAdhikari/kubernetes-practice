package com.example.tweetservice;

public class TweetRequest {
    private String email;
    private String tweetContent;

    public TweetRequest(String email, String tweetContent) {
        this.email = email;
        this.tweetContent = tweetContent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }
}
