package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidationOfUserInputDataTest {


    @Test
    public void testValidateName() throws Exception {
        String name1 = "Radomir Sebek";
        //String name2 = "2";

        assertTrue(ValidationOfUserInputData.validateName(name1));


    }

    @Test
    public void validateCorrectBirthDate() throws Exception {
        String input1 = "15.05.1988";
        assertTrue(ValidationOfUserInputData.validateBirthDate(input1));


    }

    @Test
    public void validateIncorrectBirthDate() throws Exception {

        String input2 = "35.05.1988";

        //assertFalse(ValidationOfUserInputData.validateBirthDate(input2));


    }

    @Test
    public void validateCorrectCountryCode() throws Exception {
        String input1 = "me";
        String input3 = "ee";

        assertTrue(ValidationOfUserInputData.validateCountryCode(input1));
        assertTrue(ValidationOfUserInputData.validateCountryCode(input3));


    }

    @Test
    public void validateIncorrectCountryCode() throws Exception {
        String input2 = "mne";
        String input4 = "EESTI";
        String input5 = "e";

        assertFalse(ValidationOfUserInputData.validateCountryCode(input2));
        assertFalse(ValidationOfUserInputData.validateCountryCode(input4));
        assertFalse(ValidationOfUserInputData.validateCountryCode(input5));
    }

    @Test
    public void validateCorrectMetersOrSecondsEvent() throws Exception {
        String input1 = "12.32";
        String input2 = "12";
        String input4 = "00.32";

        assertTrue(ValidationOfUserInputData.validateMetersOrSecondsEvent(input1));
        assertTrue(ValidationOfUserInputData.validateMetersOrSecondsEvent(input2));
        assertTrue(ValidationOfUserInputData.validateMetersOrSecondsEvent(input4));


    }

    @Test
    public void validateIncorrectMetersOrSecondsEvent() throws Exception {
        String input3 = "0. 32";
        String input5 = "10:32";
        String input6 = "10.32 ";
        assertFalse(ValidationOfUserInputData.validateMetersOrSecondsEvent(input3));
        assertFalse(ValidationOfUserInputData.validateMetersOrSecondsEvent(input5));
        assertFalse(ValidationOfUserInputData.validateMetersOrSecondsEvent(input6));

    }

    @Test
    public void validateCorrectMinColonSecEvent() throws Exception {
        String input1 = "12:32";
        String input4 = "00:32.01";
        String input5 = "0:32";

        assertTrue(ValidationOfUserInputData.validateMinColonSecEvent(input1));
        assertTrue(ValidationOfUserInputData.validateMinColonSecEvent(input4));
        assertTrue(ValidationOfUserInputData.validateMinColonSecEvent(input5));


    }

    @Test
    public void validateIncorrectMinColonSecEvent() throws Exception {

        String input2 = "12.32";
        String input3 = "12:32:32";
        String input5 = "0: 32";

        assertFalse(ValidationOfUserInputData.validateMinColonSecEvent(input2));
        assertFalse(ValidationOfUserInputData.validateMinColonSecEvent(input3));
        assertFalse(ValidationOfUserInputData.validateMinColonSecEvent(input5));


    }
}
