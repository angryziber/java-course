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
	
	public static void main(String[] args) {
		try {
			// Load the JDBC driver. 
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			
            // Establish the connection to the database
			String url = "jdbc:mysql://srv.azib.net:3306";
			Connection conn = DriverManager.getConnection(url,"java","java");
			Statement stmt = conn.createStatement();
			
			stmt.execute("create table persons (id integer, name varchar, date varchar)");
			stmt.execute("insert into persons values (1, 'Siim Susi', '01.01.1976')");
			stmt.execute("insert into persons values (1, 'Beata Kana', '29.02.1982')");
			
			PreparedStatement personStatement = conn.prepareStatement("SELECT name, date FROM persons WHERE id=?;");
			
			personStatement.setInt(1, 1);
			ResultSet rs = personStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println();
			}
			
			conn.close();
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}

}
