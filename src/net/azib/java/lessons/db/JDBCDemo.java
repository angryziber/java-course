package net.azib.java.lessons.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.sql.DataSource;

/**
 * JDBCDemo
 *
 * @author anton
 */
public class JDBCDemo {
	
	public static String someFunc(String x) {
		return "<" + x + ">"; 
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		System.out.println(conn.getMetaData().getDatabaseProductName() + ", v" + conn.getMetaData().getDatabaseProductVersion());
		
		Statement stmt = conn.createStatement();
		stmt.execute("create table persons (id integer, name varchar, age integer)");
		stmt.execute("insert into persons values (1, 'John Doe', 25)");
		stmt.execute("insert into persons values (2, 'Jaan Tamm', 43)");
		stmt.execute("create alias some_func for \"" + JDBCDemo.class.getName() + ".someFunc\"");
		
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




