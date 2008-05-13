package net.azib.java.students.t040719.homework.io;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


/**
 * InputParserTest
 *
 * @author romi
 */
public class InputParserTest {
	@Test
	public void isValidNameFails(){
		assertEquals(false, InputParser.isValidName("ss"));
	}
	
	@Test
	public void isValidNameSucceeds() {
		assertEquals(true, InputParser.isValidName("s s"));
	}
	
	@Test
	public void removesQuotesFromBothStringEnds(){
		assertEquals("test\"middle quote", InputParser.removeQuotes("\"test\"middle quote\""));
	}

/*	@Test
	public void parseNameSucceeds(){
		assertEquals("Siim susi", InputParser.parseName("\"Siim susi\""));
	}

	@Test
	public void parseNameFails(){
		assertEquals("", InputParser.parseName("Si+im susi"));
		assertEquals("", InputParser.parseName("\"Siimsusi\""));
	}*/
	
	@Test
	public void parseCountryCodeFails(){
		assertEquals("", InputParser.parseCountryCode("EX"));
	}

	@Test
	public void parseCountryCodeSucceeds(){
		assertEquals("ET", InputParser.parseCountryCode("ET"));
	}
	
	@Test
	public void parseDateStringSucceeds() throws ParseException{
		String dateString = "29.02.2008";
		Date d = new SimpleDateFormat(InputParser.DATE_FORMAT).parse(dateString);
		assertEquals(d, InputParser.parseDateString(dateString));
	}
	
	@Test
	public void parseDateStringFails(){
		String dateString = "29:02.2008";
		assertEquals(null, InputParser.parseDateString(dateString));
	}
	
	@Test
	public void parseLongTimeSucceeds(){
		assertEquals(39.28f, InputParser.parseLongTime("39.28"));
		assertEquals(99.28f, InputParser.parseLongTime("1:39.28"));
	}

	@Test
	public void parseLongTimeFails(){
		assertEquals(0, InputParser.parseLongTime("1.39.28"));
	}
	
	@Test
	public void parseEventResultsSucceeds(){
		String[] eventResults = {"12.61","5.00","9.22","1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		for (int i = 0; i< realResults.length; i++)
			assertEquals(realResults[i], InputParser.parseEventResults(eventResults)[i]);
	}

	@Test
	public void parseEventResultsFails(){
		assertEquals(null, InputParser.parseEventResults(new String[5]));
		String[] eventResults = {"12.61",".5.00","9.22","1.50","59.3.9","16.43","21.60","2.60","35.81","5:25.72"};
		assertEquals(null, InputParser.parseEventResults(eventResults));
	}
}
