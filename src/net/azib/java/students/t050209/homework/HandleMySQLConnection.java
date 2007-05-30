package net.azib.java.students.t050209.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * HandleMySQLConnection
 *
 * @author Kaupo Laan
 */
public class HandleMySQLConnection {
	
	/**
	 * Function to handle MYSQL database connection.
	 * 
	 * The connection is initiated.
	 * Then the query is sent to database.
	 * Finally the connection is closed.
	 * 
	 * The function returns sportsmanlist.
	 * 
	 * @param connection - parameter for connecting to database
	 * @param query - string, which contains all needed key-words to ask data from database
	 */
	public static List<Sportsman> handleMySQLConnection(){
		int nofCompetitions = 0;
		int value;
		Connection connection = null;
		String askCompetitions = "SELECT id, description, country_code, date " +
								 "FROM competitions";
		
		String query = "SELECT name, dob, country_code, " +
					   "race_100m, long_jump, shot_put, high_jump, race_400m, " +
					   "hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m " +
					   "FROM results a, athletes b WHERE a.athlete_id=b.id AND competition_id=";
		//String query = "SELECT name, dob, country_code " + "FROM athletes";
		
		List<Sportsman> sportsmanList = new LinkedList<Sportsman>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException error in handleMySQLConnection");
		}
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon?user=" + 
													 "java" +
													 "&password=java");
		} 
		catch (SQLException e) {
		}
		
		try {			
			Statement statement = connection.createStatement();
			
			ResultSet competitions = statement.executeQuery(askCompetitions);
			try{
				System.out.println("Choose competition");
				while(competitions.next()){
					System.out.println("- " + competitions.getInt(1) +
									   " " + competitions.getString(2) +
									   " (" + competitions.getString(3) + ")" +
									   " " + competitions.getString(4));
					nofCompetitions++;
				}
			}catch (SQLException e) {
				if (connection != null) {
					try {
						// Try again
						connection.rollback();
					} catch (SQLException f) {
						System.out.println("SQLException in handleMySQLConncetion");
					}
				}
			} finally {
				try {
					competitions.close();
				} catch (SQLException e) {
					System.out.println("SQLException 2 in handleMySQLConncetion");
				}
			}
			do{
				value = (int)HandleDecathlonIO.getUserInsertedValue();
			}
			while(value < 1 && value > nofCompetitions);
			
			ResultSet resultSet = statement.executeQuery(query + value);
			System.out.println("executed");
			try {
				while (resultSet.next()) {
					Sportsman sm = new Sportsman();
					
					sm.setSportsmanName(resultSet.getString(1));
					sm.setSportsmanDateOfBirth(resultSet.getString(2));
					sm.setSportsmanCountry(resultSet.getString(3));
					
					try {
						List<Double> results = new LinkedList<Double>();
						for (int i = 0; i < 10; i++) {
							results.add(resultSet.getDouble(i + 4));
						}
						sm.setSportsmanResults(results);
					} catch (NumberFormatException e) {
						System.out.println("NumberFormatException in handleMySQLConncetion");
					}
					sm.calculateAndStoreSportsmanScore();
					sportsmanList.add(sm);
				}
			} catch (SQLException e) {
				if (connection != null) {
					try {
						// Try again
						connection.rollback();
					} catch (SQLException f) {
						System.out.println("SQLException in handleMySQLConncetion");
					}
				}
			} finally {
				try {
					resultSet.close();
				} catch (SQLException e) {
					System.out.println("SQLException 2 in handleMySQLConncetion");
				}
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("SQLException 3 in handleMySQLConncetion");
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException 4 in handleMySQLConncetion");
		}
		
		
		try {
			connection.close();
		} catch (SQLException e) {
		}
		
		
		return sportsmanList;
	}
}
