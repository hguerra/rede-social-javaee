package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import com.google.gson.Gson;

public class DataBase {
    private final static String DATA_BASE_PATH = "database/data.db4o";
    private ObjectContainer data;
    /* Singleton */
    private static DataBase uniqueInstance;

    private DataBase() {
        data = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
                DATA_BASE_PATH);
    }

    public static DataBase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DataBase();
        }
        return uniqueInstance;
    }

	/* End Singleton */

    /* User */
    public void addUser(User user) {
        data.store(user);
        data.commit();
    }

    public void addUser(List<User> users) {
        for (User i : users) {
            addUser(i);
        }
    }

    public void updateUser(String name, String newName, String accessName,
                           String password, String email) {
        List<String> list = Arrays.asList(name, accessName, password, email);
        if (ValidInformation.valid(list)) {
            User user = searchUserEmail(email);
            if (ValidInformation.valid(user) && user.getName().equals(name)) {
                user.setName(newName);
                user.setAccessName(accessName);
                user.setPassword(password);
                user.setEmail(email);
                addUser(user);
            }
        }
    }

    public void recoverPassWord(String name, String email, String code,
                                String newPassoword) {
        List<String> list = Arrays.asList(name, email, code);
        if (ValidInformation.valid(list)) {
            User user = searchUserEmail(email);
            if (ValidInformation.valid(user) && user.getName().equals(name)
                    && user.getPassword().equals(code)) {
                user.setPassword(newPassoword);
                addUser(user);
            }
        }
    }

    public Integer getUserId() {
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        Integer id = queryList.size() + 1;
        return id;
    }

    public List<User> searchUser(String name) {
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        List<User> result = new ArrayList<>();

        for (User u : queryList) {
            if (u.getName().equals(name))
                result.add(u);
        }
        return result;
    }

    public User searchUserEmail(String email) {
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        User result = null;

        for (User u : queryList) {
            if (u.getEmail().equals(email))
                result = u;
        }
        return result;
    }

    public User searchUser(Integer id) {
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        User result = null;
        for (User u : queryList) {
            if (u.getId().equals(id))
                result = u;
        }
        return result;
    }

    public String removeUser(User user) {
        String msg = "";
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();

        for (User u : queryList) {
            if (u.getName().equals(user.getName())
                    && u.getAccessName().equals(user.getAccessName())
                    && u.getPassword().equals(user.getPassword())) {
                data.delete(u);
                msg = "Success to remove user!";
            } else {
                msg = "User not found!";
            }

        }
        return msg;
    }

    public boolean login(User user) {
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        for (User u : queryList) {
            if (u.getAccessName().equals(user.getAccessName())
                    && u.getPassword().equals(user.getPassword())) {
                return true;

            }
        }
        return false;
    }

    public User login(String accessName, String password) {
        User user = null;
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        for (User u : queryList) {
            if (u.getAccessName().equals(accessName)
                    && u.getPassword()
                    .equals(TransformaStringMD5.md5(password))) {
                user = u;
            }
        }
        return user;
    }

	/* Post */

    public void addPost(Post post) {
        data.store(post);
        data.commit();
    }

    public Map<String, Post> searchPost(Integer idUser) {
        Query query = data.query();
        query.constrain(Post.class);
        ObjectSet<Post> queryList = query.execute();
        Map<String, Post> messages = new HashMap<String, Post>();
        for (Post m : queryList) {
            if (m.getIdUser().equals(idUser)) {
                String title = m.getTitle();
                messages.put(title, m);
            }
        }
        return messages;
    }

    public Post searchPost(String title) {
        Query query = data.query();
        query.constrain(Post.class);
        ObjectSet<Post> queryList = query.execute();
        Post result = null;
        for (Post m : queryList) {
            if (m.getTitle().equals(title)) {
                result = m;
            }
        }
        return result;
    }

    public Post searchPost(String title, Map<String, Post> messages) {
        Post result = null;
        if (title != null) {
            for (Map.Entry<String, Post> kv : messages.entrySet()) {
                if (kv.getKey().equals(title)) {
                    result = kv.getValue();
                }
            }
        }
        return result;
    }

    public String removePost(String title) {
        String answer = "";
        Post result = searchPost(title);
        if (result != null) {
            data.delete(result);
            answer = "Post deleted!";
        } else {
            answer = "Post not found!";
        }
        return answer;
    }

	/* MongoDB */

    public String userToJson(User user) {
        Gson gson = new Gson();
        // converte objetos Java para JSON e retorna JSON como String
        String json = gson.toJson(user);
        return json;
    }

    public User jsonToUser(String json) {
        Gson gson = new Gson();
        // Converte String JSON para objeto Java
        User user = gson.fromJson(json, User.class);
        return user;
    }

}
