package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
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

	@Before
	public void setUp(){
		URL fUrl = DecathlonResultStreamReaderTest.class.getResource("src.txt");
		try {
			File f = new File(fUrl.toURI());
			in = new FileInputStream(f.getAbsoluteFile());
		}
		catch (FileNotFoundException e) {
			fail("File " + fUrl + " not found!");
		}
		catch (URISyntaxException e) {
			fail("URI syntax failure: " + fUrl);
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
	
	@After
	public void tearDown(){
		try {
			in.close();
		}
		catch (IOException e) {
			fail("Failed closing stream");
		}
	}
}
