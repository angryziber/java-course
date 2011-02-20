package net.azib.java.students.t104971.homework.athletics.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jaroslav Judin
 */
public class InputParametersValidator {

    public String inputMethod;
    public String inputParameter;
    public String outputMethod;
    public String outputParameter;

    public void validate(String... args) throws UserInputException {
        List<String> allowedInputMethods = Arrays.asList("-console", "-csv", "-db");
        List<String> allowedOutputMethods = Arrays.asList("-console", "-csv", "-xml", "-html");

        if (args.length < 2) {
            throw new UserInputException("Please, specify input(" + allowedInputMethods + ") and output(" + allowedOutputMethods + ") methods");
        }

        inputMethod = args[0];
        if (!allowedInputMethods.contains(inputMethod)) {
            throw new UserInputException(inputMethod + " input method doesn't exist");
        }

        if ("-console".equals(inputMethod)) {
            outputMethod = args[1];
        } else if (args.length < 3) {
            throw new UserInputException("Output method doesn't specified");
        } else {
            inputParameter = args[1];
            outputMethod = args[2];
        }
        if (!allowedOutputMethods.contains(outputMethod)) {
            throw new UserInputException(outputMethod + " output method doesn't exist");
        }

        if (!"-console".equals(inputMethod)) {
            if (args.length < 4) {
                throw new UserInputException("Output parameter doesn't specified for " + inputMethod);
            }
            outputParameter = args[3];
        }

    }

}
