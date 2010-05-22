package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * XMLOutputTest
 *
 * @author Marek
 */
public class XMLOutputTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.XMLOutput#flush(java.util.ArrayList)}.
	 */
	@Test
	public void testFlush() {
		File ftmp=null;
		try {
			ftmp = File.createTempFile("xmlo", "tmp");
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
		
		XMLOutput o=new XMLOutput(ftmp.getAbsolutePath());
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
		String myStr=new String("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><competition><result><pos>1</pos><score>1121</score><athlete>Fancyman</athlete><dob>01.01.1987</dob><country>EE</country><event><name>100m race</name><performance>9.9</performance></event><event><name>Long jump</name><performance>0.0</performance></event><event><name>Shot put</name><performance>0.0</performance></event><event><name>High jump</name><performance>0.0</performance></event><event><name>400m race</name><performance>0.00</performance></event><event><name>110m hurdles race</name><performance>0.0</performance></event><event><name>Discus throw</name><performance>0.0</performance></event><event><name>Pole vault</name><performance>0.0</performance></event><event><name>Javelin throw</name><performance>0.0</performance></event><event><name>1500m race</name><performance>0:00.00</performance></event></result></competition>");
		assertEquals(myStr.trim(), output.trim());
	}

}
