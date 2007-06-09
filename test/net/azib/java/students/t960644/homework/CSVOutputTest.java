package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * CSVOutputTest
 *
 * @author Lembit
 */
public class CSVOutputTest {
	@Test
	public void testQuotation() throws Exception {
		CSVOutput csv = new CSVOutput();
		assertTrue(csv.quotation("neli").toString().equals("\"neli\""));
	}
	
	@Test
	public void testWriteLine() throws Exception {
		CSVOutput csv = new CSVOutput();
		Result result = OutputTest.singleResult();
		assertTrue(csv.writeLine(result).toString().equals("1,8815,\"Peeter Hülss\",01.05.1986,EE,10.600,7.63,14.90,2.03,46.230,14.400,43.40,5.40,67.01,4:29.580"));
	}
}
