package com.model.post;

import com.model.user.SessionUser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    private Integer idUser;
    private String titulo;
    private String mensagem;
    private String imagem;

    public Post(Integer idUser, String message) {
        this.mensagem = message;
        this.idUser = idUser;
        setTitle();
    }

    public Post(Integer idUser, String message, String image) {
        this.mensagem = message;
        this.idUser = idUser;
        this.imagem = image;
        setTitle();
    }

    public void setTitle() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(SessionUser.getUserName());
        stringBuffer.append(date);
        this.titulo = stringBuffer.toString();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getImage() {
        return imagem;
    }

    public void setImage(String image) {
        this.imagem = image;
    }

}
