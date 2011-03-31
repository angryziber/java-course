package net.azib.java.students.t093759.hometasks.sixth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * 31.03.11 0:41
 *
 * @author dionis
 */
public class EmailTest {
	private String[] correctEmails = {"a@b.com", "13131@goo.com", "museumworker@greatmuseum.musem", "coolcompany@freemail.com",
			"super-puper.mega@param-pam.su"};
	private String[] incorrectEmails = {".a@b.com", "13131.@goo.com", "museumworker@.musem", "coolcompany@freemail.",
			"super-puper.mega@param-pam.laslslsllssl"};

	@Test
	public void correctEmailExamples() {
		for (String correctEmail : correctEmails) {
			assertTrue(correctEmail, Email.isValid(correctEmail));
		}
	}

	@Test
	public void incorrectEmailExamples() {
		for (String correctEmail : incorrectEmails) {
			assertFalse(correctEmail, Email.isValid(correctEmail));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void isIsNotPossibleToCreateIncorrectEmail() {
		for (String incorrectEmail : incorrectEmails) {
			new Email(incorrectEmail);
		}
	}

	@Test
	public void getterIsAvailable() {
		for (String correctEmail : correctEmails) {
			assertThat(correctEmail, equalTo(new Email(correctEmail).getEmail()));
		}
	}
}
