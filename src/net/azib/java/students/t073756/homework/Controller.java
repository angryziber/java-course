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
	private InputProcessor inputProcessor;
	private OutputProvider outputProvider;

	public void doService(String[] args) {
		validateArgumentsAmount(args);

		setIO(args);

		proceedWithCalculation(inputProcessor, outputProvider);
	}

	void setIO(String[] args) {
		IO inputIO = IO.getMethod(args[0]);
		inputProcessor = inputIO.getInput(args);
		outputProvider = IO.getMethod(args[inputIO.argNumber]).getProvider(args);
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

	private void proceedWithCalculation(InputProcessor inputProcessor, OutputProvider outputProvider) {
		List<Athlete> athletes = inputProcessor.readAthletes();
		ResultCalculator calculator = new ResultCalculator(athletes);
		calculator.calculate();
		outputProvider.writeAthletes(athletes);
	}

	enum IO {
		CSV("-csv", 2) {
			@Override
			public InputProcessor getInput(String[] args) {
				return new CsvProcessor(validatePath(args[1]));
			}

			@Override
			public OutputProvider getProvider(String[] args) {
				return new CsvOutput(validatePath(args[args.length-1]));
			}
		},
		CONSOLE("-console", 1) {
			@Override
			public InputProcessor getInput(String[] args) {
				return new ConsoleProcessor(new BufferedReader(new InputStreamReader(System.in)));
			}

			@Override
			public OutputProvider getProvider(String[] args) {
				return new ConsoleOutput();
			}
		},
		DB("-db",2) {
			@Override
			public InputProcessor getInput(String[] args) {
				String secondArg = args[1];
				Connection c = getConnection();
				if (CommandLineArgumentValidator.COMPETITION_ID.validate(secondArg)) {
					return new DbInputProcessor(c, Integer.parseInt(secondArg));
				} else { //there is no restrictions for competition name :(
					return new DbInputProcessor(c, secondArg);
				}
			}

			Connection getConnection() {
				return DbConnectionProvider.provideConnection();
			}
		},
		XML("-xml",2) {
			@Override
			public OutputProvider getProvider(String[] args) {
				return new XmlOutput(validatePath(args[args.length-1]));
			}
		},
		HTML("-html",2) {
			@Override
			public OutputProvider getProvider(String[] args) {
				return new HtmlOutput(validatePath(args[args.length-1]));
			}
		};

		public int argNumber;
		private String key;

		IO(String key, int argNumber) {
			this.key = key;
			this.argNumber = argNumber;
		}

		public InputProcessor getInput(String[] args) {
			throw new DecathlonException("no such input method");
		}

		public OutputProvider getProvider(String[] args) {
			throw new DecathlonException("no such output method");
		}

		public static IO getMethod(String name) {
			for (IO method : IO.values()) {
				if (method.key.equals(name)) {
					return method;
				}
			}
			throw new DecathlonException("no such input/output method");
		}

		private static File validatePath(String path) {
			File file = new File(path);
			if (!CommandLineArgumentValidator.FILE_PATH.validate(path) && !file.isFile()) {
				throw new DecathlonException("second parameter must be a file path!");
			}
			return file;
		}
	}
}
