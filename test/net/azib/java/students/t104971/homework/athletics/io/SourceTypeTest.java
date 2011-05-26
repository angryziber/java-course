package net.azib.java.students.t104971.homework.athletics.io;

import net.azib.java.students.t104971.homework.athletics.io.input.ConsoleDataCollector;
import net.azib.java.students.t104971.homework.athletics.io.input.CsvDataCollector;
import net.azib.java.students.t104971.homework.athletics.io.input.DbDataCollector;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * @author Jaroslav Judin
 */
public class SourceTypeTest {

    @Test
    public void testGetWriter() {
        assertTrue(SourceType.CONSOLE.getCollector() instanceof ConsoleDataCollector);
        assertTrue(SourceType.CSV.getCollector() instanceof CsvDataCollector);
        assertTrue(SourceType.DB.getCollector() instanceof DbDataCollector);
    }
}
