package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static net.azib.java.lessons.db.FakeDB.openConnection;

public class SQLInjectionDemo {
	public static void main(String[] args) throws SQLException {
		Connection conn = openConnection();
		conn.createStatement().execute("create table users (username varchar, password varchar)");
		conn.createStatement().execute("insert into users values ('foo', 'bar')");

		String username = loginInsecure(conn, "foo", "bar123");
		System.out.println("Logged in as " + username);

		username = loginInsecure(conn, "foo", "bar");
		System.out.println("Logged in as " + username);

		username = loginInsecure(conn, "foo", "' or 1=1 --");
		System.out.println("Logged in as " + username);

		username = loginInsecure(conn, "abc", "' or 1=1 --");
		System.out.println("Logged in as " + username);

		username = loginSecure(conn, "foo", "' or 1=1 --");
		System.out.println("Logged in as " + username);

		conn.close();
	}

	private static String loginInsecure(Connection conn, String username, String password) throws SQLException {
		String sql = "select username from users where username='" + username + "' and password = '" + password + "'";
		System.out.println(sql);
		ResultSet rs = conn.createStatement().executeQuery(sql);

		if (rs.next())
			return rs.getString("username");
		else
			return null;
	}

	private static String loginSecure(Connection conn, String username, String password) throws SQLException {
		String sql = "select username from users where username=? and password=?";
		System.out.println(sql);
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet rs = statement.executeQuery();

		if (rs.next())
			return rs.getString("username");
		else
			return null;
	}
}
