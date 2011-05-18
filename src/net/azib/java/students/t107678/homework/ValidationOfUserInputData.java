package net.azib.java.students.t107678.homework;

import java.util.regex.Pattern;

/** Central logic for validation of user input from various sources
 *
 */
public class ValidationOfUserInputData {

    private static final Pattern NAME = Pattern.compile("[a-zA-Z]");   //TODO implement name regex
    private static final Pattern COUNTRY = Pattern.compile("[a-zA-Z]{2}");
    private static final Pattern DOB = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");  //TODO need better regex here
    private static final Pattern MetersOrSeconds1 = Pattern.compile("\\d+\\.\\d+");
    private static final Pattern MetersOrSeconds2 = Pattern.compile("\\d+");
    private static final Pattern MinColonSec1 = Pattern.compile("\\d+:\\d+\\.\\d+");
    private static final Pattern MinColonSec2 = Pattern.compile("\\d+:\\d+");

    /**
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateName(String inputValue) {  //TODO enable commented code
//        if(NAME.matcher(inputValue).matches() ){
//            return true;
//        }
//
//        return false;
        return true;
    }

    /**
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateBirthDate(String inputValue) {
        if(DOB.matcher(inputValue).matches()){
            return true;
        }
        return false;

    }

    /**
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateCountryCode(String inputValue) {

        if (COUNTRY.matcher(inputValue).matches()) {
            return true;
        }
        return false;

    }

    /**
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateMetersOrSecondsEvent(String inputValue) {
        if(MetersOrSeconds1.matcher(inputValue).matches() | MetersOrSeconds2.matcher(inputValue).matches()){
            return true;
        }

        return false;
    }

    /**
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateMinColonSecEvent(String inputValue) {
        if(MinColonSec1.matcher(inputValue).matches() | MinColonSec2.matcher(inputValue).matches()){
            return true;
        }

        return false;
    }
}
