package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBCDemo
 *
 * @author anton
 */
public class SQLInjectionDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table users (id varchar, password varchar)");
		stmt.execute("insert into users values ('abc1', '123')");
		stmt.execute("insert into users values ('abc2', '234')");
		
		// malicious user enters
		String name = "abc1";
		String password = "' or 1 = 1 --";
		
		System.out.println("SQL Injection try:");
		String sql = "select 1 from users where id = '" + name + "' and password = '" + password + "'";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			System.out.println("Login OK!");
		}
		else {
			System.out.println("Login failed!");
		}
		

		System.out.println("Prepared statement:");
		sql = "select 1 from users where id = ? and password = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, name);
		prepStmt.setString(2, password);
		rs = prepStmt.executeQuery();
		if (rs.next()) {
			System.out.println("Login OK!");
		}
		else {
			System.out.println("Login failed!");
		}

		conn.close();
	}
}




