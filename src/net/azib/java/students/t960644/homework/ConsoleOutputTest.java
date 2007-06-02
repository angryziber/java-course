package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;
/**
 * ConsoleOutputTest
 *
 * @author Lembit
 */
public class ConsoleOutputTest {
	
	@Test
	public void testpadLeft() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.padLeft("a", 1).toString().equals("a|"));
		assertTrue(co.padLeft("aa", 1).toString().equals("aa|"));
		assertTrue(co.padLeft("a", 2).toString().equals(" a|"));
	}
	
	@Test
	public void testpadRight() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.padRight("a", 1).toString().equals("a|"));
		assertTrue(co.padRight("aa", 1).toString().equals("aa|"));
		assertTrue(co.padRight("a", 2).toString().equals("a |"));		
	}
	@Test
	public void testSpaces() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.spaces(4).toString().equals("    "));
		assertTrue(co.spaces(0).toString().equals(""));
		assertTrue(co.spaces(-1).toString().equals(""));
	}
	@Test
	public void testWriteLine() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		Result res = new Result();
		Athlete a = new Athlete();
		a.setName("Peeter Pauksoo");
		a.setBorn(Date.valueOf("1950-05-01"));
		a.setCountryCode("EE");
		res.setAthlete(a);
		res.setPosition("1");
		res.setRace100(10.60);
		res.setLongJump(7.63);
		res.setShotPut(14.90);
		res.setHighJump(2.03);
		res.setRace400(46.23);
		res.setHurdles110(14.40);
		res.setDiscusThrow(43.40);
		res.setPoleVault(5.40);
		res.setJavelinThrow(67.01);
		res.setRace1500(269.58);
		assertTrue(co.writeLine(5, 20, res).toString().
				equals("     1|Peeter Pauksoo      |1950-05-01|EE| 8815| 10.60|  7.63| 14.90|  2.03|   46.23| 14.40| 43.40|  5.40| 67.01|4:29.580|"));
		
	}

}
