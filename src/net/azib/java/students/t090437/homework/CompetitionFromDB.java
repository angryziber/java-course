package net.azib.java.students.t090437.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * CompetitionFromDB
 *
 * @author Ronald
 */
public class CompetitionFromDB implements CompetitionDataLoader {
	private Connection dbConn;
	private SortedSet<Competitor> competitors;
	private String competitionName;
	private boolean filterByName;
	private int competitionId;

	/**
	 * Creates CompetitionFromDB object with CompetitionLoader interface.
	 * The parameter is the name of the competition whose results are to be loaded.	
	 * @param competitionName
	 */
	public CompetitionFromDB(String competitionName) {
		competitors = new TreeSet<Competitor>();
		this.competitionName = competitionName;
		filterByName = true;
		
	}
	
	/**
	 * Creates CompetitionFromDB object with CompetitionLoader interface.
	 * The parameter is the id of the competition whose results are to be loaded.	
	 * @param competitionId
	 */
	public CompetitionFromDB(int competitionId) {
		competitors = new TreeSet<Competitor>();
		filterByName = false;
		this.competitionId = competitionId;
	}
	
	@Override
	public SortedSet<Competitor> getResults() {
		return competitors;
	}
	
	@Override
	public void loadData() throws MyException {
		//loadProperties();
		PreparedStatement statement;
		ResultSet results;
		Competitor competitor;
		boolean badCompetitionEntry;
		
		dbConn = openConnection();
		
		if(filterByName) {
			try {
				statement = dbConn.prepareStatement("SELECT id, COUNT(*) AS count FROM competitions WHERE name = ?");
				statement.setString(1, competitionName);
				results = statement.executeQuery();
				
				if(!results.next() || results.getInt("count") == 0) {
					throw new MyException("No competitions with the name " + competitionName);
				} else if(results.getInt("count") > 1) {
					throw new MyException("Too many competitions by the name " + competitionName +
							". Use competition id for selecting the competition.");
				} else {
					competitionId = results.getInt("id");
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			statement = dbConn.prepareStatement("SELECT * FROM `results`, athletes WHERE competition_id = ? AND athletes.id = results.athlete_id");
			statement.setInt(1, competitionId);
			statement.execute();
			results = statement.getResultSet();
		}
		catch (SQLException e) {
			try {
				dbConn.close();
			}
			catch (SQLException e1) {
			}
			throw new MyException("Unable to load data from database : " + e);
		}
		
		while(true) {
			badCompetitionEntry = false;
			competitor = null;
			
			try {
				if(!results.next()) {
					break;
				}
			
				competitor = insertNewCompetitor(results);
			} catch(Exception e) {
				badCompetitionEntry = true;
				try {
					System.out.println(("Bad data or result entry for competitor " + results.getString("name") + "\r\n" +
							"This competitor not added.\r\n" + e));
				}
				catch (SQLException e1) {
				}
			}
			if(!badCompetitionEntry) {
				competitor.calcScore();
				competitors.add(competitor);
			}
		}
		
		try {
			dbConn.close();
		}
		catch (SQLException e) {
		}
		
		PositionCalculator.calcPositions(competitors);
	}

	/**
	 * @throws MyException
	 */
	Connection openConnection() throws MyException {
		String connectionStr = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("dbConnString.txt")));
			connectionStr = reader.readLine();
			return DriverManager.getConnection(connectionStr);
		}
		catch (Exception e) {
			throw new MyException("Unable to connect to database " +
					"using connection string \"" + connectionStr + "\" : " + e);
		}
	}

	private Competitor insertNewCompetitor(ResultSet results) throws SQLException, BadDataFormatException {
		Competitor competitor = new Competitor();
		
		competitor.setSprint_100m_s(TimeResult.createObj(((double)results.getFloat("race_100m"))));
		competitor.setLong_jump_m(DecimalResult.createObj((double)results.getFloat("long_jump")));
		competitor.setShot_put_m(DecimalResult.createObj((double)results.getFloat("shot_put")));
		competitor.setHigh_jump_m(DecimalResult.createObj((double)results.getFloat("high_jump")));
		competitor.setSprint_400m_m_s(TimeResult.createObj((double)results.getFloat("race_400m")));
		competitor.setHurdles_s(TimeResult.createObj((double)results.getFloat("hurdles_110m")));
		competitor.setDiscus(DecimalResult.createObj((double)results.getFloat("discus_throw")));
		competitor.setPole_vault(DecimalResult.createObj((double)results.getFloat("pole_vault")));
		competitor.setJavelin_throw(DecimalResult.createObj((double)results.getFloat("javelin_throw")));
		competitor.setRace_1500m_m_s(TimeResult.createObj((double)results.getFloat("race_1500m")));
		
		competitor.setName(results.getString("name"));
		competitor.setBirthday(results.getDate("dob"));
		competitor.setCountry(results.getString("country_code"));
		
		return competitor;
	}
}
