package net.azib.java.students.t980814.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * ResultRecord
 *
 * @author dell
 */
public class ResultRecord implements Comparable<ResultRecord> {

	Athlete athlete;
	private HashMap<String, Float> results;
	private int sum;
	
	public ResultRecord(Connection conn,
			            PreparedStatement result_stmt) throws SQLException {
		sum = 0;
		ResultSet rs = result_stmt.executeQuery();
		while (rs.next()) { 
			athlete = new Athlete(conn, rs.getInt("athlete_id"));
			results = new HashMap<String, Float>();
			for (String e : DecathlonEvent.getAllKeys()) {
				float result = rs.getFloat(e);
				results.put(e, result);
				sum += DecathlonEvent.getDecathlonEventByKey(e).calcPoints(result);
			}
		}
		rs.close();
	}
	
	public int getSum() {
		return sum;
	}
	
	public String getResultString(String key) {
		String result;
		float res = results.get(key);
		if (DecathlonEvent.getDecathlonEventByKey(key).isRunningEvent && (res >= 60.0))
			result = String.format("%d:%4.2f", ((int)res / 60), res % 60);
		else
			result = String.format("%.2f", res); 
		return result.replace(',', '.');
	}
	
	public String toString() {
		final String COMMA = ",";
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(COMMA).append(athlete);
		for (String key : DecathlonEvent.getAllKeys())
			sb.append(COMMA).append(getResultString(key));
		return sb.toString();
	}

	public int compareTo(ResultRecord o) {
		return (sum <= o.getSum())? 1 : -1;
	}
}
