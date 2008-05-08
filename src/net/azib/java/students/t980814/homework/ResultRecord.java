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
	private HashMap<String, Float> resultData;
	private int sum;
	private static int athleteIdGenerator = 0;
	
	public ResultRecord(String lineCSV) throws DecaCalcException, IndexOutOfBoundsException {
		// Get the athlete name (everything between ""-s)
		String athleteName = lineCSV.substring(1, lineCSV.lastIndexOf('"'));
		lineCSV = lineCSV.substring(lineCSV.lastIndexOf('"') + 2); // +1 because of '"' and +1 because of ','
		String[] csvComponents = lineCSV.split(",");
		athlete = new Athlete(athleteIdGenerator++, athleteName, csvComponents[0], csvComponents[1]);
		resultData = new HashMap<String, Float>();

		sum = 0;
		DecathlonEvent event = DecathlonEvent.RACE_100M;
		int index = 2;
		while (true) {
			Float result;
			String[] timeComponents = csvComponents[index++].split(":");
			if (event.isRunningEvent && (timeComponents.length > 1))
				result = (new Integer(timeComponents[0]) * 60) + new Float(timeComponents[1]);
			else
				result = new Float(timeComponents[0]);
			
			resultData.put(event.key, result);	
			if (result > 0)
				sum += event.calcPoints(result);
			if (event.hasNext())
				event = event.next();
			else
				break;
		};			
	}
	
	public ResultRecord(Connection conn,
			            PreparedStatement result_stmt) throws DecaCalcException {
		sum = 0;
		ResultSet rs = null;
		try {
			rs = result_stmt.executeQuery();
			while (rs.next()) { 
				athlete = new Athlete(conn, rs.getInt("athlete_id"));
				resultData = new HashMap<String, Float>();
				for (String e : DecathlonEvent.getAllKeys()) {
					float result = rs.getFloat(e);
					resultData.put(e, result);
					if (result > 0)
						sum += DecathlonEvent.getDecathlonEventByKey(e).calcPoints(result);
				}
			}
		}
		catch (SQLException e) {
			throw new DecaCalcException("Error reading results database.");
		}
		finally {
			Results.closeQuietly(rs);
		}
	}
	
	public int getSum() {
		return sum;
	}
	
	public String getResultString(String key) {
		String result = "0";
		if (resultData.containsKey(key))
		{
			float res = resultData.get(key);
			if (DecathlonEvent.getDecathlonEventByKey(key).isRunningEvent && (res >= 60.0))
				result = String.format("%d:%4.2f", ((int)res / 60), res % 60);
			else
				result = String.format("%.2f", res);
		}
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
