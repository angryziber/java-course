package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * DecathlonOutputWriterTest
 *
 * @author Triin Nestor
 */
public class DecathlonOutputWriterTest {
	private PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>();
	private DecathlonOutputWriter outWriter = new DecathlonOutputWriter();
	
	//creating PriorityQueue
	private PriorityQueue<Competitor> createQueue(){
		String string = 
			"\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n" +
			"\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75\n";
		DecathlonInputReader inReader = new DecathlonInputReader();
		InputStream inStream = new ByteArrayInputStream(string.getBytes());
		PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>();
		pq.addAll(inReader.readInputStream(inStream));
		return pq;
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.DecathlonOutputWriter#writeToFile}
	 * 
	 */
	@Test
	public void testWriteToFile(){
		compQueue.addAll(createQueue());
		String file = "C:\\test.txt";
		File test = new File(file);
		
		outWriter.writeToFile(file,compQueue);
		assertTrue(test.exists());
		assertTrue(test.isFile());
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.DecathlonOutputWriter#writeToXmlOrHtml}
	 * 
	 */
	@Test
	public void testWriteToXmlOrHtml(){
		compQueue.addAll(createQueue());
		String fileXml = "C:\\test.xml";
		File testXml = new File(fileXml);
		String fileHtml = "C:\\test.html";
		File testHtml = new File(fileHtml);
		
		outWriter.writeToXmlOrHtml(0, fileXml, compQueue);
		assertTrue(testXml.exists());
		assertTrue(testXml.isFile());
		
		outWriter.writeToXmlOrHtml(1, fileHtml, compQueue);
		assertTrue(testHtml.exists());
		assertTrue(testHtml.isFile());
	}

}
