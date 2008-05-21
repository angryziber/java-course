package net.azib.java.students.t980814.homework;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;


/**
 * ResultsTest
 *
 * @author dell
 */
public class ResultsTest {

	class MockAthlete extends Athlete {
		public MockAthlete() {
			athleteId = 0;
		}
		
		public String toString() {
			return "nothing";
		}
		
		public String toStringCSV() {
			return toString();
		}
		
		public Element addAthleteDataToElement(Element root) {
			return root;
		}
	}
	
	private LinkedList<Float> getTestResults() {
		LinkedList<Float> resultList = new LinkedList<Float>();
		resultList.add(10.12f);
		resultList.add(7.78f);
		resultList.add(15.00f);
		resultList.add(2.02f);
		resultList.add(47.25f);
		resultList.add(14.65f);
		resultList.add(43.22f);
		resultList.add(5.05f);
		resultList.add(62.54f);
		resultList.add(275.22f);
		return resultList;
	}
	
	@Test
	public void testResultsConstructor() {
		Results a = new Results(new MockAthlete(), getTestResults());
		assertEquals("Results are not calculated correctly", a.getSum(), 8665);
	}
	
	@Test
	public void testResultsConstructorCSV() {
		boolean exceptionWasThrown = false;
		try {
			Results a = new Results("\"Nipi Tiri\",02.02.1999,EE,10.12,7.78,15.00,2.02,47.25,14.65,43.22,5.05,62.54,4:35.22");
			assertEquals("Results are not calculated correctly", a.getSum(), 8665);
		}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
			e.printStackTrace();
		}
		assertEquals("Unexpected exception was thrown when creating Results", false, exceptionWasThrown);		
	}
	
	@Test
	public void testResultsConstructorDB() throws SQLException {
		boolean exceptionWasThrown = false;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
			Statement stmt = conn.createStatement();
			stmt.execute("create table results (id integer, athlete_id integer, competition_id integer, " +
					     "race_100m float, long_jump float, shot_put float, high_jump float, race_400m float," +
					     "hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
			stmt.execute("insert into results values (3, 1, 1, 10.12, 7.78, 15.00, 2.02, 47.25, 14.65, 43.22, 5.05, 62.54, 275.22)");
			// Unfortunately I didn't find an elegant way to mock the Athlete that I'm using inside Results class,
			// therefore I will add athletes table as well.
			stmt.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
			stmt.execute("insert into athletes values (1, 'John Doe', '1970-02-03', 'EE')");
			
			Results a = new Results(conn, 3);
			assertEquals("Results are not calculated correctly", a.getSum(), 8665);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
			e.printStackTrace();
		}
		finally {
			if (conn != null)
				conn.close();
		}
		assertEquals("Unexpected exception was thrown when creating Results", false, exceptionWasThrown);		
	}

	@Test
	public void testResultsToString() {
		Results a = new Results(new MockAthlete(), getTestResults());
		assertEquals("Results are not output correctly / toString()", a.toString(),
					 "8665 - nothing, Results: 10.12,7.78,15.00,2.02,47.25,14.65,43.22,5.05,62.54,4:35.22");
		assertEquals("Results are not output correctly / toStringCSV()", a.toStringCSV(),
		 			 "8665,nothing,10.12,7.78,15.00,2.02,47.25,14.65,43.22,5.05,62.54,4:35.22");
	}

	@Test
	public void testResultsDOM4JElement() {
		boolean exceptionWasThrown = false;
		try {
			Results a = new Results(new MockAthlete(), getTestResults());
			Document document = DocumentHelper.createDocument();
			Element root = document.addElement("competition");
			root = a.addResultsDataToElement(root, "123");

			assertEquals("The 'athlete'-s id attribute was not added correctly", "0", root.element("athlete").attributeValue("id") );
			assertEquals("The 'position' element was not added correctly", "123", root.element("athlete").elementText("position"));
			assertEquals("The 'score' element was not added correctly", "8665", root.element("athlete").elementText("score"));
			assertEquals("The 'race_100m' element was not added correctly", "10.12", root.element("athlete").element("results").elementText("race_100m"));
			assertEquals("The 'long_jump' element was not added correctly", "7.78", root.element("athlete").element("results").elementText("long_jump"));
			assertEquals("The 'shot_put' element was not added correctly", "15.00", root.element("athlete").element("results").elementText("shot_put"));
			assertEquals("The 'high_jump' element was not added correctly", "2.02", root.element("athlete").element("results").elementText("high_jump"));
			assertEquals("The 'race_400m' element was not added correctly", "47.25", root.element("athlete").element("results").elementText("race_400m"));
			assertEquals("The 'hurdles_110m' element was not added correctly", "14.65", root.element("athlete").element("results").elementText("hurdles_110m"));
			assertEquals("The 'discus_throw' element was not added correctly", "43.22", root.element("athlete").element("results").elementText("discus_throw"));
			assertEquals("The 'pole_vault' element was not added correctly", "5.05", root.element("athlete").element("results").elementText("pole_vault"));
			assertEquals("The 'javelin_throw' element was not added correctly", "62.54", root.element("athlete").element("results").elementText("javelin_throw"));
			assertEquals("The 'race_1500m' element was not added correctly", "4:35.22", root.element("athlete").element("results").elementText("race_1500m"));
		}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
			e.printStackTrace();
		}
		assertEquals("Unexpected exception was thrown when creating Athlete", false, exceptionWasThrown);
	}
}

