package net.azib.java.students.t030726.homework.input;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator;
import net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent;
import net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.HighJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.LongJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent;
import net.azib.java.students.t030726.homework.decathlon.ShotPutEvent;

/**
 * Class is responsible for SQL server access and extraction of date. Also abstracts the input in a common way for the input controller to read
 * @author Deniss Nikiforov
 *
 */
public class SQLInput implements IInput {
	private Connection mysqlConnection= null;
	
	ArrayList finalResult = new ArrayList();
	private Logger log = null;
	
	Iterator mainIterator = null;
	
	/**
	 * Constructor accepts all parameters required to connect to the server. They are entered in the console
	 * @param serverURL
	 * @param serverUsername
	 * @param serverPassword
	 * @param competitionID
	 * @throws Exception 
	 * @throws InstantiationException 
	 */
	public SQLInput(String serverURL, String serverUsername, String serverPassword, int competitionID) throws InstantiationException, Exception {
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		this.establishConnection(serverURL, serverUsername, serverPassword);
		ResultSet rs = null;
		try {
			rs = this.readRawSQLData(competitionID);
			this.finalResult = this.processResultSetResults(rs);
			this.mainIterator = this.finalResult.iterator();
		} catch (Exception ex) {
			this.log.log(Level.SEVERE, "Connection broke", ex);
			throw ex;
		} finally {
			this.terminateConnection();
		}
		
		
	}
	
	/**
	 * Processes a single record from the database and instantiates the DecathlonChampionship object
	 * @param rs
	 * @return
	 * @throws InstantiationException
	 * @throws SQLException
	 * @throws Exception
	 */
	private DecathlonChampionship processSingleRecord(ResultSet rs) throws InstantiationException, SQLException, Exception {
		DecathlonChampionship championship = null;
		DecathlonChampionshipParticipator participator = null;
		
		participator = new DecathlonChampionshipParticipator(rs.getString("name"), rs.getString("country_code"), 
				rs.getString("dob"));
		championship = new DecathlonChampionship(participator);
		
		//Initialize event data properties of the championship instance
		championship.setHundredMeterSprintData(new HundredMeterSprint(rs.getString("race_100m")));
		championship.setLongJumpEventData(new LongJumpEvent(Double.parseDouble(rs.getString("long_jump"))));
		championship.setShotPutEventData(new ShotPutEvent(Double.parseDouble(rs.getString("shot_put"))));
		championship.setHighJumpEventData(new HighJumpEvent(Double.parseDouble(rs.getString("high_jump"))));
		championship.setFourHundredMeterSprintEventData(new FourHundredMeterSprint(rs.getString("race_400m")));
		championship.setHundredAndTenMeterHurdlesEventData(new HundredAndTenMeterHurdlesEvent(rs.getString("hurdles_110m")));
		championship.setDiscusThrowEventData(new DiscusThrowEvent(Double.parseDouble(rs.getString("discus_throw"))));
		championship.setPoleVaultEventData(new PoleVaultEvent(Double.parseDouble(rs.getString("pole_vault"))));
		championship.setJavelinThrowEventData(new JavelinThrowEvent(Double.parseDouble(rs.getString("javelin_throw"))));
		championship.setFifteenHundredMeterRunEventData(new FifteenHundredMeterRunEvent(rs.getString("race_1500m")));
		
		return championship;
	}
	
	/**
	 * This is bulk processing of database records. Stores all those newly created DecathlonChampionship objects into an ArrayList
	 * @param rs
	 * @return
	 * @throws Exception 
	 * @throws InstantiationException 
	 * @throws SQLException 
	 */
	private ArrayList processResultSetResults(ResultSet rs) throws SQLException, InstantiationException, Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
			while(rs.next()){
				
				out.add(this.processSingleRecord(rs));
			  }
		return out;
	}
	
	
	/**
	 * Establishing the connectio to the server
	 * @param serverURL
	 * @param serverUsername
	 * @param serverPassword
	 * @throws SQLException
	 */
	private void establishConnection(String serverURL, String serverUsername, String serverPassword) throws SQLException {
		String url = serverURL;
			
		this.mysqlConnection = DriverManager.getConnection(url,serverUsername, serverPassword);
	}
	
	private void terminateConnection() throws SQLException {
		this.mysqlConnection.close();
	}
	
	/**
	 * Getting a resultset from the database
	 * @param competitionID
	 * @return
	 * @throws SQLException
	 */
	private ResultSet readRawSQLData(int competitionID) throws SQLException {
		ResultSet rs = null;
		String sql = "SELECT * FROM results join athletes on results.athlete_id = athletes.id where competition_id = ?";
		this.log.log(Level.INFO, "Executing: " + sql);
		PreparedStatement preparedStatement = this.mysqlConnection.prepareStatement(sql);
		preparedStatement.setInt(1, competitionID);

		rs = preparedStatement.executeQuery();

		return rs;
	}

	/**
	 * Getting the next element from the iterator
	 */
	public DecathlonChampionship getNext() throws InstantiationException, Exception {
		return (DecathlonChampionship) this.mainIterator.next();
	}

	/**
	 * Returns true if there is some next element that could be read
	 */
	public boolean hasNext() {
		return this.mainIterator.hasNext();
	}

}
