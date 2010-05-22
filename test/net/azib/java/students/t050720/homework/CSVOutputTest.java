package net.azib.java.students.t050720.homework;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * CSVOutputTest
 *
 * @author Marek
 */
public class CSVOutputTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.CSVOutput#flush(java.util.ArrayList)}.
	 */
	@Test
	public void testFlush() {
		File ftmp=null;
		try {
			ftmp = File.createTempFile("csvo", "tmp");
			ftmp.deleteOnExit();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		ArrayList<Record> records = new ArrayList<Record>();
		Record rec=new Record();
		
		rec.setAthlete("Fancyman");
		rec.setRace_100m((float) 9.90);
		rec.setBirthDate("01.01.1987");
		rec.setCountry("EE");
		
		records.add(rec);
		
		CSVOutput o=new CSVOutput(ftmp.getAbsolutePath());
		try {
			o.flush(records);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		String output=null;

		try {
			FileReader freader=new FileReader(ftmp);
			BufferedReader r=new BufferedReader(freader);
			output=r.readLine();
			r.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String ls=System.getProperty("line.separator");
		String myStr=new String("1,1121,\"Fancyman\",01.01.1987,EE,9.90,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0:00.00"+ls);
		assertEquals(myStr.trim(), output.trim());
	}

}
