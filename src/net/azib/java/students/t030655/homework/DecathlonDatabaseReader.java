package net.azib.java.students.t030655.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PriorityQueue;

;

/**
 * DecathlonDatabaseReader - Class to read decathlon data from database.
 *
 * @author Triin Nestor
 */
public class DecathlonDatabaseReader {
	private Connection connection;
	private int competitionId;
	
	/**
	 * Sets connection with database.
	 * 
	 * @param url - url of database
	 * @param user - username
	 * @param password
	 */
	public void setConnection (String url, String user, String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException e) {
			System.out.println("Loading drivers faild! No class found!");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Unable to connect to database!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Displays competitions available from database to console.
	 * 
	 */
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
			resultSet.close();
			statement.close();
		}
		catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets competition ID.
	 * 
	 * @param number - competition ID
	 */
	public void setCompetitionId (int number){
		competitionId = number;
	}
	
	/**
	 * Method reads data from database.
	 * 
	 * @return PriorityQueue of competitors
	 */
	public PriorityQueue<Competitor> readDatabase (){
		ResultSet results = selectResults();
		PriorityQueue<Competitor> pqCompetitor = new PriorityQueue<Competitor>();
		if (results == null){
			System.out.println("Database cannot be read!");
			return null;
		}
		else{
			try {
				while (results.next()){
					pqCompetitor.add(createCompetitor(results));
				}
			}
			catch (SQLException e) {
				System.out.println("Connection failed!");
				e.printStackTrace();
			}
			try {
				results.close();
			}
			catch (SQLException e) {
				System.out.println("Unable to close statement!");
				e.printStackTrace();
			}
			return pqCompetitor;
		}
	}
	
	/**
	 * Selects results from database.
	 * 
	 * @return 
	 */
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
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Creates competitor according to the data received from database.
	 * 
	 * @param rs - data from database
	 * @return
	 */
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
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Closes database connection.
	 * 
	 */
	public void closeConnection(){
		try {
			connection.close();
		}
		catch (SQLException e) {
			System.out.println("Unable to close connection!");
			e.printStackTrace();
		}
	}

}
