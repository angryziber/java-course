package net.azib.java.students.t030604.homework.parser;

import net.azib.java.students.t030604.homework.IDataParser;
import net.azib.java.students.t030604.homework.domain.AthleteScore;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
 
 

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleksandr.ivanov@tietoenator.com">contact</a>
 */
public class DbParser implements IDataParser {

	private Connection connection;
	private final static String ID_BASED = "select a.*, r.* from " +
			"athletes a, results r, competitions c where c.id = r.competition_id and a.id = r.athlete_id and c.id = ?";
	private final static String NAME_BASED = "select a.*, r.* from " +
			"athletes a, results r, competitions c where c.id = r.competition_id and a.id = r.athlete_id and c.name = ?";
	
	private Long id;
	private String name;
	
	/** 
	 * @see main.java.homework.IDataParser#cleanup()
	 * {@inheritDoc}
	 */
	public void cleanup() throws ParserException {
		if (connection != null ) {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException fatal) {
				throw new ParserException("could not close connection to the DB", fatal);
			}
		}
	}

	/** 
	 * @see main.java.homework.IDataParser#parseData()
	 * {@inheritDoc}
	 */
	public List<AthleteScore> parseData() throws ParserException {
		List<AthleteScore> results = new LinkedList<AthleteScore>();
		try {
		PreparedStatement statement = connection.prepareStatement(
				id != null
						? ID_BASED
						: NAME_BASED);
		if (id != null) {
			statement.setLong(1, id);
		} else {
			statement.setString(1, name);
		}
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			AthleteScore temp =	new AthleteScore(
					resultSet.getString("name"),
					resultSet.getDate("dob"),
					resultSet.getString("country_code"),
					resultSet.getFloat("race_100m"),
					resultSet.getFloat("long_jump"),
					resultSet.getFloat("shot_put"),
					resultSet.getFloat("high_jump"),
					resultSet.getFloat("race_400m"),
					resultSet.getFloat("hurdles_110m"),
					resultSet.getFloat("discus_throw"),
					resultSet.getFloat("pole_vault"),
					resultSet.getFloat("javelin_throw"),
					resultSet.getFloat("race_1500m"));
			if (temp.validate()) {
				results.add(temp);
			} else {
				throw new ParserException("DB contains invalid data", null);
			}
		}
		
		} catch (SQLException fatal) {
			throw new ParserException("sql error has occured", fatal);
		}
		return results;
	}

	/** 
	 * @see main.java.homework.IDataParser#setup(java.lang.String[])
	 * {@inheritDoc}
	 */
	public void setup(String... args) throws ParserException {
		try {
			if (args == null || args.length == 0) {
				throw new ParserException("initialization parameter required", null);
			}
			if (args[0].trim().matches("^\\d+$")) {
				//probably a number
				id = new Long(args[0]);
			} else {
				name = args[0];
			}
			Class.forName("com.mysql.jdbc.Driver");
			Properties connectionProperties = new Properties();
			InputStream stream = getClass().getResourceAsStream("../db.properties");
			if (stream == null) {
				throw new ParserException("properties file not found", null);
			}
			connectionProperties.load(stream);
			connection = DriverManager.getConnection(
					connectionProperties.getProperty("dbHost"),
					connectionProperties.getProperty("username"),
					connectionProperties.getProperty("password"));
		} catch (ClassNotFoundException fatal) {
			throw new ParserException("mysql Driver not found", fatal);
		} catch (SQLException fatal) {
			fatal.printStackTrace();
			throw new ParserException("sql host unreachable", fatal);
		} catch (IOException fatal) {
			throw new ParserException("properties file could not be loaded", fatal);
		}
	}

}
