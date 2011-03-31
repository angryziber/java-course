package net.azib.java.students.t093759.hometasks.sixth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * 30.03.11 22:48
 *
 * @author dionis
 */
public class PersonNameTest {
	private final String[] incorrectNames = new String[]{"Вася", "Martin Über", "odooadqs?", "Goo_",
			"  ", "100", "Moo ", " Boo", "Ou'", "I", "O'Reilly"};
	private final String[] correctNames = new String[]{"Bart", "Homer Simpson", "Marquis de Sade", "Li"};

	@Test
	public void namesShouldConsistOnlyFromUSCharsAndWhitespaces() {
		for (String name : correctNames) {
			assertTrue(name, PersonName.isValid(name));
		}
	}

	@Test
	public void incorrectNamesExamples() {
		for (String name : incorrectNames) {
			assertFalse(name, PersonName.isValid(name));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void itIsNotPossibleToHaveAnIncorrectName() {
		for (String name : incorrectNames) {
			new PersonName(name);
		}
	}

	@Test
	public void getterIsAvailable() {
		for (String correctName : correctNames) {
			assertThat(correctName, equalTo(new PersonName(correctName).getName()));
		}
	}

	@Test
	public void stringRepresentationExample() {
		for (String correctName : correctNames) {
			PersonName personName = new PersonName(correctName);
			assertThat(personName.toString(), equalTo(personName.getName()));
		}
	}
}
