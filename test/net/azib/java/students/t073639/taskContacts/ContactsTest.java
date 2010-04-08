package net.azib.java.students.t073639.taskContacts;

import static org.junit.Assert.*;


import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Contacts
 * 
 * @author t073639
 */
public class ContactsTest {
	Contacts c = new Contacts("Kirill Strelkov", "7.7.1988", "strelkov@hot.ee", "53887638");
	Pattern namePattern = Pattern.compile("[A-Z]{1}[a-z]+\\ [A-Z]{1}[a-z]+");
	Pattern emailPattern = Pattern.compile("[a-z0-9_A-Z.]+@[-a-zA-Z0-9.]+\\.[a-zA-Z]{2,4}");
	Pattern birthdayPattern = Pattern.compile("[0-9]{1,2}+\\.[0-9]{1,2}+\\.[0-9]{4}+");
	Pattern phoneNumPattern = Pattern.compile("[0-9]+");

	@Test
	public void namePatternIsCorrect() throws Exception {
		assertTrue("Name has invalid symbols!", Pattern.matches(namePattern.toString(), c.getName()));
	}

	@Test
	public void emailPatternIsCorrect() throws Exception {
		assertTrue("Email has invalid symbols", Pattern.matches(emailPattern.toString(), c.getEmail()));
	}

	@Test
	public void birthdayPatternIsCorrect() throws Exception {
		assertTrue("Birthday has invalid symbols", Pattern.matches(birthdayPattern.toString(), c.getBirthday()));
	}

	@Test
	public void phoneNumberPatternIsCorrect() throws Exception {
		assertTrue("Phone number has invalid symbols", Pattern.matches(phoneNumPattern.toString(), c.getPhoneNum()));
	}

	@Test
	public void birthdayValuesComparison() throws Exception {
		assertEquals("False", "7.07.1988", c.getBirthday());
	}
}
