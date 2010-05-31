package net.azib.java.students.t092851.homework;


import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.junit.Test;


/**
 * DecathlonDataInputDBTest
 *
 * @author Lauri
 */
public class DecathlonDataInputDBTest {
	
	private final ParticipantTest athleteFactory = new ParticipantTest();
	static private final int MAX_COUNT = 30;
	private DecathlonData input1Data;
	private DecathlonData input2Data;
	private Connection conn = null;
	
	
	@Test
	public void testReadData() {
		DecathlonData  outputData;
		ClassUnderTest cut;
		
		input1Data = new DecathlonData();
		input2Data = new DecathlonData();
		
		for (int i = 0; i < MAX_COUNT; i++) {
			input1Data.insert(athleteFactory.createParticipantRandom()); 
			input2Data.insert(athleteFactory.createParticipantRandom()); 
		}
		
		if (buildDatabase()) {
			
			// Case1 - input data by competition name
			{
				cut = new ClassUnderTest("World Championship 2009");
				outputData = cut.readData();
				assertFalse(outputData == null);
				assertTrue(input1Data.equals(outputData));
			}
			
			// Case2 - input data by competition id
			{
				cut = new ClassUnderTest("2");
				outputData = cut.readData();
				assertFalse(outputData == null);
				assertTrue(input2Data.equals(outputData));
			}
			
			closeDatabase();
		}
		else
			assertFalse(true); // Cannot create database for tests!
		
	}

	
	private boolean buildDatabase() {
		Statement  stmt = null;
		
		try {
			conn = openConnection();
			stmt = conn.createStatement();
			
			// Create tables
			{
				stmt.execute("create table athletes     (id integer, name varchar, dob date, country_code varchar)");
				stmt.execute("create table competitions (id integer, name varchar)");
				stmt.execute("create table results      (id integer, athlete_id integer, competition_id integer, race_100m float, long_jump float, shot_put float, high_jump float, race_400m float, hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
			}
				
			// Fill tables
			{
				stmt.execute("insert into competitions values (1, 'World Championship 2009')");
				stmt.execute("insert into competitions values (2, 'World Championship 2010')");
				
				fillAthletesData(input1Data, 1);
				fillAthletesData(input2Data, 2);
			}
			
		}
		catch (SQLException e) {
			closeDatabase();
			return false;
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
			}
			catch (SQLException e) {
			}
		}
		return true;
	}
	
	
	private void closeDatabase() {
		try {
			if (conn != null)
				conn.close();
		}
		catch (SQLException e) {
		}		
	}

	
	private void fillAthletesData(DecathlonData data, int competitionId) throws SQLException {
		PreparedStatement pstm = null;
		int id = (competitionId - 1) * MAX_COUNT;
		
		try {
			for (Participant athlete : data) {
				pstm = conn.prepareStatement("insert into athletes values (?, ?, ?, ?)");
				pstm.setInt(1, ++id);
				pstm.setString(2, athlete.getName());
				pstm.setString(3, (new SimpleDateFormat("yyyy-MM-dd")).format(athlete.getBirthDate()));
				pstm.setString(4, athlete.getCountry());
				pstm.execute();
				pstm.close();
				
				pstm = conn.prepareStatement("insert into results values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstm.setInt(1, id);
				pstm.setInt(2, id);
				pstm.setInt(3, competitionId);
				
				for (DecathlonEvent event: DecathlonEvent.values())
					pstm.setDouble(event.getIndex() + 4, athlete.getResult(event));
				
				pstm.execute();
				pstm.close();
			}
		}
		finally {
			try {
				if (pstm != null)
					pstm.close();
			}
			catch (SQLException e) {
			}
		}
	}
	
	
	private static Connection openConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
	}
	
	
	/**
	 * ClassUnderTest - wrapped DecathlonDataInputDB for using temporary database
	 * 	which resides in tester memory only. This solution does not use
	 *  real database connection for testing.
	 */
	static private class ClassUnderTest extends DecathlonDataInputDB {

		public ClassUnderTest(String competition) {
			super(competition);
		}
		
		@Override
		protected Connection openConnection() throws SQLException {
			return DecathlonDataInputDBTest.openConnection();
		}
	}
	
}
