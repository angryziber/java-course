package net.azib.java.students.t050720.homework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

/**
 * <b>ConsoleOutputTest</b>
 * 
 * Tests for ConsoleOutput class.
 *
 * @author Marek
 */
public class ConsoleOutputTest {

	/**
	 * Tests conformation to format. Adds one record to the list and outputs it to a diverted stdout stream.
	 * Test method for {@link net.azib.java.students.t050720.homework.ConsoleOutput#flush(java.util.ArrayList)}.
	 */
	@Test
	public void testFlush() {
		final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
		ArrayList<Record> records = new ArrayList<Record>();
		Record rec=new Record();
		
		rec.setAthlete("Fancyman");
		rec.setRace_100m((float) 9.90);
		rec.setBirthDate("01.01.1987");
		rec.setCountry("EE");
		
		records.add(rec);
		
		ConsoleOutput o=new ConsoleOutput();
		o.flush(records);

		final String standardOutput = myOut.toString();
		String ls=System.getProperty("line.separator");
		String myStr=new String("Position, Score, Athlete, Birthdate, Country, 100 m, Long Jump, Shot Put, High Jump, 400m, 110m Hurdles, Discus, Pole Vault, Javelin, 1500m"+ls+"1,1121,\"Fancyman\",01.01.1987,EE,9.90,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0:00.00"+ls);
		assertEquals(myStr.trim(), standardOutput.trim());
	}

}
