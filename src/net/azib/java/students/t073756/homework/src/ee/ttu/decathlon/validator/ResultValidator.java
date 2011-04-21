package ee.ttu.decathlon.validator;

import java.util.Calendar;

/**
 * Static constants generally for regexp validation are presented in this enum.
 * Name are
 */
public enum ResultValidator implements Validator<String> {
    TIME_RESULT_VALIDATOR(TIME_RESULT_PATTERN),
    SIMPLE_RESULT_VALIDATOR(RESULT_PATTERN),
    NAME_VALIDATOR(NAME_PATTERN),
    BIRTHDAY_VALIDATOR(BIRTHDAY_PATTERN) {
        @Override
        public boolean validate(String input) {
            return super.validate(input) && validateYear(input);
        }

        /**
         * Validate if athlete birthday year is in valid range.
         * Assume that there is no athletes younger than ~ 5 years old and older than 130 :)
         * @param date input String for date
         * @return is athlete age in valid range
         */
        private boolean validateYear(String date) {
            int athleteDOBYear = Integer.parseInt(date.split("\\.")[2]);
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            return (currentYear - athleteDOBYear >= 5) && (currentYear - athleteDOBYear <= 130);
        }
    },
    ISO2_COUNTRY_VALIDATOR(ISO2_PATTERN);

    private String pattern;

    ResultValidator(String pattern) {
        this.pattern = pattern;
    }

    public boolean validate(String input) {
        return RegexpValidator.validate(input, pattern);
    }
}
