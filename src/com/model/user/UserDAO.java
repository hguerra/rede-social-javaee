package com.model.user;

import com.model.facebook.FacebookConfig;
import com.model.twitter.TwitterConfig;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by heitor on 04/10/15.
 */
public class UserDAO {
    private static final String DEFAULT_IMAGE = "assets/img/storm-user.jpg";
    private Integer id;
    private String name;
    private String accessName;
    private String password;
    private String email;
    private String image = DEFAULT_IMAGE;
    private FacebookConfig fbConfig;
    private TwitterConfig twConfig;
    private Map<String, String> post = new HashMap<>(); //tituto mensagem, mensagem
    private Map<Integer, String> inbox = new HashMap<>(); // id do remetente, mensagem
    private Map<Integer, String> sent = new HashMap<>(); // id do destinatario, mensagem
    private List<Integer> followings = new LinkedList<>();//id de cada usuario
    private List<Integer> followers = new LinkedList<>();  // ide de casa usuario
    private List<String> hashtags = new LinkedList<>(); // lista de hashtags escritas

    /**
     * colocar uma lista de hashtag em dataBase, selecionar os mais usados
     * e exibir na tela
     * <p>
     * Salvar todos os users em uma lista no SessionUser tbm
     * exibir esta lista no buscar da navbar
     * <p>
     * DataBase, realizar metodos que dao getUser().getLista.add(elemento)
     */

    public UserDAO(Integer id, String name, String accessName, String password, String email) {
        this.id = id;
        this.name = name;
        this.accessName = accessName;
        this.password = password;
        this.email = email;
    }

    public UserDAO(Integer id, String name, String accessName, String password, String email, String image) {
        this.id = id;
        this.name = name;
        this.accessName = accessName;
        this.password = password;
        this.email = email;
        this.image = image;
    }

    public UserDAO(Integer id, String name, String accessName, String password, String email, String image, FacebookConfig fbConfig) {
        this.id = id;
        this.name = name;
        this.accessName = accessName;
        this.password = password;
        this.email = email;
        this.image = image;
        this.fbConfig = fbConfig;
    }

    public UserDAO(Integer id, String name, String accessName, String password, String email, String image, TwitterConfig twConfig) {
        this.id = id;
        this.name = name;
        this.accessName = accessName;
        this.password = password;
        this.email = email;
        this.image = image;
        this.twConfig = twConfig;
    }

    public UserDAO(Integer id, String name, String accessName, String password, String email, String image, FacebookConfig fbConfig, TwitterConfig twConfig) {
        this.id = id;
        this.name = name;
        this.accessName = accessName;
        this.password = password;
        this.email = email;
        this.image = image;
        this.fbConfig = fbConfig;
        this.twConfig = twConfig;
    }

    /*getter and setter*/
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
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Map<String, String> getPost() {
        return post;
    }

    public void setPost(Map<String, String> post) {
        this.post = post;
    }

    public Map<Integer, String> getInbox() {
        return inbox;
    }

    public void setInbox(Map<Integer, String> inbox) {
        this.inbox = inbox;
    }

    public Map<Integer, String> getSent() {
        return sent;
    }

    public void setSent(Map<Integer, String> sent) {
        this.sent = sent;
    }

    public List<Integer> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Integer> followings) {
        this.followings = followings;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }
}
