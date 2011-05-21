package net.azib.java.students.t107678.homework;

import java.util.regex.Pattern;

/** Central logic for validation of user input from various sources
 *
 */
public class ValidationOfUserInputData {

    private static final Pattern NAME = Pattern.compile(".+");   //TODO implement name regex
    private static final Pattern COUNTRY = Pattern.compile("[a-zA-Z]{2}");
    private static final Pattern DOB = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");  //TODO need better regex here
    private static final Pattern MOS1 = Pattern.compile("\\d+\\.\\d+");       //MOS stands for metersOrSeconds
    private static final Pattern MOS2 = Pattern.compile("\\d+");
    private static final Pattern MCS1 = Pattern.compile("\\d+:\\d+\\.\\d+");  //MCS stands for MinutesColonSeconds
    private static final Pattern MCS2 = Pattern.compile("\\d+:\\d+");

    /** Logic for validating a name
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateName(String inputValue) {
        if(NAME.matcher(inputValue).matches() ){
            return true;
        }

        return false;


    }

    /** vLogic for validating a birth date
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateBirthDate(String inputValue) {
//        if(DOB.matcher(inputValue).matches()){
//            return true;
//        }
//        return false;
        return true;

    }

    /** Logic for validating a country code
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

    /** Logic for validating a input of 8 meters or second events
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateMetersOrSecondsEvent(String inputValue) {
        if(MOS1.matcher(inputValue).matches() | MOS2.matcher(inputValue).matches()){
            return true;
        }

        return false;
    }

    /** Logic for validating a 2 minutes colon seconds events
     *
     * @param inputValue user's input value
     * @return true if logically correct
     */
    public static boolean validateMinColonSecEvent(String inputValue) {
        if(MCS1.matcher(inputValue).matches() | MCS2.matcher(inputValue).matches()){
            return true;
        }

        return false;
    }
}
