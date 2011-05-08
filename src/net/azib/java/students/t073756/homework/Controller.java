package net.azib.java.students.t073756.homework;

import net.azib.java.students.t073756.homework.calculator.ResultCalculator;
import net.azib.java.students.t073756.homework.io.*;
import net.azib.java.students.t073756.homework.validator.CommandLineArgumentValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.List;

public class Controller {
    private int argNumber;
    private InputProcessor inputProcessor;
    private OutputProvider outputProvider;
    private DecathlonException filePathException = new DecathlonException("second parameter must be a file path!");

    public void doService(String[] args) {
        validateArgumentsAmount(args);

        setInputProcessor(args);
        setOutputProvider(args);

        proceedWithCalculation(inputProcessor, outputProvider);
    }

    void setInputProcessor(String[] args) {
        String processorFlag = args[argNumber];

        if (CommandLineArgumentValidator.CONSOLE.validate(processorFlag)) {
            inputProcessor = new ConsoleProcessor(new BufferedReader(new InputStreamReader(System.in)));
            argNumber++;
        } else if (CommandLineArgumentValidator.CSV.validate(processorFlag)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                inputProcessor = new CsvProcessor(new File(args[argNumber]));
            } else {
                throw filePathException;
            }
        } else if (CommandLineArgumentValidator.DB_INPUT.validate(processorFlag)) {
            String secondArg = args[++argNumber];
            Connection c = getConnection();
            if (CommandLineArgumentValidator.COMPETITION_ID.validate(secondArg)) {
                inputProcessor = new DbInputProcessor(c, Integer.parseInt(secondArg));
            } else { //there is no restrictions for competition name :(
                inputProcessor = new DbInputProcessor(c, secondArg);
            }
        } else {
            throw new DecathlonException("please provide at least one input method!");
        }
    }

	void setOutputProvider(String[] args) {
        String providerFlag = args[++argNumber];
        if (CommandLineArgumentValidator.CONSOLE.validate(providerFlag)) {
            outputProvider = new ConsoleOutput();
        } else if (CommandLineArgumentValidator.CSV.validate(providerFlag)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new CsvOutput(new File(args[argNumber]));
            } else {
                throw filePathException;
            }
        } else if (CommandLineArgumentValidator.XML_OUTPUT.validate(providerFlag)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new XmlOutput(new File(args[argNumber]));
            } else {
                throw filePathException;
            }
        } else if (CommandLineArgumentValidator.HTML_OUTPUT.validate(providerFlag)) {
            if (CommandLineArgumentValidator.FILE_PATH.validate(args[++argNumber])) {
                outputProvider = new HtmlOutput(new File(args[argNumber]));
            } else {
                throw filePathException;
            }
        } else {
            throw new DecathlonException("please provide at least one output method!");
        }
    }

	void validateArgumentsAmount(String[] args) {
		int argsNumber = args.length;
		if (argsNumber < 2 || argsNumber > 4) {
			throw new DecathlonException("wrong amount of arguments! there must be at least 2 and no more than 4 arguments!");
		}
	}

	InputProcessor getInputProcessor() {
		return inputProcessor;
	}

	OutputProvider getOutputProvider() {
		return outputProvider;
	}

	Connection getConnection() {
		return DbConnectionProvider.provideConnection();
	}

	private void proceedWithCalculation(InputProcessor inputProcessor, OutputProvider outputProvider) {
        List<Athlete> athletes = inputProcessor.readAthletes();
        ResultCalculator calculator = new ResultCalculator(athletes);
        calculator.calculate();
        outputProvider.writeAthletes(athletes);
    }
}
