package net.azib.java.students.t040750.homework.main;

import net.azib.java.students.t040750.homework.io.InputHandler;
import net.azib.java.students.t040750.homework.io.OutputHandler;
import net.azib.java.students.t040750.org.apache.commons.cli.BasicParser;
import net.azib.java.students.t040750.org.apache.commons.cli.CommandLine;
import net.azib.java.students.t040750.org.apache.commons.cli.CommandLineParser;
import net.azib.java.students.t040750.org.apache.commons.cli.HelpFormatter;
import net.azib.java.students.t040750.org.apache.commons.cli.Option;
import net.azib.java.students.t040750.org.apache.commons.cli.Options;
import net.azib.java.students.t040750.org.apache.commons.cli.ParseException;

public class DecathlonDemo {

	public static String CONSOLE = "console";
	public static String CSV = "csv";
	public static String DB = "db";
	public static String XML = "xml";
	public static String HTML = "html";
	
	public static String DB_PROPERTIES_FILE = "db.properties";
	public static String XSL_SCHEMA = "decathlon.xsl";

/**
 * Main class of the program. Takes exactly 2 parameters, one for
 * input and the other for output data, and parses the input data
 * from the requested source to the selected output.
 * 
 * @param args - program parameters
 */
public static void main(String[] args) {
		
		// Create the Options object
		Options options = new Options();
		
		// Define the valid options (option name, take parameters?, description)
		options.addOption(CONSOLE,	false,	"Command line input/output");
		options.addOption(CSV,		true,	"CSV input/output");
		options.addOption(DB,		true,	"Database input");
		options.addOption(XML,		true,	"XML output");
		options.addOption(HTML,		true,	"HTML output");
		
		// Create new parser for command line parameters
		CommandLineParser parser = new BasicParser();
		CommandLine cmd;
		
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException pe) { 
			usage(options); 
			return; 
		}
		
		// Check if correct number of arguments
		if (cmd.getOptions().length != 2) {
			System.out.println("Invalid number of arguments");
			usage(options); 
			return; 
		}
		else {
			try {
				Option input = cmd.getOptions()[0];
				Option output = cmd.getOptions()[1];
				
				if (input.getOpt().equals(XML) || input.getOpt().equals(HTML)) {
					System.out.println("Invalid argument for input");
					usage(options); 
					return; 
				}
				
				if (output.getOpt().equals(DB)) {
					System.out.println("Invalid argument for output");
					usage(options); 
					return; 
				}
				
				// Start the parsing process
				OutputHandler.outputData(output,InputHandler.readInput(input));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	/**
	 * Program usage help menu
	 * 
	 * @param options - valid options to start the program
	 */
	private static void usage(Options options){
		// Use the inbuilt formatter class
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("DecathlonDemo", options);
	}
}
