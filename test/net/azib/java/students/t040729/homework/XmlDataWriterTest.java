package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import net.azib.java.students.t040729.homework.Athlete;
import net.azib.java.students.t040729.homework.XmlDataWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.transform.TransformerFactoryConfigurationError;

import org.junit.Test;

public class XmlDataWriterTest {

	@Test
	public void testXmlFileWriting() throws TransformerFactoryConfigurationError, Exception {
		float[] results = {10.99f,3.95f,23.12f,2.45f,61.99f,12.87f,74.08f,6.14f,98.48f,206f};
		String[] expected = {
				"<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>",
				"<decathlon xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"decathlon.xsd\">",
				"<athlete country=\"HU\" place=\"1\" points=\"10283\">",
				"<name>Szőrös Szűk</name>",
				"<birthdate>1972-04-03</birthdate>",
				"<results>",
				"<e_100_m>10.99</e_100_m>",
				"<e_long_jump>3.95</e_long_jump>",
				"<e_shot_put>23.12</e_shot_put>",
				"<e_high_jump>2.45</e_high_jump>",
				"<e_400_m>1:01.99</e_400_m>",
				"<e_110_m_hurdles>12.87</e_110_m_hurdles>",
				"<e_discus_throw>74.08</e_discus_throw>",
				"<e_pole_vault>6.14</e_pole_vault>",
				"<e_javelin_throw>98.48</e_javelin_throw>",
				"<e_1500_m>3:26.00</e_1500_m>",
				"</results>",
				"</athlete>",
				"</decathlon>"
		};
		File file = File.createTempFile("xmlwritetest","");
		file.deleteOnExit();
		
		List<Athlete> listToWrite = new ArrayList<Athlete>();
		Athlete athlete = new Athlete(new Name("Szőrös Szűk"),new BirthDate("3.04.1972","dd.MM.yyyy"),new Country("HU"));
		
		for (int i=0; i < results.length; i++){
			athlete.insertEventResult((byte) i, results[i]);

		}
		
		athlete.calculateTotalPoints();
		athlete.setPlace("1");
		listToWrite.add(athlete);
		
		XmlDataWriter dataOut = new XmlDataWriter(file.getAbsolutePath());
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
