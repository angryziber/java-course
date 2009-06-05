package net.azib.java.students.t040750.homework.parser.db;

import net.azib.java.students.t040750.homework.generic.DecathlonData;
import net.azib.java.students.t040750.homework.main.DecathlonDemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

/**
 * DataReaderTest
 *
 * @author karpo
 */
public class DataReaderTest {
	private DataReader reader;
	private List<DecathlonData> decathlonData;
	private Properties props;
	
	@Before
	public void setUp() throws Exception {
		reader = new DataReader();
		decathlonData = new ArrayList<DecathlonData>();
		props = new Properties();
		props.load(DecathlonDemo.class.getResourceAsStream("testdata.properties"));
	}

	@Test
	public void testGetDecathlonData() throws Exception {
		decathlonData = reader.getDecathlonData(props.getProperty("competition"));
		assertFalse(decathlonData.isEmpty());
		
		decathlonData = reader.getDecathlonData(props.getProperty("invalidcompetition"));
		assertTrue(decathlonData.isEmpty());
	}
}
