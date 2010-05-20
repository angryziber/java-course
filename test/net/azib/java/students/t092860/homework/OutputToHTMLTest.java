package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * OutputToHTMLTest
 *
 * @author armin
 */
public class OutputToHTMLTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.OutputToHTML#set(java.util.List)}.
	 */
	@Test
	public final void testSet() {
		OutputStreamMock outputMock = new OutputStreamMock();
		OutputToHTML testObj = null;
		
		try {
			testObj = new OutputToHTML(outputMock);
			assertNotNull(testObj);
			testObj.set(AthleteData.GetOutputData());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		String expected = "<html><body><h2>Decathlon competition</h2>" +
				"<table border=\"1\"><tr bgcolor=\"#9acd32\"><th>Position</th>" +
				"<th>Score</th><th>Name</th><th>Birthdate</th><th>Country</th>" +
				"<th>Race 100m</th><th>Shot put</th><th>Long jump</th><th>Javelin throw</th>" +
				"<th>Pole vault</th><th>High jump</th><th>Hurdles 100m</th><th>Race 400m</th>" +
				"<th>Race 1500m</th><th>Discus throw</th></tr><tr><td>1</td><td>6000</td>" +
				"<td>Name</td><td>reede, 20. Oktoober 2000</td><td>EE</td><td>90.0</td>" +
				"<td>20.45</td><td>20.45</td><td>20.45</td><td>20.45</td><td>20.45</td>" +
				"<td>90.0</td><td>90.0</td><td>90.0</td><td>20.45</td></tr></table></body></html>";
		
		String result = outputMock.read();
		assertTrue(result.compareTo(expected) == 0);
	}

}
