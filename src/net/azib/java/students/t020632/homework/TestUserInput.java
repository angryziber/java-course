package net.azib.java.students.t020632.homework;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestUserInput is a test class for UserInput
 *
 * @author Marek Soobik t020632
 */
public class TestUserInput {

	UserInput user1;
	UserInput user2;
	UserInput user3;
	UserInput user4;
	String s1 = "console out.xml";
	String s2 = "  database   out.csv ";
	String s3 = "console out.html";
	String s4 = "in.csv console";
	
	@Before
	public void setUp() throws Exception {
		user1 = new UserInput(s1);
		user2 = new UserInput(s2);
		user3 = new UserInput(s3);
		user4 = new UserInput(s4);
	}
	
	/**
	 * Tests user inputs
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUserInput() throws Exception {
		assertEquals(user1.parseUserInput(), "Input OK");
		assertEquals(user2.parseUserInput(), "Input OK");
		assertEquals(user3.parseUserInput(), "Input OK");
		assertEquals(user4.parseUserInput(), "Input OK");
	}

	
	@After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		user3 = null;
		user4 = null;
	}

}
