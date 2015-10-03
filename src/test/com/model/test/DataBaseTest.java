package test.com.model.test;

import com.model.data.DataBase;
import com.model.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataBaseTest {
    DataBase data;
    User sessionUser;
    User user;

    @Before
    public void init() {
        data = DataBase.getInstance();

    }

    // create user
//
//	 @Test
//	 public void createTest() {
//	 Integer id = SessionUser.getData().getUserId();
//	 user = new User("Heitor Guerra Carneiro", "hguerra", "teste", id,
//	 "heitorguerrac@gmail.com");
//	 data.addUser(user);
//	 }


    @Test
    public void searchTest() {
        String user = "Heitor Guerra Carneiro";
        List<User> users = data.searchUser(user);
        assertEquals(users.get(0).getName(), user);
    }

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
