package net.azib.java.students.t980814.lec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * AthleteLoadingJDBC
 *
 * @author dell
 */
public class AthleteLoadingJDBC {

	public static final String EVENT_LIST[] = {
			"race_100m", "long_jump", "shot_put", "high_jump", "race_400m", "hurdles_110m",
			"discus_throw", "pole_vault", "javelin_throw", "race_1500m"	};
	public static final String COMMA = ",";
	public static final String LN = System.getProperty("line.separator");
	
	Results results;

	private class Results {
		private LinkedList<ResultRecord> results;
		
		public Results(Connection conn) throws SQLException {
			PreparedStatement result_statement  = conn.prepareStatement("select * from results where id = ?");
			PreparedStatement athlete_statement = conn.prepareStatement("select * from athletes where id = ?");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select id from results");
			results = new LinkedList<ResultRecord>();
			while (rs.next())
				results.add(new ResultRecord(conn, rs.getInt("id"), result_statement, athlete_statement));
			rs.close();
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (ResultRecord rr : results) {
				sb.append(rr);
				sb.append(LN);
			}
			return sb.toString();
		}
	}
	
	private class ResultRecord {
		Athlete athlete;
		// Competition competition;
		private HashMap<String, Float> results;

		public ResultRecord(Connection conn,
				            int id,
				            PreparedStatement result_stmt,
				            PreparedStatement athlete_stmt) throws SQLException {
			result_stmt.setInt(1, id);
			ResultSet rs = result_stmt.executeQuery();
			while (rs.next()) { 
				athlete = new Athlete(conn, rs.getInt("athlete_id"), athlete_stmt);
				results = new HashMap<String, Float>();
				for (String e : EVENT_LIST)
					results.put(e, rs.getFloat(e));
			}
			rs.close();
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(athlete);
			for (String key : EVENT_LIST) {
				sb.append(COMMA);
				sb.append(results.get(key));
			}
			return sb.toString();
		}
	}
	
/*	private class Competition {
		
		private int id;
		private Date date;
		private String country_code;
		private String description; 
		
		public Competition(Connection conn, int id) throws SQLException {
			PreparedStatement statement = conn.prepareStatement("select * from competitions where id = ?");
			statement.setInt(1, id);
			this.id = id;
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				date = rs.getDate("date");
				country_code = rs.getString("country_code");
				description = rs.getString("description");
			}
			rs.close();
		}
		
		@Override
		public int hashCode() {
			return id;
		}

		public String toString() {
			return "";
		}
	}
*/	
	private class Athlete {
		private int athlete_id;
		private String name;
		private Date dob;
		private String country;

		public Athlete(Connection conn,
				       int athlete_id,
				       PreparedStatement athlete_stmt) throws SQLException {
			athlete_stmt.setInt(1, athlete_id);
			ResultSet rs = athlete_stmt.executeQuery();
			while (rs.next()) {
				this.athlete_id = athlete_id;
				this.name = rs.getString("name");
				this.dob = rs.getDate("dob");
				this.country = rs.getString("country_code");
			}
			rs.close();
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(name);    sb.append(COMMA);
			sb.append(dob);     sb.append(COMMA);
			sb.append(country); 
			return sb.toString();
		}

		@Override
		public int hashCode() {
			return athlete_id;
		}
	}
	
	public AthleteLoadingJDBC(Connection conn) {
		try {
			results = new Results(conn);
		}
		catch (SQLException e) {
			System.out.println("Unable to load data");
			e.printStackTrace();
		}
	}
	
	public String toString() {
		if (results == null)
			return "";
		else
			return results.toString();
	}
	
	public static void main(String[] args) throws SQLException {
		AthleteLoadingJDBC alJDBC = new AthleteLoadingJDBC(DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon", "java", "java"));
		System.out.println(alJDBC);
	}
}
