package test.com.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.model.ValidInformation;

public class ValidInformationTest {
	
	@Test
	public void testValidString() {
		String one = "";
		assertEquals(false, ValidInformation.valid(one));
	}

	@Test
	public void testValidListOfString() {
		String one = "";
		String two = "";
		String three = null;
		List<String> list = new ArrayList<String>();
		list.add(one);
		list.add(two);
		list.add(three);
		assertEquals(false, ValidInformation.valid(one));
	}

}
