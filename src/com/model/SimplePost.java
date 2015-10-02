package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by heitor on 02/10/15.
 */
public class SimplePost {
    private String titulo;
    private String mensagem;
    private String imagem;

    public SimplePost(String mensage, String image) {
        setTitulo();
        this.mensagem = mensage;
        this.imagem = image;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setTitulo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        String date = sdf.format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("@");
        stringBuffer.append(date);
        this.titulo = stringBuffer.toString();
    }


}
