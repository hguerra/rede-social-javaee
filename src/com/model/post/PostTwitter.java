package com.model.post;

/**
 * Created by heitor on 02/10/15.
 */
public class PostTwitter {
    private String tweet;

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public PostTwitter(String tweet) {

        this.tweet = tweet;
    }
}
