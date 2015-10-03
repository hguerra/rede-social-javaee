package test.com.model.test;

import com.model.post.Hashtag;
import com.model.post.Post;
import com.model.post.PostFacebook;
import com.model.post.PostTwitter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heitor on 02/10/15.
 */
public class Fake {
    public static List<Post> getFakeList = Arrays.asList(
            new Post(1, "Ola mundo", "assets/img/bg_4.jpg"),
            new Post(2, "Ola mundo", "assets/img/bg_4.jpg"),
            new Post(3, "Ola mundo", "assets/img/bg_4.jpg")
    );
}
