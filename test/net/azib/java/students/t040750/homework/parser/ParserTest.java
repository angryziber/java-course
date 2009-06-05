package net.azib.java.students.t040750.homework.parser;

import static org.junit.Assert.*;

import net.azib.java.students.t040750.homework.generic.Athlete;
import net.azib.java.students.t040750.homework.generic.DecathlonData;
import net.azib.java.students.t040750.homework.generic.Result;
import net.azib.java.students.t040750.homework.main.DecathlonDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

/**
 * ParserTest
 *
 * @author karpo
 */
public class ParserTest {
	private Parser parser;
	private List<DecathlonData> decathlonData;
	private List<DecathlonData> testDecathlonData;
	private Properties props;
	private Athlete athlete;
	private Result result;
	private long points;
	
	@Before
	public void setUp() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		parser = new Parser();
		
		decathlonData = new ArrayList<DecathlonData>();
		testDecathlonData = new ArrayList<DecathlonData>();
		
		props = new Properties();
		props.load(DecathlonDemo.class.getResourceAsStream("testdata.properties"));
		
		athlete = new Athlete("Erki Nool",new java.sql.Date(
				df.parse("1970-06-25").getTime()), "EE");
		result = new Result();
		
		result.setRun100m(10.94f);
		result.setLongJump(7.83f);
		result.setShotPut(12.48f);
		result.setHighJump(2.0f);
		result.setRun400m(49.72f);
		result.setHurdles110m(15.67f);
		result.setDiscus(38.3f);
		result.setPoleVault(5.4f);
		result.setJavelin(55.84f);
		result.setRun1500m(271.72f);
		
		points = 8001;
		
		testDecathlonData.add(new DecathlonData(athlete,result,points));
		
		athlete = new Athlete("Василий Пупкин",new java.sql.Date(
				df.parse("1980-10-21").getTime()), "UA");
		result = new Result();
		
		result.setRun100m(13.43f);
		result.setLongJump(4.35f);
		result.setShotPut(8.64f);
		result.setHighJump(1.5f);
		result.setRun400m(66.06f);
		result.setHurdles110m(19.05f);
		result.setDiscus(24.89f);
		result.setPoleVault(2.2f);
		result.setJavelin(33.48f);
		result.setRun1500m(411.01f);
		
		points = 3099;
		
		testDecathlonData.add(new DecathlonData(athlete,result,points));
	}

	@Test
	public void loadDBDataTest() throws Exception {
		decathlonData = parser.loadDBData(props.getProperty("competition"));
		assertFalse(decathlonData.isEmpty());
		
		decathlonData = parser.loadDBData(props.getProperty("invalidcompetition"));
		assertTrue(decathlonData.isEmpty());
	}
	
	@Test
	public void loadCMDDataTest() throws Exception {
		
	}
	
	@Test
	public void loadCSVDataTest() throws Exception {
	/*	decathlonData = parser.loadCSVData(DecathlonDemo.class.getResourceAsStream("in.csv"));
		assertFalse(decathlonData.isEmpty());
		
		decathlonData = parser.loadCSVData(DecathlonDemo.class.getResourceAsStream("invalid_nat.csv"));
		assertTrue(decathlonData.isEmpty());
		
		decathlonData = parser.loadCSVData(DecathlonDemo.class.getResourceAsStream("invalid_result.csv"));
		assertTrue(decathlonData.isEmpty());
	*/
	}
	
	@Test
	public void outputCMDDataTest() throws Exception {
		parser.outputCMDData(testDecathlonData);
	}
	
	@Test
	public void outputCSVDataTest() throws Exception {
		parser.outputCSVData("parser_out.csv",testDecathlonData);
	}
	
	@Test
	public void outputXMLDataTest() throws Exception {
		parser.outputXMLData("parser_out.xml",testDecathlonData);
	}
	
	@Test
	public void outputHTMLDataTest() throws Exception {
		//parser.outputHTMLData("parser_out.html",testDecathlonData);
	}

}
