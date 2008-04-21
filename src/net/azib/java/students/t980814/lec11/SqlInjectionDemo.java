package net.azib.java.students.t980814.lec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SqlInjectionDemo
 *
 * @author dell
 */
public class SqlInjectionDemo {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table users (id varchar, password varchar)");
		stmt.execute("insert into users values ('abc1', '123')");
		stmt.execute("insert into users values ('abc2', '234')");
	
		String id = "abc1";
		String password = "ei tea";
		String sqlStatement = "select id from users where id = '" + id + "' and password = '" + password + "'";
		System.out.println(sqlStatement);
		ResultSet rs = stmt.executeQuery(sqlStatement);
		if (rs.next())
			System.out.println("Login OK");
		else
			System.out.println("Login not OK");
		// võimalik häkkida.... SQL injection...
		password = "' or 1 = 1 --";
		sqlStatement = "select id from users where id = '" + id + "' and password = '" + password + "'";
		System.out.println(sqlStatement);
		rs = stmt.executeQuery(sqlStatement);
		if (rs.next()) {
			System.out.println("Hacked login OK");
		}

		
		// Võimalik seda probleemi lahendada kasutades prepared statementi
		sqlStatement = "select id from users where id = ? and password = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sqlStatement);
		prepStmt.setString(1, id);
		prepStmt.setString(2, password);
		System.out.println(sqlStatement);
		rs = prepStmt.executeQuery();
		if (rs.next())
			System.out.println("Login OK");
		else
			System.out.println("Hacked login not OK");
		
		
		conn.close();
	}
}
