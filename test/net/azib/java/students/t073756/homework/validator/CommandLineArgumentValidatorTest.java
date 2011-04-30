package net.azib.java.students.t073756.homework.validator;

import org.junit.Test;

import java.io.File;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static net.azib.java.students.t073756.homework.validator.CommandLineArgumentValidator.COMPETITION_ID;
import static net.azib.java.students.t073756.homework.validator.CommandLineArgumentValidator.FILE_PATH;

/**
 * User: anton
 * Date: 4/19/11
 * Time: 9:30 PM
 */
public class CommandLineArgumentValidatorTest {

    @Test
    public void testCompetitionId() throws Exception {
        assertTrue(COMPETITION_ID.validate("1"));
        assertTrue(COMPETITION_ID.validate("12"));
        assertTrue(COMPETITION_ID.validate("12222222"));
        assertFalse(COMPETITION_ID.validate("-10"));
        assertFalse(COMPETITION_ID.validate("asd"));
        assertFalse(COMPETITION_ID.validate(""));
    }

    @Test
    public void testFilePath() throws Exception {
        String separator = File.separator;
        assertTrue(FILE_PATH.validate("csv" + separator + "csv.txt"));
        assertTrue(FILE_PATH.validate("C:" + separator + "dev" + separator + "csv.txt"));
        assertTrue(FILE_PATH.validate("C:" + separator + separator + "dev" + separator + "csv.txt"));
        assertFalse(FILE_PATH.validate("C:" + separator + separator + "dev" + separator + "csv.txt" + separator));
    }
}
