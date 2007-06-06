package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.Vector;

import org.junit.Test;


/**
 * CSVInputTest
 *
 * @author Lembit
 */
public class CSVInputTest {
	@Test
	public void testReadLine() throws Exception {
		CSVInput ci = new CSVInput();
		StringReader reader = new StringReader("\"Juhan Paul Kasemäe\",21.08.1986,EE,11.5,1:40.32\n12.6,\"abc\"\rabc");
		Vector<String> v = ci.readFullLines(reader);
		assertEquals(v.size(),3);
		assertTrue(v.elementAt(0).contains("\"Juhan Paul Kasemäe\",21.08.1986,EE,11.5,1:40.32"));
		assertTrue(v.elementAt(1).contains("12.6,\"abc\""));
		assertTrue(v.elementAt(2).contains("abc"));
		Vector<String> el = ci.readLineElements(v.elementAt(0));
		assertEquals(el.size(),5);
		assertTrue(el.elementAt(0).equals("Juhan Paul Kasemäe"));
		assertTrue(el.elementAt(1).equals("21.08.1986"));
		assertTrue(el.elementAt(2).equals("EE"));
		assertTrue(el.elementAt(3).equals("11.5"));
		assertTrue(el.elementAt(4).equals("1:40.32"));
		
	}
	@Test
	public void testname() throws Exception {
		CSVInput ci = new CSVInput();
		assertEquals(ci.initReader(""),false);
	}
}
