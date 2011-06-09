package net.azib.java.students.t100224.homework.db;

import net.azib.java.students.t100224.homework.interfaces.IResultsLoader;
import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBLoader implements IResultsLoader {

	private final Logger LOG = Logger.getLogger(getClass().getName());
	private String competition;

	public DBLoader(String competition) {
		this.competition = competition;
	}

	@Override
	public List<Result> loadResults() {
		String query;
		try {
			int competitionID = Integer.parseInt(competition);
			query = "SELECT a.name, a.dob, a.country_code, "
					+ "r.* FROM results r INNER JOIN "
					+ "athletes a ON r.athlete_id = a.id "
					+ "WHERE r.competition_id = " + competitionID + ";";
			LOG.info(query);
		} catch (NumberFormatException e) {
			query = "SELECT athletes.name, athletes.dob, athletes.country_code, results. *"
					+ " FROM athletes, results, competitions"
					+ " WHERE results.competition_id = competitions.id"
					+ " AND athletes.id = results.athlete_id"
					+ " AND competitions.name LIKE '" + competition + "'; ";
			LOG.info(query);
		}

		DBConnection dbconnection = new DBConnection();

		List<Result> results = new ArrayList<Result>();
		Athlete athlete;
		Result result;
		try {
			Statement statement = dbconnection.getConnection()
					.createStatement();
			ResultSet rs = statement.executeQuery(query);
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
			LOG.error(e.getMessage());
		} finally {
			dbconnection.close();
		}

		return results;
	}

}