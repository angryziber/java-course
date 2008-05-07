package net.azib.java.students.t980814.homework;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DecathlonCalculator
 *
 * @author dell
 */
public class DecathlonCalculator {

	private Results results;

	/**
	 * 
	 */
	public DecathlonCalculator(Connection conn, String competition_id) {
		try {
			results = new Results(conn, competition_id);
		}
		catch (SQLException e) {
			System.out.println("Unable to load data from DB");			
		}
	}

	/* Input from keyboard */
	public DecathlonCalculator() {
		
	}
	
	/* Input from inputstream */
	public DecathlonCalculator(InputStream stream) {
		
	}
	
	/* outputs to XML */
	public void outputCalculatedData(int i) {
		
	}
	
	/* outputs to HTML */
	public void outputCalculatedData(int i, int j) {
		
	}
	
	/* outputs to screen */
	public void outputCalculatedData() {
		System.out.println(results);
	}
	
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon", "java", "java");
			
			DecathlonCalculator deca = new DecathlonCalculator(connection, "DECATHLON4BEER");
			deca.outputCalculatedData();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch (Exception e) { }
		}
		
	}
}
