package net.azib.java.students.t040810.Homework;

import java.sql.*;

/**
 * Class: dbRead
 * User: Vladimir Glushakov
 */
public class dbRead {

	static Connection openConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://srv2.azib.net:3306/decathlon", "java", "java");
	}   //Opening connection to MySQL database

	public static void main(String[] args) throws SQLException {
		Connection conn = openConnection();
		Statement statement = conn.createStatement();
		statement.executeQuery("select * from athletes"); //reading statement from DB
		ResultSet rs = statement.getResultSet();
		int columnCount = rs.getMetaData().getColumnCount();

		/*for (int i = 1; i <= columnCount; i++) {   //to get names of a columns
			System.out.print(rs.getMetaData().getColumnName(i) + " ");
		}
		System.out.println(); */
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				writeTmpFile.writeToFile(rs.getString(i), rs.getString(i)); //TODO: write data from SQL to the tmp file

				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
		conn.close();
	}
}
