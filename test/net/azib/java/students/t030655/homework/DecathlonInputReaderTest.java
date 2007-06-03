package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * DecathlonInputReaderTest
 *
 * @author Triin Nestor
 */
public class DecathlonInputReaderTest {
	private DecathlonInputReader inReader = new DecathlonInputReader();
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.DecathlonInputReader#readInputStream}
	 * 
	 */
	@Test
	public void testReadInputStream(){
		String string = 
			"\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n" +
			"\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75\n";
		InputStream inStream = new ByteArrayInputStream(string.getBytes());
		PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>();
		pq.addAll(inReader.readInputStream(inStream));
		assertNotNull(pq);
		assertTrue(pq.size() == 2);
		
	}
	

}
