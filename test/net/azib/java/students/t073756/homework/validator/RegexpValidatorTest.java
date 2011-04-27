package net.azib.java.students.t073756.homework.validator;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * User: anton
 * Date: 4/19/11
 * Time: 9:26 PM
 */
public class RegexpValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(RegexpValidator.validate("tdd", "tdd"));
        assertTrue(RegexpValidator.validate("tdd", "t.d"));
        assertFalse(RegexpValidator.validate("bdd", "a.d"));
        assertTrue(RegexpValidator.validate("bdd", ".*"));
        assertTrue(RegexpValidator.validate("", ".*"));
    }
}
