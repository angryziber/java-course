package net.azib.java.students.t040750.hometasks.lesson6;

import net.azib.java.students.t040750.lesson6.BinaryParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * BinaryParserTest
 *
 * @author t040750
 */
public class BinaryParserTest {

	private static final String LN = System.getProperty("line.separator"); 
	
	@Test
	public void welcomeNoteDisplayed() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		new BinaryParser(new Scanner(""), new PrintStream(out)).processInput();
		assertEquals(BinaryParser.WELCOME_TEXT + LN, out.toString());
	}
}
