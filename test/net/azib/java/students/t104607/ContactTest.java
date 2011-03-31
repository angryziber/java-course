package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ContactTest {
	private Contact contact = new Contact();

	@Test
	public void name() throws Exception {
		contact.setName("John Smith");
	 	assertNotNull(contact.getName());
		contact.setName("Cow nr.1234");
	 	assertNull(contact.getName());
	}

	@Test
	public void birthday() throws Exception {
		contact.setBirthday(DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()));
		assertNotNull(contact.getBirthday());
		contact.setBirthday("31/31/00");
		assertNull(contact.getBirthday());
	}

	@Test
	public void email() throws Exception {
	   	contact.setEmail("john@toy.museum");
		assertNotNull(contact.getEmail());
		contact.setEmail("devil_xxx@l33t.hell");
		assertNull(contact.getEmail());
	}

	@Test
	public void phone() throws Exception {
	   	contact.setPhone("372-555-5555");
		assertNotNull(contact.getPhone());
		contact.setPhone("012-LOL-5555");
	    assertNull(contact.getPhone());
	}
}
