package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.DecathlonComputation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * This class represents the database input action.
 * */
public class DatabaseInputAction extends AbstractInputAction {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final String DB_PROPS = "db.properties";
	
	private static final String SQL_QUERY = "select a.name, a.dob, " +
		"a.country_code, r.race_100m, r.long_jump, r.shot_put, r.high_jump, " +
		"r.race_400m, r.hurdles_110m, r.discus_throw, r.pole_vault, " +
		"r.javelin_throw, r.race_1500m from competitions c, athletes a, " +
		"results r where r.competition_id = c.id and r.athlete_id = a.id ";
	
	private static final String ID_SQL_QUERY = SQL_QUERY + "and c.id = ?";
	private static final String NAME_SQL_QUERY = SQL_QUERY + "and c.name = ?";
	
	private String value;
	
	public DatabaseInputAction(String value) {
		this.value = value;
	}
	
	@Override
	DateFormat getDateFormat() {
		return DATE_FORMAT;
	}
	
	@Override
	public Set<Athlete> handleData() {
		Set<Athlete> athletes = createAthleteSet();
		
		Connection conn = null;
		try {
			conn = openConnection();
			
			ResultSet resultSet =  getResultSet(conn);
			
			while(resultSet.next()) {
				athletes.add(createAthlete(getRow(resultSet)));
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception npe) {
				
			}
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			} else {
				throw new DBException("Database connection failed", e);
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				
			}
		}
		return athletes;
	}

	private ResultSet getResultSet(
			Connection conn) throws SQLException, ParseException {
		PreparedStatement statement;
		
		if (value.matches("\\d+")) {
			statement = conn.prepareStatement(ID_SQL_QUERY);
			statement.setInt(1, Integer.parseInt(value));
		} else {
			statement = conn.prepareStatement(NAME_SQL_QUERY);
			statement.setString(1, value);
		}
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet == null) {
			throw new DBException("Cannot read data");
		}
		return resultSet;
	}

	private String[] getRow(ResultSet resultSet) throws SQLException {
		int columns = resultSet.getMetaData().getColumnCount();
		
		List<String> list = new ArrayList<String>(columns);
		
		for (int i = 0; i < columns; ) {
			list.add(resultSet.getString(++i));
		}
		
		return list.toArray(new String[list.size()]);
	}

	private Connection openConnection() throws SQLException, IOException {
		Properties props = new Properties();
	    props.load(DecathlonComputation.class.getResourceAsStream(DB_PROPS));
	    
		return DriverManager.getConnection(props.getProperty("db.url"), 
			props.getProperty("db.username"), props.getProperty("db.password"));
	}
	
	private static class DBException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		private DBException(String message) {
			super(message);
		}

		private DBException(String message, Throwable cause) {
			super(message, cause);
		}
	}
}
