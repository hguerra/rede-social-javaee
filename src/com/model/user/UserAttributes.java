package com.model.user;

import com.google.gson.Gson;

/**
 * Created by heitor on 03/10/15.
 */
public class UserAttributes {
    public String jsonPost() {
        return new Gson().toJson(SessionUser.getPostList());
    }

    public String jsonUser() {
        return new Gson().toJson(SessionUser.getUser());
    }

    public String jsonInbox() {
        String json = "[{\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 1\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 2\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 3\"}]";
        return json;
    }

    public String jsonMailSent() {
        String json = "[{\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 1\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 2\"}, {\"remetenteNome\": \"God\", \"remetenteImagem\" : \"assets/img/butters.jpg\", \"mensagem\": \"'mensagem privada 3\"}]";
        return json;
    }

    public String jsonFollowing() {
        return new Gson().toJson(SessionUser.getFollowings());
    }

    public String jsonFollowers() {
        return new Gson().toJson(SessionUser.getFollowers());
    }

    public String jsonHashtags() {
        return new Gson().toJson(SessionUser.getHashtags());
    }
}
