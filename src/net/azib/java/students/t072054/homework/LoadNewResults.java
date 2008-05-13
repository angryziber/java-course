package net.azib.java.students.t072054.homework;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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

// TODO how will I know, how many rows in a MySQL table?
public class LoadNewResults {
	static private ResultSet rs1;
	static private ResultSet rs2;
	static private ResultSet rs3;

	// 3 tables read from database
	// static private Map<Integer, String[]> result_map1;
	// static private Map<Integer, String[]> result_map2;
	// static private Map<Integer, String[]> result_map3;

	static private Connection conn;

	// TODO where is encapsulation, common interfaces?

	public void loadResultsDB(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3) {
		// public static void main(String[] args) {
		try {
			// Structure with results after reading from database here
			// Later it will be moved to function parameters
			// result_map1 = new LinkedHashMap<Integer, String[]>();
			// result_map2 = new LinkedHashMap<Integer, String[]>();
			// result_map3 = new LinkedHashMap<Integer, String[]>();

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
			do {
				for (int i = 0; i < column_number; i++) {
					str[j][i] = rs.getString(i + 1);
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

	public void loadResultsCSV(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, String fileName) {
		// public static void main(String[] args) {
		try {
			// Structure with results after reading from database here
			// Later it will be moved to function parameters
			// Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer,
			// String[]>();
			// Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer,
			// String[]>();
			// Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer,
			// String[]>();

			// Open the file
			File f1 = /* new File(fileName); */new File("C:\\source.csv");

			BufferedReader in = new BufferedReader(new FileReader(f1));

			// One row in a table
			String line;
			// Num of line
			int num_line = 0;
			// Strings separated by ','
			String[] str_buf = new String[13];
			char[] char_buf = new char[1000];
			// Counter for chars in String
			int char_count = 0;

			int count = 0;

			while (in.ready()) {
				line = in.readLine();
				for (int i = 0; i < (line.length()); i++) {
					if (line.charAt(i) != ',' && (i + 1) != line.length()) {
						char_buf[char_count] = line.charAt(i);
						// char_buf[char_count + 1] = '\0';
						char_count++;
					}
					else {
						str_buf[count] = String.copyValueOf(char_buf, 0, char_count);
						char_count = 0;
						count++;
					}

				}
				result_map3.put(num_line, str_buf);
				//for (int i = 0; i < 13; i++) {
				//	System.out.println(str_buf[i]);
				//}
				count = 0;
				num_line++;
			}

		}
		catch (Exception e) {
			System.out.println("File exception");
		}

	}

	 public void loadResultsConsole(Map<Integer, String[]> result_map1,
	 Map<Integer, String[]> result_map2, Map<Integer, String[]> result_map3) {
	//public static void main(String[] args) {
		try {
			// Structure with results after reading from database here
			// Later it will be moved to function parameters
			//Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
			//Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
			//Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

			// Reading stream
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(input);

			// One row in a table
			String line = " ";
			// Num of line
			int num_line = 0;
			// Strings separated by ','
			String[] str_buf = new String[13];
			char[] char_buf = new char[1000];
			// Counter for chars in String
			int char_count = 0;

			int count = 0;

			while (!line.equalsIgnoreCase("quit")) {
				System.out.println("Enter results or write 'quit' to finish");
				line = reader.readLine();
				if (!line.equalsIgnoreCase("quit")) {

					for (int i = 0; i < (line.length()); i++) {
						if (line.charAt(i) != ','/* && (i) != line.length() */) {
							char_buf[char_count] = line.charAt(i);
							// char_buf[char_count + 1] = '\0';
							char_count++;
						}
						if (line.charAt(i) == ',' || (i + 1) == line.length()) {
							str_buf[count] = String.copyValueOf(char_buf, 0, char_count);
							char_count = 0;
							count++;
						}

					}
				}
				result_map2.put(num_line, str_buf);
				for (int i = 0; i < 13; i++) {
					System.out.println(str_buf[i]);
				}
				count = 0;
				num_line++;
			}

		}
		catch (Exception e) {
			System.out.println("File exception");
		}

	}
}
