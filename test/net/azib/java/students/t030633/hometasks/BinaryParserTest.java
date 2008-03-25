package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * BinaryParserTest
 * 
 * @author t030633
 */
public class BinaryParserTest {

	private static final String LN = System.getProperty("line.separator");

	private String parseInput(String input) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new BinaryParser(new Scanner(input), new PrintStream(out)).parse();
		return out.toString();
	}

	private String result(String in) {
			return BinaryParser.INIT_MESSAGE + LN + in + LN;
	}

	@Test
	public void initMessageIsShown() {
		assertEquals(BinaryParser.INIT_MESSAGE + LN, parseInput(""));
	}

	@Test
	public void parseBinaryZero() {
		assertEquals(result("0 (0x0)"), parseInput("0"));
	}

	@Test
	public void parseBinaryTen() {
		assertEquals(result("10 (0xA)"), parseInput("1010"));
	}

	@Test
	public void parseMultipleNumbers() {
		assertEquals(result("12 (0xC)" + LN + "5 (0x5)"), parseInput("1100" + LN + "101"));
	}

	@Test
	public void xExitsParser() {
		assertEquals(result("31 (0x1F)"), parseInput("011111" + LN + "x" + LN + "1"));
	}

	@Test
	public void nonBinaryCausesError() {
		assertEquals(result("7 is not a binary number."), parseInput("7"));
	}

}
