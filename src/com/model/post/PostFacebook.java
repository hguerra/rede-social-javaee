package com.model.post;

/**
 * Created by heitor on 02/10/15.
 */
public class PostFacebook {
    private String mensagem;

    public PostFacebook(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
