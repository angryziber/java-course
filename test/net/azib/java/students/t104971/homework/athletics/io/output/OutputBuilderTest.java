package net.azib.java.students.t104971.homework.athletics.io.output;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.io.SourceType;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.HTMLWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.XMLWriter;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * @author Jaroslav Judin
 */
public class OutputBuilderTest {

    @Test
    public void testGetWriter() throws Exception {
        PropertiesLoader.setProperties();
        OutputBuilder builder = new OutputBuilder(null);
        assertTrue(builder.getWriter(SourceType.CONSOLE) instanceof ConsoleWriter);
        assertTrue(builder.getWriter(SourceType.XML) instanceof XMLWriter);
        assertTrue(builder.getWriter(SourceType.HTML) instanceof HTMLWriter);
        assertTrue(builder.getWriter(SourceType.CSV) instanceof CSVWriter);
        assertNull(builder.getWriter(SourceType.DB));
    }
}
