package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBCDemo
 *
 * @author anton
 */
public class JDBCDemo {
		
	public static void main(String[] args) throws SQLException {		
		new FakeDB().prepare();
		
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		System.out.println(conn.getMetaData().getDatabaseProductName() + ", v" + conn.getMetaData().getDatabaseProductVersion());
		
		PreparedStatement personStatement = conn.prepareStatement("select * from persons where id = ?");

		personStatement.setInt(1, 1);
		ResultSet rs = personStatement.executeQuery();
		System.out.println("columnCount = " + rs.getMetaData().getColumnCount());
		while (rs.next()) {			
			System.out.println(rs.getString("name"));
			System.out.println(rs.getObject("age"));
			System.out.println(rs.getObject("age").getClass());
		}
		
		personStatement.setInt(1, 2);
		rs = personStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}
		
//		CallableStatement call = conn.prepareCall("{?= call ABS(?)}");
//		call.registerOutParameter(0, Types.INTEGER);
//		call.setInt(1, -32);
//		call.execute();
		
//		System.out.println(call.getInt(1));
		
		conn.close();
	}
}




