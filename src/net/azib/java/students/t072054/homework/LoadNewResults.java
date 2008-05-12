package net.azib.java.students.t072054.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Map;

//import java.util.LinkedHashMap;

/**
 * LoadNewResults
 * 
 * @author r_vassiljev
 */

// TODO how will I know, how many rows in a MySQL table?

public class LoadNewResults {
	static private ResultSet rs1;
	static private ResultSet rs2;
	static private ResultSet rs3;

	// 3 tables read from database
	//static private Map<Integer, String[]> result_map1;
	//static private Map<Integer, String[]> result_map2;
	//static private Map<Integer, String[]> result_map3;

	static private Connection conn;

	// TODO where is encapsulation, common interfaces?

	public void loadResults(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2, Map<Integer, String[]> result_map3) {
	//public static void main(String[] args) {
		try {
			// Structure with results after reading from database here
			// Later it will be moved to function parameters
			//result_map1 = new LinkedHashMap<Integer, String[]>();
			//result_map2 = new LinkedHashMap<Integer, String[]>();
			//result_map3 = new LinkedHashMap<Integer, String[]>();

			// Establish the connection to the database
			String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
			conn = DriverManager.getConnection(url, "java", "java");
			Statement stmt = conn.createStatement();

			PreparedStatement personStatement = conn.prepareStatement("SELECT * FROM athletes WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs1 = personStatement.executeQuery();

			rs1.first();
			
			readDatabase(rs1, result_map1, 4);
			
			String str[] = result_map1.get(0);

			personStatement = conn.prepareStatement("SELECT * FROM competitions WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs2 = personStatement.executeQuery();
			
			rs2.first();
			
			readDatabase(rs2, result_map2, 5);

			personStatement = conn.prepareStatement("SELECT * FROM results WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs3 = personStatement.executeQuery();

			rs3.first();
			
			readDatabase(rs3, result_map3, 13);
			
			connClose();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readDatabase(ResultSet rs, Map<Integer, String[]> result_map, int column_number) {
		String[][] str = new String[100][100];
		int j = 0;

		try {
			do{
				for (int i = 0; i < column_number; i++) {
					str[j][i] = rs.getString(i+1);
				}
				result_map.put(j, str[j]);
				j++;
			}
			while (rs.next());
			
			rs.first();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void connClose() {
		try {
			conn.close();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadResultsCSV(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2, Map<Integer, String[]> result_map3) {
		//public static void main(String[] args) {
			try {
				// Structure with results after reading from database here
				// Later it will be moved to function parameters
				//result_map1 = new LinkedHashMap<Integer, String[]>();
				//result_map2 = new LinkedHashMap<Integer, String[]>();
				//result_map3 = new LinkedHashMap<Integer, String[]>();

				// Establish the connection to the database
				String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
				conn = DriverManager.getConnection(url, "java", "java");
				Statement stmt = conn.createStatement();

				PreparedStatement personStatement = conn.prepareStatement("SELECT * FROM athletes WHERE id > ?;");

				// Optionally you can set some parameter for personStatment
				personStatement.setInt(1, 0);
				rs1 = personStatement.executeQuery();

				rs1.first();
				
				readDatabase(rs1, result_map1, 4);
				
				String str[] = result_map1.get(0);

				personStatement = conn.prepareStatement("SELECT * FROM competitions WHERE id > ?;");

				// Optionally you can set some parameter for personStatment
				personStatement.setInt(1, 0);
				rs2 = personStatement.executeQuery();
				
				rs2.first();
				
				readDatabase(rs2, result_map2, 5);

				personStatement = conn.prepareStatement("SELECT * FROM results WHERE id > ?;");

				// Optionally you can set some parameter for personStatment
				personStatement.setInt(1, 0);
				rs3 = personStatement.executeQuery();

				rs3.first();
				
				readDatabase(rs3, result_map3, 13);
				
				connClose();
			}
			catch (SQLException e) {
				// Auto-generated catch block
				e.printStackTrace();
			}
		}

}
