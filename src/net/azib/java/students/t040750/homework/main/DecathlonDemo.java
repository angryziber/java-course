package net.azib.java.students.t040750.homework.main;

import net.azib.java.students.t040750.homework.io.InputHandler;
import net.azib.java.students.t040750.homework.io.OutputHandler;
import net.azib.java.students.t040750.org.apache.commons.cli.BasicParser;
import net.azib.java.students.t040750.org.apache.commons.cli.CommandLine;
import net.azib.java.students.t040750.org.apache.commons.cli.CommandLineParser;
import net.azib.java.students.t040750.org.apache.commons.cli.HelpFormatter;
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
	
	public static void main(String[] args) {
		
		// Create the Options object
		Options options = new Options();

		options.addOption(CONSOLE,	false,	"Command line input/output");
		options.addOption(CSV,		true,	"CSV input/output");
		options.addOption(DB,		true,	"Database input");
		options.addOption(XML,		true,	"XML output");
		options.addOption(HTML,		true,	"HTML output");
		
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
			System.err.println("Invalid number of arguments");
			usage(options); 
			return; 
		}
		else {
			OutputHandler.outputData(cmd.getOptions()[1], 
					InputHandler.readInput(cmd.getOptions()[0]));
		}
		
	}
	
	private static void usage(Options options){

		// Use the inbuilt formatter class
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "DecathlonDemo", options );
	}
}
