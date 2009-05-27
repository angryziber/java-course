package net.azib.java.students.t030620.homework.input;

import net.azib.java.students.t030620.homework.beans.DecathleteScore;
import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * DataAccess
 *
 * @author Maksim Konstantinov 030620
 */
public class DBInputProvider implements InputProvider {
	
	private static final String SEARCHCOL = "SEARCHCOL";
	
	private static final String SQL_RESULST_BY_ID = "select a.*, r.* " +
									  "from athletes a " +
									  "inner join results r on r.athlete_id = a.id " +
									  "inner join competitions as c on r.competition_id = c.id " +
									  "where "+SEARCHCOL+" = ? ";
	
	private static final String MOD_NAME = "c.name";
	private static final String MOD_ID   = "c.id";
	
	
	String connectionString;
	
	DBInputProvider(Properties props) throws Exception {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e){
			throw new Exception("The MySQL driver couldn't be found");
		}
		
		if(props == null) {
			throw new Exception("No properties file found for input DB component");
		}
		
		this.connectionString = props.getProperty("db-connection");
		
		if(connectionString == null) {
			throw new Exception("No connection found in input DB component configuration file");
		}
		
	}
	
	
	
	private Collection<DecathleteScoreKeeper> getScores(String name) throws SQLException {
		String sql = SQL_RESULST_BY_ID.replace(SEARCHCOL, MOD_NAME);
		return getScores(sql, name);
	}
	
	private Collection<DecathleteScoreKeeper> getScores(Integer id) throws SQLException  {
		String sql = SQL_RESULST_BY_ID.replace(SEARCHCOL, MOD_ID);
		return getScores(sql, id);
	}
	
	private Collection<DecathleteScoreKeeper> getScores(String sql, Object ... params) throws SQLException {
		Connection con = getConnection();
		PreparedStatement stm = con.prepareStatement(sql);
		for(int i = 0; i < params.length; i++) {
			stm.setObject(i+1, params[i]);
		}
		ResultSet rs = stm.executeQuery();
		Collection<DecathleteScoreKeeper> result = fillList(rs);
		rs.close();
		stm.close();
		con.close();
		
		return result;
	}
	
	private Collection<DecathleteScoreKeeper> fillList(ResultSet rs) throws SQLException {
		Set<DecathleteScoreKeeper> result = new TreeSet<DecathleteScoreKeeper>();
		
		DecathleteScore score;
		DecathleteScoreKeeper scoreWrapper;
		Map<Competition, Double> map;
		while(rs.next()) {
			score = new DecathleteScore();
			map = score.getScores();
			
			score.setCountryCode(rs.getString("country_code"));
			score.setDate(rs.getTimestamp("dob"));
			score.setName(rs.getString("name"));
			
			map.put(Competition.SPRINT_100, new Double(rs.getFloat("race_100m")));
			map.put(Competition.LONG_JUMP, new Double(rs.getFloat("long_jump"))*100);
			map.put(Competition.SHOT_PUT, new Double(rs.getFloat("shot_put")));
			map.put(Competition.HIGH_JUMP, new Double(rs.getFloat("high_jump"))*100);
			map.put(Competition.SPRINT_400, new Double(rs.getFloat("race_400m")));
			map.put(Competition.HURDLES, new Double(rs.getFloat("hurdles_110m")));
			map.put(Competition.DISCUS_THROW, new Double(rs.getFloat("discus_throw")));
			map.put(Competition.POLE_VAULT, new Double(rs.getFloat("pole_vault"))*100);
			map.put(Competition.JAVELIN_THROW, new Double(rs.getFloat("javelin_throw")));
			map.put(Competition.RACE, new Double(rs.getFloat("race_1500m")));
			
			score.setScores(map);
			scoreWrapper = new DecathleteScoreKeeper(score);
			scoreWrapper.calclulateScore();
			result.add(scoreWrapper);
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(connectionString);
	}


	/**
	 * @param param either competition id (Integer expected) or competition name (String expected)
	 * @return sorted collection of DecathleteScoreKeeper with the calculated scores
	 */
	@Override
	public Collection<DecathleteScoreKeeper> getInput(Object param) throws Exception {
		if(param instanceof String) {return getScores((String)param);}
		if(param instanceof Integer) {return getScores((Integer)param);}
		else return null;
	}

}
