package net.azib.java.students.t030636.homework;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * PointsForObjectsTest
 *
 * @author Martin
 */
public class PointsForObjectsTest {

	/**
	 * Test method for {@link net.azib.java.students.t030636.homework.PointsForObjects#calculatePoints(java.lang.String[])}.
	 */
	@Test
	public void testCalculatePoints() {
		Competitor c1 = new Competitor();
		Competitor c2 = new Competitor();
		c1.score = 3199;
		c2.score = 3100;
		Competitor [] competitors = {c1, c2};
		String [] s ={"\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76",
				"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01"};
		PointsForObjects pfs = new PointsForObjects();
		ArrayList<Competitor> testSet= pfs.calculatePoints(s);
		int i =0;
		for (Competitor comp : testSet) {
				assertEquals(competitors[i].score,comp.score );
			i++;
		}
	
	}

}
