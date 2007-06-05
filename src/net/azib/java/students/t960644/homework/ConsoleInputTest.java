package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * ConsoleInputTest
 *
 * @author Lembit
 */
public class ConsoleInputTest {
	@Test
	public void testReadValue() throws Exception {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ByteArrayInputStream byteIn = new ByteArrayInputStream("123\n248\n".getBytes()); 
		ConsoleInput ci = new ConsoleInput();
		String retVal = ci.readValue(byteIn, byteOut, "test");
		assertTrue(byteOut.toString().contains("test"));
		assertTrue(retVal.equals("123"));
		//res = ci.readValue(byteIn, byteOut, "");
		//assertTrue(res.equals("248"));
	}
	@Test
	public void testReadOption() throws Exception {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ByteArrayInputStream byteIn = new ByteArrayInputStream("0\n".getBytes()); 
		ConsoleInput ci = new ConsoleInput();
		List<String> options = new ArrayList<String>();
		options.add("option1");
		options.add("option2");
		Integer retVal = ci.readOption(byteIn, byteOut, options, "Pick option: ");
		assertEquals(retVal.intValue(),0);
		assertTrue(byteOut.toString().contains("0: option1"));
		assertTrue(byteOut.toString().contains("1: option2"));
		byteIn = new ByteArrayInputStream("blah\n".getBytes());
		retVal = ci.readOption(byteIn, byteOut, options, "Pick option: ");
		assertNull(retVal);
		assertTrue(byteOut.toString().contains("Faulty value!"));
	}
	
	/*@Test
	// this is not testable with ByteArrayInputSTream
	public void testReadResult() throws Exception {
		ConsoleInput ci = new ConsoleInput();
		Result result = new Result();
		System.out.println(ci.readResult(System.in, System.out, result));
	}*/
	
	/*@Test
	//this is not testable with ByteArrayInputSTream
	public void testReadAthlete() throws Exception {
		ConsoleInput ci = new ConsoleInput();
		Athlete athlete = new Athlete();
		System.out.println(ci.readAthlete(System.in, System.out, athlete));
	}*/
	/*@Test
	//this is not testable with ByteArrayInputSTream
	public void testReadResults() throws Exception {
		ConsoleInput ci = new ConsoleInput();
		Competition comp = new Competition();
		ci.readResults(System.in, System.out, comp);
	}*/
}
