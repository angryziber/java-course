package net.azib.java.students.t100224.homework.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

	private Connection connection;

	public DBConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		try {
			String url = bundle.getString("url");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
