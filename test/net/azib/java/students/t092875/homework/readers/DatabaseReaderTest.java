package net.azib.java.students.t092875.homework.readers;
import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
/**
 * DatabaseReaderTest
 *
 * @author Mihhail
 */
public class DatabaseReaderTest {
	@Test
	public void testRead(){
		new FakeAthleteDB().prepare();
		DatabaseReader reader = new DatabaseReader(1);
		reader.setTestMode(true);
		reader.setFakeConnection(FakeAthleteDB.openConnection());
		List<Athlete> athletes = reader.read();
		assertEquals(1, athletes.size());
		assertEquals("Mihhail Arhipov", athletes.get(0).getName());
		assertEquals("EU", athletes.get(0).getOrigin());
		assertEquals("50.1", athletes.get(0).getEventResult(0));
		assertEquals("50.1", athletes.get(0).getEventResult(1));
		assertEquals("50.1", athletes.get(0).getEventResult(2));
		assertEquals("50.1", athletes.get(0).getEventResult(3));
		assertEquals("50.1", athletes.get(0).getEventResult(4));
		assertEquals("50.1", athletes.get(0).getEventResult(5));
		assertEquals("50.1", athletes.get(0).getEventResult(6));
		assertEquals("50.1", athletes.get(0).getEventResult(7));
		assertEquals("50.1", athletes.get(0).getEventResult(8));
		assertEquals("50.1", athletes.get(0).getEventResult(9));
		
		Locale.setDefault(new Locale("ET"));
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals("10.10.01", format.format(athletes.get(0).getDateOfBirth()));
	}
}
