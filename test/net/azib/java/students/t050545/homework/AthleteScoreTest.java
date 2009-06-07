package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sport.Person;
import static org.junit.Assert.assertEquals;
import java.util.GregorianCalendar;
import org.junit.Test;

/**
 * AthleteScoreTest
 *
 * @author libricon
 */
public class AthleteScoreTest {
	@Test
	public void testGetName() throws Exception {
		Person person = new Person("Jon Doe", "RU", new GregorianCalendar().getTime());
		assertEquals("Jon Doe", person.getName());
	}

}
