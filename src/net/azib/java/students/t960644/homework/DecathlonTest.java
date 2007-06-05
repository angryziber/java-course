package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;


/**
 * DecathlonTest
 *
 * @author Lembit
 */
public class DecathlonTest {
	@Test
	public void testParseParams() throws Exception {
		Decathlon dec = new Decathlon();
		dec.parseParams(new String[]{"key1=val1","key2=val2"});
		assertTrue(dec.commandLine.containsKey("key1"));
		assertTrue(dec.commandLine.get("key1").equals("val1"));
		assertTrue(dec.commandLine.containsKey("key2"));
		assertTrue(dec.commandLine.get("key2").equals("val2"));
		//assertTrue(false);
	}
	@Test
	public void testSplitArg() throws Exception {
		Decathlon dec = new Decathlon();
		Vector<String> vec = dec.splitArg("-csvin=test.csv");
		assertTrue(vec.elementAt(0).equals("-csvin"));
		assertTrue(vec.elementAt(1).equals("test.csv"));
	}
}
