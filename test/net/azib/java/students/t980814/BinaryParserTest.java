package net.azib.java.students.t980814;

import net.azib.java.students.t980814.lec5.BinaryParser;

import static org.junit.Assert.*;

import java.io.StringBufferInputStream;

import org.junit.Test;


/**
 * BinaryParserTest
 *
 * @author dell
 */
public class BinaryParserTest {

//  Doesn't compile!!!!
//	@Test
//	public void testLeadingZeros() {
//		BinaryParser bp = new BinaryParser(new StringBufferInputStream("00000001010"));
//		bp.processInput();
//		assertEquals("10", bp.getDecimal());
//		assertEquals("a", bp.getHex());
//	}
	
//  Doesn't compile!!!!
//	@Test
//	public void testAllOnes() {
//		BinaryParser bp = new BinaryParser(new StringBufferInputStream("11111111111111111111111111"));
//		bp.processInput();
//		assertEquals("67108863", bp.getDecimal());
//		assertEquals("3ffffff", bp.getHex());
//	}
	
//  Doesn't compile!!!!
//	@Test
//	public void testBigNumber() {
//		BinaryParser bp = new BinaryParser(new StringBufferInputStream("111101010001010101001111111000000101010101010101010100101001001010010010010010100100010100100010010110101111111111111010000000000111111111000001000001111110000010000000000111100000111000000111110"));
//		bp.processInput();
//		assertEquals("48075390446914543345113707701873657578640489586089249501246", bp.getDecimal());
//		assertEquals("7a8aa7f02aaaa949492522912d7ffd003fe083f0400f0703e", bp.getHex());
//	}
	
//	@Test
//	public void testZero() {
//		BinaryParser bp = new BinaryParser(new StringBufferInputStream("0"));
//		bp.processInput();
//		assertEquals("0", bp.getDecimal());
//		assertEquals("0", bp.getHex());
//		
//	}
	
//	@Test
//	public void testInvalidCharacters() {
//		BinaryParser bp = new BinaryParser(new StringBufferInputStream("001021001"));
//		bp.processInput();
//		assertEquals("Enter binary number!", bp.getDecimal());
//		assertEquals("Enter binary number!", bp.getHex());
//	}
	
//	@Test
//	public void testNegativeInput() {
//		BinaryParser bp = new BinaryParser(new StringBufferInputStream("-1101001"));
//		bp.processInput();
//		assertEquals("Enter binary number!", bp.getDecimal());
//		assertEquals("Enter binary number!", bp.getHex());
//	}
	
	@Test
	public void testProcessInputTrue() {
		BinaryParser bp = new BinaryParser(new StringBufferInputStream("1101001"));
		assertEquals(bp.processInput(), true);
	}

	@Test
	public void testProcessInputFalse() {
		BinaryParser bp = new BinaryParser(new StringBufferInputStream("x"));
		assertEquals(bp.processInput(), false);
	}
}
