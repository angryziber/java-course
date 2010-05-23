package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCDemo
 *
 * @author anton
 */
public class JDBCDemo {
		
	public static void main(String[] args) throws SQLException {		
		new FakeDB().prepare();
		
		Connection conn = FakeDB.openConnection();
		
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from persons");
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rsMetaData.getColumnName(i) + " ");
		}
		System.out.println();
		
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + " ");
			}	
			System.out.println();
		}
				
		conn.close();		
	}
}




