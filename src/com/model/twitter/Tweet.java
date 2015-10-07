package com.model.twitter;

/**
 * Created by heitor on 07/10/15.
 */
public class Tweet {
    private String tweet;
    private String imagem;

    public Tweet(String tweet, String imagem) {
        this.tweet = tweet;
        this.imagem = imagem;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
