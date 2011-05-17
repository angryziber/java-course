package net.azib.java.students.t107678.homework;


/** Program input arguments provided by user will be checked for logical combination validity
 *
 */
public class ValidationOfProgramArgs {

    static final String warningMessage = "INVALID ATTEMPT! PLEASE CHECK AGAIN PROGRAM INPUT ARGUMENTS AND TRY AGAIN!";


    final static String CONSOLE = "-console";
    final static String CSV = "-csv";
    final static String DB = "-db";
    final static String XML = "-xml";
    final static String HTML = "-html";

    /**
     *
     * @param inputParameters represents a user input
     * @return false is input is not according to specifications, otherwise true
     */
    public boolean validateProgramArguments(String[] inputParameters) {

        int mistakeIndicator = 0;


        if (inputParameters.length < 2) {         // at least two arguments must be specified
            mistakeIndicator++;
        }

        if (inputParameters.length == 2) {        //we have two program arguments
            if (inputParameters[0].trim().compareToIgnoreCase(CONSOLE) != 0 | inputParameters[1].trim().compareToIgnoreCase(CONSOLE) != 0) {
                mistakeIndicator++;
            }
        }

        if (inputParameters.length == 3) {         //we have 3 program arguments

            if (inputParameters[0].trim().compareToIgnoreCase(CONSOLE) == 0) {
                if (inputParameters[1].trim().compareToIgnoreCase(CSV) != 0 & inputParameters[1].trim().compareToIgnoreCase(XML) != 0 & inputParameters[1].trim().compareToIgnoreCase(HTML) != 0) {
                    mistakeIndicator++;
                }

            }
            if (inputParameters[0].trim().compareToIgnoreCase(CSV) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CONSOLE) != 0) {
                    mistakeIndicator++;
                }

            }
            if (inputParameters[0].trim().compareToIgnoreCase(DB) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CONSOLE) != 0) {
                    mistakeIndicator++;
                }

            }
        }

        if (inputParameters.length == 4) {            //we have 4 program arguments

            if (inputParameters[0].trim().compareToIgnoreCase(CONSOLE) == 0) {
                mistakeIndicator++;
            }

            if (inputParameters[0].trim().compareToIgnoreCase(CSV) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CSV) != 0 & inputParameters[2].trim().compareToIgnoreCase(XML) != 0 & inputParameters[2].trim().compareToIgnoreCase(HTML) != 0) {
                    mistakeIndicator++;
                }
            }

            if (inputParameters[0].trim().compareToIgnoreCase(DB) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CSV) != 0 & inputParameters[2].trim().compareToIgnoreCase(XML) != 0 & inputParameters[2].trim().compareToIgnoreCase(HTML) != 0 & inputParameters[2].trim().compareToIgnoreCase(DB) != 0) {
                    mistakeIndicator++;
                }
            }

        }


        if (inputParameters.length > 4) {             // we have more than 4 program arguments, which is not good :)
            mistakeIndicator++;
        }

        if (mistakeIndicator != 0) {
            System.out.println(mistakeIndicator);
            System.out.println(warningMessage);
            return false;
        } else return true;
    }
}
