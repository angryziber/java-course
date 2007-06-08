package net.azib.java.students.t960644.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DBInput
 * 
 * Class for reading competition information from a database
 */
public class DBInput {

	protected Connection connection;

	/**
	 * Initializes the connection
	 * @param sqlDriver name of the driver
	 * @param url address of the database
	 * @param user database user
	 * @param password password for the database user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void initConnection(String sqlDriver, String url, String user, String password) throws ClassNotFoundException,
			SQLException {
		Class.forName(sqlDriver);
		connection = DriverManager.getConnection(url, user, password);
	}

	/**
	 * Reads the contents of the competitions table into a List<Competition>. The athletes and performance results are not read.
	 * @return a List containing all Competitions in the database. 
	 * @throws SQLException
	 */
	public List<Competition> readCompetitions() throws SQLException {
		Statement statement = connection.createStatement();
		List<Competition> returnList = new ArrayList<Competition>();
		ResultSet resultSet = statement.executeQuery("select * from competitions");
		while (resultSet.next()) {
			returnList.add(readSingleCompetition(resultSet));
		}
		return returnList;
	}
	/**
	 * Reads 
	 * @param compId the id of the competition in the database
	 * @return a new Competition object without the Athletes and Results
	 * @throws SQLException
	 */
	public Competition readCompetition(String compId) throws SQLException {
		Competition competition = null;
		PreparedStatement ps = connection.prepareStatement("select * from competitions where id=?");
		ps.setString(1, compId);
		ResultSet resultSet = ps.executeQuery("select * from competitions where id=2");
		if (resultSet.first()) {
			competition = readSingleCompetition(resultSet);
		}
		resultSet.close();
		ps.close();
		return competition;
	}
	/**
	 * Creates a new Competition object and fills the fields from the provided ResultSet.
	 * @param resultSet an active ResultSet containing the competition data 
	 * @return a new Competition object filled by the data from the ResultSet
	 * @throws SQLException
	 */
	protected Competition readSingleCompetition(ResultSet resultSet) throws SQLException {
		Competition competition = new Competition();
		competition.setDate(resultSet.getDate("date"));
		competition.setCountryCode(resultSet.getString("country_code"));
		competition.setDescription(resultSet.getString("description"));
		competition.setId(resultSet.getInt("id"));
		return competition;
	}
	/**
	 * Adds list of Athletes associated with the competiton
	 * @param competition an instantiated Competition with its fields set
	 * @throws SQLException
	 */
	public void readAthletes(Competition competition) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from athletes where id in (select athlete_id from results where competition_id= ? )");
		preparedStatement.setString(1, String.valueOf(competition.getId()));
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Athlete athlete = new Athlete();
			athlete.setBorn(resultSet.getDate("dob"));
			athlete.setCountryCode(resultSet.getString("country_code"));
			athlete.setName(resultSet.getString("name"));
			athlete.setId(resultSet.getInt("id"));
			competition.addAthlete(athlete);
		}
		resultSet.close();
		preparedStatement.close();
	}
	/**
	 * Add list of Results associated with the competition. readAthletes method has to be called before this one.
	 * @param competition an instantiated Competition with its fields and list of athletes set
	 * @throws SQLException
	 */
	public void readResults(Competition competition) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select * from results where competition_id= ? ");
		preparedStatement.setString(1, String.valueOf(competition.getId()));
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Result result = new Result();
			result.setId(resultSet.getInt("id"));
			result.setRace100(resultSet.getDouble("race_100m"));
			result.setLongJump(resultSet.getDouble("long_jump"));
			result.setShotPut(resultSet.getDouble("shot_put"));
			result.setHighJump(resultSet.getDouble("high_jump"));
			result.setRace400(resultSet.getDouble("race_400m"));
			result.setHurdles110(resultSet.getDouble("hurdles_110m"));
			result.setDiscusThrow(resultSet.getDouble("discus_throw"));
			result.setPoleVault(resultSet.getDouble("pole_vault"));
			result.setJavelinThrow(resultSet.getDouble("javelin_throw"));
			result.setRace1500(resultSet.getDouble("race_1500m"));
			competition.addResult(result);
			result.setAthlete(competition.findAthleteById(resultSet.getInt("athlete_id")));
		}
		resultSet.close();
		preparedStatement.close();
	}
	/**
	 * Releases connection.
	 * @throws SQLException
	 */
	public void releaseConnection() throws SQLException {
		connection.close();
	}

}
