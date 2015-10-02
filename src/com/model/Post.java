package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    private Integer idUser;
    private String title;
    private String message;

    public Post(Integer idUser, String message) {
        this.message = message;
        this.idUser = idUser;
        setTitle();
    }

    public void setTitle() {
        /* User information */
    	/*
        Integer oldNumberPost = SessionUser.getUser().getNumberPost();
        Integer newNumberPost = oldNumberPost + 1;
        SessionUser.getUser().setNumberPost(newNumberPost);
        */
		/* Set Title */
    	/*
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#");
        stringBuffer.append(newNumberPost);
        stringBuffer.append("-");
        stringBuffer.append(date);
    	 */
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#");
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

}
