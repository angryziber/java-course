package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.dto.ResultType;
import net.azib.java.students.t104971.homework.athletics.util.DbConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class DbDataCollector implements DataCollector {

    Logger logger = Logger.getLogger(getClass());

    public List<Athlete> getAllAthletes() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        try {
            Connection connection = DbConnection.getConnection();
            ResultSet result = connection.createStatement().executeQuery("SELECT * FROM athletes");
            while (result.next()) {
                athletes.add(parseResult(result));
            }
        } catch (SQLException e) {
            logger.error("Cannot get connection", e);
        }

        return athletes;
    }

    public List<Athlete> loadCompetitionResults(String competition) {
        List<Athlete> athletes = new ArrayList<Athlete>();
        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM results "
                            + "LEFT JOIN athletes ON results.athlete_id=athletes.id "
                            + "LEFT JOIN competitions ON results.competition_id=competitions.id  "
                            + "WHERE competitions.id=?");
            statement.setString(1, competition);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                athletes.add(parseResult(result));
            }
        } catch (SQLException e) {
            logger.error("Cannot get connection", e);
        }

        return athletes;
    }

    private Athlete parseResult(ResultSet result) {
        Athlete athlete = new Athlete();
        try {
            athlete.setId(result.getInt("athletes.id"));
            athlete.setName(result.getString("athletes.name"));
            athlete.setCountry(result.getString("athletes.country_code"));

            athlete.addResult(ResultType.RACE_100_METERS, result.getDouble("results.race_100m"));
            athlete.addResult(ResultType.LONG_JUMP, result.getDouble("results.long_jump"));
            athlete.addResult(ResultType.SHOT_PUT, result.getDouble("results.shot_put"));
            athlete.addResult(ResultType.HIGH_JUMP, result.getDouble("results.high_jump"));
            athlete.addResult(ResultType.RACE_400_METERS, result.getDouble("results.race_400m"));
            athlete.addResult(ResultType.RACE_110_METERS_HURDLES, result.getDouble("results.hurdles_110m"));
            athlete.addResult(ResultType.DISCUS_THROW, result.getDouble("results.discus_throw"));
            athlete.addResult(ResultType.POLE_VAULT, result.getDouble("results.pole_vault"));
            athlete.addResult(ResultType.JAVELIN_THROW, result.getDouble("results.javelin_throw"));
            athlete.addResult(ResultType.RACE_1500_METERS, result.getDouble("results.race_1500m"));

            athlete.setDateBirth(result.getDate("athletes.dob"));
        } catch (SQLException e) {
            logger.error("Cannot get Date form db", e);
        }
        return athlete;
    }

}
