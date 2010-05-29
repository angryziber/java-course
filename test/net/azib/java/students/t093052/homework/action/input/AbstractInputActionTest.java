package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.CompetitionType;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * ConsoleInputActionTest
 *
 * @author Kostja
 */
public class AbstractInputActionTest {
	private static final String[] RESULTS = new String[] { "12.61", "5.00", 
		"9.22", "1.50", "59.39", "16.43", "21.60", "2.60", "35.81", "5:25.72"};
	
	private static final String[] RESULT_NAMES = new String[] {"Vagon Kovbojev", 
			"Kamaz Arbuzov", "Rulon Obojev", "Bidon Pomojev"};
	
	@Test
	public void testCreateAthlete() throws Exception {
		AbstractInputAction abstractInputAction = createAbstractInputAction();
		
		String name = "Karabas Barabasov";
		String dateOfBirth = "01.01.1976";
		String country = "EE";
		
		Athlete athlete = abstractInputAction.createAthlete(name, 
			dateOfBirth, country, RESULTS[0], RESULTS[1], RESULTS[2], RESULTS[3], 
			RESULTS[4], RESULTS[5], RESULTS[6], RESULTS[7], RESULTS[8], RESULTS[9]);
		
		assertEquals(name, athlete.getName());
		assertEquals(dateOfBirth, athlete.getDateOfBirth());
		assertEquals(country, athlete.getCountry());
		
		resultsCheck(athlete.getResults());
	}
	
	@Test
	public void testCreateAthleteSet() throws Exception {
		Set<Athlete> athletes = createAthletes();
		
		int index = 0;
		for (Athlete athlete : athletes) {
			assertEquals(RESULT_NAMES[index++], athlete.getName());
		}
	}
	
	private void resultsCheck(Map<CompetitionType, String> result) {
		CompetitionType[] competitionTypes = CompetitionType.values();
		for (int i = 0; i < competitionTypes.length; i++) {
			assertEquals(RESULTS[i], result.get(competitionTypes[i]));
		}
	}
	
	private Set<Athlete> createAthletes() {
		AbstractInputAction abstractInputAction = createAbstractInputAction();
		Set<Athlete> athletes = abstractInputAction.createAthleteSet();
		
		athletes.add(createAthlete(RESULT_NAMES[3], new Double(25)));
		athletes.add(createAthlete(RESULT_NAMES[2], new Double(50)));
		athletes.add(createAthlete(RESULT_NAMES[0], new Double(100)));
		athletes.add(createAthlete(RESULT_NAMES[1], new Double(50)));
		
		return athletes;
	}
	
	private Athlete createAthlete(final String name, final Double points) {
		return new Athlete() {
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public Double getPoints() {
				return points;
			}
		};
	}

	private AbstractInputAction createAbstractInputAction() {
		return new AbstractInputAction() {
			@Override
			public Set<Athlete> handleData() {
				return null;
			}

			@Override
			DateFormat getDateFormat() {
				return DateFormat.getDateInstance(DateFormat.MEDIUM);
			}
		};
	}
}
