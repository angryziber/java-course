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
 * DecathlonResultDataBaseReader
 *
 * @author Agu Aarna
 */
public class DecathlonResultDataBaseReader implements IDechatlonResultReader {

	private Connection connection;
	
	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * @author Agu Aarna
	 * 
	 * @see net.azib.java.students.t020556.homework.IDechatlonResultReader#readResults()
	 * 
	 * @version 1
	 */
	public PriorityQueue<Competitor> readResults() {
		ResultSet results = readRaw();
		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>();
		try {
			if(results == null)
				throw new SQLException("No results set");

			while(results.next())
				compQ.add(createCompetitor(results));
			return compQ;
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to move forward in the obtained results", e);
		}
		return null;
	}
	
	/**
	 * initConnection method initializes the connection to the specified database
	 * 
	 * @author Agu Aarna
	 * 
	 * @param url - url to the database
	 * @param user - user of the database
	 * @param password - password of the database
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
	
	private ResultSet readRaw(){
		
		try {
			if(connection == null)
				throw new SQLException("No connection set");
			
			Statement st = connection.createStatement();
			String Query = 
				"SELECT A.name, A.dob, A.country_code, R.* " +
				"FROM athletes AS A INNER JOIN results AS R ON A.id=R.athlete_id";
			return st.executeQuery(Query);
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to query data from database", e);
			return null;
		}
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
}
