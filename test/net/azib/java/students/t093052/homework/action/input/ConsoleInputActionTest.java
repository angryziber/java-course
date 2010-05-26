package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.CompetitionType;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

/**
 * ConsoleInputActionTest
 *
 * @author Kostja
 */
public class ConsoleInputActionTest {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private static final String ATHLETE_NAME = "\"Tolpa Baranov\"";
	private static final String DATE_OF_BIRTH = "01.01.1976";
	private static final String COUNTRY = "EE";
	
	private static final String SPRINT_100M = "12.61";
	private static final String LONG_JUMP = "5.00";
	private static final String SHOT_PUT = "9.22";
	private static final String HIGH_JUMP = "1.50";
	private static final String SPRINT_400M = "59.39";
	private static final String HURDLES_110M = "16.43";
	private static final String DISCUS_THROW = "21.60";
	private static final String POLE_VAULT = "2.60";
	private static final String JAVELIN_THROW = "35.81";
	private static final String RACE_1500M = "5:25.72";
	
	private static final String[] RESULTS = new String[] {
		SPRINT_100M, LONG_JUMP, SHOT_PUT, HIGH_JUMP, SPRINT_400M, 
		HURDLES_110M, DISCUS_THROW, POLE_VAULT, JAVELIN_THROW, RACE_1500M};
	
	@Test
	public void testHandleData() throws Exception {
		InputAction inputAction = createConsoleInputAction();
		
		Set<Athlete> athletes = inputAction.handleData();
		
		assertEquals(1, athletes.size());
		
		Athlete athlete = athletes.iterator().next();
		
		assertEquals(ATHLETE_NAME, athlete.getName());
		resultsCheck(RESULTS, athlete.getResults());
	}

	private void resultsCheck(String[] expected, Map<CompetitionType, String> results) {
		CompetitionType[] competitionTypes = CompetitionType.values();
		for (int i = 0; i < competitionTypes.length; i++) {
			assertEquals(expected[i], results.get(competitionTypes[i]));
		}
	}
	
	private String createData() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(LINE_SEPARATOR).append(ATHLETE_NAME).append(
			LINE_SEPARATOR).append(DATE_OF_BIRTH).append(
			LINE_SEPARATOR).append(COUNTRY).append(LINE_SEPARATOR);
		
		for (int i = 0; i < RESULTS.length; i++) {
			stringBuilder.append(RESULTS[i]).append(LINE_SEPARATOR);
		}
		
		stringBuilder.append("OK");
		
		return stringBuilder.toString();
	}
	
	private InputAction createConsoleInputAction() {
		return new ConsoleInputAction() {
			@Override
			InputStream getInputStream() throws IOException {
				return new ByteArrayInputStream(createData().getBytes());
			}
			
			@Override
			String nextLine(Scanner scanner) {
				return scanner.nextLine();
			}
			
			@Override
			String getValue(String title, Scanner scanner, String pattern) {
				return scanner.nextLine();
			}
		};
	}
	
}
