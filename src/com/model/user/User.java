package com.model.user;

import com.model.twitter.TwitterConfig;
import com.model.util.TransformStringMD5;
import com.model.facebook.FacebookConfig;

public class User {
    private static final String IMAGEM_PADRAO = "assets/img/storm-user.jpg";
    private Integer id;
    private String name;
    private String accessName;
    private String password;
    private String image = IMAGEM_PADRAO;
    private Integer numberPost;
    private String email;
    private FacebookConfig fbConfig;
    private TwitterConfig twConfig;

    public User(){

    }

    public User(Integer id, String name, String accessName,
                String password, String image, Integer numberPost,
                String email, FacebookConfig fbConfig,
                TwitterConfig twConfig) {
        this.id = id;
        this.name = name;
        this.accessName = accessName;
        this.password = TransformStringMD5.md5(password);
        this.image = image;
        this.numberPost = numberPost;
        this.email = email;
        this.fbConfig = fbConfig;
        this.twConfig = twConfig;
    }

    public User(String name, String accessName, String password, Integer id, String email) {
        this.name = name;
        this.accessName = accessName;
        this.password = TransformStringMD5.md5(password);
        this.id = id;
        this.numberPost = 0;
        this.email = email;
    }

    public User(String name, String accessName, String password, Integer id, String email, FacebookConfig fb) {
        this.name = name;
        this.accessName = accessName;
        this.password = TransformStringMD5.md5(password);
        this.id = id;
        this.numberPost = 0;
        this.email = email;
        this.fbConfig = fb;
    }

    public User(String name, String accessName, String password, Integer id, String email, FacebookConfig fb, TwitterConfig t) {
        this.name = name;
        this.accessName = accessName;
        this.password = TransformStringMD5.md5(password);
        this.id = id;
        this.numberPost = 0;
        this.email = email;
        this.fbConfig = fb;
        this.twConfig = t;
    }

    public User(String name, String accessName, String password, Integer id, String email, TwitterConfig t) {
        this.name = name;
        this.accessName = accessName;
        this.password = TransformStringMD5.md5(password);
        this.id = id;
        this.numberPost = 0;
        this.email = email;
        this.twConfig = t;
    }


    public User(String accessName, String password) {
        this.accessName = accessName;
        this.password = TransformStringMD5.md5(password);
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = TransformStringMD5.md5(password);
    }

    public Integer getNumberPost() {
        return numberPost;
    }

    public void setNumberPost(Integer numberPost) {
        this.numberPost = numberPost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public FacebookConfig getFbConfig() {
        return fbConfig;
    }

    public void setFbConfig(FacebookConfig fbConfig) {
        this.fbConfig = fbConfig;
    }

    public TwitterConfig getTwConfig() {
        return twConfig;
    }

    public void setTwConfig(TwitterConfig twConfig) {
        this.twConfig = twConfig;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
