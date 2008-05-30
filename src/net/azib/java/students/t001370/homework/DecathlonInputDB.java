package net.azib.java.students.t001370.homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonInputDB
 * Class for getting data from Database
 * @author maksim
 */
public class DecathlonInputDB extends DecathlonInput{
	private static final Logger LOG = Logger.getLogger(DecathlonInputDB.class.getName());

	private PrintStream output;
	
	/**
	 * DecathlonInputDB constructor
	 */
	DecathlonInputDB(){
		this.output = new PrintStream(System.out);
	}
	
	/**
	 * DecathlonInputDB constructor. Mostly user for testing purpose
	 * @param out - print stream for user interaction
	 */
	DecathlonInputDB(PrintStream out){
		this.output = out;
	}

	/**
	 * SQL statement for PreparedStatement
	 * @return SQL statement string
	 */
	 String getSQLStatement(){
			
		 return "SELECT a.name 		AS name, 													" +
			"       a.dob 			AS birthday, 											" +
			"       a.country_code 	AS country_code,										" +
			"       r.race_100m 	AS race_100m,											" +
			"       r.long_jump 	AS long_jump,											" +
			"       r.shot_put 		AS shot_put,											" +
			"       r.high_jump 	AS high_jump,											" +
			"       r.race_400m 	AS race_400m,											" +
			"       r.hurdles_110m 	AS hurdles_110m,										" +
			"       r.discus_throw 	AS discus_throw,										" +
			"       r.pole_vault 	AS pole_vault,											" +
			"       r.javelin_throw AS javelin_throw,										" +
			"       r.race_1500m 	AS race_1500m											" +
			"FROM athletes AS a,results AS r,competitions AS c  							" +
			"WHERE a.id = r.athlete_id AND 													" +
			"      r.competition_id = c.id  AND												" +
			"      (c.id = ? OR c.name = ?)"; 
	}
	
	/**
	 * Get decathlon competition data from database
	 * @param readParam String - specifies the competition (can be a number or competition name) 
	 * @param pr - db properties
	 * @return Collection of athletes
	 * @throws DecathlonException throws in case data could not be retrieved from db
	 */
	 Collection<Athlete> getAthletesDataFromDB(String readParam, Properties pr) throws DecathlonException {
		LOG.log(Level.INFO, "get data from DB entered");
		
		Collection<Athlete> returnAthletCollection = new TreeSet<Athlete>();
		Connection conn = null;

		try{
			LOG.log(Level.INFO, "current db properties:" + 
						" subprotocol=" + pr.getProperty("db.subprotocol") + 
						" subname=" + pr.getProperty("db.subname") + 
						" username=" + pr.getProperty("db.username") + 
						" password=" + pr.getProperty("db.password"));
			LOG.log(Level.INFO, "current db readArg=" + readParam);

			
			conn = DriverManager.getConnection(
					"jdbc:" + 
					pr.getProperty("db.subprotocol", "mysql") + ":" + 
					pr.getProperty("db.subname", "//srv.azib.net:3306/decathlon"),
					pr.getProperty("db.username", "java"),
					pr.getProperty("db.password", "java"));
			
			PreparedStatement pstmt = conn.prepareStatement(getSQLStatement());
			pstmt.setString(1, readParam);
			pstmt.setString(2, readParam);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {	
				Athlete athleteData = new Athlete();
				
				// set athlete data
				athleteData.setName(rs.getString("name"));
				athleteData.setBirthday(rs.getDate("birthday"));
				athleteData.setCountryCode(rs.getString("country_code"));
				athleteData.competitionResults.setResult100mRace(rs.getFloat("race_100m"));
				athleteData.competitionResults.setResultLongJump(rs.getFloat("long_jump"));
				athleteData.competitionResults.setResultShotPut(rs.getFloat("shot_put"));
				athleteData.competitionResults.setResultHighJump(rs.getFloat("high_jump"));
				athleteData.competitionResults.setResult400mSprint(rs.getFloat("race_400m"));
				athleteData.competitionResults.setResult110mHurdles(rs.getFloat("hurdles_110m"));
				athleteData.competitionResults.setResultDiscusThrow(rs.getFloat("discus_throw"));
				athleteData.competitionResults.setResultPoleVault(rs.getFloat("pole_vault"));
				athleteData.competitionResults.setResultJavelinThrow(rs.getFloat("javelin_throw"));
				athleteData.competitionResults.setResult1500mRace(rs.getFloat("race_1500m"));
				
				//add new athlete to collection
				returnAthletCollection.add(athleteData);
			}
		}
		catch (SQLException e){
			
			output.println(Errors.ERROR_COULD_NOT_READ_DB.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_COULD_NOT_READ_DB.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			
			throw new DecathlonException();
		}
		finally{
			
			try{
				if (conn != null) {
					conn.close();
				}
			}
			catch(SQLException e){
				output.println(Errors.ERROR_COULD_NOT_CLOSE_DB_RELATIONS.getErrorText());

				LOG.log(Level.INFO, Errors.ERROR_COULD_NOT_CLOSE_DB_RELATIONS.getErrorText());
				LOG.log(Level.INFO, e.getMessage());
			}
		}
		return returnAthletCollection;
	}

	/**
	 * Reads DB propetries file (db.properties)
	 * @return - db properties 
	 * @throws DecathlonException throws in case db.properties file could not be found or read
	 */
	Properties getDBProperties() throws DecathlonException{
		
		Properties dbp = new Properties();
		
		try{
			
			LOG.log(Level.INFO, DecathlonDataReader.class.getResource("db.properties").getPath());
			//read properties from properties file
			dbp.load(DecathlonDataReader.class.getResourceAsStream("db.properties"));
		}
		catch (FileNotFoundException e) {
			output.println(Errors.ERROR_DB_PROPERTIES_NOT_FOUND.getErrorText());
			output.println(Errors.ERROR_COULD_NOT_READ_DB.getErrorText());

			LOG.log(Level.INFO, e.getMessage());
			throw new DecathlonException();
		}
		catch (IOException e) {
			output.println(Errors.ERROR_PROBLEMS_READING_DB_PROPERTIES.getErrorText());
			output.println(Errors.ERROR_COULD_NOT_READ_DB.getErrorText());

			LOG.log(Level.INFO, e.getMessage());
			throw new DecathlonException();
		}

		return dbp;
	}
	
	@Override
	public Collection<Athlete> getData(String inArg) throws DecathlonException {

		return getAthletesDataFromDB(inArg, getDBProperties());
	}
}
