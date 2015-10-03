package com.model.facebook;

import facebook4j.Comment;
import facebook4j.PagableList;

/**
 * Created by heitor on 02/10/15.
 */
public class FacebookPostInfo {
    private String mensage;
    private String date;
    private String name;
    private String idUser;
    private PagableList<Comment> comments;

    public FacebookPostInfo(String mensage, String date, String name, String idUser) {
        this.mensage = mensage;
        this.date = date;
        this.name = name;
        this.idUser = idUser;
    }

    public FacebookPostInfo(String mensage, String date, String name, String idUser, PagableList<Comment> comments) {
        this.mensage = mensage;
        this.date = date;
        this.name = name;
        this.idUser = idUser;
        this.comments = comments;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public PagableList<Comment> getComments() {
        return comments;
    }

    public void setComments(PagableList<Comment> comments) {
        this.comments = comments;
    }
}
