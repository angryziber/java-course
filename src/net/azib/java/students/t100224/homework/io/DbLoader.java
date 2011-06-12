package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.azib.java.students.t100224.homework.model.Decathlon.Event;

public class DbLoader implements ResultsLoader {

	private final Logger LOG = Logger.getLogger(getClass().getName());

	@Override
	public List<Result> loadResults(String competition) {
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
		Map<String, Float> performances;
		try {
			Statement statement = dbconnection.getConnection()
					.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				result = new Result();
				athlete = new Athlete();
				performances = new HashMap<String, Float>();
				athlete.setName(rs.getString("name"));
				athlete.setCountry(rs.getString("country_code"));
				athlete.setDateOfBirth(rs.getDate("dob"));
				for (int i = 0; i < Event.values().length; i++) {
					performances.put(Event.values()[i].name(), rs.getFloat(Event.values()[i].name()));
				}
				result.setPerformances(performances);
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