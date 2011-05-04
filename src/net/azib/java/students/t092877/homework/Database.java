package net.azib.java.students.t092877.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Database {

	public static List<Athlete> input(String name) {
		return Utility.athletes;
	}

	public static void connectToDatabase(String name) {

		Connection con = null;

	    try {

	      con = DriverManager.getConnection("jdbc:mysql:///test","java", "java");

	      if(!con.isClosed())
	        System.out.println("Successfully connected to " +
	          "MySQL server");

	    } catch(Exception e) {
	      System.err.println("Exception: " + e.getMessage());
	    } finally {
	      try {
	        if(con != null)
	          con.close();
	      } catch(SQLException e) {}
	    }
	}
}
