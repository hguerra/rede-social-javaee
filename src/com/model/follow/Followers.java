package com.model.follow;

/**
 * Created by heitor on 03/10/15.
 */
public class Followers {
    private Integer idUser;
    private Integer idUserFollowers;

    public Followers(Integer idUser, Integer idUserFollowers) {
        this.idUser = idUser;
        this.idUserFollowers = idUserFollowers;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUserFollowers() {
        return idUserFollowers;
    }

    public void setIdUserFollowers(Integer idUserFollowers) {
        this.idUserFollowers = idUserFollowers;
    }
}
