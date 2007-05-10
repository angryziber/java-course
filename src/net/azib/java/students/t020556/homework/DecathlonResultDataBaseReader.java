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
		// TODO Auto-generated method stub
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
	
	public String readRaw(){
		try {
			Statement st = connection.createStatement();
			ResultSet result = st.executeQuery("SELECT name FROM athletes");
			StringBuilder sb = new StringBuilder();
			while(result.next())
				sb.append(result.getString("name") + " ");
			
			return sb.toString();
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
			connection.close();
		}
		catch (SQLException e) {
			LOG.log(Level.SEVERE, "Unable to close connection", e);
		}
	}
}
