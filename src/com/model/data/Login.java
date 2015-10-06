package com.model.data;

import com.model.util.TransformStringMD5;

/**
 * Created by heitor on 06/10/15.
 */
public class Login {
    private String user;
    private String pwd;

    public Login(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}
