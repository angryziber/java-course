package net.azib.java.students.t980814.lec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * MySQLDemo
 *
 * @author dell
 */
public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
//		Connection conn = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/java", "java", "java");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table persons (id integer, name varchar, age integer)");
		stmt.execute("insert into persons values (1, 'John Doe', 25)");
		stmt.execute("insert into persons values (2, 'Jaan Tamm', 43)");
		
/*		ResultSet rs = stmt.executeQuery("select name from persons");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}*/
		
		//PreparedStatement personStatement = conn.prepareStatement("select name from persons where id = 1");
		//PreparedStatement personStatement = conn.prepareStatement("select name from persons where id = 1");
		PreparedStatement personStatement = conn.prepareStatement("select * from persons where id = ?");
		System.out.println("Ask the first person");
		personStatement.setInt(1, 1);
		ResultSet rs = personStatement.executeQuery();
		while (rs.next()) {
			// Mitu võimalust väljade lugemiseks
			System.out.println(rs.getString(2));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getObject("age"));
		}
		
		personStatement.setInt(1, 2);
		System.out.println("Ask the second person");
		rs = personStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}

		conn.close();
	}
}
