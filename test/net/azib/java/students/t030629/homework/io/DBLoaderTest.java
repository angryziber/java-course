package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import static org.easymock.EasyMock.*;

import java.sql.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.math.BigDecimal;
import java.net.URISyntaxException;

import static junit.framework.Assert.*;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 17.05.2008
 * <br>Time: 14:13:06
 */
public class DBLoaderTest {
    private static final String MOCK_URL = "jdbc:hsqldb:mem:TestDB";
    private static final String MOCK_USER = "sa";
    private static final String MOCK_PASSWORD = "";

    static {
        DecathlonCalculator.initProperties();
        try {
            createVirtualDb();
        } catch (SQLException e) {
            Logger.getLogger(DBLoaderTest.class.getName()).log(Level.SEVERE, "Error creating virtual DB for tests", e);
        }
    }

    @Test
    public void propertiesInitializedCorrectly() throws URISyntaxException {
        /* Initialize and save properties to DBLoader.DEFAULT_DB_PROPERTIES_FILE_PATH */
        new DBLoader(2);
        /* Read properties */
        assertNotNull(System.getProperty(DBLoader.URL_KEY));
        assertNotNull(System.getProperty(DBLoader.USER_KEY));
        assertNotNull(System.getProperty(DBLoader.PASSWORD_KEY));
    }

    @Test (expected = ConnectionOpenedException.class)
    public void testOpenConnection() {
        try {
            new DBLoader(1).openConnection();
            /* Indicates that connection was created successfully */
            throw new ConnectionOpenedException();
        } catch (SQLException e) {
            /* Suppress (mute) exception, which indicates that connection hasn't been created */
        }

    }

    /* Helper class, to see the descriptive exception when Unit Test fails */
    private class ConnectionOpenedException extends RuntimeException {}

    @Test (expected = InvalidCompetitionNameException.class)
    public void correctCompetitionIdSet() {
        DBLoader dbLoader = new DBLoader("Training");
        assertEquals(1, dbLoader.competitionId);

        dbLoader = new DBLoader("DECATHLON4BEER");
        assertEquals(2, dbLoader.competitionId);

        dbLoader = new DBLoader(1);
        assertEquals(1, dbLoader.competitionId);

        dbLoader = new DBLoader(2);
        assertEquals(2, dbLoader.competitionId);

        try {
            new DBLoader("KRAKOZJABLJA 123123    13ASFLKAJ");
        } catch (RuntimeException e) {
            throw new InvalidCompetitionNameException();
        }

    }

    /* Helper class, to see the descriptive exception when Unit Test fails */
    private class InvalidCompetitionNameException extends RuntimeException{}

    @Test
    public void resultsCorrectlyLoadedAndNormalized() throws SQLException {
        String[] dbEventNames = {"race_100m","long_jump","shot_put","high_jump","race_400m",
                "hurdles_110m","discus_throw","pole_vault","javelin_throw","race_1500m"};
        String[] dbEventResults = {"12.61","5","9.22","1.5","60.25","16.43","21.6","2.6","35.81","325.72"};
        BigDecimal[] correctResults = {
                new BigDecimal("12.61"),
                new BigDecimal("500"),
                new BigDecimal("9.22"),
                new BigDecimal("150"),
                new BigDecimal("60.25"),
                new BigDecimal("16.43"),
                new BigDecimal("21.6"),
                new BigDecimal("260"),
                new BigDecimal("35.81"),
                new BigDecimal("325.72"),
        };

        ResultSet mockResultSet = createMock(ResultSet.class);
        for (int i = 0; i < dbEventNames.length; i++) {
            expect(mockResultSet.getString(dbEventNames[i])).andReturn(dbEventResults[i]);
        }
        replay(mockResultSet);

        DecathlonEvent event = DecathlonEvent.getFirstEvent();
        for (BigDecimal correctResult : correctResults) {
            assertTrue(correctResult.compareTo(DBLoader.extractResultFor(event, mockResultSet)) == 0);
            event = event.next();
        }

    }

    @Test
    public void testLoad() throws IOException, ParseException, SQLException {
        DBLoader dbLoader = new DBLoader(1);
        /* Override properties automatically set in DBLoader constructor */
        mockProperties();

        dbLoader.load();
        List<Athlete> athletes = dbLoader.getAthletes();
        assertEquals("Second Name", athletes.get(1).getName());
        assertEquals("Third Name", athletes.get(2).getName());
        assertEquals("Fourth Name", athletes.get(3).getName());
    }

    @Test
    public void resultsLoadedForCorrectCompetition() throws SQLException {

        /* 1 competition */
        DBLoader dbLoader = new DBLoader(1);
        /* Override properties automatically set in DBLoader constructor */
        mockProperties();

        dbLoader.load();
        assertEquals(5, dbLoader.getAthletes().size());

        /* 2 competition */
        dbLoader = new DBLoader(2);
        /* Override properties automatically set in DBLoader constructor */
        mockProperties();

        dbLoader.load();
        assertEquals(2, dbLoader.getAthletes().size());

    }

    private void mockProperties() {
        System.setProperty(DBLoader.URL_KEY, MOCK_URL);
        System.setProperty(DBLoader.USER_KEY, MOCK_USER);
        System.setProperty(DBLoader.PASSWORD_KEY, MOCK_PASSWORD);
    }


    private static void createVirtualDb() throws SQLException {
        /* Create virtual DB */
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MOCK_URL, MOCK_USER, MOCK_PASSWORD);
            Statement stmt = conn.createStatement();

            /*####### R E S U L T S  #######*/
            stmt.execute("create table results (id integer, athlete_id integer, competition_id integer, " +
                    "race_100m float, long_jump float, shot_put float, high_jump float, race_400m float, " +
                    "hurdles_110m float, discus_throw float, pole_vault float, javelin_throw float, race_1500m float)");
            /* Competition #1 */
            stmt.execute("insert into results values (1, 1, 1, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
            stmt.execute("insert into results values (2, 2, 1, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
            stmt.execute("insert into results values (3, 3, 1, 10.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
            stmt.execute("insert into results values (4, 4, 1, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
            stmt.execute("insert into results values (5, 5, 1, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
            /* Competition #2 */
            stmt.execute("insert into results values (6, 1, 2, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");
            stmt.execute("insert into results values (7, 2, 2, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");

            /*####### A T H L E T E S  #######*/
            stmt.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
            stmt.execute("insert into athletes values (1, 'First Name', '1999-01-01', 'EE')");
            stmt.execute("insert into athletes values (2, 'Second Name', '1999-02-02', 'ZA')");
            stmt.execute("insert into athletes values (3, 'Third Name', '1999-03-03', 'HU')");
            stmt.execute("insert into athletes values (4, 'Fourth Name', '1999-04-04', 'JP')");
            stmt.execute("insert into athletes values (5, 'Fifth Name', '1999-05-05', 'LV')");

            /*####### C O M P E T I T I O N S  #######*/
            stmt.execute("create table competitions (id integer, name varchar)");
            stmt.execute("insert into competitions values (1, 'Training')");
            stmt.execute("insert into competitions values (2, 'DECATHLON4BEER')");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

}
