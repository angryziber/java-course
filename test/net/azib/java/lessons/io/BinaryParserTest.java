package net.azib.java.lessons.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * BinaryParserTest
 *
 * @author anton
 */
public class BinaryParserTest {
	
	private static final String LN = System.getProperty("line.separator");;
	
	private String processInput(String s) {
		Scanner input = new Scanner(s);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new BinaryParser(input, new PrintStream(out)).processInput();
		return out.toString();
	}
	
	private void assertOutput(String expected, String input) {
		assertEquals(BinaryParser.WELCOME_TEXT + LN + expected + LN, processInput(input));
	}

	@Test
	public void welcomeNoteDisplayed() throws Exception {
		assertEquals(BinaryParser.WELCOME_TEXT + LN, processInput(""));
	}
	
	@Test
	public void simpleBinaryNumberConversion() throws Exception {
		assertOutput("0 (0x0)", "0");
	}

	@Test
	public void arbitraryBinaryNumberConversion() throws Exception {
		assertOutput("15 (0xF)", "1111");
	}
	
	@Test
	public void nonBinaryNumberRejected() throws Exception {
		assertOutput("'foo' is not a binary number", "foo");
	}
	
	@Test
	public void multipleInputProcessing(){
		assertOutput("8 (0x8)" + LN + "5 (0x5)", "1000" + LN + "101");
	}

	@Test
	public void xEndsProgram() {
		assertOutput("65535 (0xFFFF)", "1111111111111111" + LN + "x" + LN + "1");
	}
}
