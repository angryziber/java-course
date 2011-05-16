package net.azib.java.students.t107678.homework;

import org.apache.commons.io.IOUtils;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public class DecathlonCalculator {

    final static String CONSOLE = "-console";
    final static String CSV = "-csv";
    final static String DB = "-db";
    final static String XML = "-xml";
    final static String HTML = "-html";


    public static void main(String[] args) throws IOException, RecordFormatException, SQLException {

        if (validateProgramArguments(args)==false) {
            System.exit(1);
        }

        if (args[0].trim().compareToIgnoreCase(CONSOLE) == 0) {      //our input is CONSOLE

            ConsoleReader reader = new ConsoleReader();

            ResultsComputation resultsComputation = new ResultsComputation();
            resultsComputation.readRecords(reader);
            resultsComputation.computeRecordsResults();

            if (args[1].trim().compareToIgnoreCase(CONSOLE) == 0) {

                ConsoleWriter writer = new ConsoleWriter();
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon competition results: ");

            }

            if (args[1].trim().compareToIgnoreCase(CSV) == 0) {

                CSVWriter writer = new CSVWriter(args[2]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified file");  //to be removed in final code
            }

            if (args[1].trim().compareToIgnoreCase(XML) == 0) {

                XMLWriter writer = new XMLWriter(args[2]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified XML file");  //to be removed in final code

            }

            if (args[1].trim().compareToIgnoreCase(HTML) == 0) {

                HTMLWriter writer = new HTMLWriter(args[2]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified HTML file");  //to be removed in final code
            }

            IOUtils.closeQuietly((Closeable) reader);
        } else if (args[0].trim().compareToIgnoreCase(CSV) == 0) {        //Our input is CSV file

            CSVReader reader = new CSVReader(args[1]);

            ResultsComputation resultsComputation = new ResultsComputation();
            resultsComputation.readRecords(reader);
            resultsComputation.computeRecordsResults();

            if (args[2].trim().compareToIgnoreCase(CSV) == 0) {

                CSVWriter writer = new CSVWriter(args[3]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified CSV file");  //to be removed in final code
            }
            if (args[2].trim().compareToIgnoreCase(CONSOLE) == 0) {

                ConsoleWriter writer = new ConsoleWriter();
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon competition results: ");
            }
            if (args[2].trim().compareToIgnoreCase(XML) == 0) {

                XMLWriter writer = new XMLWriter(args[3]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified XML file");  //to be removed in final code

            }
            if (args[2].trim().compareToIgnoreCase(HTML) == 0) {

                HTMLWriter writer = new HTMLWriter(args[3]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified HTML file");  //to be removed in final code
            }

            //IOUtils.closeQuietly((Closeable) reader);


        } else if (args[0].trim().compareToIgnoreCase(DB) == 0) {   //We take data from database

            DataBaseReader reader = new DataBaseReader(new DataBaseConnector(), args[1]);

            ResultsComputation resultsComputation = new ResultsComputation();
            resultsComputation.readRecords(reader);
            resultsComputation.computeRecordsResults();

            if (args[2].trim().compareToIgnoreCase(CONSOLE) == 0) {

                ConsoleWriter writer = new ConsoleWriter();
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon competition results: ");
            }
            if (args[2].trim().compareToIgnoreCase(CSV) == 0) {

                CSVWriter writer = new CSVWriter(args[3]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified CSV  file");  //to be removed in final code
            }
            if (args[2].trim().compareToIgnoreCase(XML) == 0) {

                XMLWriter writer = new XMLWriter(args[3]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified XML file");  //to be removed in final code

            }

            if (args[2].trim().compareToIgnoreCase(HTML) == 0) {

                HTMLWriter writer = new HTMLWriter(args[3]);
                writer.writeOutput(resultsComputation);
                System.out.println("Decathlon results are stored in specified HTML file");  //to be removed in final code
            }

            reader.connector.getConnection().close();
        } else {
            System.out.println("The input or output is not recognized/specified correctly. Try again!");
        }


    }


    private static boolean validateProgramArguments(String[] inputParameters) {


        if (inputParameters.length < 2) {         // at least two arguments must be specified
            System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
            return false;
        }

        if (inputParameters.length == 2) {        //we have two program arguments
            if (inputParameters[0].trim().compareToIgnoreCase(CONSOLE) != 0 || inputParameters[1].trim().compareToIgnoreCase(CONSOLE) != 0) {
                System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                return false;
            }
        }

        if (inputParameters.length == 3) {         //we have 3 program arguments

            if (inputParameters[0].trim().compareToIgnoreCase(CONSOLE) == 0) {
                if (inputParameters[1].trim().compareToIgnoreCase(CSV) != 0 || inputParameters[1].trim().compareToIgnoreCase(DB) != 0 || inputParameters[1].trim().compareToIgnoreCase(XML) != 0 || inputParameters[0].trim().compareToIgnoreCase(HTML) != 0) {
                    System.out.println("INVALID ATTEMPT! Specified Output method not allowed!");
                    return false;
                }
            } else if (inputParameters[0].trim().compareToIgnoreCase(CSV) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CONSOLE) != 0) {
                    System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                    return false;
                }
            } else if (inputParameters[0].trim().compareToIgnoreCase(DB) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CONSOLE) != 0) {
                    System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                    return false;
                }
            } else {
                System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                return false;
            }
        }

        if (inputParameters.length == 4) {            //we have 4 program arguments

            if (inputParameters[0].trim().compareToIgnoreCase(CONSOLE) == 0) {
                System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                return false;
            } else if (inputParameters[0].trim().compareToIgnoreCase(CSV) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CSV) != 0 || inputParameters[2].trim().compareToIgnoreCase(XML) != 0 || inputParameters[2].trim().compareToIgnoreCase(HTML) != 0 || inputParameters[2].trim().compareToIgnoreCase(DB) != 0) {
                    System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                }
            } else if (inputParameters[0].trim().compareToIgnoreCase(DB) == 0) {
                if (inputParameters[2].trim().compareToIgnoreCase(CSV) != 0 || inputParameters[2].trim().compareToIgnoreCase(XML) != 0 || inputParameters[2].trim().compareToIgnoreCase(HTML) != 0 || inputParameters[2].trim().compareToIgnoreCase(DB) != 0) {
                    System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                }
            } else {
                System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
                return false;
            }

        }


        if (inputParameters.length > 4) {             // we have more than 4 program arguments, which is not good :)

            System.out.println("INVALID ATTEMPT! CHECK INPUT ARGUMENTS!");
            return false;
        }

        return true;
    }
}





