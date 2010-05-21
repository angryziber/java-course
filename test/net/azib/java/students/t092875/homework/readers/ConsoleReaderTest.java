package net.azib.java.students.t092875.homework.readers;
import net.azib.java.students.t092875.homework.athletes.Athlete;

import org.junit.Test;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * ConsoleReaderTest
 *
 * @author Mihhail
 */
public class ConsoleReaderTest {
	@Test
	public void testSetAthleteName(){
		String name = "Mihhail Arhipov";
		String result = null;
		ConsoleReader reader = new ConsoleReader();
		reader.changeScanner(name);
		result = reader.setAthleteName();
		assertEquals("Mihhail Arhipov", result);
	}
	
	@Test
	public void testSetOrigin(){
		String origin = "RU";
		String result = null;
		ConsoleReader reader = new ConsoleReader();
		reader.changeScanner(origin);
		result = reader.setOrigin();
		assertEquals("RU", result);
	}
	
	@Test
	public void testSetDOB(){
		Locale.setDefault(new Locale("ET"));
		String dob = "29.08.09";
		Date result = null;
		ConsoleReader reader = new ConsoleReader();
		reader.changeScanner(dob);
		try {
			result = reader.setDOB();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals("29.08.09", format.format(result));
	}
	
	@Test
	public void testSetEventResult(){
		String eventResult = "5.10";
		String result = null;
		ConsoleReader reader = new ConsoleReader();
		reader.changeScanner(eventResult);
		result = reader.setEventResult(1);
		assertEquals("5.10", result);
		reader.changeScanner(eventResult);
		eventResult = "2:05.10";
		reader.changeScanner(eventResult);
		result = reader.setEventResult(0);
		assertEquals("2:05.10", result);
	}
	
	@Test
	public void testSetEventResults(){
		String[] result = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		String[] realResult = null;
		ConsoleReader reader = new ConsoleReader();
		reader.changeTestMode(true);
		reader.setEventTestValues(result);
		realResult = reader.setEventResults();
		assertArrayEquals(result, realResult);
	}
	
	@Test
	public void testInsertMessage(){
		String result = null;
		ConsoleReader reader = new ConsoleReader();
		result = reader.insertMessage(1);
		assertEquals("Please insert the 1st athlete",result);
		result = reader.insertMessage(2);
		assertEquals("Please insert the 2nd athlete",result);
		result = reader.insertMessage(3);
		assertEquals("Please insert the 3rd athlete",result);
		result = reader.insertMessage(4);
		assertEquals("Please insert the 4th athlete",result);
	}
	
	@Test
	public void testAddAnotherAthlete(){
		String input = "y";
		ConsoleReader reader = new ConsoleReader();
		reader.changeScanner(input);
		assertTrue(reader.addAnotherAthlete());
		input = "n";
		reader.changeScanner(input);
		assertFalse(reader.addAnotherAthlete());
	}
	
	@Test
	public void testRead(){
		Locale.setDefault(new Locale("ET"));
		
		ConsoleReader reader = new ConsoleReader();
		String[] data = {"Mihhail Arhipov","29.08.87","ET","n"};
		String[] result = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		reader.changeTestMode(true);
		reader.setEventTestValues(result);
		reader.setDataTestValues(data);
		
		List<Athlete> athletes = null; 
		athletes = reader.read();
		
		assertEquals(1, athletes.size());
		assertEquals("Mihhail Arhipov", athletes.get(0).getName());
		assertEquals("ET", athletes.get(0).getOrigin());
		assertEquals("50.20", athletes.get(0).getEventResult(0));
		assertEquals("50.20", athletes.get(0).getEventResult(1));
		assertEquals("50.20", athletes.get(0).getEventResult(2));
		assertEquals("50.20", athletes.get(0).getEventResult(3));
		assertEquals("50.20", athletes.get(0).getEventResult(4));
		assertEquals("50.20", athletes.get(0).getEventResult(5));
		assertEquals("50.20", athletes.get(0).getEventResult(6));
		assertEquals("50.20", athletes.get(0).getEventResult(7));
		assertEquals("50.20", athletes.get(0).getEventResult(8));
		assertEquals("50.20", athletes.get(0).getEventResult(9));
		
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals("29.08.87", format.format(athletes.get(0).getDateOfBirth()));
	}
}
