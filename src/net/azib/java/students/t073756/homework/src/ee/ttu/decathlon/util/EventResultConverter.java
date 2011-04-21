package ee.ttu.decathlon.util;

import ee.ttu.decathlon.DecathlonException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static ee.ttu.decathlon.validator.ResultValidator.SIMPLE_RESULT_VALIDATOR;
import static ee.ttu.decathlon.validator.ResultValidator.TIME_RESULT_VALIDATOR;

public class EventResultConverter {

    /**
     * Method converts given result in any running event to athlete result in seconds.
     *
     * @param result - Athlete result in any running event
     * @return - time in seconds
     */
    public static double convertRunningResults(String result) {
        if (SIMPLE_RESULT_VALIDATOR.validate(result)) {
            return Double.parseDouble(result);
        } else if (TIME_RESULT_VALIDATOR.validate(result)) {
            List<Integer> time = splitResult(result);
            return (time.get(0) * 60) + (time.get(1) + (time.get(2) * 0.01));
        } else {
            throw new DecathlonException("Wrong format for running event, input string: " + result);
        }
    }

    /**
     * Method converts given result in any jumping event , to athlete result in centimeters.
     *
     * @param result - Athlete result in any jumping event
     * @return - result in centimeters
     */
    public static double convertJumpingResults(String result) {
        return new BigDecimal(result).setScale(2).unscaledValue().doubleValue();
    }

    /**
     * Method split the given result string to tokens with "." or ":" delimiter
     *
     * @param result - Athlete result in any event
     * @return - Array of integers
     */
    static List<Integer> splitResult(String result) {
        List<Integer> fractions = new ArrayList<Integer>();

        for (String token : result.split("(:)|(\\.)")) {
            fractions.add(Integer.valueOf(token));
        }

        return fractions;
    }
}
