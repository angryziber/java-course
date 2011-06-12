package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.DecathlonCalculator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private final Logger LOG = Logger.getLogger(getClass().getName());
	private Connection connection;

	public DBConnection() {

		URL resUrl = DecathlonCalculator.class.getResource("db.properties");
		Properties properties = new Properties();
		try {
			properties.load(resUrl.openStream());
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}

		try {
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
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