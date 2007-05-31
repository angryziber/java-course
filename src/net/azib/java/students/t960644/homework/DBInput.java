package net.azib.java.students.t960644.homework;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBInput
 * 
 * @author Lembit
 */
public class DBInput {

	protected Connection connection;

	public void initConnection(String sqlDriver, String url, String user, String password) throws ClassNotFoundException,
			SQLException {
		Class.forName(sqlDriver);
		connection = DriverManager.getConnection(url, user, password);
	}

	public Competition readCompetition() throws SQLException {
		Competition competition = new Competition();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from competitions where id=2");
		while (resultSet.next()) { // uhh kui vilets lahendus, ajutine teema.
			competition.setDate(resultSet.getDate("date"));
			competition.setCountryCode(resultSet.getString("country_code"));
			competition.setDescription(resultSet.getString("description"));
			competition.setId(resultSet.getInt("id"));
		}
		resultSet.close();
		statement.close();
		return competition;
	}

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
	
	public void readResults(Competition competition) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from results where competition_id= ? ");
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
	

	public void releaseConnection() throws SQLException {
		connection.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
		DBInput dbInput = new DBInput();
		dbInput.initConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "MykB5kB5");
		Competition competition = dbInput.readCompetition();
		dbInput.readAthletes(competition);
		dbInput.readResults(competition);
		dbInput.releaseConnection();
		//PrintStream out = System.out; 
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		out.println(competition.getCountryCode());
		out.println(competition.getDate());
		out.println(competition.getDescription());
		for(Result res : competition.getResults()){
			out.println(res.getAthlete().getName());
			out.println(res.getAthlete().getCountryCode());
			out.println(res.calcResult());
		}
	}
}
