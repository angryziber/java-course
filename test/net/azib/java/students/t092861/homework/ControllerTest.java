package net.azib.java.students.t092861.homework;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class ControllerTest {

	@Test
	public void testCheckNameValid() {
		assertTrue(new Controller().checkName("Stanislav Kuhtinski"));
		assertTrue(new Controller().checkName("Siim Susi"));
		assertTrue(new Controller().checkName("José Mañana Perez"));
		assertTrue(new Controller().checkName("Jürgõn Hingšäläinen"));
		assertTrue(new Controller().checkName("Hicham El Guerrouj"));
		assertTrue(new Controller().checkName("Hans-Heinrich Sievert"));
		assertTrue(new Controller().checkName("Kim Kun-Woo"));
		assertTrue(new Controller().checkName("Carlos O'Connell"));
		assertTrue(new Controller().checkName("Michael von Baumann"));
		assertTrue(new Controller().checkName("Qi Haifeng"));
		assertTrue(new Controller().checkName("Catherine Zeta-Jones"));
		assertTrue(new Controller().checkName("Dimitar Ivanov Popov"));
		assertTrue(new Controller().checkName("Mumbalele-Nsowu Mensah-Bonsu Pops"));
	}
	
	@Test
	public void testCheckNameRussianValid() {
		assertTrue(new Controller().checkName("Василий Пупкин"));
		assertTrue(new Controller().checkName("Василий Пу"));
		assertTrue(new Controller().checkName("Ва Пупкин"));
		assertTrue(new Controller().checkName("Василий Д'Артаньян"));
	}
	
	@Test
	public void testCheckNameRussianInValid() {
		assertFalse(new Controller().checkName("Василий П"));
		assertFalse(new Controller().checkName("В Пупкин"));
		assertFalse(new Controller().checkName("василий пупкин"));
		assertFalse(new Controller().checkName("василий Пупкин"));
		assertFalse(new Controller().checkName("василий д'Артаньян"));
		assertFalse(new Controller().checkName("Василий пупкин"));
	}

	@Test
	public void testCheckNameInValid() {
		assertFalse(new Controller().checkName("siim susi"));
		assertFalse(new Controller().checkName("Siim susi"));
		assertFalse(new Controller().checkName("siim Susi"));
		assertFalse(new Controller().checkName("siimSusi"));
	}

	@Test
	public void testCheckCountryValid() {
		assertTrue(new Controller().checkCountry("EE"));
		assertTrue(new Controller().checkCountry("RU"));
		assertTrue(new Controller().checkCountry("DE"));
	}
	
	@Test
	public void testCheckCountryInValid() {
		assertFalse(new Controller().checkCountry("eE"));
		assertFalse(new Controller().checkCountry("Ru"));
		assertFalse(new Controller().checkCountry("de"));
		assertFalse(new Controller().checkCountry("D"));
		assertFalse(new Controller().checkCountry("DDE"));
	}

	@Test
	public void testCheckTime() {
		assertEquals(251.18, new Controller().checkTime("4:11.18"),0.5);
		assertEquals(324.26, new Controller().checkTime("5:24.26"),0.5);
		assertEquals(59.39, new Controller().checkTime("59.39"),0.5);
	}
	
	@Test
	public void testRemoveQuotes() {
		assertEquals("Stanislav Kuhtinski", new Controller().removeQuotes("\"Stanislav Kuhtinski\""));
		assertEquals("Stanislav", new Controller().removeQuotes("\"Stan\"islav\""));
	}

	@Test
	public void testCheckMetersValid() {
		assertTrue(new Controller().checkMeters("1.50"));
		assertTrue(new Controller().checkMeters("13.43"));
		assertTrue(new Controller().checkMeters("22.2"));
		assertTrue(new Controller().checkMeters("17"));
	}
	
	@Test
	public void testCheckMetersInValid() {
		assertFalse(new Controller().checkMeters("1,50m"));
		assertFalse(new Controller().checkMeters("13,43"));
		assertFalse(new Controller().checkMeters("22,2"));
		assertFalse(new Controller().checkMeters("17:21"));
		assertFalse(new Controller().checkMeters("4:55.01"));
	}
	
	
	
	@Test
	public void testArrangeInOrder() {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		String[] lines = 
		{
		"Horn Phillip,21.05.1981,US,11.23,6.62,11.49,1.75,51.97,14.89,33.37,3.98,45.6,5:24.26", //2-4 6379 
		"Horn Dhillip,21.05.1981,US,11.23,6.62,11.49,1.75,51.97,14.89,33.37,3.98,45.6,5:24.26", //2-4 6379 
		"Horn Mhillip,21.05.1981,US,11.23,6.62,11.49,1.75,51.97,14.89,33.37,3.98,45.6,5:24.26", //2-4 6379 
		"Dunkle Jeremy,27.03.1975,US,11.39,6.69,10.0,2.05,49.52,15.72,24.39,3.38,30.37,4:11.18", //1 6438    
		"Thomas Nathan,11.05.1960,DE,11.39,6.69,10.0,2.05,49.52,15.72,24.39,3.38,30.37,4:27.58", //5 6326    
		"Roth AJ,16.06.1966,PL,11.39,6.69,10.0,2.05,49.52,15.72,24.39,3.38,30.37,4:51.28" //6 6176   
		};
		for (int i = 0; i < lines.length; i++) {
			ArrayList<String> inputData = new ArrayList<String>(Arrays.asList(lines[i].split(",")));
			athletes.add(new Controller().readData(inputData));
		}
		
		new Controller().arrangeInOrder(athletes);
		
		assertEquals(6438, athletes.get(0).getScore());
		assertEquals("1", athletes.get(0).getPlace());
		
		assertEquals(6379, athletes.get(1).getScore());
		assertEquals("2-4", athletes.get(1).getPlace());
		
		assertEquals(6379, athletes.get(2).getScore());
		assertEquals("2-4", athletes.get(2).getPlace());
		
		assertEquals(6379, athletes.get(3).getScore());
		assertEquals("2-4", athletes.get(3).getPlace());
		
		assertEquals(6326, athletes.get(4).getScore());
		assertEquals("5", athletes.get(4).getPlace());
		
		assertEquals(6176, athletes.get(5).getScore());
		assertEquals("6", athletes.get(5).getPlace());
	}
	
	@Test
	public void testCalculatePoints() throws ParseException {
		Athlete a;
		Controller ctrl = new Controller();
		
		String[][] results = {
				{"10.43","7.41","14.38","1.99","48.49","13.95","44.76","5.00","64.12","5:16.01","8261"},
				{"13.43","4.35","8.74","1.40","1:6.06","19.05","24.89","2.2","33.48","6:51.02","3033"},
				{"12.43","3.35","7.62","1.4","1:6.05","18.04","24.79","2.1","33.48","5:51.01","3263"},
				{"11.23","6.62","11.49","1.75","51.97","14.89","33.37","3.98","45.6","5:24.26","6379"}
				};

		for (int c = 0; c < results.length; c++) {
			a = new Athlete();
			int res = 0;
			a.setSprint100(ctrl.checkTime(results[c][res++]));
			a.setLongJump(Float.valueOf(results[c][res++].trim()));
			a.setShortPut(Float.valueOf(results[c][res++].trim()));
			a.setHighJump(Float.valueOf(results[c][res++].trim()));
			a.setSprint400(ctrl.checkTime(results[c][res++]));
			a.setHurdles(ctrl.checkTime(results[c][res++]));
			a.setDiscusThrow(Float.valueOf(results[c][res++].trim()));
			a.setPoleVault(Float.valueOf(results[c][res++].trim()));
			a.setJavelinThrow(Float.valueOf(results[c][res++].trim()));
			a.setSprint1500(ctrl.checkTime(results[c][res++]));
			a.setScore(Integer.valueOf(results[c][res++].trim()));
			
			assertEquals(a.getScore(), ctrl.calculatePoints(a));
		}
	}

}
