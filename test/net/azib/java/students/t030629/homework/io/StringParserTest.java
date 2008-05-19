package net.azib.java.students.t030629.homework.io;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;
import java.io.IOException;

import static junit.framework.Assert.*;
import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 11:17:48
 */
public class StringParserTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void testNameParsing() throws ParseException {
        String name1 = "\"Siim Susi\"";
        String name2 = "\"Sz?r?s Sz?k\"";
        String parsedName1 = "Siim Susi";
        String parsedName2 = "Sz?r?s Sz?k";
        assertEquals(parsedName1, StringParser.parseName(name1));
        assertEquals(parsedName2, StringParser.parseName(name2));
    }

    @Test
    public void testBirthdayParsing() throws ParseException {
        String dateAsString = "29.02.2008";
        Date date = StringParser.parseBirthday(dateAsString);
        assertEquals(dateAsString, new SimpleDateFormat(System.getProperty(DecathlonCalculator.DATE_PATTERN)).format(date));
    }

    @Test
    public void testDecimalResultParsing() throws IOException {
        String resultAsString = "12.61";
        BigDecimal result = new BigDecimal(resultAsString);
        assertEquals(result, StringParser.parseResult(DecathlonEvent.SPRINT_100M, resultAsString));
    }

    @Test
    public void testTimeResultParsing() throws IOException {
        String resultAsString1 = "59.39";
        String resultAsString2 = "6:51.01";
        BigDecimal result1 = new BigDecimal("59.39");
        BigDecimal result2 = new BigDecimal("411.01");
        assertEquals(result1, StringParser.parseResult(DecathlonEvent.SPRINT_400M, resultAsString1));
        assertEquals(result2, StringParser.parseResult(DecathlonEvent.RACE_1500M, resultAsString2));
    }



}
