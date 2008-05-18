package net.azib.java.students.t072054.homework;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;

/**
 * LoadNewResults
 * 
 * @author r_vassiljev
 */

public class LoadNewResults implements ResultsLoader {
	static private ResultSet rs1;
	static private ResultSet rs2;
	static private ResultSet rs3;

	static private Connection conn;

	/**
	 * Loads results from MySQL database
	 * 
	 * @param result_map1
	 * @param result_map2
	 * @param result_map3
	 */
	public void loadResultsDB(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3) {

		String connection_string = " ";
		String login = " ";
		String password = " ";

		// Reading data from db.properties
		// Open the file
		try {
			File f1 = new File(LoadNewResults.class.getResource("db.properties").toURI().getPath());

			BufferedReader in = new BufferedReader(new FileReader(f1));

			connection_string = in.readLine();
			login = in.readLine();
			password = in.readLine();
		}
		catch (Exception e) {
			System.out.print("Error opening db.properties");
		}

		try {
			// Establish the connection to the database
			String url = connection_string;
			conn = DriverManager.getConnection(url, login, password);

			conn.createStatement();

			PreparedStatement personStatement = conn.prepareStatement("SELECT * FROM athletes WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs1 = personStatement.executeQuery();

			rs1.first();

			readDatabase(rs1, result_map1, 4);

			// String str[] = result_map1.get(0);

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

	/**
	 * Reads all strings from one table of database
	 * 
	 * @param rs
	 * @param result_map
	 * @param column_number
	 */
	private static void readDatabase(ResultSet rs, Map<Integer, String[]> result_map, int column_number) {
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

	/**
	 * 
	 */
	private void connClose() {
		try {
			conn.close();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Loads results from CSV file
	 * 
	 * @param result_map1
	 * @param result_map2
	 * @param result_map3
	 * @param fileName
	 */
	public void loadResultsCSV(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, String fileName) {
		try {

			// Open the file
			File f1 = /* new File(fileName); */new File(fileName);

			BufferedReader in = new BufferedReader(new FileReader(f1));

			// One row in a table
			String line;
			// Num of line
			int num_line = 0;

			char[] char_buf = new char[1000];
			// Counter for chars in String
			int char_count = 0;

			int count = 0;

			// If true, needs conversion to second:millisecond format
			boolean flag_need_converted = false;

			while (in.ready()) {
				line = in.readLine();

				// Strings separated by ',' for map3
				String[] str_buf = new String[13];

				// Same strings for map1, map2
				String[] str_map1 = new String[4];
				String[] str_map2 = new String[5];

				for (int i = 0; i < (line.length()); i++) {
					if (line.charAt(i) != ',' && (i + 1) != line.length()) {
						char_buf[char_count] = line.charAt(i);
						if (char_buf[char_count] == ':')
							flag_need_converted = true;
						char_count++;
					}
					else {
						if (count > 2) {
							str_buf[count] = String.copyValueOf(char_buf, 0, char_count);
							if (flag_need_converted)
								str_buf[count] = convertTime(str_buf[count]);
							flag_need_converted = false;
							char_count = 0;
							count++;
						}
						else {
							if (count == 0 || count == 1) {
								str_buf[count] = String.valueOf(num_line + 1);
								if (count == 0) {
									str_map1[0] = String.valueOf(num_line + 1);
									str_map1[1] = String.copyValueOf(char_buf, 0, char_count);
								}
								if (count == 1) {
									str_map1[2] = String.copyValueOf(char_buf, 0, char_count);
								}
								char_count = 0;
								count++;
							}
							else if (count == 2) {
								str_buf[count] = "1";
								str_map1[3] = String.copyValueOf(char_buf, 0, char_count);
								char_count = 0;
								count++;
							}
						}
					}

				}
				result_map3.put(num_line, str_buf);
				result_map1.put(num_line, str_map1);

				if (num_line == 0) {
					str_map2[0] = "1";
					str_map2[1] = "NA";
					str_map2[2] = "0000-00-00";
					str_map2[3] = "NA";
					str_map2[4] = "NA";
					result_map2.put(0, str_map2);
				}

				count = 0;
				num_line++;
			}

		}
		catch (Exception e) {
			System.out.println("File exception");
		}

	}

	/**
	 * Loads results from console
	 * 
	 * @param result_map1
	 * @param result_map2
	 * @param result_map3
	 */
	public void loadResultsConsole(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3) {
		try {

			// Reading stream
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(input);

			// One row in a table
			String line = " ";
			// Num of line
			int num_line = 0;

			char[] char_buf = new char[1000];
			// Counter for chars in String
			int char_count = 0;

			int count = 0;

			// If true, needs conversion to second:millisecond format
			boolean flag_need_converted = false;

			while (!line.equalsIgnoreCase("quit")) {
				System.out.println("Enter results or write 'quit' to finish");
				line = reader.readLine();
				if (!line.equalsIgnoreCase("quit")) {

					// Strings separated by ',' for map3
					String[] str_buf = new String[13];

					// Same strings for map1, map2
					String[] str_map1 = new String[4];
					String[] str_map2 = new String[5];

					for (int i = 0; i < (line.length()); i++) {
						if (line.charAt(i) != ',' && (i + 1) != line.length()) {
							char_buf[char_count] = line.charAt(i);
							if (char_buf[char_count] == ':')
								flag_need_converted = true;
							char_count++;
						}
						if ((i + 1) == line.length() || line.charAt(i) == ',') {
							if (count > 2) {
								str_buf[count] = String.copyValueOf(char_buf, 0, char_count);
								if (flag_need_converted)
									str_buf[count] = convertTime(str_buf[count]);
								flag_need_converted = false;
								char_count = 0;
								count++;
							}
							else {
								if (count == 0 || count == 1) {
									str_buf[count] = String.valueOf(num_line + 1);
									if (count == 0) {
										str_map1[0] = String.valueOf(num_line + 1);
										str_map1[1] = String.copyValueOf(char_buf, 0, char_count);
									}
									if (count == 1) {
										str_map1[2] = String.copyValueOf(char_buf, 0, char_count);
									}
									char_count = 0;
									count++;
								}
								else if (count == 2) {
									str_buf[count] = "1";
									str_map1[3] = String.copyValueOf(char_buf, 0, char_count);
									char_count = 0;
									count++;
								}
							}
						}

					}

					result_map3.put(num_line, str_buf);
					result_map1.put(num_line, str_map1);

					if (num_line == 0) {
						str_map2[0] = "1";
						str_map2[1] = "NA";
						str_map2[2] = "0000-00-00";
						str_map2[3] = "NA";
						str_map2[4] = "NA";
						result_map2.put(0, str_map2);
					}

					count = 0;
					num_line++;
				}

			}

		}
		catch (Exception e) {
			System.out.println("File exception");
		}

	}

	/**
	 * Converts from minute:second.millisecond to second.millisecond format
	 * 
	 * @param not_converted
	 * @return Converted data
	 */
	public String convertTime(String not_converted) {
		String converted;

		int minute = 0;
		int second = 0;
		int millisecond = 0;

		char[] char_buf = new char[10];
		char char_count = 0;

		for (int i = 0; i < (not_converted.length()); i++) {
			if (not_converted.charAt(i) != ',') {
				if (not_converted.charAt(i) == ':') {
					minute = Integer.parseInt(String.copyValueOf(char_buf, 0, char_count));
					char_count = 0;
				}
				else if (not_converted.charAt(i) == '.') {
					second = Integer.parseInt(String.copyValueOf(char_buf, 0, char_count));
					char_count = 0;
				}
				else {
					char_buf[char_count] = not_converted.charAt(i);
					char_count++;
				}
			}
		}

		millisecond = Integer.parseInt(String.copyValueOf(char_buf, 0, char_count));

		second = minute * 60 + second;
		converted = String.valueOf(second) + "." + String.valueOf(millisecond);

		return converted;
	}
}
