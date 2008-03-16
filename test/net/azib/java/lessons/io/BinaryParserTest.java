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
	
	private static final String LN = System.getProperty("line.separator");
	
	private String processInput(String input) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new BinaryParser(new Scanner(input), new PrintStream(out)).processInput();
		return out.toString();
	}
	
	private void assertLastLine(String expected, String out) {
		String lastLine = out.substring(out.lastIndexOf('\n', out.length() - 2) + 1, out.length() - 1);
		assertEquals(expected, lastLine);
	}
	
	@Test
	public void welcomeTextIsDisplayed() throws Exception {
		String out = processInput("");
		assertTrue(out.startsWith(BinaryParser.WELCOME_TEXT));
		assertTrue(out.endsWith(LN));
	}

	@Test
	public void xEndsProgram() throws Exception {
		String outWithX = processInput("x\nsomething else");
		String welcomeOut = processInput("");
		assertEquals("'x' resulted in weird output", welcomeOut, outWithX);
	}
	
	@Test
	public void binaryAccepted() throws Exception {
		assertLastLine("0 (0x0)", processInput("0"));
		assertLastLine("1 (0x1)", processInput("1"));
		assertLastLine("15 (0xf)", processInput("00001111"));
		assertLastLine("101 (0x65)", processInput("1100101"));
		assertLastLine("65535 (0xffff)", processInput("1111111111111111"));
	}
	
	@Test
	public void nonBinaryRejected() throws Exception {
		assertLastLine("'abc'" + BinaryParser.NOT_A_NUMBER_TEXT, processInput("abc"));
		assertLastLine("'12'" + BinaryParser.NOT_A_NUMBER_TEXT, processInput("12"));
	}
	
	@Test
	public void fullSequenceWorks() throws Exception {
		String expected = BinaryParser.WELCOME_TEXT + LN +
						  "0 (0x0)" + LN + 
						  "1 (0x1)" + LN +
						  "'q'" + BinaryParser.NOT_A_NUMBER_TEXT + LN;
		assertEquals(expected, processInput("0\n1\nq\nx\nall!"));
	}
}
