package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.util.InputParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Jaroslav Judin
 */
public class ConsoleDataCollectorTest {
    @Test
    public void testLoadCompetitionResults() throws Exception {
        ConsoleDataCollector collector = new ConsoleDataCollector();
        collector.setConsole(getMockConsole());

        List<Athlete> athletes = collector.loadCompetitionResults(null);
        assertEquals(1, athletes.size());

        Athlete athlete = athletes.get(0);

        assertEquals("Jaak Tepandi", athlete.getName());
        assertEquals("EE", athlete.getCountry());
        assertEquals(InputParser.parseDate("10.01.1976"), athlete.getDateBirth());
    }

    private ConsoleInput getMockConsole() throws IOException {
        ConsoleInput console = new ConsoleInput();
        BufferedReader reader = mock(BufferedReader.class);
        console.console = reader;

        when(reader.readLine())
                .thenReturn("Jaak Tepandi")
                .thenReturn("10.01.1976")
                .thenReturn("EE")
                .thenReturn("12.61")
                .thenReturn("5")
                .thenReturn("9.22")
                .thenReturn("1.5")
                .thenReturn("59.39")
                .thenReturn("16.43")
                .thenReturn("21.6")
                .thenReturn("2.6")
                .thenReturn("35.81")
                .thenReturn("325.72")
                .thenReturn("yes");
        return console;
    }
}
