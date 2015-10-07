package com.model.facebook;

/**
 * Created by heitor on 07/10/15.
 */
public class Face {
    private String publicar;
    private String imagem;

    public Face(String publicar, String imagem) {
        this.publicar = publicar;
        this.imagem = imagem;
    }

    public String getPublicar() {
        return publicar;
    }

    public void setPublicar(String publicar) {
        this.publicar = publicar;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
