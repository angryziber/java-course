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
 *
 * @author maksim
 */
public class DecathlonInputDB extends DecathlonInput{
	private static final Logger LOG = Logger.getLogger(DecathlonInputDB.class.getName());

	private PrintStream output;
	
	DecathlonInputDB(){
		this.output = new PrintStream(System.out);
	}
	
	DecathlonInputDB(PrintStream out){
		this.output = out;
	}

	/**
	 * SQL statement for PreparedStatement
	 * @return SQL statement string
	 */
	private String getSQLStatement(){
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
				"FROM (athletes AS a INNER JOIN results AS r ON a.id = r.athlete_id) 			" +
				"                    INNER JOIN competitions AS c ON r.competition_id = c.id 	" + 
				"WHERE c.id = ? OR c.name = ?"; 

	}
	
	/**
	 * Get decathlon competition data from database
	 * @param readParam String - specifies the competition (can be a number or competition name) 
	 * @return Collection of athletes
	 */
	private Collection<Athlete> getAthletesDataFromDB(String readParam) {
		LOG.log(Level.INFO, "get data from DB entered");

		
		Collection<Athlete> returnAthletCollection = new TreeSet<Athlete>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;

		try{
			Properties pr = new Properties();
			
			LOG.log(Level.INFO, DecathlonDataReader.class.getResource("db.properties").getPath());
			pr.load(DecathlonDataReader.class.getResourceAsStream("db.properties"));
			
			conn = DriverManager.getConnection(
					"jdbc:" + 
						pr.getProperty("db.subprotocol", "mysql") + ":" + 
						pr.getProperty("db.subname", "//srv.azib.net:3306/decathlon"),
					pr.getProperty("db.username", "java"),
					pr.getProperty("db.password", "java"));
			
			pstmt = conn.prepareStatement(getSQLStatement());
			pstmt.setString(1, readParam);
			pstmt.setString(2, readParam);
			
			rs = pstmt.executeQuery();
			
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
			
			output.println(Errors.ERROR_0012.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_0012.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			
			System.exit(1);
		}
		catch (FileNotFoundException e) {
			output.println(Errors.ERROR_0024.getErrorText());
			output.println(Errors.ERROR_0012.getErrorText());

			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}
		catch (IOException e) {
			output.println(Errors.ERROR_0025.getErrorText());
			output.println(Errors.ERROR_0012.getErrorText());

			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}
		finally{
			
			try{
				pstmt.close();
				rs.close();
				conn.close();
			}
			catch(SQLException e){
				output.println(Errors.ERROR_0013.getErrorText());

				LOG.log(Level.INFO, Errors.ERROR_0013.getErrorText());
				LOG.log(Level.INFO, e.getMessage());
			}
		}
		return returnAthletCollection;
	}

	@Override
	public Collection<Athlete> getData(String inArg) {

		return getAthletesDataFromDB(inArg);
	}

	
}
