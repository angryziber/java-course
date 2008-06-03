package net.azib.java.students.t030629.homework.io;

import java.io.File;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Class for storing input arguments of the main program as correct underlying objects.
 * <p>
 * Contains an inner {@link net.azib.java.students.t030629.homework.io.Arguments.ArgumentParser} class
 * for argument parsing.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 14:22:13
 */
public class Arguments {

    private InputMethod inMethod;
    private File inFile;
    private String competitionName = null;
    private int competitionId;
    private OutputMethod outMethod;
    private File outFile;

    /**
     * Constructor that parses the specified arguments.
     * @param args an array of main program arguments
     */
    public Arguments(String... args) {
        new ArgumentParser(args).parse();
    }

    /**
     * @return <code>true</code> if the name of the competition in Database is set.
     * <code>false</code> otherwise.
     */
    public boolean isCompetitionNameSet() {
        return competitionName != null;
    }

    /* Getters */

    /**
     * @return input source (method)
     */
    public InputMethod getInMethod() {
        return inMethod;
    }
    /**
     * @return input file
     */
    public File getInFile() {
        return inFile;
    }
    /**
     * @return name of the competition in Database
     */
    public String getCompetitionName() {
        return competitionName;
    }
    /**
     * @return id of the competition in Database
     */
    public int getCompetitionId() {
        return competitionId;
    }
    /**
     * @return output destination (method)
     */
    public OutputMethod getOutMethod() {
        return outMethod;
    }
    /**
     * @return output file
     */
    public File getOutFile() {
        return outFile;
    }

    /**
     * Parser for input parameters.
     * Checks for correct number of arguments specified in the task.
     * Checks for validity of parameters (Input/OutputMethods checked only)
     * and encapsulates parameters into corresponding objects.
     *
     * <br><br>User: Anton Chepurov
     * <br>Date: 10.05.2008
     * <br>Time: 17:08:24
     */
    public class ArgumentParser {
        private static final String MISSING_INPUT_FILE_TEXT = "Missing input file name or path";
        private static final String MISSING_COMPETITION_ID_TEXT = "Missing competition ID or name";
        private static final String MALFORMED_COMPETITION_ID_TEXT = "Malformed competition ID";
        private static final String MISSING_OUTPUT_FILE_TEXT = "Missing output file name or path";
        private static final String MISSING_ARGUMENTS_TEXT = "Missing arguments";
        private static final String MISSING_OUTPUT_METHOD_TEXT = "Missing output method";
        private static final String INPUT_METHOD_EXPECTED_TEXT = "Input Method expected";
        private static final String OUTPUT_METHOD_EXPECTED_TEXT = "Output Method expected";

        private final String[] args;

        /**
         * Constructor with main program arguments
         * @param args arguments of the main program
         */
        public ArgumentParser(String... args) {
            this.args = args;
        }

        /**
         * Parses the arguments into underlying objects
         */
        public void parse() {
            Iterator<String> argsIterator = Arrays.asList(args).iterator();
            String arg;

            // Parse INPUT METHOD
            parseControlArgument(InputMethod.class, argsIterator);
            // Parse ARGUMENTS for Input Method
            switch (inMethod) {
                case CONSOLE: /* Do nothing */
                    break;
                case CSV:
                    checkMissingArgument(argsIterator, MISSING_INPUT_FILE_TEXT);
                    inFile = new File(argsIterator.next());
                    break;
                case DB:
                    checkMissingArgument(argsIterator, MISSING_COMPETITION_ID_TEXT);
                    arg = argsIterator.next();
                    if (Character.isDigit(arg.charAt(0))) {
                        try {
                            competitionId = Integer.parseInt(arg);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException(MALFORMED_COMPETITION_ID_TEXT);
                        }
                    }
                    else {
                        competitionName = arg;
                    }
            }
            // Parse OUTPUT METHOD
            parseControlArgument(OutputMethod.class, argsIterator);
            // Parse ARGUMENTS for Output Method
            switch (outMethod) {
                case CONSOLE: /* Do nothing */
                    break;
                default:
                    checkMissingArgument(argsIterator, MISSING_OUTPUT_FILE_TEXT);
                    outFile = new File(argsIterator.next());
            }
        }

        private void parseControlArgument(Class methodClass, Iterator<String> argsIterator) {
            checkMissingArgument(argsIterator, methodClass == InputMethod.class ? MISSING_ARGUMENTS_TEXT : MISSING_OUTPUT_METHOD_TEXT);
            String arg = argsIterator.next().toUpperCase();
            if (!arg.startsWith("-"))
                throw new IllegalArgumentException(methodClass == InputMethod.class ? INPUT_METHOD_EXPECTED_TEXT : OUTPUT_METHOD_EXPECTED_TEXT);

            if (methodClass == InputMethod.class) {
                inMethod = InputMethod.valueOf(arg.substring(1));
            } else {
                outMethod = OutputMethod.valueOf(arg.substring(1));
            }

        }

        private void checkMissingArgument(Iterator<String> argsIterator, String errorMessage) {
            if (!argsIterator.hasNext())
                throw new IllegalArgumentException(errorMessage);
        }

    }
}
