package com.model.post;

/**
 * Created by heitor on 02/10/15.
 */
public class Hashtag {
    private Integer idUser;
    private String hashtag;

    public Hashtag(Integer idUser, String hashtag) {
        this.idUser = idUser;
        this.hashtag = hashtag;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
