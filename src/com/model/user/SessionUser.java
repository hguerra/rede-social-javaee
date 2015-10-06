package com.model.user;

import com.model.data.DataBase;
import com.model.facebook.FacebookConfig;
import com.model.follow.Followers;
import com.model.follow.Following;
import com.model.post.Hashtag;
import com.model.post.Post;
import com.model.twitter.TwitterConfig;

import java.util.List;
import java.util.Map;

public class SessionUser {
    private static DataBase data = DataBase.getInstance();
    private static User user;
    private static Map<String, Post> post;
    private static List<Post> postList;
    private static List<PersonData> followings;
    private static List<PersonData> followers;
    private static List<Hashtag> hashtags;
    /*Test*/
    private static UserDAO userDAO;
    public static UserDAO getUserDAO(){return userDAO;}
    public static void createUserSession(UserDAO user) {
        SessionUser.userDAO = user;
    }
    public static void commitChanges(){getData().updateDataBaseObject(getUserDAO());}
    /*Test*/
    /*DataBase**/
    public static DataBase getData() {
        return data;
    }

    /*User*/

    public static void createUserSession(User user) {
        SessionUser.user = user;
        post = getData().searchPost(getUserId());
        postList = getData().searchPostList(getUserId());
        followings = getData().getFollowing(getUserId());
        followers = getData().getFollowers(getUserId());
        hashtags = getData().getHashTags(getUserId());
    }

    public static void destroyUserSession() {
        SessionUser.user = null;
        post = null;
    }

    public static User getUser() {
        return user;
    }

    /*User information*/
    public static String getUserName() {
        return getUser().getName();
    }

    public static FacebookConfig getFacebookConfig() {
        return getUser().getFbConfig();
    }

    public static TwitterConfig getTwitterConfig() {
        return getUser().getTwConfig();
    }

    /*Post*/
    public static Integer getUserId() {
        return getUser().getId();
    }

    // setNumberPost inside Post, setTitle
    public static Integer getNumberPost() {
        return getUser().getNumberPost();
    }

    public static Map<String, Post> getPost() {
        return post;
    }

    public static List<Post> getPostList() {
        return postList;
    }

    public static Post searchPost(String title) {
        return getData().searchPost(title, getPost());
    }

    public static void updatePost() {
        post = getData().searchPost(getUserId());
    }
    /*Following*/

    public static List<PersonData> getFollowings() {
        return followings;
    }
    /*Followers*/

    public static List<PersonData> getFollowers() {
        return followers;
    }
    /*Hashtags*/

    public static List<Hashtag> getHashtags() {
        return hashtags;
    }
}
