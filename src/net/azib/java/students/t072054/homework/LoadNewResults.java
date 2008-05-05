package net.azib.java.students.t072054.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * LoadNewResults
 * 
 * @author r_vassiljev
 */
public class LoadNewResults {
	// TOD WTF? public ResultSets?
	public ResultSet rs1;
	public ResultSet rs2;
	public ResultSet rs3;

	private Connection conn;
	
	// TODO Java naming convention is not followed
	// TODO where is encapsulation, common interfaces?
	// TODO unit test should never go the real DB!

	public void LoadResults() {
		try {
			// Structure with results after reading from database here
			// Later it will be moved to function parameters

			// Establish the connection to the database
			String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
			conn = DriverManager.getConnection(url, "java", "java");
			Statement stmt = conn.createStatement();

			PreparedStatement personStatement = conn.prepareStatement("SELECT * FROM athletes WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs1 = personStatement.executeQuery();

			rs1.first();

			personStatement = conn.prepareStatement("SELECT * FROM competitions WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs2 = personStatement.executeQuery();

			rs2.first();

			personStatement = conn.prepareStatement("SELECT * FROM results WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs3 = personStatement.executeQuery();

			rs3.first();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ConnClose() {
		try {
			conn.close();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

}
