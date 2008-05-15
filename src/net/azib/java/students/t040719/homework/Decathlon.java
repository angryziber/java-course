package net.azib.java.students.t040719.homework;

import net.azib.java.students.t040719.homework.io.InputMethod;
import net.azib.java.students.t040719.homework.io.OutputMethod;

import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Decathlon - the main program for the homework
 *
 * @version 1.1
 * @author Romi Agar
 */
public class Decathlon {
	private static final Logger LOG = Logger.getLogger(Decathlon.class.getSimpleName());			

	static final String WRONG_ARGS = "Incorrect arguments.";
	static final String USAGE = "Usage: -<input-method> [input-parameters] -<output-method> [output-parameters]";
	private final PrintStream out;
	private InputMethod im;
	private OutputMethod om;
	private String inputFile = "";
	private String outputFile = "";
	private String outputFormat = "";
	private List<Athlete> athletes;
	
	
	public Decathlon() {
		this(System.out);
	}
	
	/**
	 * Constructor for testing purposes
	 * @param out output stream
	 */
	Decathlon(PrintStream out){
		this.out = out;
	}
	
	/**
	 * Prints the program usage if incorrect arguments given
	 */
	private void printUsage(){
		out.println(WRONG_ARGS);
		out.println(USAGE);
	}
	
	/**
	 * Processes the actual command line arguments and executes the program
	 * @param args command-line arguments
	 */
	void processInput(String... args){
		switch (args.length){
		case 2:
			if (args[0].equals("-console") && args[1].equals("-console")){
				im = InputMethod.K;
				om = OutputMethod.K;
			}else{
				printUsage();
				return;
			}
			break;
		case 3:
			if (args[0].equals("-console") && (args[1].equals("-csv") || args[1].equals("-html") || args[1].equals("-xml"))){
				im = InputMethod.K;
				if(args[1].equals("-csv"))
					om = OutputMethod.C;
				else if(args[1].equals("-xml"))
					om = OutputMethod.X;
				else
					om = OutputMethod.H;
				outputFile = args[2];
				outputFormat = args[1];
			}else if((args[0].equals("-csv") || args[0].equals("-db")) &&  args[2].equals("-console")){
				if(args[0].equals("-csv"))
					im = InputMethod.C;
				else
					im = InputMethod.D;
				inputFile = args[1];
				om = OutputMethod.K;
			}else{
				printUsage();
				return;
			}
			break;
		case 4:
			if((args[0].equals("-csv") || args[0].equals("-db")) && (args[2].equals("-csv") || args[2].equals("-html") || args[2].equals("-xml"))){
				if(args[0].equals("-csv"))
					im = InputMethod.C;
				else
					im = InputMethod.D;
				inputFile = args[1];
				if(args[2].equals("-csv"))
					om = OutputMethod.C;
				else if(args[2].equals("-xml"))
					om = OutputMethod.X;
				else
					om = OutputMethod.H;
				outputFile = args[3];
				outputFormat = args[2];
			}else{
				printUsage();
			}
			break;
		default:
			printUsage();
			return;
		}
		out.println("Loading athletes' information from "+im.getInputName());
		athletes = im.getInput().getResults(inputFile);
		out.println("Loaded " + athletes.size() + " entrie(s).");
		Collections.sort(athletes);
		out.println("Outputting results to " + om.getOutputName());
		om.getOutput().outputResults(athletes, outputFile, outputFormat);
		out.println("All done.");
	}
	
	/**
	 * The main entry point to the program
	 * @param args command-line arguments
	 */
	public static void main(String... args) {
		try{
			new Decathlon().processInput(args);
		}catch(Exception e){
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Unexpected bug", e);
			else
				LOG.log(Level.SEVERE, "Unexpected bug");
		}	
	}
}
