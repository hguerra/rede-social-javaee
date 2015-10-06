package test.com.model.test;

import com.model.data.DataBase;
import com.model.data.Login;
import com.model.user.SessionUser;
import com.model.user.User;
import com.model.user.UserDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {
    DataBase data;
    User sessionUser;
    User user;

    @Before
    public void init() {
        data = DataBase.getInstance();

    }
    /*UserDAO*/
    // create userDAOs

//    @Test
//    public void createTest() {
//        UserDAO userDAO = new UserDAO(2, "Heitor Guerra Carneiro", "hguerra2", "teste",
//                "heitorguerrac@gmail.com");
//        data.addDataBaseObject(userDAO);
//    }
//
//    @Test
//    public void searchTest() {
//        UserDAO user = data.searchUserDAO(1);
//        assertEquals("Heitor Guerra Carneiro", user.getName());
//    }
//
//    @Test
//    public void updateUserTest() {
//        UserDAO user = data.searchUserDAO(2);
//        //user.setName("Carneiro");
//        //data.updateDataBaseObject(user);
//        assertEquals("Carneiro", user.getName());
//    }
//
//
//    @Test
//    public void dataBaseSearchObjectTest() {
//        String name = "Heitor Guerra Carneiro";
//        UserDAO user = (UserDAO) data.dataBaseSearchObject("name", name);
//        assertEquals(name, user.getName());
//    }
//
//    @Test
//    public void dataBaseSearchTest() {
//        String name = "Heitor Guerra Carneiro";
//        Set set = data.dataBaseSearch("name", name, UserDAO.class);
//        assertEquals(1, set.size());
//    }
//
//    @Test
//    public void postTest() {
//        UserDAO user2 = data.searchUserDAO(2);
////        Map<String, String> map = new HashMap<String, String>();
////        map.put("Titulo", "Mensagem");
////        user2.setPost(map);
////        data.updateDataBaseObject(user2);
//        assertEquals("Mensagem", user2.getPost().get("Titulo"));
//    }

    /*END UserDAO*/
    // create user
//
//	 @Test
//	 public void createTest() {
//	 Integer id = SessionUser.getData().getUserId();
//	 user = new User("Heitor Guerra Carneiro", "heitor", "teste", id,
//	 "heitorguerrac@gmail.com");
//	 data.addUser(user);
//	 }

    @Test
    public void loginTest() {
        user = SessionUser.getData().login(new Login("heitor", "teste"));
        String name = "Heitor Guerra Carneiro";
        assertEquals(name, user.getName());
    }

//    @Test
//    public void searchTest() {
//        String user = "Heitor Guerra Carneiro";
//        List<User> users = data.searchUser(user);
//        assertEquals(users.get(0).getName(), user);
//    }

//	@Test
//	public void idTest() {
//		String user = "Heitor Guerra Carneiro";
//		Integer id = 2;
//		List<User> users = data.searchUser(user);
//		assertEquals(users.get(0).getId(), id);
//	}

    // @Test
    // public void numbersIdTest() {
    // Integer id = 5;
    // Integer numbersId = data.getUserId();
    // assertEquals(numbersId, id);
    // }

	/*
     * @Test public void updateTest(){ List<User> u =
	 * data.searchUser("Victoria"); for(User i: u){
	 * i.setName("Victoria Guerra Carneiro"); } data.addUser(u);
	 * 
	 * String user = "Victoria Guerra Carneiro";
	 * 
	 * List<User> users = data.searchUser(user); Integer id = 1; Integer size =
	 * users.size(); assertEquals(size, id); }
	 */

    // @Test
    // public void jsonToJavaTest() {
    // //
    // {"id":1,"name":"Heitor Guerra Carneiro","accessName":"hguerra","password":"698dc19d489c4e4db73e28a713eab07b","numberPost":1,"email":"heitorguerrac@gmail.com"}
    // User user = data.searchUserEmail("heitorguerrac@gmail.com");
    // String json = data.userToJson(user);
    // String expected = data.userToJson(user);
    // assertEquals(expected, json);
    // }

    @After
    public void end() {
        data = null;
        sessionUser = null;
        user = null;
    }

}
