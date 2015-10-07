package com.model.twitter;


import com.model.util.WebUtil;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.net.URL;

/**
 * Created by heitor on 02/10/15.
 */
public class Tweet {
    private static final String CONSUMER_KEY = "BvIzamXKeArqoIq8LpeFdOT8W";
    private static final String CONSUMER_SECRET = "nmR3Mndl9Zs6IE7rrdPUEIdaWdzGdnSIOazrMlS6PPCY8vBA4v";
    private static final String ACCESS_TOKEN = "3324793583-RwqeDGsNdTZtGd3vo5u7OvK5avg3bZxf48hwTOr";
    private static final String ACCESS_TOKEN_SECRET = "DvYb8phjgjJVMPx0AspAxOuSZ0fTpuiy8K4MB6Xgb0gMT";

    public Twitter authTwitter() {
        Twitter twitter = null;
        try {
            // Instantiate a re-usable and thread-safe factory
            TwitterFactory twitterFactory = new TwitterFactory();
            // Instantiate a new Twitter instance
            twitter = twitterFactory.getInstance();
            // setup OAuth Consumer Credentials
            twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
            // setup OAuth Access Token
            twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN,
                    ACCESS_TOKEN_SECRET));
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

    private ConfigurationBuilder twitterConfigurationBuilder() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        // the following is set without accesstoken- desktop client
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(
                        CONSUMER_SECRET);
        return cb;
    }

    public boolean requestPin() {
        boolean canOpened = false;
        try {
            TwitterFactory tf = new TwitterFactory(
                    twitterConfigurationBuilder().build());
            Twitter twitter = tf.getInstance();

            try {
                RequestToken requestToken = twitter.getOAuthRequestToken();
                WebUtil.openWebpage(requestToken.getAuthorizationURL());
                canOpened = true;
            } catch (IllegalStateException ie) {
            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
        return canOpened;
    }

    public void postTweet(String text, String pin) {
        try {
            TwitterFactory tf = new TwitterFactory(twitterConfigurationBuilder().build());
            Twitter twitter = tf.getInstance();
            try {
                RequestToken requestToken = twitter.getOAuthRequestToken();
                AccessToken accessToken = null;
                if (pin.length() > 0) {
                    accessToken = twitter.getOAuthAccessToken(
                            requestToken, pin);
                }
            } catch (IllegalStateException ie) {
            }
            Status status = twitter.updateStatus(text);
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

}
