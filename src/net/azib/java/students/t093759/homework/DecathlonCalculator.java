package net.azib.java.students.t093759.homework;

import java.util.Arrays;
import java.util.Collection;

/**
 * Decathlon calculator provides functionality for
 * calculating points of athletes and output them to different sources etc.
 *
 * @author dionis
 *         5/29/117:53 PM
 */
public class DecathlonCalculator {
	AthletesLoader athleteLoader;
	AthletesOutput athleteSaver;

	public static void main(String[] args) {
		new DecathlonCalculator().handleRequest(args);
	}

	void handleRequest(String[] parameters) {
		if (parameters.length < 2 || parameters.length > 4) {
			printHelpMessage();
			return;
		}
		int currentIndexOfParam = 0;

		System.out.println("Params:" + Arrays.asList(parameters));

		InputMethod inputMethod = InputMethod.getInstanceFor(parameters[currentIndexOfParam]);
		athleteLoader = inputMethod.createAthleteLoader();
		Collection<Athlete> athletes = null;
		try {
			athletes = athleteLoader.load(inputMethod.getParameter(currentIndexOfParam, parameters));
		} catch (Exception e) {
			System.out.println(inputMethod);
		}
		currentIndexOfParam = inputMethod.getNextInputMethodArgumentsIndex(currentIndexOfParam);

		OutputMethod outputMethod = OutputMethod.getInstanceFor(parameters[currentIndexOfParam]);
		athleteSaver = outputMethod.createAthleteSaver();
		try {
			athleteSaver.save(athletes, outputMethod.getParameter(currentIndexOfParam, parameters));
		} catch (Exception e) {
			System.out.println(outputMethod);
		}
	}

	private void printHelpMessage() {
		final String newLine = System.getProperty("line.separator");
		System.out.println("usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
		System.out.println(new StringBuilder().append("where").append(newLine)
				.append("\t<program> is your main class, e.g. java net.azib.java.students.txxxxxx.homework.DecathlonCalculator").append(newLine)
				.append("\t<input-method> is the name of the input method preceded by dash (-): -console, -csv, -db").append(newLine)
				.append("\t[input-parameters] are optional parameters depending on the specified input method:").append(newLine)
				.append("\t-console - no parameters").append(newLine)
				.append("\t-csv - input file name or path").append(newLine)
				.append("\t-db - competition id or name - both should work (DB connection string must be read from ")
				.append("db.properties in the same package as the main class)").append(newLine)
				.append("\t<output-method> is the name of the output method preceded by dash (-): -conole, -csv, -xml, -html").append(newLine)
				.append("\t[output-parameters] are optional parameters depending on the specified output method:").append(newLine)
				.append("\t-conole - no parameters").append(newLine)
				.append("\t-csv - output file name or path").append(newLine)
				.append("\t-xml - output file name or path").append(newLine)
				.append("\t-html - output file name or path").toString());
	}

	private static enum InputMethod {
		CONSOLE {
			AthletesLoader createAthleteLoader() {
				return new ConsoleLoader();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return "";
			}

			@Override
			int getNextInputMethodArgumentsIndex(int currentIndex) {
				return ++currentIndex;
			}
		},
		CSV {
			AthletesLoader createAthleteLoader() {
				return new CSVLoader();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return from[++currentIndex];
			}

			@Override
			int getNextInputMethodArgumentsIndex(int currentIndex) {
				return currentIndex + 2;
			}
		},
		DB {
			AthletesLoader createAthleteLoader() {
				return new DataBaseLoader();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return from[++currentIndex];
			}

			@Override
			int getNextInputMethodArgumentsIndex(int currentIndex) {
				return currentIndex + 2;
			}
		};

		abstract AthletesLoader createAthleteLoader();

		abstract String getParameter(int currentIndex, String[] fromParameters);

		abstract int getNextInputMethodArgumentsIndex(int currentIndex);

		private static InputMethod getInstanceFor(String inputMethodString) {
			inputMethodString = inputMethodString.trim().toLowerCase();
			if (inputMethodString.equals("-console"))
				return CONSOLE;
			else if (inputMethodString.equals("-csv"))
				return CSV;
			else if (inputMethodString.equals("-db"))
				return DB;
			else
				throw new UnsupportedOperationException();
		}
	}


	private static enum OutputMethod {
		CONSOLE {
			ConsoleOutput createAthleteSaver() {
				return new ConsoleOutput();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return "";
			}

		},
		CSV {
			AthletesOutput createAthleteSaver() {
				return new CSVOutput();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return from[++currentIndex];
			}

		},
		XML {
			AthletesOutput createAthleteSaver() {
				return new XMLOutput();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return from[++currentIndex];
			}

		},
		HTML {
			AthletesOutput createAthleteSaver() {
				return new HTMLOutput();
			}

			@Override
			String getParameter(int currentIndex, String[] from) {
				return from[++currentIndex];
			}

		};

		abstract AthletesOutput createAthleteSaver();

		abstract String getParameter(int currentIndex, String[] fromParameters);

		private static OutputMethod getInstanceFor(String outputMethodString) {
			outputMethodString = outputMethodString.trim().toLowerCase();
			if (outputMethodString.equals("-console"))
				return CONSOLE;
			else if (outputMethodString.equals("-csv"))
				return CSV;
			else if (outputMethodString.equals("-xml"))
				return XML;
			else if (outputMethodString.equals("-html"))
				return HTML;
			else
				throw new UnsupportedOperationException();
		}
	}
}
