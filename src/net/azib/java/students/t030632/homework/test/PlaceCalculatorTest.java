package net.azib.java.students.t030632.homework.test;

import net.azib.java.students.t030632.homework.Competitor;
import net.azib.java.students.t030632.homework.PlaceCalculator;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;


/**
 * PlaceCalculatorTest
 *
 * @author Toni
 */
public class PlaceCalculatorTest {
	@Test
	public void testPlaceCalculator() throws Exception {
		List <Competitor> champsLIst = new LinkedList<Competitor> ();
		champsLIst.add(new Competitor("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 "));// points 4238
		champsLIst.add(new Competitor("\"Siim Silm\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 "));// points 4238
		champsLIst.add(new Competitor("\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 "));// points 3204
		PlaceCalculator pc = new PlaceCalculator(champsLIst);
		Map <Integer, String> map = pc.getPlaces();
		assertEquals("1-2",map.get(4238));
		assertEquals("3",map.get(3204));
	}

}
