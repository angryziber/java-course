package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.IOException;

import net.azib.java.students.t020556.homework.DecathlonResultFileReader;

import org.junit.Before;
import org.junit.Test;

/**
 * DecathlonResultFileReaderTest
 *
 * @author agu
 */
public class DecathlonResultFileReaderTest {
	
	DecathlonResultFileReader dfr = new DecathlonResultFileReader();

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.DecathlonResultFileReader#readResults()}.
	 */
	@Test
	public void testReadResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.DecathlonResultFileReader#setStream
	 * 		(java.io.InputStream)}.
	 */
	@Before
	@Test
	public void testSetStream() {
		assertNull(dfr.readResults());
		
		BufferedInputStream dummyStream = new BufferedInputStream(System.in);
		dfr.setStream(dummyStream);
		assertNull(dfr.readResults());
		
		try {
			dummyStream.close();
		}
		catch (IOException e) {
			// shouldn't happen
		}
		
		String fName = "src\\net\\azib\\java\\students\\t020556\\homework\\test\\src.txt";
	
	}

}
