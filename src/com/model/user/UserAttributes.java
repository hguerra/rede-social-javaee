package com.model.user;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heitor on 03/10/15.
 */
public class UserAttributes {
    public static String jsonPost() {
        return new Gson().toJson(SessionUser.getPostList());
    }

    public static String jsonUser() {
        PersonData p = new PersonData(SessionUser.getUser().getId(), SessionUser.getUser().getName(), SessionUser.getUser().getImage(), SessionUser.getPostList());
        return new Gson().toJson(p);
    }

    public static String jsonFollowing() {
        return new Gson().toJson(SessionUser.getFollowings());
    }

    public static String jsonFollowers() {
        return new Gson().toJson(SessionUser.getFollowers());
    }

    public static String jsonHashtags() {
        return new Gson().toJson(SessionUser.getHashtags());
    }

    public static String jsonInbox() {
        String json = "[{\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 1\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 2\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 3\"}]";
        return json;
    }

    public static String jsonMailSent() {
        String json = "[{\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 1\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 2\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 3\"}]";
        return json;
    }
}
