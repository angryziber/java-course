package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * PlaceTest
 *
 * @author Triin Nestor
 */
public class PlaceTest {
	private PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>();
	private Place obj = new Place();
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.Place#competitionResults}
	 * 
	 */
	@Test
	public void testCompetitionResults() {
		compQueue.addAll(createQueue());
		PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>();
		pq.addAll(obj.competitionResults(compQueue));
		Competitor comp;
		while((comp = pq.poll()) != null){
			assertTrue(comp.getPlace() != "");
		}
		
	}


	//creating PriorityQueue
	private PriorityQueue<Competitor> createQueue(){
		String string = 
			"\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n" +
			"\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75\n" +
			"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01\n";
		DecathlonInputReader inReader = new DecathlonInputReader();
		InputStream inStream = new ByteArrayInputStream(string.getBytes());
		PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>();
		pq.addAll(inReader.readInputStream(inStream));
		return pq;
	}

}
