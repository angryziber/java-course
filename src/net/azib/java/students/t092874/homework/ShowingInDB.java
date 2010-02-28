package net.azib.java.students.t092874.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * ShowingInDB
 * 
 * @author Aleksandr Gladki
 */
class ShowingInDB {
	private String nameOrId = "";
	private boolean numInput = false;

	/**
	 * @return the nameOrId
	 */
	public String getNameOrId() {
		return nameOrId;
	}

	ShowingInDB(String nameOrId) {
		this.nameOrId = nameOrId;
		try {
			Integer.valueOf(nameOrId).toString();
			numInput = true;
		}
		catch (NumberFormatException e) {
		}
	}

	/**
	 * 
	 * @return List<Result> from Data base.
	 */
	public List<Result> read() {

		Properties defaultProps = new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(System.getProperty("user.dir")+Constants.MY_PATH + "db.properties");
			defaultProps.load(in);
			in.close();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		String url = "jdbc:mysql://" + defaultProps.getProperty("server") + ":" + defaultProps.getProperty("port.default") + "/";
		String dbName = defaultProps.getProperty("database");
		String driver = "com.mysql.jdbc.Driver";
		String userName = defaultProps.getProperty("user");
		String password = defaultProps.getProperty("password");
		Statement statement = null;
		ResultSet resultSet = null;
		List<Result> resultsList = new ArrayList<Result>();
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			statement = conn.createStatement();
			// Result set get the result of the SQL query
			String query = "select r.*, a.* from ";
			if (numInput) {
				query += "results r, athletes a where  r.competition_id = " + getNameOrId() + " and a.id = r.athlete_id";

			}
			else {
				query += "results r, athletes a, competitions c where c.name ='" + getNameOrId()
						+ "' and c.id = r.competition_id and a.id=r.athlete_id";
			}
			resultSet = statement.executeQuery(query);

			if (numInput) {
				while (resultSet.next()) {
					putDataToResult(resultSet, resultsList);
				}
			}
			else {
				while (resultSet.next()) {
					putDataToResult(resultSet, resultsList);
				}
			}
			Collections.sort(resultsList);
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return resultsList;
	}

	private void putDataToResult(ResultSet resultSet, List<Result> resultsList) throws SQLException {
		Result result = new Result();
		Athlete athlete = new Athlete();
		athlete.setName(resultSet.getString("name"));
		try {
			athlete.setBirthDate(resultSet.getDate("dob"));
		}
		catch (java.sql.SQLException e) {
			athlete.setBirthDate(null);
		}
		athlete.setCountryCode(resultSet.getString("country_code"));
		result.setAthlete(athlete);

		result.setSprint100(resultSet.getFloat("race_100m"));
		result.setLongJump(resultSet.getFloat("long_jump"));
		result.setShortPut(resultSet.getFloat("shot_put"));
		result.setHighJump(resultSet.getFloat("high_jump"));
		result.setSprint400(resultSet.getFloat("race_400m"));
		result.setHurdles(resultSet.getFloat("hurdles_110m"));
		result.setDiscusThrow(resultSet.getFloat("discus_throw"));
		result.setPoleVault(resultSet.getFloat("pole_vault"));
		result.setJavelinThrow(resultSet.getFloat("javelin_throw"));
		result.setRace(resultSet.getFloat("race_1500m"));
		result.getPoints();// fill points
		resultsList.add(result);
	}
}
