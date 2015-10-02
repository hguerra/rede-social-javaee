package com.model;

import java.util.Map;

public class SessionUser {
    private static DataBase data = DataBase.getInstance();
    private static User user;
    private static Map<String, Post> post;

    /*DataBase**/
    public static DataBase getData() {
        return data;
    }

    /*User*/

    public static void createUserSession(User user) {
        SessionUser.user = user;
        post = getData().searchPost(getUserId());
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

    public static Post searchPost(String title) {
        return getData().searchPost(title, getPost());
    }

    public static void updatePost( ){
        post = getData().searchPost(getUserId());
    }
}
