package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

/**
 * Test for HTML export facility
 *
 * @author Marek
 */
public class HTMLOutputTest {
	/**
	 * Simple HTML export test, creating a file and comparing it to a predefined result.
	 * Test method for {@link net.azib.java.students.t050720.homework.HTMLOutput#flush(java.util.ArrayList)}.
	 */

	@Test
	public void telush() {
		File ftmp=null;
		try {
			ftmp = File.createTempFile("htmlo", "tmp");
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
		
		HTMLOutput o=new HTMLOutput(ftmp.getAbsolutePath());
		try {
			o.flush(records);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		String output=new String("");
		String outputTmp=new String("");

		try {
			FileReader freader=new FileReader(ftmp);
			BufferedReader r=new BufferedReader(freader);

			while(outputTmp!=null) {
				outputTmp=r.readLine();
				if(outputTmp!=null) output+=outputTmp;
			} 
			r.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer myStr=new StringBuffer("");
		myStr.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		myStr.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		myStr.append("<head>");
		myStr.append("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		myStr.append("<title>Decathlon results</title>");
		myStr.append("</head><body><div>");
		myStr.append("<h1>1. Fancyman (EE), 01.01.1987</h1>");
		myStr.append("<h2>Score:1121</h2>");
		myStr.append("<table border=\"0\"><tr>");
		myStr.append("<td>Competition</td><td>Result</td>");
		myStr.append("</tr><tr><td>100m race</td><td>9.9</td>");
		myStr.append("</tr><tr><td>Long jump</td><td>0.0</td>");
		myStr.append("</tr><tr><td>Shot put</td><td>0.0</td>");
		myStr.append("</tr><tr><td>High jump</td><td>0.0</td>");
		myStr.append("</tr><tr><td>400m race</td><td>0.00</td>");
		myStr.append("</tr><tr><td>110m hurdles race</td><td>0.0</td>");
		myStr.append("</tr><tr><td>Discus throw</td><td>0.0</td>");
		myStr.append("</tr><tr><td>Pole vault</td><td>0.0</td>");
		myStr.append("</tr><tr><td>Javelin throw</td><td>0.0</td>");
		myStr.append("</tr><tr><td>1500m race</td><td>0:00.00</td>");
		myStr.append("</tr></table></div></body></html>");

		assertEquals(myStr.toString().trim(), output.trim());
	}

}
