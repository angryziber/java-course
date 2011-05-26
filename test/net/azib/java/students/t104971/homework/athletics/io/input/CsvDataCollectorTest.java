package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static net.azib.java.students.t104971.homework.athletics.util.InputParser.parseDate;

/**
 * @author Jaroslav Judin
 */
public class CsvDataCollectorTest {

    @Before
    public void setUp() throws Exception {
        PropertiesLoader.setProperties();
        PropertyConfigurator.configure(System.getProperties());
    }

    @Test
    public void testLoadCompetitionResults() throws Exception {

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
    public void testLoadCompetitionResultsNoSuchFile() throws Exception {
        DataCollector collector = new CsvDataCollector();
        List<Athlete> athletes = collector.loadCompetitionResults("noFile");
        assertEquals(0, athletes.size());

    }

    @Test
    public void testGetAthlete() throws Exception {
        Athlete athlete = new CsvDataCollector().getAthlete("\"Siim Susi\",01.01.1976,EE,12a.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
        assertEquals(0.0, athlete.getResults().get(0).getResult());
    }
}
