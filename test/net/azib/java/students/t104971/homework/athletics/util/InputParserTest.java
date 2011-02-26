package net.azib.java.students.t104971.homework.athletics.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static net.azib.java.students.t104971.homework.athletics.util.InputParser.*;

/**
 * @author Jaroslav Judin
 */
public class InputParserTest {
    @Test
    public void testParseResult() throws Exception {
        assertEquals(105.11, parseResult("1:45.11"));
        assertEquals(0.0, parseResult("1:1:45.11"));

        assertEquals(65.01, parseResult("65.01"));
        assertEquals(0.0, parseResult("65.01.01"));
    }

    @Test
    public void testParseName() throws Exception {
        assertEquals("John Taylor", parseName("John Taylor"));
        assertNull(parseName("Taylor"));
        assertNull(parseName("John"));
        assertNull(parseName("T J"));
    }

    @Test
    public void testParseDate() throws Exception {
        String strDate = "01.12.1965";
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(strDate);
        assertEquals(date, parseDate(strDate));
        assertNull(parseDate("41.01.2000"));
        assertNull(parseDate("2000.01.01"));
    }

    @Test
    public void testParseCountry() throws Exception {
        assertEquals("UK", parseCountry("UK"));
        assertEquals("EE", parseCountry("EE"));
        assertNull(parseCountry("ee"));
        assertNull(parseCountry("EST"));
        assertNull(parseCountry("Estonia"));
    }
}
