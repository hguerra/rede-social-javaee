package com.model.post;

import com.model.user.SessionUser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    private Integer idUser;
    private String title;
    private String message;
    private String image;

    public Post(Integer idUser, String message) {
        this.message = message;
        this.idUser = idUser;
        setTitle();
    }

    public Post(Integer idUser, String message, String image) {
        this.message = message;
        this.idUser = idUser;
        this.image = image;
        setTitle();
    }

    public void setTitle() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@ ");
        stringBuffer.append(SessionUser.getUserName());
        stringBuffer.append(date);
        this.title = stringBuffer.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
