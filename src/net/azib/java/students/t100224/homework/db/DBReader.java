package net.azib.java.students.t100224.homework.db;

import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBReader {

	private String query;

	public DBReader(String competition) {

		try {
			int competitionID = Integer.parseInt(competition);
			query = "SELECT a.name, a.dob, a.country_code, "
					+ "r.* FROM results r INNER JOIN "
					+ "athletes a ON r.athlete_id = a.id "
					+ "WHERE r.competition_id = " + competitionID + ";";
		} catch (NumberFormatException e) {
			query = "SELECT * FROM results ";
			e.printStackTrace();
		}
	}

	public ArrayList<Result> loadResults() {

		DBConnection dbconnection = new DBConnection();

		ArrayList<Result> results = new ArrayList<Result>();
		Athlete athlete;
		Result result;
		try {
			Statement statement = dbconnection.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {

				athlete = new Athlete();
				athlete.setName(rs.getString("name"));
				athlete.setCountry(rs.getString("country_code"));
				athlete.setDateOfBirth(rs.getDate("dob"));

				result = new Result();
				result.setSprint100(rs.getFloat("race_100m"));
				result.setLongJump(rs.getFloat("long_jump"));
				result.setShotPut(rs.getFloat("shot_put"));
				result.setHighJump(rs.getFloat("high_jump"));
				result.setSprint400(rs.getFloat("race_400m"));
				result.setHurdles110(rs.getFloat("hurdles_110m"));
				result.setDiscusThrow(rs.getFloat("discus_throw"));
				result.setPoleVault(rs.getFloat("pole_vault"));
				result.setJavelinThrow(rs.getFloat("javelin_throw"));
				result.setRace1500(rs.getFloat("race_1500m"));

				result.setAthlete(athlete);
				results.add(result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
}
