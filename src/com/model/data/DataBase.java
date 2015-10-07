package com.model.data;

import java.util.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import com.google.gson.Gson;
import com.model.follow.Followers;
import com.model.follow.Following;
import com.model.post.Hashtag;
import com.model.user.PersonData;
import com.model.user.User;
import com.model.post.Post;
import com.model.user.UserDAO;
import com.model.util.CountDuplicatedList;
import com.model.util.TransformStringMD5;
import com.model.util.ValidInformation;

public class DataBase {
    private final static String DATA_BASE_PATH = "/home/heitor/Documentos/Desenvolvimento/Java/ideaProjects/stuffs/database/data.db4o";
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

    public void updateUser(String name, String newName, String accessName,
                           String password, String email, String image) {
        List<String> list = Arrays.asList(name, accessName, password, email);
        if (ValidInformation.valid(list)) {
            User user = searchUserEmail(email);
            if (ValidInformation.valid(user) && user.getName().equals(name)) {
                user.setName(newName);
                user.setAccessName(accessName);
                user.setPassword(password);
                user.setEmail(email);
                user.setImage(image);
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

    public List<PersonData> searchUserPersonData(String name) {
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        List<PersonData> result = new ArrayList<>();
        for (User u : queryList) {
            if (u.getName().equals(name))
                result.add(new PersonData(u.getId(), u.getName(), u.getImage()));
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
                    .equals(TransformStringMD5.md5(password))) {
                user = u;
            }
        }
        return user;
    }

    public User login(Login login) {
        User user = null;
        Query query = data.query();
        query.constrain(User.class);
        ObjectSet<User> queryList = query.execute();
        for (User u : queryList) {
            if (u.getAccessName().equals(login.getUser())
                    && u.getPassword().equals(TransformStringMD5.md5(login.getPwd()))) {
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
                String title = m.getTitulo();
                messages.put(title, m);
            }
        }
        return messages;
    }

    public List<Post> searchPostList(Integer idUser) {
        Query query = data.query();
        query.constrain(Post.class);
        ObjectSet<Post> queryList = query.execute();
        List<Post> messages = new ArrayList<>();
        for (Post m : queryList) {
            if (m.getIdUser().equals(idUser)) {
                messages.add(m);
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
            if (m.getTitulo().equals(title)) {
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
            data.commit();
            answer = "Post deleted!";
        } else {
            answer = "Post not found!";
        }
        return answer;
    }

    /*Following*/
    public void addFollowing(Following following) {
        data.store(following);
        data.commit();
    }

    public void removeFollowing(Following following) {
        data.delete(following);
        data.commit();
    }

    public void removeFollowing(Integer userId) {
        Query query = data.query();
        query.constrain(Following.class);
        ObjectSet<Following> queryList = query.execute();
        for (Following f : queryList) {
            if (f.getIdUser().equals(userId)) {
                data.delete(f);
                data.commit();
            }
        }
    }

    public List<PersonData> getFollowing(Integer userId) {
        Query query = data.query();
        query.constrain(Following.class);
        ObjectSet<Following> queryList = query.execute();
        List<PersonData> pData = new ArrayList<>();
        for (Following f : queryList) {
            if (f.getIdUser().equals(userId)) {
                Integer idFollowing = f.getIdUserFollowing();
                User temp = searchUser(idFollowing);
                if (temp != null) {
                    pData.add(new PersonData(idFollowing, temp.getName(), temp.getImage(), searchPostList(idFollowing)));
                }
            }
        }
        return pData;
    }

    /*Followers*/
    public void addFollowers(Followers followers) {
        data.store(followers);
        data.commit();
    }

    public void removeFollowers(Followers followers) {
        data.delete(followers);
        data.commit();
    }

    public void removeFollowers(Integer userId) {
        Query query = data.query();
        query.constrain(Followers.class);
        ObjectSet<Followers> queryList = query.execute();
        for (Followers f : queryList) {
            if (f.getIdUser().equals(userId)) {
                data.delete(f);
                data.commit();
            }
        }
    }

    public List<PersonData> getFollowers(Integer userId) {
        Query query = data.query();
        query.constrain(Followers.class);
        ObjectSet<Followers> queryList = query.execute();
        List<PersonData> pData = new ArrayList<>();
        for (Followers f : queryList) {
            if (f.getIdUser().equals(userId)) {
                Integer idFollowers = f.getIdUserFollowers();
                User temp = searchUser(idFollowers);
                if (temp != null) {
                    pData.add(new PersonData(idFollowers, temp.getName(), temp.getImage(), searchPostList(idFollowers)));
                }
            }
        }
        return pData;
    }

    /*Hashtags*/

    public void addHashTag(Hashtag hashtag) {
        data.store(hashtag);
        data.commit();
    }

    public void removeHashTag(Hashtag hashtag) {
        data.delete(hashtag);
        data.commit();
    }

    public List<Hashtag> getHashTags(Integer userId) {
        Query query = data.query();
        query.constrain(Hashtag.class);
        ObjectSet<Hashtag> queryList = query.execute();
        List<Hashtag> hashs = new ArrayList<>();
        for (Hashtag h : queryList) {
            if (h.getIdUser().equals(userId)) {
                hashs.add(h);
            }
        }
        return hashs;
    }

    public Map<String, Integer> getAllHashTags() {
        Query query = data.query();
        query.constrain(Hashtag.class);
        ObjectSet<Hashtag> queryList = query.execute();
        List<String> preResult = new LinkedList<>();
        for (Hashtag h : queryList) {
            preResult.add(h.getHashtag());
        }
        return CountDuplicatedList.allElementFrequencyMapSorted(preResult);
    }

    public void removeHashTag(Integer userId) {
        Query query = data.query();
        query.constrain(Hashtag.class);
        ObjectSet<Hashtag> queryList = query.execute();
        for (Hashtag f : queryList) {
            if (f.getIdUser().equals(userId)) {
                data.delete(f);
                data.commit();
            }
        }
    }

    /*Test*/
    public UserDAO searchUserDAO(Integer userId) {
        Query query = data.query();
        query.descend("id").constrain(userId);
        ObjectSet result = query.execute();
        UserDAO user = (UserDAO) result.next();
        return user;

    }

    public void addDataBaseObject(Object object) {
        data.store(object);
        data.commit();
    }

    public void removeDataBaseObject(Object object) {
        data.delete(object);
        data.commit();
    }

    public void updateDataBaseObject(Object object) {
        addDataBaseObject(object);
    }

    public Object dataBaseSearchObject(String attributeName, Object attributeValue) {
        Query query = data.query();
        query.descend(attributeName).constrain(attributeValue);
        ObjectSet execute = query.execute();
        Object result = execute.next();
        return result;
    }

    public Set dataBaseSearch(String attributeName, Object attributeValue, Class<?> c) {
        Query query = data.query();
        query.descend(attributeName).constrain(attributeValue);
        ObjectSet preResult = query.execute();
        Set result = removeGenericElements(preResult, c);
        return result;
    }

    private static Set removeGenericElements(ObjectSet preResult, Class<?> c) {
        Set result = new HashSet();
        for (Object ob : preResult) {
            if (c.isInstance(ob)) {
                result.add(ob);
            }
        }
        return result;
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
