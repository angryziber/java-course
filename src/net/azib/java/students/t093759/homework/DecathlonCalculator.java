package net.azib.java.students.t093759.homework;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.FileUtils.readLines;

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
		Map<String, List<String>> params = ParamsParser.getInstance().parse(parameters);
		if (notEnoughOrTooMuchParameters(params)) {
			System.out.println(helpMessage());
			return;
		}

		System.out.println("Params:" + Arrays.asList(parameters));
		Iterator<Map.Entry<String, List<String>>> iterator = params.entrySet().iterator();
		Map.Entry<String, List<String>> inputMethodEntry = iterator.next();
		InputMethod inputMethod = InputMethod.getInstanceFor(inputMethodEntry.getKey());
		athleteLoader = inputMethod.createAthleteLoader();
		List<Athlete> athletes = null;
		try {
			List<String> param = inputMethodEntry.getValue();
			athletes = athleteLoader.load((Object[])param.toArray(new String[param.size()]));
		} catch (Exception e) {
			System.err.println("Exception in " + inputMethod);
		}

		Map.Entry<String, List<String>> outputMethodEntry = iterator.next();
		OutputMethod outputMethod = OutputMethod.getInstanceFor(outputMethodEntry.getKey());
		athleteSaver = outputMethod.createAthleteSaver();
		try {
			List<String> param = outputMethodEntry.getValue();
			athleteSaver.output(athletes, (Object[])param.toArray(new String[param.size()]));
		} catch (Exception e) {
			System.err.println("Exception in " + outputMethod);
		}
	}

	boolean notEnoughOrTooMuchParameters(Map<String, List<String>> parameters) {
		return parameters.size() != 2;
	}

	String helpMessage() {
		final String newLine = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder(8000);
		try {
			for (String line : readLines(new File(getClass().getResource("help.txt").getFile()), "UTF-8")) {
				builder.append(line).append(newLine);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return builder.toString();
	}

	static enum InputMethod {
		CONSOLE {
			AthletesLoader createAthleteLoader() {
				return new ConsoleLoader();
			}
		},
		CSV {
			AthletesLoader createAthleteLoader() {
				return new CSVLoader();
			}
		},
		DB {
			AthletesLoader createAthleteLoader() {
				return new DataBaseLoader();
			}
		};

		abstract AthletesLoader createAthleteLoader();

		static InputMethod getInstanceFor(String inputMethodString) {
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

	static enum OutputMethod {
		CONSOLE {
			ConsoleOutput createAthleteSaver() {
				return new ConsoleOutput();
			}
		},
		CSV {
			AthletesOutput createAthleteSaver() {
				return new CSVOutput();
			}
		},
		XML {
			AthletesOutput createAthleteSaver() {
				return new XMLOutput();
			}
		},
		HTML {
			AthletesOutput createAthleteSaver() {
				return new HTMLOutput();
			}
		};

		abstract AthletesOutput createAthleteSaver();

		static OutputMethod getInstanceFor(String outputMethodString) {
			outputMethodString = outputMethodString.trim().toLowerCase();
			if (outputMethodString.equals("-conole"))
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
