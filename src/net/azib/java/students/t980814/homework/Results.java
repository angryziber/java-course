package net.azib.java.students.t980814.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

import org.dom4j.Element;

/**
 * ResultRecord
 *
 * @author dell
 */
public class Results implements Comparable<Results> {

	private static final Logger LOG = Logger.getLogger(Results.class.getName());
	final static String COMMA = ",";

	Athlete athlete;
	private HashMap<String, Float> resultData;
	private int sum;
	private static int athleteIdGenerator = 0;
	
	/**
	 * @param athlete
	 * @param results
	 */
	public Results(Athlete athlete, LinkedList<Float> results) {
		LOG.info("Creating resultData from Athlete and LinkedList<Float>");
		this.athlete = athlete;
		resultData = new HashMap<String, Float>();
		DecathlonEvent event = DecathlonEvent.RACE_100M;
		while (!results.isEmpty()) {
			float result = results.pop();
			resultData.put(event.key, result);	
			if (result > 0)
				sum += event.calcPoints(result);
			if (event.hasNext())
				event = event.next();
			else
				break;
		}
	}
	
	/**
	 * @param lineCSV
	 * @throws DecaCalcException
	 * @throws IndexOutOfBoundsException
	 */
	public Results(String lineCSV) throws DecaCalcException, IndexOutOfBoundsException {
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
			LOG.info("Reed result from CSV (float): " + result);
			
			resultData.put(event.key, result);	
			if (result > 0)
				sum += event.calcPoints(result);
			if (event.hasNext())
				event = event.next();
			else
				break;
		};			
	}
	
	/**
	 * @param conn
	 * @param id
	 * @throws DecaCalcException
	 */
	public Results(Connection conn, int id) throws DecaCalcException {
		sum = 0;
		ResultSet rs = null;
		try {
			PreparedStatement result_statement = conn.prepareStatement("select * from results where id = ?");
			result_statement.setInt(1, id);
			rs = result_statement.executeQuery();
			while (rs.next()) { 
				athlete = new Athlete(conn, rs.getInt("athlete_id"));
				resultData = new HashMap<String, Float>();
				for (String e : DecathlonEvent.getAllKeys()) {
					float result = rs.getFloat(e);
					LOG.info("Reed result from DB (results id=" + id + ") (float): " + result);

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
			Competition.closeQuietly(rs);
		}
	}
	
	/**
	 *
	 */
	public int compareTo(Results o) {
		return (sum <= o.getSum())? 1 : -1;
	}

	/**
	 * @return
	 */
	public int getSum() {
		return sum;
	}
	
	/**
	 * @param key
	 * @return
	 */
	public String getResultString(String key) {
		String result = "0";
		if (resultData.containsKey(key))
		{
			float res = resultData.get(key);
			if (DecathlonEvent.getDecathlonEventByKey(key).isRunningEvent && (res >= 60.0))
				result = String.format("%d:%05.2f", ((int)res / 60), res % 60);
			else if (res != 0)
				result = String.format("%.2f", res);
		}
		return result.replace(',', '.');
	}
	
	/**
	 *
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(" - ").append(athlete).append(COMMA).append(" Results: ");
		for (String key : DecathlonEvent.getAllKeys())
			sb.append(getResultString(key)).append(COMMA);
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * @return
	 */
	public String toStringCSV() {
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(COMMA).append(athlete.toStringCSV());
		for (String key : DecathlonEvent.getAllKeys())
			sb.append(COMMA).append(getResultString(key));
		return sb.toString();
	}
	
	/**
	 * @param root
	 * @param position
	 * @return
	 * @throws DecaCalcException
	 */
	public Element addResultsDataToElement(Element root, int position) throws DecaCalcException {
		if (root instanceof Element) {
			Element athleteElement = root.addElement("athlete").
										  addAttribute("id", String.valueOf(athlete.getAthleteId()));
			athleteElement.addElement("position").addText(String.valueOf(position));
			athleteElement.addElement("score").addText(String.valueOf(sum));
			athlete.addAthleteDataToElement(athleteElement);
			Element resultsElement = athleteElement.addElement("results");
			for (String key : DecathlonEvent.getAllKeys())
				resultsElement.addElement(key).addText(getResultString(key));
		}
		else
			throw new DecaCalcException("Unable to add data to XML document");
		return root;
	} 
}
