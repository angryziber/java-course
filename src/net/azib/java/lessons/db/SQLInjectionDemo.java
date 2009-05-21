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
		String password = "123";
		
		System.out.println("SQL Injection try:");
		ResultSet rs = stmt.executeQuery("select 1 from users where id = '" + name + "' and password = '" + password + "'");
		if (rs.next()) {
			System.out.println("Login OK!");
		}
		else {
			System.out.println("Login failed!");
		}
		
		// TODO: avoid using PreparedStatement

		conn.close();
	}
}




