package ee.ttu.decathlon;

import ee.ttu.decathlon.beans.Athlete;
import ee.ttu.decathlon.calculator.ResultCalculator;
import ee.ttu.decathlon.io.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.List;

import static ee.ttu.decathlon.validator.CommandLineArgumentValidator.*;

public class MainController {

    public static void main(String[] args) {
        System.out.println("Welcome to decathlon points calculation system!");
        if (args.length < 0) {
            throw new DecathlonException("please provide program arguments");
        }
        doService(args);
    }

    static void doService(String[] args) {
        int argNumber = 0;
        InputProcessor inputProcessor;
        OutputProvider outputProvider;

        String arg = args[argNumber];
        if (CONSOLE.validate(arg)) {
            inputProcessor = new ConsoleProcessor(new BufferedReader(new InputStreamReader(System.in)));
            argNumber++;
        } else if(CSV.validate(arg)) {
            if (FILE_PATH.validate(args[++argNumber])) {
                inputProcessor = new CsvProcessor(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else if (DB_INPUT.validate(arg)) {
            String secondArg = args[++argNumber];
            Connection c = null;//todo provide connection
            if (COMPETITION_ID.validate(secondArg)) {
                inputProcessor = new DbInputProcessor(c, Integer.parseInt(secondArg));
            } else { //there is no restrictions for competition name :(
                inputProcessor = new DbInputProcessor(c, secondArg);
            }
        } else {
            throw new DecathlonException("please provide at least one input method!");
        }

        arg = args[++argNumber];
        if (CONSOLE.validate(arg)) {
            outputProvider = new ConsoleOutput();
        } else if (CSV.validate(arg)) {
            if (FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new CsvOutput(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else if (XML_OUTPUT.validate(arg)) {
            if (FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new XmlOutput(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else if (HTML_OUTPUT.validate(arg)) {
            if (FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new HtmlOutput(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else {
            throw new DecathlonException("please provide at least one output method!");
        }

        proceedWithCalculation(inputProcessor, outputProvider);
    }

    private static void proceedWithCalculation(InputProcessor inputProcessor, OutputProvider outputProvider) {
        List<Athlete> athletes = inputProcessor.readAthletes();
        ResultCalculator calculator = new ResultCalculator(athletes);
        calculator.calculate();
        outputProvider.writeAthletes(athletes);
    }
}
