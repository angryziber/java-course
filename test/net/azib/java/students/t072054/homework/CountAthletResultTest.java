package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

/**
 * CountAthletResultTest
 * 
 * @author r_vassiljev
 */
public class CountAthletResultTest {

	/**
	 * Test method for ???
	 */
	@Test
	public void testAthletResult() {
		LoadNewResults lnr = new LoadNewResults();

		lnr.LoadResults();

		int i;
		double[] buf = new double[14];
		
		try {
			do {
				for (i = 4; i < 14; i++) {
					//System.out.println(lnr.rs3.getDouble(i));
					buf[i] = lnr.rs3.getDouble(i);
				}
				double result = CountAthletResult.CountResult(buf[4], buf[5], buf[6], 
						buf[7], buf[8], buf[9], buf[10], buf[11], buf[12], buf[13]);
				System.out.println(result);
			}
			while (lnr.rs3.next());
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

		lnr.ConnClose();
	}
}
