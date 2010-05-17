package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQLInjectionDemo
 *
 * @author anton
 */
public class SQLInjectionDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = FakeDB.openConnection();
		Statement stmt = conn.createStatement();
		
		stmt.execute("create table users (id integer, username varchar(100), password varchar(100))");
		stmt.execute("insert into users values (123, 'mega-user', 'pwd123')");
		
		int id = unsafeLogin(conn, "mega-user", "pwd123");
		System.out.println(id);
		
		id = unsafeLogin(conn, "mega-user", "' or 1=1 --");
		System.out.println(id);
		
		id = unsafeLogin(conn, "' or 1=1 --", "blah");
		System.out.println(id);

		id = safeLogin(conn, "mega-user", "pwd123");
		System.out.println(id);

		id = safeLogin(conn, "mega-user", "' or 1=1 --");
		System.out.println(id);
		
		conn.close();
	}

	private static int unsafeLogin(Connection conn, String username, String password) throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "select id from users where username = '" + username + "' and password = '" + password + "'";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		if (!rs.next())
			return -1;
		return rs.getInt("id");
	}
	
	private static int safeLogin(Connection conn, String username, String password) throws SQLException {
		String sql = "select id from users where username = ? and password = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		System.out.println(sql);
		
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if (!rs.next())
			return -1;
		return rs.getInt("id");
	}

}
