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
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 */
	public void loadResultsDB(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3) {

		String connectionString = " ";
		String login = " ";
		String password = " ";

		// Reading data from db.properties
		// Open the file
		try {
			File f1 = new File(LoadNewResults.class.getResource("db.properties").toURI().getPath());

			BufferedReader in = new BufferedReader(new FileReader(f1));

			connectionString = in.readLine();
			login = in.readLine();
			password = in.readLine();
		}
		catch (Exception e) {
			System.out.print("Error opening db.properties");
		}

		try {
			// Establish the connection to the database
			String url = connectionString;
			conn = DriverManager.getConnection(url, login, password);

			conn.createStatement();

			PreparedStatement personStatement = conn.prepareStatement("SELECT * FROM athletes WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs1 = personStatement.executeQuery();

			rs1.first();

			readDatabase(rs1, resultMap1, 4);

			// String str[] = resultMap1.get(0);

			personStatement = conn.prepareStatement("SELECT * FROM competitions WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs2 = personStatement.executeQuery();

			rs2.first();

			readDatabase(rs2, resultMap2, 5);

			personStatement = conn.prepareStatement("SELECT * FROM results WHERE id > ?;");

			// Optionally you can set some parameter for personStatment
			personStatement.setInt(1, 0);
			rs3 = personStatement.executeQuery();

			rs3.first();

			readDatabase(rs3, resultMap3, 13);

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
	 * @param resultMap
	 * @param column_number
	 */
	private static void readDatabase(ResultSet rs, Map<Integer, String[]> resultMap, int column_number) {
		String[][] str = new String[100][100];
		int j = 0;

		try {
			do {
				for (int i = 0; i < column_number; i++) {
					str[j][i] = rs.getString(i + 1);
				}
				resultMap.put(j, str[j]);
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
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 * @param fileName
	 */
	public void loadResultsCSV(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3, String fileName) {
		try {

			// Open the file
			File f1 = /* new File(fileName); */new File(fileName);

			BufferedReader in = new BufferedReader(new FileReader(f1));

			// One row in a table
			String line;
			// Num of line
			int numLine = 0;

			char[] char_buf = new char[1000];
			// Counter for chars in String
			int charCount = 0;

			int count = 0;

			// If true, needs conversion to second:millisecond format
			boolean flag_need_converted = false;

			while (in.ready()) {
				line = in.readLine();

				// Strings separated by ',' for map3
				String[] strBuf = new String[13];

				// Same strings for map1, map2
				String[] strMap1 = new String[4];
				String[] strMap2 = new String[5];

				for (int i = 0; i < (line.length()); i++) {
					if (line.charAt(i) != ',' && (i + 1) != line.length()) {
						char_buf[charCount] = line.charAt(i);
						if (char_buf[charCount] == ':')
							flag_need_converted = true;
						charCount++;
					}
					else {
						if (count > 2) {
							strBuf[count] = String.copyValueOf(char_buf, 0, charCount);
							if (flag_need_converted)
								strBuf[count] = convertTime(strBuf[count]);
							flag_need_converted = false;
							charCount = 0;
							count++;
						}
						else {
							if (count == 0 || count == 1) {
								strBuf[count] = String.valueOf(numLine + 1);
								if (count == 0) {
									strMap1[0] = String.valueOf(numLine + 1);
									strMap1[1] = String.copyValueOf(char_buf, 0, charCount);
								}
								if (count == 1) {
									strMap1[2] = String.copyValueOf(char_buf, 0, charCount);
								}
								charCount = 0;
								count++;
							}
							else if (count == 2) {
								strBuf[count] = "1";
								strMap1[3] = String.copyValueOf(char_buf, 0, charCount);
								charCount = 0;
								count++;
							}
						}
					}

				}
				resultMap3.put(numLine, strBuf);
				resultMap1.put(numLine, strMap1);

				if (numLine == 0) {
					strMap2[0] = "1";
					strMap2[1] = "NA";
					strMap2[2] = "0000-00-00";
					strMap2[3] = "NA";
					strMap2[4] = "NA";
					resultMap2.put(0, strMap2);
				}

				count = 0;
				numLine++;
			}

		}
		catch (Exception e) {
			System.out.println("File exception");
		}

	}

	/**
	 * Loads results from console
	 * 
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 */
	public void loadResultsConsole(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3) {
		try {

			// Reading stream
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(input);

			// One row in a table
			String line = " ";
			// Num of line
			int numLine = 0;

			char[] charBuf = new char[1000];
			// Counter for chars in String
			int charCount = 0;

			int count = 0;

			// If true, needs conversion to second:millisecond format
			boolean flagNeedConverted = false;

			while (!line.equalsIgnoreCase("quit")) {
				System.out.println("Enter results or write 'quit' to finish");
				line = reader.readLine();
				if (!line.equalsIgnoreCase("quit")) {

					// Strings separated by ',' for map3
					String[] strBuf = new String[13];

					// Same strings for map1, map2
					String[] strMap1 = new String[4];
					String[] strMap2 = new String[5];

					for (int i = 0; i < (line.length()); i++) {
						if (line.charAt(i) != ',' && (i + 1) != line.length()) {
							charBuf[charCount] = line.charAt(i);
							if (charBuf[charCount] == ':')
								flagNeedConverted = true;
							charCount++;
						}
						if ((i + 1) == line.length() || line.charAt(i) == ',') {
							if (count > 2) {
								strBuf[count] = String.copyValueOf(charBuf, 0, charCount);
								if (flagNeedConverted)
									strBuf[count] = convertTime(strBuf[count]);
								flagNeedConverted = false;
								charCount = 0;
								count++;
							}
							else {
								if (count == 0 || count == 1) {
									strBuf[count] = String.valueOf(numLine + 1);
									if (count == 0) {
										strMap1[0] = String.valueOf(numLine + 1);
										strMap1[1] = String.copyValueOf(charBuf, 0, charCount);
									}
									if (count == 1) {
										strMap1[2] = String.copyValueOf(charBuf, 0, charCount);
									}
									charCount = 0;
									count++;
								}
								else if (count == 2) {
									strBuf[count] = "1";
									strMap1[3] = String.copyValueOf(charBuf, 0, charCount);
									charCount = 0;
									count++;
								}
							}
						}

					}

					resultMap3.put(numLine, strBuf);
					resultMap1.put(numLine, strMap1);

					if (numLine == 0) {
						strMap2[0] = "1";
						strMap2[1] = "NA";
						strMap2[2] = "0000-00-00";
						strMap2[3] = "NA";
						strMap2[4] = "NA";
						resultMap2.put(0, strMap2);
					}

					count = 0;
					numLine++;
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
	 * @param notConverted
	 * @return Converted data
	 */
	public String convertTime(String notConverted) {
		String converted;

		int minute = 0;
		int second = 0;
		int millisecond = 0;

		char[] charBuf = new char[10];
		char charCount = 0;

		for (int i = 0; i < (notConverted.length()); i++) {
			if (notConverted.charAt(i) != ',') {
				if (notConverted.charAt(i) == ':') {
					minute = Integer.parseInt(String.copyValueOf(charBuf, 0, charCount));
					charCount = 0;
				}
				else if (notConverted.charAt(i) == '.') {
					second = Integer.parseInt(String.copyValueOf(charBuf, 0, charCount));
					charCount = 0;
				}
				else {
					charBuf[charCount] = notConverted.charAt(i);
					charCount++;
				}
			}
		}

		millisecond = Integer.parseInt(String.copyValueOf(charBuf, 0, charCount));

		second = minute * 60 + second;
		converted = String.valueOf(second) + "." + String.valueOf(millisecond);

		return converted;
	}
}
