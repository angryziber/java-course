package net.azib.java.students.t073756.homework.validator;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * User: anton
 * Date: 4/19/11
 * Time: 9:30 PM
 */
public class CommandLineArgumentValidatorTest {

    @Test
    public void testCompetitionId() throws Exception {
        assertTrue(CommandLineArgumentValidator.COMPETITION_ID.validate("1"));
        assertTrue(CommandLineArgumentValidator.COMPETITION_ID.validate("12"));
        assertTrue(CommandLineArgumentValidator.COMPETITION_ID.validate("12222222"));
        assertFalse(CommandLineArgumentValidator.COMPETITION_ID.validate("-10"));
        assertFalse(CommandLineArgumentValidator.COMPETITION_ID.validate("asd"));
        assertFalse(CommandLineArgumentValidator.COMPETITION_ID.validate(""));
    }
}
