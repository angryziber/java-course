package ee.ttu.decathlon.io;

import ee.ttu.decathlon.DecathlonException;
import ee.ttu.decathlon.beans.Athlete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbInputProcessor extends AbstractInputProcessor<Connection> {

    private String sql = "SELECT " +
            " a.name,DATE_FORMAT(dob, '%d.%m.%Y') birthday,a.country_code,race_100m,long_jump,shot_put,high_jump," +
            " race_400m,hurdles_110m,discus_throw,pole_vault,javelin_throw,race_1500m" +
            " FROM results r, athletes a, competitions c" +
            " WHERE r.athlete_id = a.id AND c.id = r.competition_id AND year( dob ) >1900";

    public DbInputProcessor(Connection c, int competitionId) {
        super(c);
        sql = sql + " AND c.id = " + competitionId;
    }

    public DbInputProcessor(Connection c, String competitionName) {
        super(c);
        sql = sql + " AND c.name = '" + competitionName + "'";
    }

    public List<Athlete> readAthletes() {
        PreparedStatement preparedStatement;
        List<Athlete> athletes = new ArrayList<Athlete>();

        try {
            preparedStatement = getSource().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                athletes.add(createAthlete(Arrays.asList(
                        rs.getString("name"),
                        rs.getString("birthday"),
                        rs.getString("country_code"),
                        rs.getString("race_100m"),
                        rs.getString("long_jump"),
                        rs.getString("shot_put"),
                        rs.getString("high_jump"),
                        rs.getString("race_400m"),
                        rs.getString("hurdles_110m"),
                        rs.getString("discus_throw"),
                        rs.getString("pole_vault"),
                        rs.getString("javelin_throw"),
                        rs.getString("race_1500m")
                )));
            }
        } catch (SQLException e) {
            throw new DecathlonException("Unable to load athletes from DB!");
        }
        return athletes;
    }
}
