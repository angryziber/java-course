package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.PointSystem;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t072073.tasks.Circle;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * DecathlonTest
 *
 * @author libricon
 */
public class DecathlonTest {
	
	// PointSystem Test
	@Test
	public void testPointSystem() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 7.76f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 2.208f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 5.285f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		PointSystem points = new PointSystem(arrayScore);
		assertEquals(" Hurra  ", 10000, points.getScore(),10);
	}
	
	// Person class test
	@Test
	public void testPersonClass() throws Exception {
		Person person = new Person("Jon Doe","RU",new GregorianCalendar());
		assertEquals("Jon Doe", person.getName());
		assertEquals("RU", person.getCountry());
	}
	
	// Sportman class test
	@Test
	public void testsportmanClass() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 7.76f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 2.208f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 5.285f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		Sportman sportman = new Sportman(arrayScore, new Person("Kirill", "RU", new GregorianCalendar(1987, 4, 29)));
		assertEquals("Kirill", sportman.getPerson().getName());
		assertEquals(10000, sportman.getPoints().getScore(), 10);
		assertEquals(new GregorianCalendar(1987, 4, 29).getTime(), sportman.getPerson().getBirthDay().getTime());
	}
	
	

}
