package net.azib.java.students.t110013.homework.readers;

import net.azib.java.students.t110013.homework.model.Athlete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static net.azib.java.students.t110013.homework.model.AthleteUtils.validateCountry;
import static net.azib.java.students.t110013.homework.model.AthleteUtils.validateName;
import static net.azib.java.students.t110013.homework.model.Decathlon.*;

/**
 * @author Vadim
 */
public class DBAthletesReader implements AthletesReader {
    private static final String DB_URL = "jdbc:mysql://srv2.azib.net:3306/decathlon";
    private static final String DB_USER = "java";
    private static final String DB_PASSWORD = "java";
    private static final String DB_RESULTS_QUERY =
            "SELECT * " +
            "FROM athletes INNER JOIN results ON athletes.id = results.athlete_id " +
            "WHERE competition_id = ?;";
    private static final String DB_COMPETITIONS_QUERY = "SELECT id FROM competitions;";
    private static final Logger LOG = Logger.getLogger(DBAthletesReader.class.getName());
    private String competitionID;

    public DBAthletesReader(String competitionID) {
        this.competitionID = competitionID;
    }

    public List<Athlete> getAthletes() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement statement = connection.prepareStatement(DB_RESULTS_QUERY);
            statement.setInt(1, validateCompetitionID(connection, parseInt(competitionID)));
            ResultSet rs = statement.executeQuery();

            if (!rs.next()) {
                LOG.warning("Athletes and their results cannot be found. The database result set is empty.\n");
            }
            else {
                do athletes.add(buildAthlete(rs)); while (rs.next());
            }
        }
        catch (SQLException e) {
            LOG.severe(e.getMessage() + "\n");
            throw new RuntimeException(e);
        }
        finally {
            if (connection != null) closeQuietly(connection);
        }

        return athletes;
    }

    int parseInt(String competitionID) {
        try {
            return Integer.parseInt(competitionID);
        }
        catch (NumberFormatException e) {
            LOG.severe("The competition ID " + competitionID + " is invalid. Integer is expected.\n");
            throw new IllegalArgumentException(e);
        }
    }

    int validateCompetitionID(Connection connection, int id) throws SQLException {
        List<Integer> competitions = new ArrayList<Integer>();
        int idFromDatabase;

        ResultSet rs = connection.prepareStatement(DB_COMPETITIONS_QUERY).executeQuery();

        if (!rs.next())
            LOG.warning("Competitions cannot be found. The database result set is empty.\n");
        else {
            do {
                idFromDatabase = rs.getInt("id");
                competitions.add(idFromDatabase);

                if (idFromDatabase == id)
                    return id;
            } while (rs.next());
        }

        displayCompetitionIDNotFoundMessage(id, competitions);
        throw new IllegalArgumentException();
    }

    void displayCompetitionIDNotFoundMessage(int id, List<Integer> competitions) {
        StringBuilder sb = new StringBuilder("The specified competition ID " + id + " cannot be found.\n");

        sb.append("Following competition IDs were found in the database: ");
        for (int i = 0; i < competitions.size()-1; ++i) {
            sb.append(competitions.get(i)).append(", ");
        }
        sb.append(competitions.get(competitions.size()-1));

        LOG.severe(sb.append(".\n").toString());
    }

    Athlete buildAthlete(ResultSet rs) throws SQLException {
        Athlete athlete = new Athlete();

        athlete.setName(validateName(rs.getString("name")));
        athlete.setDateOfBirth(rs.getDate("dob"));
        athlete.setCountry(validateCountry(rs.getString("country_code")));

        athlete.setPerformanceResult(SPRINT_100M.getIndex(), rs.getDouble("race_100m"));
        athlete.setPerformanceResult(LONG_JUMP.getIndex(), rs.getDouble("long_jump"));
        athlete.setPerformanceResult(SHOT_PUT.getIndex(), rs.getDouble("shot_put"));
        athlete.setPerformanceResult(HIGH_JUMP.getIndex(), rs.getDouble("high_jump"));
        athlete.setPerformanceResult(SPRINT_400M.getIndex(), rs.getDouble("race_400m"));
        athlete.setPerformanceResult(HURDLES_110M.getIndex(), rs.getDouble("hurdles_110m"));
        athlete.setPerformanceResult(DISCUS_THROW.getIndex(), rs.getDouble("discus_throw"));
        athlete.setPerformanceResult(POLE_VAULT.getIndex(), rs.getDouble("pole_vault"));
        athlete.setPerformanceResult(JAVELIN_THROW.getIndex(), rs.getDouble("javelin_throw"));
        athlete.setPerformanceResult(RACE_1500M.getIndex(), rs.getDouble("race_1500m"));

        return athlete;
    }

    void closeQuietly(Connection connection) {
        try {
            connection.close();
        }
        catch (SQLException ignore) {
        }
    }
}
