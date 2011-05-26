package net.azib.java.students.t104971.homework.athletics.io;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.io.output.CSVWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.ConsoleWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.HTMLWriter;
import net.azib.java.students.t104971.homework.athletics.io.output.xml.XMLWriter;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

/**
 * @author Jaroslav Judin
 */
public class OutputTypeTest {

    @Test
    public void testGetWriter() {
        PropertiesLoader.setProperties();
        ArrayList<Athlete> athletes = new ArrayList<Athlete>();

        assertTrue(OutputType.CONSOLE.getWriter(athletes) instanceof ConsoleWriter);
        assertTrue(OutputType.CSV.getWriter(athletes) instanceof CSVWriter);
        assertTrue(OutputType.XML.getWriter(athletes) instanceof XMLWriter);
        assertTrue(OutputType.HTML.getWriter(athletes) instanceof HTMLWriter);
    }

}
