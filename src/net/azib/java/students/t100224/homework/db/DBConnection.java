package net.azib.java.students.t100224.homework.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {

	private final Logger LOG = Logger.getLogger(getClass().getName());
	private Connection connection;

	public DBConnection() {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		try {
			String url = bundle.getString("url");
			String user = bundle.getString("user");
			String password = bundle.getString("password");
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
	}
}