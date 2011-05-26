package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.Decathlon;
import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.io.TestDB;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class DbDataCollectorTest {

    @Before
    public void setUp() throws Exception {
        Decathlon.initLogger();
        TestDB.prepare();
    }

    @Test
    public void testLoadCompetitionResults() throws Exception {

        DataCollector collector = new DbDataCollector() {
            @Override
            public void setConnection(Connection c) throws SQLException {
                connection = TestDB.openConnection();
            }
        };

        List<Athlete> athletes = collector.loadCompetitionResults("1");

        assertEquals(1, athletes.size());
        Athlete athlete = athletes.get(0);
        assertEquals("Jaak Tepandi", athlete.getName());
        assertEquals(InputParser.parseDate("01.01.1976"), athlete.getDateBirth());
        assertEquals("EE", athlete.getCountry());
        assertEquals(10, athlete.getResults().size());

    }
}
