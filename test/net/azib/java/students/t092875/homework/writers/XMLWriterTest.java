package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.*;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * XMLWriterTest
 *
 * @author Mihhail
 */
public class XMLWriterTest {
	@Before
	public void initLocale() {
		Locale.setDefault(new Locale("et"));
	}
	
	@Test
	public void  testWrite(){
		List<Athlete> athletes = new ArrayList<Athlete>();
		Date dob = new Date(0);
		String[] results = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		Athlete a = new Athlete("Mihhail Arhipov",dob,"ET",results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
		XMLWriter writer = new XMLWriter("test_write_result.xml");
		writer.write(athletes);
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File xml = new File("test_write_result.xml");
			Document doc = builder.parse(new FileInputStream(xml));
			assertTrue(xml.exists());
			
			assertXpathExists("/athletes/athlete", doc);
			assertXpathExists("/athletes/athlete/event", doc);
			assertXpathExists("/athletes/athlete/total_result", doc);
			
			assertXpathEvaluatesTo("Mihhail Arhipov", "/athletes/athlete[1]/@name", doc);
			assertXpathEvaluatesTo("ET", "/athletes/athlete[1]/@origin", doc);
			assertXpathEvaluatesTo("1.01.70", "/athletes/athlete[1]/@dob", doc);
			assertXpathEvaluatesTo("1", "/athletes/athlete[1]/@place", doc);
			
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[1]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[2]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[3]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[4]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[5]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[6]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[7]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[8]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[9]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[10]", doc);
			assertXpathEvaluatesTo("2000", "/athletes/athlete[1]/total_result[1]", doc);
		
			assertXpathEvaluatesTo("SPRINT_100M", "/athletes/athlete[1]/event[1]/@event_name", doc);
			assertXpathEvaluatesTo("LONG_JUMP", "/athletes/athlete[1]/event[2]/@event_name", doc);
			assertXpathEvaluatesTo("SHOT_PUT", "/athletes/athlete[1]/event[3]/@event_name", doc);
			assertXpathEvaluatesTo("HIGH_JUMP", "/athletes/athlete[1]/event[4]/@event_name", doc);
			assertXpathEvaluatesTo("SPRINT_400M", "/athletes/athlete[1]/event[5]/@event_name", doc);
			assertXpathEvaluatesTo("HURDLES_110M", "/athletes/athlete[1]/event[6]/@event_name", doc);
			assertXpathEvaluatesTo("DISCUS_THROW", "/athletes/athlete[1]/event[7]/@event_name", doc);
			assertXpathEvaluatesTo("POLE_VAULT", "/athletes/athlete[1]/event[8]/@event_name", doc);
			assertXpathEvaluatesTo("JAVELIN_THROW", "/athletes/athlete[1]/event[9]/@event_name", doc);
			assertXpathEvaluatesTo("RACE_1500M", "/athletes/athlete[1]/event[10]/@event_name", doc);
		
			xml.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void  testGenerateXML(){
		List<Athlete> athletes = new ArrayList<Athlete>();
		Date dob = new Date(0);
		String[] results = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		Athlete a = new Athlete("Mihhail Arhipov",dob,"ET",results);
		a.setPlace("1");
		a.setResult(2000);
		athletes.add(a);
		XMLWriter writer = new XMLWriter("test_write_result.xml");
		try {
			Document doc = writer.generateXML(athletes);
			
			assertXpathExists("/athletes/athlete", doc);
			assertXpathExists("/athletes/athlete/event", doc);
			assertXpathExists("/athletes/athlete/total_result", doc);
			
			assertXpathEvaluatesTo("Mihhail Arhipov", "/athletes/athlete[1]/@name", doc);
			assertXpathEvaluatesTo("ET", "/athletes/athlete[1]/@origin", doc);
			assertXpathEvaluatesTo("1.01.70", "/athletes/athlete[1]/@dob", doc);
			assertXpathEvaluatesTo("1", "/athletes/athlete[1]/@place", doc);
			
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[1]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[2]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[3]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[4]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[5]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[6]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[7]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[8]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[9]", doc);
			assertXpathEvaluatesTo("50.20", "/athletes/athlete[1]/event[10]", doc);
			assertXpathEvaluatesTo("2000", "/athletes/athlete[1]/total_result[1]", doc);
		
			assertXpathEvaluatesTo("SPRINT_100M", "/athletes/athlete[1]/event[1]/@event_name", doc);
			assertXpathEvaluatesTo("LONG_JUMP", "/athletes/athlete[1]/event[2]/@event_name", doc);
			assertXpathEvaluatesTo("SHOT_PUT", "/athletes/athlete[1]/event[3]/@event_name", doc);
			assertXpathEvaluatesTo("HIGH_JUMP", "/athletes/athlete[1]/event[4]/@event_name", doc);
			assertXpathEvaluatesTo("SPRINT_400M", "/athletes/athlete[1]/event[5]/@event_name", doc);
			assertXpathEvaluatesTo("HURDLES_110M", "/athletes/athlete[1]/event[6]/@event_name", doc);
			assertXpathEvaluatesTo("DISCUS_THROW", "/athletes/athlete[1]/event[7]/@event_name", doc);
			assertXpathEvaluatesTo("POLE_VAULT", "/athletes/athlete[1]/event[8]/@event_name", doc);
			assertXpathEvaluatesTo("JAVELIN_THROW", "/athletes/athlete[1]/event[9]/@event_name", doc);
			assertXpathEvaluatesTo("RACE_1500M", "/athletes/athlete[1]/event[10]/@event_name", doc);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
