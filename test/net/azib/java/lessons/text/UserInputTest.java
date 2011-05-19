package net.azib.java.lessons.text;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * @author anton
 */
public class UserInputTest {
	@Test
	public void readName() throws IOException {
		UserInput input = new UserInput();
		input.reader = new StringReader("John Doe\n");
		assertEquals("John Doe", input.askForName());
	}
}
