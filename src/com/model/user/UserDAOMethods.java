package com.model.user;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by heitor on 04/10/15.
 */
public class UserDAOMethods {
    /*post*/
    public static void addPost(String tile, String post) {
        SessionUser.getUserDAO().getPost().put(tile, post);
    }

    public static void removePost(String title) {
        SessionUser.getUserDAO().getPost().remove(title);
    }

    public static String searchPost(String title) {
        return SessionUser.getUserDAO().getPost().get(title);
    }

    public static Map<String, String> getAllPosts() {
        return SessionUser.getUserDAO().getPost();
    }

    public static void mentionPeople(String userName, String title, String post) {
        if (userName.startsWith("@")) {
            String name = userName.substring(1);
            Set result = SessionUser.getData().dataBaseSearch("name", name, UserDAO.class);
            if (!result.isEmpty()) {
                List<Integer> followings = SessionUser.getUserDAO().getFollowings();
                for (Integer f : followings) {
                    UserDAO tempUser = SessionUser.getData().searchUserDAO(f);
                    String tempName = tempUser.getName();
                    if (result.contains(tempName)) {
                        mentionPeople(f, title, post);
                    }
                }
            }
        }
    }

    public static void mentionPeople(Integer id, String title, String post) {
        UserDAO tempUser = SessionUser.getData().searchUserDAO(id);
        tempUser.getPost().put(title, post);
    }

//    public Map<Integer, String> search() {
//
//    }
//
//    public String search() {
//
//    }
//
//    public List<String> search() {
//
//    }

    /*inbox*/
    /*sent*/
    /*following*/
    /*followers*/
    /*hashtag*/
}
