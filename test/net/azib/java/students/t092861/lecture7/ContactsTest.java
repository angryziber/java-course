package net.azib.java.students.t092861.lecture7;

import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ContactsTest {

	@Test
	public void testCheckNameAreValid() {
		assertTrue(new Contacts().checkName("Stanislav Kuhtinski"));
		assertTrue(new Contacts().checkName("Siim Susi"));
		assertTrue(new Contacts().checkName("José Mañana Perez"));
		assertTrue(new Contacts().checkName("Jürgõn Hingšäläinen"));
		assertTrue(new Contacts().checkName("Hicham El Guerrouj"));
		assertTrue(new Contacts().checkName("Hans-Heinrich Sievert"));
		assertTrue(new Contacts().checkName("Kim Kun-Woo"));
		assertTrue(new Contacts().checkName("Carlos O'Connell"));
		assertTrue(new Contacts().checkName("Michael von Baumann"));
		assertTrue(new Contacts().checkName("Qi Haifeng"));
		assertTrue(new Contacts().checkName("Catherine Zeta-Jones"));
		assertTrue(new Contacts().checkName("Dimitar Ivanov Popov"));
	}

	@Test @Ignore
	public void testCheckNameInRussianIsValid() {
		assertTrue(new Contacts().checkName("Василий Пупкин"));
		fail("Not yet implemented");
	}

	@Test
	public void testCheckNameAreInvalid() {
		assertFalse(new Contacts().checkName("siim susi"));
		assertFalse(new Contacts().checkName("Siim susi"));
		assertFalse(new Contacts().checkName("siim Susi"));
		assertFalse(new Contacts().checkName("siimSusi"));
	}

	@Test
	public void testCheckMailIsValid() {
		assertTrue(new Contacts().checkMail("stanislav@mail.ee"));
		assertTrue(new Contacts().checkMail("stanislav.kuhtinski@gmail.com"));
		assertTrue(new Contacts().checkMail("stanislav-kuhtinski@mail.ru"));
		assertTrue(new Contacts()
				.checkMail("stanislav-kuhtinski@mail.subhost.de"));
		assertTrue(new Contacts().checkMail("stanislav_kuhtinski@hotmail.biz"));
		assertTrue(new Contacts().checkMail("stanislav_kuh777@host210.ip"));
		assertTrue(new Contacts()
				.checkMail("stanislav_kuh777@host210.subhost.net"));
		assertTrue(new Contacts()
				.checkMail("stanislav_kuh777@micro-soft.subhost.net"));
		assertTrue(new Contacts().checkMail("stanislav777@host210.info"));
		assertTrue(new Contacts().checkMail("007@gmail.com"));
		assertTrue(new Contacts().checkMail("wwwmail@gmail.com"));
		assertTrue(new Contacts().checkMail("wwwmail@gmail.sub.com"));
	}

	@Test
	public void testCheckMailIsNotValid() {
		assertFalse(new Contacts().checkMail("stanislav.mail.ee"));
		assertFalse(new Contacts().checkMail("007*gmail.com"));
		assertFalse(new Contacts().checkMail("007@gmail.77"));
		assertFalse(new Contacts().checkMail("www.stanislav.mail.ee"));
		assertFalse(new Contacts().checkMail("www.stanislav@gmail.info"));
	}

	@Test
	public void testCheckNumberIsValid() {
		assertTrue(new Contacts().checkNumber("555123456"));
		assertTrue(new Contacts().checkNumber("+372555123456"));
		assertTrue(new Contacts().checkNumber("+372 555123456"));
		assertTrue(new Contacts().checkNumber("6-123-456"));
		assertTrue(new Contacts().checkNumber("6-12-3456"));
		assertTrue(new Contacts().checkNumber("6123456"));
		assertTrue(new Contacts().checkNumber("112"));
	}

	@Test
	public void testCheckNumberIsInvalid() {
		assertFalse(new Contacts().checkNumber("+5"));
		assertFalse(new Contacts().checkNumber("+5 "));
		assertFalse(new Contacts().checkNumber("+5  "));
		assertFalse(new Contacts().checkNumber("5"));
		assertFalse(new Contacts().checkNumber("55"));
	}

	@Test
	public void testCheckFacebookIsValid() {
		assertTrue(new Contacts().checkFacebook("stanislav.kuhtinski"));
		assertTrue(new Contacts().checkFacebook("stanislavkuhtinski"));
		assertTrue(new Contacts().checkFacebook("john.smith55"));
		assertTrue(new Contacts().checkFacebook("johnsmith55"));
	}

	@Test
	public void testCheckFacebookIsInvalid() {
		assertFalse(new Contacts().checkFacebook("john"));
		assertFalse(new Contacts().checkFacebook("joj5"));
		assertFalse(new Contacts().checkFacebook("j.hn"));
	}

	@Test @Ignore
	public void testPrintAllContacts() throws ParseException {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(0, new Friend("Usain Bolt", newDate("21.09.1986"), "usain@hot.ee",
				"6463987", "usain.bolt"));
		friends.add(1, new Friend("Mike Powell", newDate("10.11.1963"),
				"mike@powell.ee", "6-123-456", "mike1963"));
		friends.add(2, new Friend("Randy Barnes", newDate("16.06.1966"),
				"randy@barnes.com", "6-12-3456", "barnes"));
		new Contacts().printAllContacts(friends);
	}

	Date newDate(String date) throws ParseException {
		return new SimpleDateFormat("dd.MM.yyyy").parse(date);
	}
}
