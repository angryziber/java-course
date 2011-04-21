package ee.ttu.decathlon.validator;

import ee.ttu.decathlon.DecathlonException;
import ee.ttu.decathlon.io.CsvProcessor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static ee.ttu.decathlon.validator.ResultValidator.*;

/**
 * User: anton
 * Date: 4/19/11
 * Time: 8:56 PM
 */
public class CsvLineValidator implements Validator<CsvProcessor.CsvLine> {

    private List<ResultValidator> validators = Arrays.asList(NAME_VALIDATOR, BIRTHDAY_VALIDATOR, ISO2_COUNTRY_VALIDATOR,
            SIMPLE_RESULT_VALIDATOR, SIMPLE_RESULT_VALIDATOR, SIMPLE_RESULT_VALIDATOR, SIMPLE_RESULT_VALIDATOR,
            TIME_RESULT_VALIDATOR, SIMPLE_RESULT_VALIDATOR, SIMPLE_RESULT_VALIDATOR, SIMPLE_RESULT_VALIDATOR,
            SIMPLE_RESULT_VALIDATOR, TIME_RESULT_VALIDATOR);

    /**
     * Composite check of CSV line using other Validators.
     * Throws exception in case line contains errors.
     *
     * @param input - CsvLine which needs validation.
     * @return - true if line is valid.
     */
    public boolean validate(CsvProcessor.CsvLine input) {
        List<String> tokens = input.getValues();
        if (tokens.size() != validators.size()) {
            throw new DecathlonException("Wrong csv line length: " + input.toString());
        }

        Iterator<String> i = tokens.iterator();
        for (ResultValidator validator : validators) {
            String value = i.next();
            if (!validator.validate(value)) {
                throw new DecathlonException("Wrong value: " + value + " in csv line " + input.toString());
            }
        }

        return true;
    }
}
