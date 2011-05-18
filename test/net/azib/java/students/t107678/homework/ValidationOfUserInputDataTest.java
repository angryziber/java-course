package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationOfUserInputDataTest {


    @Test @Ignore
    public void testValidateName() throws Exception {


    }

    @Test
    public void testValidateBirthDate() throws Exception {
        String input1 = "15.05.1988";

        assertEquals(true,ValidationOfUserInputData.validateBirthDate(input1));


    }

    @Test
    public void testValidateCountryCode() throws Exception {
        String input1 = "me";
        String input2 = "mne";
        String input3 = "ee";
        String input4 = "EESTI";
        String input5 = "e";

        assertEquals(true, ValidationOfUserInputData.validateCountryCode(input1));
        assertEquals(false, ValidationOfUserInputData.validateCountryCode(input2));
        assertEquals(true, ValidationOfUserInputData.validateCountryCode(input3));
        assertEquals(false, ValidationOfUserInputData.validateCountryCode(input4));
        assertEquals(false, ValidationOfUserInputData.validateCountryCode(input5));
    }

    @Test
    public void testValidateMetersOrSecondsEvent() throws Exception {
        String input1 = "12.32";
        String input2 = "12";
        String input3 = "0.32";
        String input4 = "00.32";
        String input5 = "10:32";
        String input6 = "10.32 ";

        assertEquals(true, ValidationOfUserInputData.validateMetersOrSecondsEvent(input1));
        assertEquals(true, ValidationOfUserInputData.validateMetersOrSecondsEvent(input2));
        assertEquals(true, ValidationOfUserInputData.validateMetersOrSecondsEvent(input3));
        assertEquals(true, ValidationOfUserInputData.validateMetersOrSecondsEvent(input4));
        assertEquals(false, ValidationOfUserInputData.validateMetersOrSecondsEvent(input5));
        assertEquals(false, ValidationOfUserInputData.validateMetersOrSecondsEvent(input6));

    }

    @Test
    public void testValidateMinColonSecEvent() throws Exception {
        String input1 = "12:32";
        String input2 = "12.32";
        String input3 = "12:32:32";
        String input4 = "00:32.01";
        String input5 = "0:32";
        String input6 = "0:32.0 ";     //space will not be allowed !

        assertEquals(true,ValidationOfUserInputData.validateMinColonSecEvent(input1));
        assertEquals(false,ValidationOfUserInputData.validateMinColonSecEvent(input2));
        assertEquals(false,ValidationOfUserInputData.validateMinColonSecEvent(input3));
        assertEquals(true,ValidationOfUserInputData.validateMinColonSecEvent(input4));
        assertEquals(true,ValidationOfUserInputData.validateMinColonSecEvent(input5));
        assertEquals(false,ValidationOfUserInputData.validateMinColonSecEvent(input6));


    }
}
