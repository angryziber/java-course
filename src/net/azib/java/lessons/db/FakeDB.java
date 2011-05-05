package net.azib.java.lessons.db;

import java.sql.*;

/**
 * FakeDB
 *
 * @author anton
 */
public class FakeDB {

	public static void prepare() throws SQLException {
		Connection conn = null;
		try {
			conn = openConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("create table persons (id integer, name varchar, age integer, sex char)");
			stmt.execute("insert into persons values (2, 'Jaan Tamm', 43, 'M')");

			conn.commit();
		}
		catch (SQLException e) {
			// todo log also here
			rollbackQuietly(conn);
		}
		finally {
			if (conn != null)
				conn.close();
		}
	}

	private static void rollbackQuietly(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (SQLException ignore) {}
	}

	static Connection openConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
	}

	public static void closeQuietly(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		}
		catch (SQLException ignore) {
		}
	}

	public static void main(String[] args) throws SQLException {
		prepare();
		Connection conn = openConnection();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("select * from persons");
		int columnCount = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rs.getMetaData().getColumnName(i) + " ");
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
