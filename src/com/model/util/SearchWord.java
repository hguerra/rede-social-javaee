package com.model.util;

import com.model.post.Hashtag;
import com.model.post.Post;
import com.model.user.PersonData;
import com.model.user.SessionUser;
import com.model.user.User;
import com.model.user.UserDAO;

import java.util.*;

/**
 * Created by heitor on 05/10/15.
 */
public class SearchWord {
    public static void hashtag(String post) {
        List<Set<String>> search = searchAtSignAndNumberSign(post);
        if (!search.isEmpty()) {
            Set<String> atSign = search.get(0);
            Set<String> numberSign = search.get(1);
            for (String at : atSign) {
                mentionPeople(at, post);
            }
            for (String n : numberSign) {
                SessionUser.getData().addHashTag(new Hashtag(SessionUser.getUserId(), n));
                SessionUser.updateHashtag();
            }
        }

    }

    public static void mentionPeople(String userName, String post) {
        if (userName.startsWith("@")) {
            String name = userName.substring(1);
            Set result = SessionUser.getData().dataBaseSearch("name", name, User.class);
            if (!result.isEmpty()) {
                List<PersonData> person = SessionUser.getFollowings();
                for (PersonData f : person) {
                    User tempUser = SessionUser.getData().searchUser(f.getId());
                    String tempName = tempUser.getName();
                    if (result.contains(tempName)) {
                        mentionPeople(f.getId(), post);
                    }
                }
            }
        }
    }

    public static void mentionPeople(Integer id, String post) {
        SessionUser.getData().addPost(new Post(id, post));
    }

    /**
     * @param text
     * @return SearchWord.searchAtSignAndNumberSign(text).get(1) -> #
     */
    public static List<Set<String>> searchAtSignAndNumberSign(String text) {
        List<Set<String>> result = null;
        if (text.contains("@") || text.contains("#")) {
            result = new LinkedList<>();
            Set<String> resultAtSign = new HashSet<>();
            Set<String> resultNumberSign = new HashSet<>();
            List<String> words = words = Arrays.asList(text.split(" "));
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).startsWith("@")) {
                    resultAtSign.add(words.get(i));
                }
                if (words.get(i).startsWith("#")) {
                    resultNumberSign.add(words.get(i));
                }
            }
            result.add(resultAtSign);
            result.add(resultNumberSign);
        }
        return result;
    }

    public static Set<String> searchAtSign(String text) {
        Set<String> result = null;
        if (text.contains("@")) {
            result = new HashSet<>();
            List<String> words = words = Arrays.asList(text.split(" "));
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).startsWith("@")) {
                    result.add(words.get(i));
                }
            }
        }
        return result;
    }

    public static Set<String> searchNumberSign(String text) {
        Set<String> result = null;
        if (text.contains("#")) {
            result = new HashSet<>();
            List<String> words = words = Arrays.asList(text.split(" "));
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).startsWith("#")) {
                    result.add(words.get(i));
                }
            }
        }
        return result;
    }


}
