package net.azib.java.students.t092875.homework.readers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DatabaseReader
 *
 * @author Mihhail
 */
public class DatabaseReader implements DecathlonReader {
	int database;
	boolean testMode = false;
	Connection fakeConnection = null;
	
	/**
	 * Creates a DatabaseReader object for a specific competition
	 * @param database - the id of the competition
	 */
	public DatabaseReader(int database){
		this.database = database;
	}
	
	/**
	 * Read the data from the database and output a list of athletes
	 * @output List of athletes
	 */
	@Override
	public List<Athlete> read() {
		List<Athlete> athletes = new ArrayList<Athlete>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://java.azib.net:3306/decathlon", "java", "java");
			if(testMode){
				conn = this.fakeConnection;
			}
			PreparedStatement statement = conn.prepareStatement("SELECT athletes.name as name, athletes.dob as dob, athletes.country_code as origin, " +
					"results.race_100m as event0," +
					"results.long_jump as event1," +
					"results.shot_put as event2," +
					"results.high_jump as event3," +
					"results.race_400m as event4," +
					"results.hurdles_110m as event5," +
					"results.discus_throw as event6," +
					"results.pole_vault as event7," +
					"results.javelin_throw as event8," +
					"results.race_1500m as event9 " +
					"FROM competitions " +
					"LEFT JOIN " +
					"results ON competitions.id = results.competition_id " +
					"LEFT JOIN " +
					"athletes ON results.athlete_id = athletes.id " +
					"WHERE competitions.id = ?");
			statement.setInt(1, database);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				
				String origin = rs.getString("origin");
				String [] results = new String[10];
				for(int i=0; i<10; i++){
					results[i] = rs.getString("event"+i);
				}
				Date dob = null;
				try{
					dob = rs.getDate("dob");
				}catch(Exception e){
					System.err.println("Invalid date for athlete: "+name+"! Setting default date.");
					dob = new Date();
				}
				athletes.add(new Athlete(name,dob,origin,results));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage()+"a");
		}finally{
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return athletes;
	}
	/**
	 * Test method. Activates the test mode
	 * @param mode
	 */
	void setTestMode(boolean mode){
		this.testMode = mode;
	}
	/**
	 * Test method. Sets a connection to a fake database
	 * 
	 * @param conn - fake database connection
	 */
	void setFakeConnection(Connection conn){
		this.fakeConnection = conn;
	}

}
