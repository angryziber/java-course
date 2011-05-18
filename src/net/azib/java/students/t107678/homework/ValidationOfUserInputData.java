package net.azib.java.students.t107678.homework;

import java.util.regex.Pattern;

public class ValidationOfUserInputData {

    private static final Pattern COUNTRY = Pattern.compile("[a-zA-z]{2}");
    private static final Pattern MetersOrSeconds1 = Pattern.compile("\\d+\\.\\d+");
    private static final Pattern MetersOrSeconds2 = Pattern.compile("\\d+");
    private static final Pattern MinColonSec1 = Pattern.compile("\\d+:\\d+\\.\\d+");
    private static final Pattern MinColonSec2 = Pattern.compile("\\d+:\\d+");

    public boolean validateName() {
        return true;
    }

    public boolean validateBirthDate() {
        return true;
    }

    public boolean validateCountryCode(String inputValue) {

        if (COUNTRY.matcher(inputValue).matches()) {
            return true;
        }
        return false;

    }

    public boolean validateMetersOrSecondsEvent(String inputValue) {
        if(MetersOrSeconds1.matcher(inputValue).matches() | MetersOrSeconds2.matcher(inputValue).matches()){
            return true;
        }

        return false;
    }

    public boolean validateMinColonSecEvent(String inputValue) {
        if(MinColonSec1.matcher(inputValue).matches() | MinColonSec2.matcher(inputValue).matches()){
            return true;
        }

        return false;
    }
}
