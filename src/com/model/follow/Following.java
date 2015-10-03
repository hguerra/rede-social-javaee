package com.model.follow;

/**
 * Created by heitor on 03/10/15.
 */
public class Following {
    private Integer idUser;
    private Integer idUserFollowing;

    public Following(Integer idUser, Integer idUserFollowing) {
        this.idUser = idUser;
        this.idUserFollowing = idUserFollowing;
    }

    public Integer getIdUserFollowing() {
        return idUserFollowing;
    }

    public void setIdUserFollowing(Integer idUserFollowing) {
        this.idUserFollowing = idUserFollowing;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
