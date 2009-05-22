package net.azib.java.lessons.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * JDBCDemo
 *
 * @author anton
 */
public class JDBCDemo {
		
	public static void main(String[] args) throws SQLException {		
		new FakeDB().prepare();
		
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		
		System.out.println(conn.getMetaData().getDatabaseProductName());
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery("select * from persons");
		
		System.out.println("columns: " + result.getMetaData().getColumnCount());
		while (result.next()) {
			int id = result.getInt("id");
			System.out.println(id + ": " + result.getString("name"));
		}
		
		conn.close();
	}
}




