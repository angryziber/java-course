package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

/**
 * HtmlDataWriterTest
 * 
 * @author ValleTon
 */
public class HtmlDataWriterTest {

	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.HtmlDataWriter#putCompetitionData(java.util.List)}.
	 * @throws Exception 
	 */
	@Test
	public void testHtmlFileGeneration() throws Exception {
		float[] results = {10.99f,3.95f,23.12f,2.45f,61.99f,12.87f,74.08f,6.14f,98.48f,206f};
		String[] expected = {
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">",
				"<html>",
				"<head>",
				"<META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">",
				"<title>Decathlon competition results</title>",
				"</head>",
				"<body>",
				"<table cellpadding=\"3\" cellspacing=\"0\" border=\"1\">",
				"<tr style=\"background-color: #afa; text-align: center\">",
				"<td rowspan=\"2\">Place</td><td rowspan=\"2\">Points</td><td rowspan=\"2\" style=\"text-align: center\">Name</td><td rowspan=\"2\">Birthdate</td><td rowspan=\"2\">Country</td><td colspan=\"5\" style=\"background-color: #ffa; text-align: center\">Day 1</td><td colspan=\"5\" style=\"background-color: #ffa; text-align: center\">Day 2</td>",
				"</tr>",
				"<tr style=\"background-color: #afa; text-align: center\">",
				"<td>100 meters</td><td>Long Jump</td><td>Shot Put</td><td>High Jump</td><td>400 meters</td><td>110 meter hurdles</td><td>Discus throw</td><td>Pole Vault</td><td>Javelin throw</td><td>1500 meters</td>",
				"</tr>",
				"<tr style=\"background-color: #ddf; text-align: right\">",
				"<td>1</td><td>10283</td><td style=\"text-align: left\">Szőr&ouml;s Szűk</td><td>1972-04-03</td><td>HU</td><td>10.99</td><td>3.95</td><td>23.12</td><td>2.45</td><td>1:01.99</td><td>12.87</td><td>74.08</td><td>6.14</td><td>98.48</td><td>3:26.00</td>",
				"</tr>",
				"</table>",
				"</body>",
				"</html>"
		};
		
		File file = File.createTempFile("htmlwritetest","");
		file.deleteOnExit();
		
		List<Athlete> listToWrite = new ArrayList<Athlete>();
		Athlete athlete = new Athlete(new Name("Szőrös Szűk"),new BirthDate("3.04.1972","dd.MM.yyyy"),new Country("HU"));
		
		for (int i=0; i < results.length; i++){
			athlete.insertEventResult((byte) i, results[i]);

		}
		
		athlete.calculateTotalPoints();
		athlete.setPlace("1");
		listToWrite.add(athlete);
		
		HtmlDataWriter dataOut = new HtmlDataWriter(file.getAbsolutePath());
		dataOut.setAppProperties(getFakeProperties());
		dataOut.putCompetitionData(listToWrite);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
		String readLine;
		int i = 0;
		while ((readLine=input.readLine()) != null){
			assertEquals(expected[i],readLine);
			i++;
		}

		input.close();
	}
	
	private Properties getFakeProperties(){
		Properties fakeProperties = new Properties();
		fakeProperties.setProperty("encoding","utf-8");
		fakeProperties.setProperty("dateformat_string","dd.MM.yyyy");
		fakeProperties.setProperty("dateformat_console_short","dd.MM.yy");
		fakeProperties.setProperty("xml_dateformat_string","yyyy-MM-dd");
		return fakeProperties;
	}
}
