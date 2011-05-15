package net.azib.java.students.t104607.homework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 104607 IASM
 */
public class InputDb {
	public List<Athlete> load(String competition, InputStream propsStream) throws SQLException, IOException {
		String  url, user, password;
		int id = 0;
		boolean byName = false;
		List<Athlete> athletes = new ArrayList<Athlete>();

		Properties props = new Properties();
		props.load(propsStream);
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
		propsStream.close();

		try {
			id = new Integer(competition);
		} catch (NumberFormatException e) {
			byName = true;
		}

		String sql = "select a.name, a.dob, a.country_code, r.race_100m, " +
			"r.long_jump, r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw, r.pole_vault, "+
			"r.javelin_throw, r.race_1500m from competitions c, athletes a, results r where ";
	 	if (byName) {
			 sql = sql + "c.name = '" + competition + "'";
		} else {
			 sql = sql + "c.id = " + id;
		}
	    sql = sql + " and r.athlete_id = a.id and r.competition_id = c.id";

		Connection conn = DriverManager.getConnection(url, user, password);
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			Athlete athlete = new Athlete(result.getString(1),result.getDate(2),result.getString(3),
					result.getFloat(4),result.getFloat(5),result.getFloat(6),result.getFloat(7),result.getFloat(8),
					result.getFloat(9),result.getFloat(10),result.getFloat(11),result.getFloat(12),result.getFloat(13));
			athletes.add(athlete);
		}

		conn.close();

		return athletes;
	}
}
