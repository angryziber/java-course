package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * OutputToCSVTest
 *
 * @author armin
 */
public class OutputToCSVTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.OutputToCSV#set(java.util.List)}.
	 */
	@Test
	public final void testSet() {
		OutputStreamMock outputMock = new OutputStreamMock();
		OutputToCSV testObj = new OutputToCSV(outputMock);
		
		List<Output.Data> dataList = new ArrayList<Output.Data>();
		Output.Data athlete = new Output.Data();
		
		String pos = "1";
		int score = 6000;
		String name = "Name";
		Date date = new Date(8900100);
		String country = "EE";
		Events event = Events.RACE_100M;
		double time = 0;
		
		try {
			time = Converter.stringToTime("1:30");
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			athlete.setPosition(pos);
			athlete.setScore(score);
			athlete.setName(name);
			athlete.setDate(date);	
			athlete.setCountry(country);
			athlete.addEvent(event, time);
			dataList.add(athlete);
			
			testObj.set(dataList);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		String expected=pos+","+score+","+name+","+date+","+country+","+time+System.getProperty("line.separator");
		String result = outputMock.read();
		System.out.printf(result);
		assertTrue(result.equals(expected));
	}

}
