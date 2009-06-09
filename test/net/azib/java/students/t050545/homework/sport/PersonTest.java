package net.azib.java.students.t050545.homework.sport;

import net.azib.java.students.t050545.homework.sport.Person;
import static org.junit.Assert.assertEquals;
import java.util.GregorianCalendar;
import org.junit.Test;

/**
 * PersonTest
 *
 * @author libricon
 */
public class PersonTest {
	@Test
	public void testGetName() throws Exception {
		Person person = new Person("Jon Doe", "RU", new GregorianCalendar().getTime());
		assertEquals("Jon Doe", person.getName());
	}
	
	@Test
	public void testGetCountryClass() throws Exception {
		Person person = new Person("Jon Doe", "RU", new GregorianCalendar().getTime());
		assertEquals("RU", person.getCountry());
	}
	
	@Test
	public void testGetDateClass() throws Exception {
		Person person = new Person("Jon Doe", "RU", new GregorianCalendar(1111,11,11).getTime());
		assertEquals(new GregorianCalendar(1111,11,11).getTime(), person.getBirthDay());
		
	}

}
