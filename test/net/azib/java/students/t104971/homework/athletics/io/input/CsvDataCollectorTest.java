package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static net.azib.java.students.t104971.homework.athletics.util.InputParser.parseDate;

/**
 * @author Jaroslav Judin
 */
public class CsvDataCollectorTest {
    @Test
    public void testLoadCompetitionResults() throws Exception {
        PropertiesLoader.setProperties();

        DataCollector collector = new CsvDataCollector();

        List<Athlete> athletes = collector.loadCompetitionResults(PropertiesLoader.getCSVFile().getAbsolutePath());

        assertEquals(4, athletes.size());

        Athlete athlete = athletes.get(1);

        assertEquals("\"Beata Kana\"", athlete.getName());
        assertEquals("ZA", athlete.getCountry());
        assertEquals(10, athlete.getResults().size());
        assertEquals(parseDate("29.02.1982"), athlete.getDateBirth());
    }

    @Test
    public void testGetAthlete() throws Exception {

    }
}
