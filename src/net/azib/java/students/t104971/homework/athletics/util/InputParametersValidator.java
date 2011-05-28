package net.azib.java.students.t104971.homework.athletics.util;

import net.azib.java.students.t104971.homework.athletics.io.OutputType;
import net.azib.java.students.t104971.homework.athletics.io.SourceType;
import org.apache.log4j.Logger;

/**
 * @author Jaroslav Judin
 */
public class InputParametersValidator {

    private SourceType source;
    private OutputType result;
    private String sourceValue;
    private String resultValue;

    public boolean isValid(String... args) {
        try {
            validate(args);
        } catch (UserInputException e) {
            Logger.getLogger(getClass()).error(e);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void validate(String... args) throws UserInputException {
        if (args.length < 2) {
            throw new UserInputException("Please, specify input and output methods");
        }

        try {
            source = SourceType.valueOf(getTypeName(args[0]));
            if (source.equals(SourceType.CONSOLE)) {
                result = OutputType.valueOf(getTypeName(args[1]));
                if (!result.equals(OutputType.CONSOLE) && args.length > 2) {
                    resultValue = args[2];
                }
                if (result.equals(OutputType.CONSOLE)) {
                    return;
                }
            }
            sourceValue = args[1];

            if (args.length < 3) {
                throw new UserInputException("Please, specify value for output type");
            }
            result = OutputType.valueOf(getTypeName(args[2]));

            if (!result.equals(OutputType.CONSOLE)) {
                if (args.length > 3) {
                    resultValue = args[3];
                } else {
                    throw new UserInputException("Please, specify value for output type");
                }
            }
        } catch (IllegalArgumentException e) {
            throw new UserInputException("input or output type doesn't exist");
        }
    }

    public SourceType getSource() {
        return source;
    }

    public OutputType getResult() {
        return result;
    }

    public String getSourceValue() {
        return sourceValue;
    }

    public String getResultValue() {
        return resultValue;
    }

    private static String getTypeName(String arg) {
        return arg.toUpperCase().replace("-", "");
    }

}
