package com.model.twitter;

import com.model.user.SessionUser;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heitor on 02/10/15.
 */
public class GetTwitterStatus {
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

    public String getUserStatus() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Twitter twitter = authTwitter();
            if (twitter != null) {
                ResponseList<Status> a = twitter.getUserTimeline(new Paging(1, 5));
                for (Status b : a) {
                    stringBuffer.append(b.getText());
                }
            }

        } catch (Exception e) {
        }
        return stringBuffer.toString();
    }

    public Map<String, List<String>> getFriendStatus(String friend) {
        Map<String, List<String>> map = new HashMap<>();

        try {
            Twitter twitter = authTwitter();
            if (twitter != null) {
                String[] srch = new String[]{friend};
                ResponseList<User> users = twitter.lookupUsers(srch);
                for (User user : users) {
                    String title = "Friend's Name " + user.getName();
                    List<String> st = new ArrayList<>();
                    if (user.getStatus() != null) {
                        List<Status> statusess = twitter.getUserTimeline(user
                                .getName());
                        for (Status status3 : statusess) {
                            st.add(status3.getText());
                        }
                        map.put(title, st);
                    }
                }
            }

        } catch (Exception e) {
        }
        return map;
    }
}
