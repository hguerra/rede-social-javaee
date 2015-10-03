package com.model.user;

import com.model.post.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heitor on 27/09/15.
 */
public class PersonData {
    private static final String IMAGEM_PADRAO = "assets/img/storm-user.jpg";
    private Integer id;
    private String nome;
    private String imagem;
    private List<Post> feeds = new ArrayList<>();

    public PersonData(Integer id, String nome, String imagem) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
    }

    public PersonData(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        this.imagem = IMAGEM_PADRAO;
    }

    public PersonData(Integer id, String nome, List<Post> feeds) {
        this.id = id;
        this.nome = nome;
        this.imagem = IMAGEM_PADRAO;
        this.feeds = feeds;
    }

    public PersonData(Integer id, String nome, String imagem, List<Post> feeds) {
        this.id = id;
        this.nome = nome;
        this.imagem = imagem;
        this.feeds = feeds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Post> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Post> feeds) {
        this.feeds = feeds;
    }

    public boolean matchesId(Integer id) {
        if (this.id.equals(id))
            return true;
        return false;
    }
}
