package net.azib.java.students.t107678.homework;

import java.io.IOException;

public class DecathlonCalculator {

    final static String CONSOLE = "-console";
    final static String CSV = "-csv";
    final static String DB = "-db";


    public static void main(String[] args) throws IOException, RecordFormatException {

        if (args[0].trim().compareToIgnoreCase(CONSOLE ) == 0) {

        } else if (args[0].trim().compareToIgnoreCase(CSV ) == 0) {
            CSVReader reader = new CSVReader(args[1]);
            if (args[2].trim().compareToIgnoreCase(CSV ) == 0) {
                CSVWriter writer = new CSVWriter(args[3]);
                ResultsComputation resultsComputation = new ResultsComputation();
                resultsComputation.readRecords(reader);
                resultsComputation.computeRecordsResults();
                writer.writeOutput(resultsComputation);
                System.out.println("Check the output :)");
            }
            if (args[2] == CONSOLE) {
                //

            }
            if (args[2] == DB) {
                //
            }

        } else if (args[0] == DB) {

        } else {
            System.out.println("The input method is not recognized");
        }


    }
}
