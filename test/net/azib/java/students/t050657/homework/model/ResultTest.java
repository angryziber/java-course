package net.azib.java.students.t050657.homework.model;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * ResultTest
 * 
 * @author Boriss
 */
public class ResultTest extends TestCase{

	@Test
	public void testEquals() {
		Result a = new Result(5);
		Result b = new Result(7);
		Result c = new Result(5);

		assertTrue(a.equals(c));
		assertFalse(a.equals(b));
		assertFalse(b.equals(c));
	}

	@Test
	public void testCompareTo() {
		Result a = new Result(5);
		Result b = new Result(7);

		a.setDiscusThrow(12.61);
		a.setHighJump(500.0);
		a.setHurdles(10.12);
		a.setJavelinThrow(1.35);
		a.setLongJump(70.12);
		a.setPoleVault(18.65);
		a.setRace100(15.2);
		a.setRace1500(18.2);
		a.setRace400(189.2);
		a.setShotPut(175.0);

		b.setDiscusThrow(780.0);
		b.setHighJump(25.0);
		b.setHurdles(22.5);
		b.setJavelinThrow(2.25);
		b.setLongJump(2.45);
		b.setPoleVault(2.05);
		b.setRace100(2.156);
		b.setRace1500(224.0);
		b.setRace400(15.22);
		b.setShotPut(45.2);

		assertEquals(1, a.compareTo(b));
	}

	@Test
	public void testCopy() {
		Result a = new Result(5);
		Result b = new Result();

		b.copyResult(a);
		assertTrue(a.equals(b));
	}

	@Test
	public void testGetConvertedResults() {
		Result a = new Result(7);

		a.setDiscusThrow(39.0);
		a.setHighJump(204.99999523162842);
		a.setHurdles(15.600000381469727);
		a.setJavelinThrow(55.95000076293945);
		a.setLongJump(786.9999885559082);
		a.setPoleVault(544.9999809265137);
		a.setRace100(11.520000457763672);
		a.setRace1500(274.4200134277344);
		a.setRace400(50.04999923706055);
		a.setShotPut(12.399999618530273);

		List list = a.getConvertedResults();
		
		Double[] b = {748.8875231534564, 1027.9907623990807, 631.2137119730543, 850.0148246973539,
				812.7893709164897, 778.9513903374427, 644.7644604445899, 1051.909690717133,
				677.5960632589859, 716.3502814061441};
		
		List l = Arrays.asList(b);
		
		assertTrue(l.equals(list));
	}
	
	
}
