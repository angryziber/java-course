package net.azib.java.students.t103784.homework;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * The main class.
 *
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class Main {
	static String inputMethod = null, inputParameter = null, outputMethod = null, outputParameter = null;

	/**
	 * Assigns console arguments to custom parameters.
	 * <p/>
	 * Reads in the arguments given and iterates them,
	 * assigning each argument to a corresponding
	 * parameter.
	 *
	 * @param args The array of arguments.
	 * @return Returns the same array.
	 */
	public static String[] setParameters(String[] args) {
		for (String s : args) {
			if (s.contains("-")) {
				if (inputMethod == null) {
					inputMethod = s;
				} else {
					outputMethod = s;
				}
			} else {
				if (inputParameter == null && s.equals(args[1])) {
					inputParameter = s;
				} else {
					outputParameter = s;
				}
			}
		}
		return args;
	}

	/**
	 * The main method
	 * <p/>
	 * Takes in the input/output arguments and
	 * uses them to specify the input/output methods,
	 * reads in athlete data, processes it
	 * to calculate each athlete's score
	 * and place and finally outputs the data.
	 * If no input or output method is selected,
	 * the program will terminate.
	 * If no optional parameters are specified,
	 * defaults ones will be used.
	 *
	 * @param args Array of console arguments set by user.
	 * @throws java.io.IOException Is thrown when
	 *                             a reading error occurs.
	 */
	public static void main(String[] args) throws IOException {

		setParameters(args);
		List<Athlete> contestants = null;
		BufferedReader reader;
		Input input = new Input();
		Output output = new Output();

		if (inputMethod != null && inputMethod.equals("-console")) {
			try {
				contestants = input.readAthleteFromConsole();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (inputMethod != null && inputMethod.equals("-csv")) {
			try {
				File file;
				if (inputParameter != null) {
					file = new File(inputParameter);
				} else {
					file = new File("src/net/azib/java/students/t103784/homework/tmp/sample.csv");
				}
				reader = new BufferedReader(new FileReader(file));
				contestants = input.readAthleteFromCSV(reader);
			} catch (Exception e) {
				System.out.println("You have specified CSV input, but no CSV file found");
				return;
			}
		} else if (inputMethod != null && inputMethod.equals("-db")) {
			try {
				contestants = input.readAthleteFromDB();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No input selected");
			return;
		}

		if (outputMethod != null && outputMethod.equals("-console")) {
			output.outputToConsole(contestants);
		} else if (outputMethod != null && outputMethod.equals("-csv")) {
			output.outputToCSV(contestants);
		} else if (outputMethod != null && outputMethod.equals("-xml")) {
			try {
				output.outputToXML(contestants);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		} else if (outputMethod != null && outputMethod.equals("-html")) {
			try {
				output.outputToHTML(contestants);
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No output selected");
		}

	}
}
