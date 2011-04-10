package net.azib.java.students.t110013.hometask6;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

/**
 * @author Vadim
 */
public class ContactsTest {
	Contacts contacts = new Contacts();

	@Test
	public void validateName() {
		assertNull(contacts.validateName("vadim"));
		assertNull(contacts.validateName("Vadim"));
		assertNull(contacts.validateName("Vadim V"));
		assertNull(contacts.validateName("Vadim Vadim Vadim"));
		assertNull(contacts.validateName("Vadim v Vadim"));
		assertNull(contacts.validateName("Vadim V Vadim"));
		assertNull(contacts.validateName("Vadim V V Vadim"));
		assertNull(contacts.validateName("Vadim v. Vadim"));
		assertNull(contacts.validateName("888 Vadim"));
		assertNull(contacts.validateName("Vadim.Vadim"));
		assertNull(contacts.validateName("Vadim-Vadim"));
		assertNull(contacts.validateName("Vadim_Vadim"));

		assertNotNull(contacts.validateName("Vadim Vadim"));
		assertNotNull(contacts.validateName("Vadim V. Vadim"));
		assertNotNull(contacts.validateName("Vadim V. V. Vadim"));
	}

	@Test
	public void validateDate() {
		assertNull(contacts.validateDate("1986/12/28"));
		assertNull(contacts.validateDate("12/28/1986"));
		assertNull(contacts.validateDate("28-12-1986"));
		assertNull(contacts.validateDate("1986-28-12"));

		assertNotNull(contacts.validateDate("28.01.1986"));
		assertNotNull(contacts.validateDate("28.12.86"));
	}

	@Test
	public void validatePhone() {
		assertNull(contacts.validatePhone("Aa333"));
		assertNull(contacts.validatePhone("4444"));
		assertNull(contacts.validatePhone("999-999-999"));
		assertNull(contacts.validatePhone("88 888 888"));
		assertNull(contacts.validatePhone("+372 56 888 888"));

		assertNotNull(contacts.validatePhone("55555"));
		assertNotNull(contacts.validatePhone("+37256888888"));
	}

	@Test
	public void validateEmail() {
		assertNull(contacts.validateEmail("vadim"));
		assertNull(contacts.validateEmail("vadim@.com.ee"));
		assertNull(contacts.validateEmail("vadim123@gmail.a"));
		assertNull(contacts.validateEmail("vadim123@.com"));
		assertNull(contacts.validateEmail("vadim123@.com.com"));
		assertNull(contacts.validateEmail(".vadim123@gmail.com"));
		assertNull(contacts.validateEmail("vadim()*@gmail.com"));
		assertNull(contacts.validateEmail("vadim@%*.com"));
		assertNull(contacts.validateEmail("vadim..2002@gmail.com"));
		assertNull(contacts.validateEmail("vadim.@gmail.com"));
		assertNull(contacts.validateEmail("vadim@vadim@gmail.com"));
		assertNull(contacts.validateEmail("vadim@gmail.com.1a"));

		assertNotNull(contacts.validateEmail("vadim@gmail.com"));
		assertNotNull(contacts.validateEmail("vadim.trifonov@gmail.com"));
		assertNotNull(contacts.validateEmail("vadim@gmail.net.com"));
		assertNotNull(contacts.validateEmail("vadim_trifonov@gmail.com"));
		assertNotNull(contacts.validateEmail("_vadim_trifonov@gmail.com"));
		assertNotNull(contacts.validateEmail("vadim123@gmail.com"));
		assertNotNull(contacts.validateEmail("123vadim@gmail.com"));
	}
}
