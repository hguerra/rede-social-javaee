package com.model.twitter;

import com.model.user.SessionUser;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.net.URL;

/**
 * Created by heitor on 02/10/15.
 */
public class SimpleTweet {
    private String CONSUMER_KEY = SessionUser.getTwitterConfig().getConsumerKey();
    private String CONSUMER_SECRET = SessionUser.getTwitterConfig().getConsumerSecret();
    private String ACCESS_TOKEN = SessionUser.getTwitterConfig().getAccessToken();
    private String ACCESS_TOKEN_SECRET = SessionUser.getTwitterConfig().getAccessTokenSecret();

    public Twitter authTwitter() {
        Twitter twitter = null;
        try {
            if (CONSUMER_KEY != null && CONSUMER_SECRET != null && ACCESS_TOKEN != null && ACCESS_TOKEN_SECRET != null) {
                // Instantiate a re-usable and thread-safe factory
                TwitterFactory twitterFactory = new TwitterFactory();
                // Instantiate a new Twitter instance
                twitter = twitterFactory.getInstance();
                // setup OAuth Consumer Credentials
                twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
                // setup OAuth Access Token
                twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN,
                        ACCESS_TOKEN_SECRET));
            }

        } catch (Exception e) {
        }
        return twitter;
    }

    public boolean tweet(String text, String titleImage, String urlImage) {
        boolean tweet = false;
        try {
            Twitter twitter = authTwitter();
            if (twitter != null) {
                // Instantiate and initialize a new twitter status update
                StatusUpdate statusUpdate = new StatusUpdate(text);
                statusUpdate.setMedia(titleImage, new URL(urlImage).openStream());
                // tweet or update status
                Status status = twitter.updateStatus(statusUpdate);
                tweet = true;
            }

        } catch (Exception e) {
        }
        return tweet;
    }

    public boolean tweet(String text) {
        boolean tweet = false;
        try {
            Twitter twitter = authTwitter();
            if (twitter != null) {
                // Instantiate and initialize a new twitter status update
                StatusUpdate statusUpdate = new StatusUpdate(text);
                Status status = twitter.updateStatus(statusUpdate);
                tweet = true;
            }

        } catch (Exception e) {
        }
        return tweet;
    }
}
