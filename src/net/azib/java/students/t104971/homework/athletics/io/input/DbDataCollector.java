package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.util.DbConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static net.azib.java.students.t104971.homework.athletics.components.ResultType.*;

/**
 * @author Jaroslav Judin
 */
public class DbDataCollector implements DataCollector {

    private Logger logger = Logger.getLogger(getClass());

    Connection connection;

    public List<Athlete> loadCompetitionResults(String competition) {
        List<Athlete> athletes = new ArrayList<Athlete>();
        try {
            setConnection(new DbConnection().connect());
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
            System.out.println("Cannot get connection");
        }

        return athletes;
    }

    private Athlete parseResult(ResultSet result) {
        Athlete athlete = new Athlete();
        try {
            athlete.setName(result.getString("name"));
            athlete.setCountry(result.getString("country_code"));

            athlete.addResult(RACE_100_METERS, result.getDouble("race_100m"));
            athlete.addResult(LONG_JUMP, result.getDouble("long_jump"));
            athlete.addResult(SHOT_PUT, result.getDouble("shot_put"));
            athlete.addResult(HIGH_JUMP, result.getDouble("high_jump"));
            athlete.addResult(RACE_400_METERS, result.getDouble("race_400m"));
            athlete.addResult(RACE_110_METERS_HURDLES, result.getDouble("hurdles_110m"));
            athlete.addResult(DISCUS_THROW, result.getDouble("discus_throw"));
            athlete.addResult(POLE_VAULT, result.getDouble("pole_vault"));
            athlete.addResult(JAVELIN_THROW, result.getDouble("javelin_throw"));
            athlete.addResult(RACE_1500_METERS, result.getDouble("race_1500m"));

            athlete.setDateBirth(result.getDate("dob"));
        } catch (SQLException e) {
            logger.error("Cannot get Date form db", e);
            System.out.println("Cannot get Date form db");
        }
        return athlete;
    }

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
    }
}
