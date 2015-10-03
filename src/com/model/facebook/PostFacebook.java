package com.model.facebook;

/**
 * Created by heitor on 02/10/15.
 */

import com.model.user.SessionUser;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostFacebook {

    public Facebook authFacebook() {
        Facebook facebook = null;
        FacebookConfig fb = SessionUser.getFacebookConfig();
        if (fb.getAppID() != null && fb.getAppSecret() != null
                && fb.getAccessToken() != null) {
            try {
                facebook = new FacebookFactory().getInstance();
                facebook.setOAuthAppId(fb.getAppID(), fb.getAppSecret());
                String accessTokenString = fb.getAccessToken();
                AccessToken at = new AccessToken(accessTokenString);
                facebook.setOAuthAccessToken(at);
            } catch (Exception e) {
            }
        }
        return facebook;
    }

    public boolean postFacebook(String post) {
        boolean canPost = false;
        try {
            Facebook facebook = authFacebook();
            if (facebook != null) {
                facebook.postStatusMessage(post);
                canPost = true;
            }
        } catch (FacebookException e) {
        }
        return canPost;
    }

    public Map<String, String> postFacebookExtractorMap(String id, int limit) {

        Map<String, String> map = new HashMap<>();
        try {
            Facebook facebook = authFacebook();
            if (facebook != null) {
                ResponseList<Post> feeds = facebook.getFeed(id,
                        new Reading().limit(limit));
                for (int i = 0; i < feeds.size(); i++) {
                    Post post = feeds.get(i);
                    String message = post.getMessage();
                    String date = post.getCreatedTime().toString();
                    String name = post.getFrom().getName();
                    String title = new StringBuffer().append(name).append(" ").append(date).toString();
                    map.put(title, message);
                }
            }
        } catch (FacebookException e) {
        }
        return map;
    }

    public List<FacebookPostInfo> postFacebookExtractor(String id, int limit) {
        List<FacebookPostInfo> info = new ArrayList<>();
        try {
            Facebook facebook = authFacebook();
            if (facebook != null) {
                ResponseList<Post> feeds = facebook.getFeed(id,
                        new Reading().limit(limit));
                for (int i = 0; i < feeds.size(); i++) {
                    Post post = feeds.get(i);
                    String message = post.getMessage();
                    PagableList<Comment> comments = post.getComments();
                    String date = post.getCreatedTime().toString();
                    String name = post.getFrom().getName();
                    String idUser = post.getId();
                    info.add(new FacebookPostInfo(message, date, name, idUser, comments));
                }
            }
        } catch (FacebookException e) {
        }
        return info;
    }
}
