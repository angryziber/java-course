package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DatabaseInput - a class for obtaining decathlon results from a MySQL database
 *
 * @version 0.0
 * @author Romi Agar
 */
public class DatabaseInput implements DataInput {
	private static final Logger LOG = Logger.getLogger(DatabaseInput.class.getSimpleName());
	private String jdbcURL = "jdbc:mysql://srv.azib.net:3306/decathlon";
	private String jdbcUser = "java";
	String jdbcPassword = "java";
	
	Connection openConnection() {
		try {
			return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Could not connect to database.", e);
		}
		return null;
	}
	
	public List<Athlete> getResults(String... parameter){
		if (parameter.length == 0){
			LOG.severe("No competition id nor name given.");
			return null;
		}
		List<Athlete> athletes = new ArrayList<Athlete>();
		final String sql = "SELECT A.name, A.dob, A.country_code, R.race_100m, " +
				"R.long_jump, R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, " +
				"R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m FROM " +
				"results AS R INNER JOIN athletes AS A on A.id=R.athlete_id WHERE " +
				"competition_id = (SELECT id FROM competitions WHERE id = ? or name = ?)";
		Connection conn = null;
		String name = "";
		String countryCode = "";
		Date birthday = null;
		float[] results = new float[10];

		try{
			conn = openConnection();
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			prepStmt.setString(1, parameter[0]);
			prepStmt.setString(2, parameter[0]);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				name = InputParser.parseName(rs.getString("name"));
				birthday = rs.getDate("dob");
				countryCode = InputParser.parseCountryCode(rs.getString("country_code"));
				for (int i=0; i<10; i++){
					results[i] = rs.getFloat(i+4);
				}
				Athlete athlete = new Athlete(name,birthday,countryCode,results);
				athletes.add(athlete);
			}
			rs.close();
				
		}catch (SQLException e) {
			LOG.log(Level.SEVERE, "Could not get records from database.", e);
			athletes = null;
		}finally {
			if (conn != null)
				try {
					conn.close();
				}
				catch (SQLException e) {
					LOG.log(Level.SEVERE, "Could not close database connection.",e);
				}
		}
		return athletes;
	}

}
