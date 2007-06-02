package net.azib.java.students.t030647;

import static org.junit.Assert.*;

import net.azib.java.students.t030647.homework.SqlQuery;

import org.junit.Test;

/**
 * TestSQL
 *
 * @author Igor
 */
public class SqlQueryTest {

	/**
	 * @param args
	 */
	@Test
	public void testname() throws Exception {
		String[] s1 = {"Siim Susi,01.01.1976,EE,14.15,3.98,10.0,1.45,70.12,18.65,29.15,2.15,32.67,466.6",
				"Erki Nool,25.06.1970,EE,10.94,7.83,12.48,2.0,49.72,15.67,38.3,5.4,55.84,271.72"};
		String[] s = new SqlQuery("Training in Tallinn").getData();
		assertEquals(s1, s);
	}


}
