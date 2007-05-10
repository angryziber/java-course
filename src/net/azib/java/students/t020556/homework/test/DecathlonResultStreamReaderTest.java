package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

import net.azib.java.students.t020556.homework.Competitor;
import net.azib.java.students.t020556.homework.DecathlonResultStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DecathlonResultStreamReaderTest
 *
 * @author agu
 */
public class DecathlonResultStreamReaderTest {
	
	DecathlonResultStreamReader dfr = new DecathlonResultStreamReader();
	FileInputStream in = null;

	@After
	public void tearDown(){
		try {
			in.close();
		}
		catch (IOException e) {
			fail("Failed closing stream");
		}
	}
	
	@Before
	public void setUp(){
		String fName = "src\\net\\azib\\java\\students\\t020556\\homework\\test\\src.txt";
		try {
			in = new FileInputStream(fName);
		}
		catch (FileNotFoundException e) {
			fail("File " + fName + " not found!");
		}
	}
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.DecathlonResultStreamReader#readResults()}.
	 */
	@Test
	public void testReadResults() {
		dfr.setStream(in);
		PriorityQueue<Competitor> compQ = dfr.readResults(); 
		assertNotNull(compQ);
		assertNotNull(compQ.peek());
	}
}
