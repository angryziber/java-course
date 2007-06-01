package net.azib.java.students.t030655.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PriorityQueue;

;

/**
 * DecathlonDatabaseReader
 *
 * @author Triin Nestor
 */
public class DecathlonDatabaseReader {
	private Connection connection;
	private int competitionId;
	
	public void setConnection (String url, String user, String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayCompetitions (){
		String query = "SELECT id, date, country_code, description FROM competitions";
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			System.out.println("Results available for the following competitions:");
			System.out.println("ID \tDate \t\tCountry \tDescription");
			while (resultSet.next()){
				System.out.println(resultSet.getString("id") + "\t" + resultSet.getString("date") + "\t" + 
						resultSet.getString("country_code") + "\t\t" + resultSet.getString("description"));
			}
//			resultSet.close();
//			statement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setCompetitionId (int number){
		competitionId = number;
	}
	
	public PriorityQueue<Competitor> readDatabase (){
		ResultSet results = selectResults();
		PriorityQueue<Competitor> pqCompetitor = new PriorityQueue<Competitor>();
		try {
			while (results.next()){
				pqCompetitor.add(createCompetitor(results));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pqCompetitor;
	}
	
	private ResultSet selectResults (){
		String query = "SELECT a.name, a.dob, a.country_code, r.race_100m, r.long_jump, " +
				"r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw, " +
				"r.pole_vault, r.javelin_throw, r.race_1500m " + 
				"FROM results AS r INNER JOIN athletes AS a ON r.athlete_id=a.id " + 
				"WHERE r.competition_id=" + competitionId;
		Statement statement;
		ResultSet resultSet;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	private Competitor createCompetitor (ResultSet rs){
		String line = null;
		try {
			line = "\"" + rs.getString("name") + "\"," + rs.getString("dob") + "," +
			rs.getString("country_code") + "," + rs.getString("race_100m") + "," +
			rs.getString("long_jump") + "," + rs.getString("shot_put") + "," +
			rs.getString("high_jump") + "," + rs.getString("race_400m") + "," +
			rs.getString("hurdles_110m") + "," + rs.getString("discus_throw") + "," +
			rs.getString("pole_vault") + "," + rs.getString("javelin_throw") + "," +
			rs.getString("race_1500m");
			
			Competitor competitor = new Competitor();
			competitor.setCompetitor(line);
			return competitor;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void closeConnection(){
		try {
			connection.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
