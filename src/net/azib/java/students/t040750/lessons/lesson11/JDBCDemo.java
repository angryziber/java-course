package net.azib.java.students.t040750.lessons.lesson11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCDemo
 *
 * @author t040750
 */
public class JDBCDemo {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB","sa","");
			Statement stmt = conn.createStatement();
			
			stmt.execute("create table persons (id integer, name varchar)");
			stmt.execute("insert into persons values (1, 'John Doe')");
			stmt.execute("insert into persons values (1, 'Jaan Tamm')");
			
			PreparedStatement personStatement = conn.prepareStatement("select name from persons where id=?");
			
			personStatement.setInt(1, 1);
			ResultSet rs = personStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			
			conn.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
