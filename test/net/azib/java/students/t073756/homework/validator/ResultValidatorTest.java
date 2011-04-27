package net.azib.java.students.t073756.homework.validator;

import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static net.azib.java.students.t073756.homework.validator.ResultValidator.*;

/**
 * User: anton
 * Date: 4/2/11
 * Time: 7:03 PM
 */
public class ResultValidatorTest {
    @Test
    public void testSimpleResultValidator() throws Exception {
        assertTrue(SIMPLE_RESULT_VALIDATOR.validate("1.11"));
        assertTrue(SIMPLE_RESULT_VALIDATOR.validate("11.11"));
        assertTrue(SIMPLE_RESULT_VALIDATOR.validate("111.11"));
        assertTrue(SIMPLE_RESULT_VALIDATOR.validate("111.1"));
        assertFalse(SIMPLE_RESULT_VALIDATOR.validate("111.111"));
        assertFalse(SIMPLE_RESULT_VALIDATOR.validate("I.11"));
        assertFalse(SIMPLE_RESULT_VALIDATOR.validate("."));
        assertFalse(SIMPLE_RESULT_VALIDATOR.validate("1.11.11"));
        assertFalse(SIMPLE_RESULT_VALIDATOR.validate("1:11.11"));
    }

    @Test
    public void testTimeResultValidator() throws Exception {
        assertTrue(TIME_RESULT_VALIDATOR.validate("1:10.15"));
        assertTrue(TIME_RESULT_VALIDATOR.validate("11:10.15"));
        assertTrue(TIME_RESULT_VALIDATOR.validate("59.15"));
        assertFalse(TIME_RESULT_VALIDATOR.validate("1:11.111"));
        assertFalse(TIME_RESULT_VALIDATOR.validate("I:11.111"));
    }

    @Test
    public void testNameValidator() throws Exception {
        assertTrue(NAME_VALIDATOR.validate("Siim Susi"));
        assertTrue(NAME_VALIDATOR.validate("José Mañana Perez"));
        assertTrue(NAME_VALIDATOR.validate("\"Пупкин (Василий)\""));
        assertFalse(NAME_VALIDATOR.validate("123 876"));
        assertFalse(NAME_VALIDATOR.validate("asd213"));
    }

    @Test
    public void testBirthdayValidator() throws Exception {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertTrue(BIRTHDAY_VALIDATOR.validate("01.10." + (currentYear - 130)));
        assertTrue(BIRTHDAY_VALIDATOR.validate("01.10." + (currentYear - 5)));
        assertFalse(BIRTHDAY_VALIDATOR.validate("01.10." + (currentYear - 4)));
        assertFalse(BIRTHDAY_VALIDATOR.validate("01.10." + (currentYear - 131)));
        assertFalse(BIRTHDAY_VALIDATOR.validate("01.10.15"));
    }

    @Test
    public void testISO2Validator() throws Exception {
        assertTrue(ISO2_COUNTRY_VALIDATOR.validate("EE"));
        assertTrue(ISO2_COUNTRY_VALIDATOR.validate("ZZ"));
        assertTrue(ISO2_COUNTRY_VALIDATOR.validate("AA"));
        assertFalse(ISO2_COUNTRY_VALIDATOR.validate("00"));
        assertFalse(ISO2_COUNTRY_VALIDATOR.validate("A1"));
        assertFalse(ISO2_COUNTRY_VALIDATOR.validate("EST"));
        assertFalse(ISO2_COUNTRY_VALIDATOR.validate(""));
        assertFalse(ISO2_COUNTRY_VALIDATOR.validate("ee"));
    }
}
