package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.io.SourceType;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static net.azib.java.students.t104971.homework.athletics.io.input.DataCollectorBuilder.getCollector;

/**
 * @author Jaroslav Judin
 */
public class DataCollectorBuilderTest {

    @Test
    public void testGetCollector() throws Exception {
        assertTrue(getCollector(SourceType.CONSOLE) instanceof ConsoleDataCollector);
        assertTrue(getCollector(SourceType.DB) instanceof DbDataCollector);
        assertTrue(getCollector(SourceType.CSV) instanceof CsvDataCollector);
        assertNull(getCollector(SourceType.XML));
        assertNull(getCollector(SourceType.HTML));
    }
}
