package ee.ttu.decathlon.io;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * User: anton
 * Date: 4/1/11
 * Time: 8:12 PM
 */
public class CsvLineTest {

    private CsvProcessor.CsvLine line;

    @Test
    public void shouldParseValuesDefaultSeparator() throws Exception {
        line = new CsvProcessor.CsvLine("csv,formatted,line");
        List<String> values = line.getValues();
        Iterator<String> i = values.iterator();

        assertEquals(3, values.size());
        assertEquals("csv", i.next());
        assertEquals("formatted", i.next());
        assertEquals("line", i.next());
    }

    @Test
    public void shouldIgnoreSymbolsOtherThanSeparator() throws Exception {
        line = new CsvProcessor.CsvLine("csv'@#!^:;,formatted ,line");
        List<String> values = line.getValues();
        Iterator<String> i = values.iterator();

        assertEquals(3, values.size());
        assertEquals("csv'@#!^:;", i.next());
        assertEquals("formatted ", i.next());
        assertEquals("line", i.next());
    }
}
