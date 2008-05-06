package net.azib.java.students.t072054.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * LoadNewResults
 * 
 * @author r_vassiljev
 */
public class LoadNewResults {
	// TOD WTF? public ResultSets?
	static public ResultSet rs1;
	static public ResultSet rs2;
	static public ResultSet rs3;

	// 3 tables read from database
	static private Map<Integer, String[]> result_map1;
	static private Map<Integer, String[]> result_map2;
	static private Map<Integer, String[]> result_map3;

	static private Connection conn;

	// TODO Java naming convention is not followed
	// TODO where is encapsulation, common interfaces?
	// TODO unit test should never go the real DB!

	//public void loadResults() {
	public static void main(String[] args) {
		try {
			// Structure with results after reading from database here
			// Later it will be moved to function parameters
			//result_map1 = new LinkedHashMap<Integer, String[]>();
			

			// Establish the connection to the database
			String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
			conn = DriverManager.getConnection(url, "java", "java");
			Statement stmt = conn.createStatement();

			PreparedStatement personStatement = conn.prepareStatement("SELECT * FROM athletes WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs1 = personStatement.executeQuery();

			rs1.first();
			
			readDatabase(rs1, result_map1);
			
			String[] str_test = result_map1.get(0);

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

	public static void readDatabase(ResultSet rs, Map<Integer, String[]> result_map) {
		String[] str = new String[10000];
		int j = 0;
		
		str[0] = " ";

		try {
			while (rs.next()) {
				for (int i = 0; i < 4; i++) {
					str[i] = rs.getString(i+1);
				}

				result_map.put(j, str);
				j++;
			}
			
			rs.first();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connClose() {
		try {
			conn.close();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

}
