package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationOfUserInputDataTest {

    ValidationOfUserInputData validationOfUserInputData = new ValidationOfUserInputData();

    @Test
    @Ignore
    public void testValidateName() throws Exception {

    }

    @Test
    @Ignore
    public void testValidateBirthDate() throws Exception {

    }

    @Test
    public void testValidateCountryCode() throws Exception {
        String input1 = "me";
        String input2 = "mne";
        String input3 = "ee";
        String input4 = "EESTI";
        String input5 = "e";

        assertEquals(true, validationOfUserInputData.validateCountryCode(input1));
        assertEquals(false, validationOfUserInputData.validateCountryCode(input2));
        assertEquals(true, validationOfUserInputData.validateCountryCode(input3));
        assertEquals(false, validationOfUserInputData.validateCountryCode(input4));
        assertEquals(false, validationOfUserInputData.validateCountryCode(input5));
    }

    @Test
    public void testValidateMetersOrSecondsEvent() throws Exception {
        String input1 = "12.32";
        String input2 = "12";
        String input3 = "0.32";
        String input4 = "00.32";
        String input5 = "10:32";
        String input6 = "10.32 ";

        assertEquals(true, validationOfUserInputData.validateMetersOrSecondsEvent(input1));
        assertEquals(true, validationOfUserInputData.validateMetersOrSecondsEvent(input2));
        assertEquals(true, validationOfUserInputData.validateMetersOrSecondsEvent(input3));
        assertEquals(true, validationOfUserInputData.validateMetersOrSecondsEvent(input4));
        assertEquals(false, validationOfUserInputData.validateMetersOrSecondsEvent(input5));
        assertEquals(false, validationOfUserInputData.validateMetersOrSecondsEvent(input6));

    }

    @Test
    public void testValidateMinColonSecEvent() throws Exception {
        String input1 = "12:32";
        String input2 = "12.32";
        String input3 = "12:32:32";
        String input4 = "00:32.01";
        String input5 = "0:32";
        String input6 = "0:32.0 ";     //space will not be allowed !

        assertEquals(true,validationOfUserInputData.validateMinColonSecEvent(input1));
        assertEquals(false,validationOfUserInputData.validateMinColonSecEvent(input2));
        assertEquals(false,validationOfUserInputData.validateMinColonSecEvent(input3));
        assertEquals(true,validationOfUserInputData.validateMinColonSecEvent(input4));
        assertEquals(true,validationOfUserInputData.validateMinColonSecEvent(input5));
        assertEquals(false,validationOfUserInputData.validateMinColonSecEvent(input6));


    }
}
