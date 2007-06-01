package net.azib.java.students.t020556.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonResultDataBaseReader class provides functionality for reading decathlon 
 * results from a database
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public class DecathlonResultDataBaseReader implements IDecathlonResultReader {

	private Connection connection;
	private Number competitionId = null;
	
	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * The method reads competition results according to the specified competition
	 * identifier. 
	 * 
	 * (see:
	 * 		{@link net.azib.java.students.t020556.homework.DecathlonResultDataBaseReader#
	 * 			setCompetitionId(Number)}).
	 * 
	 * If no identifier is set, the reader will fetch the results from all the 
	 * competitions specified in the database.
	 * 
	 * @author Agu Aarna
	 * 
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultReader#readResults()
	 * 
	 * @version 1
	 */
	public PriorityQueue<Competitor> readResults() {
		ResultSet results = readRaw(competitionId);
		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>();
		try {
			if(results == null)
				throw new SQLException("No results set");

			while(results.next())
				compQ.add(createCompetitor(results));
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to move forward in the obtained results", e);
		}
		try {
			results.close();
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to close obtained results", e);
		}
		return compQ;
	}
	
	/**
	 * initConnection method initializes the connection to the specified database
	 * 
	 * @author Agu Aarna
	 * 
	 * @param url - url to the database
	 * @param user - user of the database
	 * @param password - password of the user
	 * 
	 * @version 1
	 */
	public void initConnection(String url, String user, String password){
		String drvClass = "com.mysql.jdbc.Driver";
		try {
			Class.forName(drvClass);
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, "Unable to find class " + drvClass, e);
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to open connection to " + url, e);
		}
	}
	
	private Competitor createCompetitor(ResultSet rs){
		try {
			Competitor comp = new Competitor();
			comp.setName(rs.getString("name"));
			comp.setDateOfBirth(rs.getDate("dob"));
			comp.setLocale(rs.getString("country_code"));
			
			String[] results = new String[10];
			int i = 0;
			for(DecathlonEvent event : DecathlonEvent.values()){
				results[i++] = rs.getFloat(event.name().toLowerCase()) + "";
			}
			
			comp.setResults(results);
			return comp;			
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Failed to extract results from a resultset", e);
		}
		return null;
	}
	
	private ResultSet readRaw(Number eventNr){
		ResultSet rs = null;
		Statement st = null;
		try {
			if(connection == null)
				throw new SQLException("No connection set");
			
			st = connection.createStatement();
			String query = 
				"SELECT A.name, A.dob, A.country_code, R.* " +
				"FROM athletes AS A INNER JOIN results AS R ON A.id=R.athlete_id";
			
			if(eventNr != null && eventNr.intValue() > 0)
				query += " WHERE competition_id = " + eventNr.intValue();
			else
				LOG.warning(
					"Competition not specified correctly! Fetching results from " +
					"all competitions.");
			
			rs = st.executeQuery(query);
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to query data from database", e);
		}
		
		if(st != null)
			try {
				st.close();
			}
			catch (SQLException e) {
				LOG.log(Level.SEVERE, "Unable to close created statement", e);
			}
		return rs;
	}
	
	/**
	 * releaseConnection releases the connection resource
	 * 
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public void releaseConnection(){
		try {
			if(connection == null)
				throw new SQLException("No connection set");

			connection.close();
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to close connection", e);
		}
	}

	/**
	 * setCompetitionId method sets the competition identifyer. It is needed 
	 * when reading the results from the database. 
	 * 
	 * @author Agu Aarna
	 * 
	 * @param competitionId the competitionId to set
	 * 
	 * @version 1
	 */
	public void setCompetitionId(Number competitionId) {
		this.competitionId = competitionId;
	}
	
	/**
	 * getCompetitions method exposes the registered competitions.
	 * The competition identifier can be chosen from the given set
	 * 
	 * @author Agu Aarna
	 * 
	 * @return a set of registered competitions in the database
	 * 
	 * @version 1
	 */
	public ResultSet getCompetitions(){
		
		try {
			if(connection == null)
				throw new SQLException("No connection set");
			
			Statement st = connection.createStatement();
			String query = 
				"SELECT id, description FROM competitions ORDER BY id";
			
			return st.executeQuery(query);
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to query data from database", e);
			return null;
		}
	}
}
