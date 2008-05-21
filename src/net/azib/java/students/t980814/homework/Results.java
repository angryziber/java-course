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
 * Results class contains data and methods for retrieving and outputting data about result records.
 * One result record (Results object) contains information about the athlete, his/her results and the total score.
 *
 * @author Allan Berg
 */
public class Results implements Comparable<Results> {

	private static final Logger LOG = Logger.getLogger(Results.class.getName());
	final static String COMMA = ",";

	Athlete athlete;
	private HashMap<String, Float> resultData;
	private int sum;
	private static int athleteIdGenerator = 0;
	
	/**
	 * This is the constructor of Results that simply fills it with data.
	 * @param athlete - instance of Athlete class to be added into this object
	 * @param results - list of float results
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
	 * This is the constructor of Results that parses the input string (CSV format) and stores data from it.
	 * @param lineCSV - CSV formatted string
	 * @throws DecaCalcException - if there are problems with creating instance of Athlete class.
	 * @throws IndexOutOfBoundsException - if there are not enough data in <b>lineCSV</b>
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
	 * This is the constructor of Results that uses the connection and id to retrieve the data from
	 * database from 'results' table (and also from 'athletes' table via Athlete constructor).  
	 * @param conn - an opened connection to database that contains an 'results' table that has following fields:
	 * id (integer), athlete_id (integer), competition_id (integer), race_100m, long_jump, shot_put, high_jump, race_400m,
	 * hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m (all float)
	 *  and 'athletes' table that has following fields:
	 * 	id (int), name (varchar in UTF-8 format), country (varchar) and dob (date). 
	 * @param id - an identificator what to search from the 'results' table
	 * @throws DecaCalcException - if it was impossible to read data from 'results' or 'athletes' table or if the athlete's name was not in UTF-8 format
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
	 * Implementation of comparator method. This is needed to be able to add Results object into TreeSet in sorted order.
	 * The comparision is made using only calculated total score and two objects are never equal (0 is never returned).
	 */
	public int compareTo(Results o) {
		return (sum <= o.getSum())? 1 : -1;
	}

	/**
	 * Returns the total score of current set of results
	 * @return score
	 */
	public int getSum() {
		return sum;
	}
	
	/**
	 * Returns a formatted string of the decathlon event
	 * @param key - the key to the event, see DecathlonEvent documentation
	 * @return result - formatted string
	 */
	private String getResultString(String key) {
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
	 * Returns the contents of Results as String (including Athlete) in regular format.
	 * @return String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(" - ").append(athlete).append(COMMA).append(" Results: ");
		for (String key : DecathlonEvent.getAllKeys())
			sb.append(getResultString(key)).append(COMMA);
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * Returns the contents of Results as String (including Athlete) in CSV format)
	 * @return String
	 */
	public String toStringCSV() {
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(COMMA).append(athlete.toStringCSV());
		for (String key : DecathlonEvent.getAllKeys())
			sb.append(COMMA).append(getResultString(key));
		return sb.toString();
	}
	
	/**
	 * Takes the data from this class (and Athlete class) and appends it to DOM4J Element as child-Elements.
	 * @param root - a DOM4J Element where to add child-Elements
	 * @param position - the position of this set of results in overall classification
	 * @return root
	 * @throws DecaCalcException - if the root Element is not instance of Element
	 */
	public Element addResultsDataToElement(Element root, String position) throws DecaCalcException {
		if (root instanceof Element) {
			Element athleteElement = root.addElement("athlete").
										  addAttribute("id", String.valueOf(athlete.getAthleteId()));
			athleteElement.addElement("position").addText(position);
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
