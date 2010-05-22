package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.Test;

/**
 * CSVInputTest
 *
 * @author Marek
 */
public class CSVInputTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.CSVInput#CSVInput(java.lang.String)}.
	 */
	@Test
	public void testCSVInput() {
		CSVInput ci=null;
		File tmpf=null;
		try {
			tmpf=File.createTempFile("iftest", "tmp");
		}
		catch (Exception e1) {
			e1.printStackTrace();
			fail("Couldn't create temporary file.");
		}
		tmpf.deleteOnExit();
		
		try {
			ci = new CSVInput(tmpf.getAbsolutePath());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(true, ci!=null);
	}
	
	@Test (expected=FileNotFoundException.class)
	public void testEmptyCSVInput() throws FileNotFoundException {
		CSVInput ci=null;
		ci = new CSVInput("");
		assertEquals(true, ci!=null);
	}

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.CSVInput#readInto(java.util.ArrayList)}.
	 */
	@Test
	public void testReadInto() {
		CSVInput ci=null;
		File tmpf=null;
		PrintWriter writer=null;
		try {
			tmpf=File.createTempFile("iftest", "tmp");
			tmpf.deleteOnExit();
			writer=new PrintWriter(tmpf);
		}
		catch (Exception e1) {
			e1.printStackTrace();
			fail("Couldn't create temporary file.");
		}
		
		writer.println("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01");
		writer.close();
		
		ArrayList<Record> records = new ArrayList<Record>();
		
		try {
			ci = new CSVInput(tmpf.getAbsolutePath());
			ci.readInto(records);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(3099, records.get(0).getScore());
		assertEquals("Василий Пупкин", records.get(0).getAthlete());
		
	}

	@Test
	public void testReadIntoAroundMinuteValues() {
		CSVInput ci=null;
		File tmpf=null;
		PrintWriter writer=null;
		try {
			tmpf=File.createTempFile("iftest", "tmp");
			tmpf.deleteOnExit();
			writer=new PrintWriter(tmpf);
		}
		catch (Exception e1) {
			e1.printStackTrace();
			fail("Couldn't create temporary file.");
		}
		
		writer.println("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:00.00,19.05,24.89,2.20,33.48,6:59.99");
		writer.close();
		
		ArrayList<Record> records = new ArrayList<Record>();
		
		try {
			ci = new CSVInput(tmpf.getAbsolutePath());
			ci.readInto(records);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(3260, records.get(0).getScore());
		
	}
}
