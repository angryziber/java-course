package net.azib.java.students.t030657.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Karina
 * public class DbReader
 * In this class dealing with the given data, computing the result of the athlete is done
 * Used IO source - sql
 *
 */
public class DbReader implements Reader {
	private static final String host = "srv.azib.net";
	private static final int port = 3306;
	private static final String database = "decathlon";
	private static final String user = "java";
	private static final String pwd = "java";

	private int competition;
	
	public DbReader(int competition) {
		this.competition=competition;
	}
	
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://"+host+":"+port+"/"+database+"?user="+user+"&password="+pwd);
		return conn;
	}

	public List<Results> readAll() {
		ArrayList<Results> results = new ArrayList<Results>();
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			String sql = "SELECT "+
					"results.race_100m,results.long_jump,results.shot_put,"+
					"results.high_jump,results.race_400m,results.hurdles_110m,"+
					"results.discus_throw,results.pole_vault,results.javelin_throw,results.race_1500m,"+
					"athletes.name,athletes.dob,athletes.country_code "+
				"FROM results, athletes WHERE results.competition_id = " + competition +
				" and results.athlete_id=athletes.id";

			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				Results r = new Results( new Athlete(
					rs.getString ("name"),
					rs.getString ("dob"),
					rs.getString ("country_code")));
				results.add(r);
				for (Event ev: Event.values()) {
					r.setResult(ev, rs.getDouble(1+ev.ordinal()));
				}
			}
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException ignore) { rs = null; }
			if (stmt != null)
				try { stmt.close(); } catch (SQLException ignore) {	stmt = null; }
			if (conn != null)
				try { conn.close(); } catch (SQLException ignore) {	conn = null; }
		}
		return results;
	}
}
