package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.CompetitionType;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * AbstractInputStreamActionTest
 *
 * @author Kostja
 */
public class CsvInputActionTest {
	private static final String[] RESULT_NAMES = new String[] {"\"Gora Almazov\"", 
		"\"Parad Geroev\""};
	
	private static final String[] RESULTS = new String[] {
		"12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72", 
		"13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01"};
	
	private static final String DATA = RESULT_NAMES[0] + ",01.01.1976,EE," + 
		RESULTS[0] + System.getProperty("line.separator") + 
		RESULT_NAMES[1] + ",21.10.1980,UA," + RESULTS[1];
	
	@Test
	public void testHandleData() throws Exception {
		InputAction inputAction = createCsvInputAction();
		
		Set<Athlete> athletes = inputAction.handleData();
		
		assertEquals(2, athletes.size());
		
		int index = 0;
		for (Athlete athlete : athletes) {
			assertEquals(RESULT_NAMES[index], athlete.getName());
			resultsCheck(RESULTS[index].split(","), athlete.getResults());
			index++;
		}
	}
	
	private InputAction createCsvInputAction() {
		return new CsvInputAction(null) {
			@Override
			InputStream getInputStream() throws IOException {
				return new ByteArrayInputStream(DATA.getBytes());
			}
		};
	}
	
	private void resultsCheck(String[] expected, 
			Map<CompetitionType, Double> results) {
		CompetitionType[] competitionTypes = CompetitionType.values();
		for (int i = 0; i < competitionTypes.length; i++) {
			assertEquals(competitionTypes[i].convert(expected[i]), 
					results.get(competitionTypes[i]));
		}
	}
}
