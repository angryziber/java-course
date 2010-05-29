package net.azib.java.students.t092859.homework;

import net.azib.java.students.t092859.homework.core.DecathlonPositioner;
import net.azib.java.students.t092859.homework.input.*;
import net.azib.java.students.t092859.homework.output.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * DecathlonCalculator
 * Main class for Decathlon calculator application
 * @author konstantin
 */
public class DecathlonCalculator {

	private static String usage = "usage: <program> -<input-method> [input-parameter] -<output-method> [output-parameter]\n" +
			"program:\n\tjava DecathlonCalculator\n\n" +
			"input-method:\n\tconsole - interactive input from console\n" +
			"\tcsv - input from CSV file\n" +
			"\tdb - input from database (connection string in db.properties)\n" +
			"input-parameter:\n\tfor -console - no parameters\n" +
			"\tfor -csv - input file name\n" +
			"\tfor -db - competition id or name\n\n" +
			"output-method:\n\tconsole - output to console in human-readable format\n" +
			"\tcsv - output to CSV file\n" +
			"\txml - output to XML file\n" +
			"\thtml - output to HTML file\n" +
			"output-parameter:\n\tfor -console - no parameters\n" +
			"\tfor -csv - output file name\n" +
			"\tfor -xml - output file name\n" +
			"\tfor -html - output file name\n";
	
	/**
	 * Main method of the application. Selects data input
	 * (fetcher) and output(writer), creates and calls
	 * DecathlonPositioner instance.
	 * @param args - command line arguments, see usage
	 * If no arguments are provided or cannot parse them,
	 * this method prints usage to command line 
	 */
	public static void main(String[] args) {
		DecathlonResultFetcher fetcher = null;
		DecathlonResultWriter writer = null;
		Iterator<String> argumentIterator = Arrays.asList(args).iterator();
		
		fetcher = parseInputArgs(argumentIterator);
		writer = parseOutputArgs(argumentIterator);
		
		if(fetcher == null || writer == null)
			System.out.println(usage);
		else {
			DecathlonPositioner positioner = new DecathlonPositioner(fetcher, writer);
			positioner.processResults();
		}
		
	}
	
	/**
	 * Iterates over command line arguments, looks for correct result
	 * input source switches and parameters
	 * @param argumentIterator - iterator over command line arguments
	 * @return DecathlonResultFetcher - instance of appropriate fetcher if parsing
	 * succeeded, null if not
	 */
	
	private static DecathlonResultFetcher parseInputArgs (Iterator<String> argumentIterator) {
		if(!argumentIterator.hasNext()) //if no input method argument is provided
			return null;
		String method = argumentIterator.next();
		
		if(method.equals("-console"))
			return new ConsoleResultFetcher();
		
		if(!argumentIterator.hasNext()) //if no input method parameter is provided
			return null;
		String param = argumentIterator.next();
		
		if(method.equals("-csv")){
			try {
				FileInputStream input = new FileInputStream(param);
				return new CSVResultFetcher(new InputStreamReader(input, "UTF-8"));
			}
			catch (FileNotFoundException e) {
				System.err.println("Input CSV file not found");
				return null; //return value irrelevant if fetcher is null
			}
			catch (UnsupportedEncodingException e) {} //UTF-8 shall be supported
		}
		if(method.equals("-db")){
			ResourceBundle bundle = ResourceBundle.getBundle(DecathlonCalculator.class.getPackage().getName() + ".db", new Locale(""));
			return new DBResultFetcher(bundle.getString("dbConnection"), bundle.getString("dbUser"), bundle.getString("dbPassword"), param);
		}
		return null;
	}
	
	/**
	 * Iterates over command line arguments, looks for correct result
	 * output switches and parameters
	 * @param argumentIterator - iterator over command line arguments
	 * @return DecathlonResultWriter - instance of appropriate writer if parsing
	 * succeeded, null if not
	 */
	private static DecathlonResultWriter parseOutputArgs (Iterator<String> argumentIterator) {
		if(!argumentIterator.hasNext()) //if no output method argument is provided
			return null;
		String method = argumentIterator.next();
		
		if(method.equals("-console"))
			return new ConsoleResultWriter();
		
		if(!argumentIterator.hasNext()) //if no output method parameter is provided
			return null;
		String param = argumentIterator.next();
		
		Writer output;
		try {
			output = new FileWriter(param);
		}
		catch (IOException e1) {
			System.err.println("error opening result file for writing");
			return null;
		}
		
		if(method.equals("-csv")){
			return new CSVResultWriter(output);
		}
		
		if(method.equals("-xml")){
			return new XMLResultWriter(output);
		}
		
		if(method.equals("-html")){
			return new HTMLResultWriter(output);
		}
		
		return null;
	}
}
