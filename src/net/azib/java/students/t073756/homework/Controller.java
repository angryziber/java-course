package net.azib.java.students.t073756.homework;

import net.azib.java.students.t073756.homework.beans.Athlete;
import net.azib.java.students.t073756.homework.calculator.ResultCalculator;
import net.azib.java.students.t073756.homework.io.*;
import net.azib.java.students.t073756.homework.validator.CommandLineArgumentValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.List;

public class Controller {

    public void doService(String[] args) {
        int argNumber = 0;
        InputProcessor inputProcessor;
        OutputProvider outputProvider;

        String arg = args[argNumber];
        if (CommandLineArgumentValidator.CONSOLE.validate(arg)) {
            inputProcessor = new ConsoleProcessor(new BufferedReader(new InputStreamReader(System.in)));
            argNumber++;
        } else if (CommandLineArgumentValidator.CSV.validate(arg)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                inputProcessor = new CsvProcessor(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else if (CommandLineArgumentValidator.DB_INPUT.validate(arg)) {
            String secondArg = args[++argNumber];
            Connection c = DbConnectionProvider.getConnection();
            if (CommandLineArgumentValidator.COMPETITION_ID.validate(secondArg)) {
                inputProcessor = new DbInputProcessor(c, Integer.parseInt(secondArg));
            } else { //there is no restrictions for competition name :(
                inputProcessor = new DbInputProcessor(c, secondArg);
            }
        } else {
            throw new DecathlonException("please provide at least one input method!");
        }

        arg = args[++argNumber];
        if (CommandLineArgumentValidator.CONSOLE.validate(arg)) {
            outputProvider = new ConsoleOutput();
        } else if (CommandLineArgumentValidator.CSV.validate(arg)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new CsvOutput(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else if (CommandLineArgumentValidator.XML_OUTPUT.validate(arg)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new XmlOutput(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else if (CommandLineArgumentValidator.HTML_OUTPUT.validate(arg)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new HtmlOutput(new File(args[argNumber]));
            } else {
                throw new DecathlonException(arg + "second parameter must be file path!");
            }
        } else {
            throw new DecathlonException("please provide at least one output method!");
        }

        proceedWithCalculation(inputProcessor, outputProvider);
    }

    private void proceedWithCalculation(InputProcessor inputProcessor, OutputProvider outputProvider) {
        List<Athlete> athletes = inputProcessor.readAthletes();
        ResultCalculator calculator = new ResultCalculator(athletes);
        calculator.calculate();
        outputProvider.writeAthletes(athletes);
    }
}