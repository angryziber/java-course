package net.azib.java.students.t092875.homework.readers;
import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.junit.Ignore;
import org.junit.Test;

/**
 * CSVReaderTest
 *
 * @author Mihhail
 */
public class CSVReaderTest {
	@Test @Ignore
	public void testRead(){
		CSVReader reader = new CSVReader("test_file.csv");
		List<Athlete> athletes = reader.read();
		// fails here with NPE
		assertEquals(1, athletes.size());
		assertEquals("Mumbalele-Nsowu Mensah-Bonsu Pops", athletes.get(0).getName());
		assertEquals("ZW", athletes.get(0).getOrigin());
		assertEquals("10.23", athletes.get(0).getEventResult(0));
		assertEquals("8.05", athletes.get(0).getEventResult(1));
		assertEquals("11", athletes.get(0).getEventResult(2));
		assertEquals("2.1", athletes.get(0).getEventResult(3));
		assertEquals("49.53", athletes.get(0).getEventResult(4));
		assertEquals("16.11", athletes.get(0).getEventResult(5));
		assertEquals("57.21", athletes.get(0).getEventResult(6));
		assertEquals("5.54", athletes.get(0).getEventResult(7));
		assertEquals("71", athletes.get(0).getEventResult(8));
		assertEquals("270.18", athletes.get(0).getEventResult(9));
		Locale.setDefault(new Locale("ET"));
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals("21.05.10", format.format(athletes.get(0).getDateOfBirth()));
	}
}
