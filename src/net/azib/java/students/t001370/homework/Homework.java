package net.azib.java.students.t001370.homework;


import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Homework
 * Decathlon homework main class.
 * Handles input arguments from OS and routes processed data to DecathlonCalculator
 *
 * @author maksim
 */
public class Homework {
	
	private static final Logger LOG = Logger.getLogger(Homework.class.getName());

	private final PrintStream output;

	/**
	 * Class constructor
	 */
	Homework(){
		this.output = System.out;
	}
	
	/**
	 * Class constructor mainly used for unit testing
	 * @param out - output stream
	 */
	Homework(PrintStream out){
		this.output = out;
	}
	
	/**
	 * Check if the chosen input method is valid for input. 
	 * Valid inputs are: CONSOLE, CSV, DB.
	 *
	 * @param method - the input method to be checked
	 * @return  'false' if method is not valid input method, else 'true'
	 */
	private boolean checkIfInputMethodValid(IOMethod method){
		
		boolean checkReturn = false;
		
		if (method == IOMethod.CONSOLE_INPUT || 
			method == IOMethod.CSV_INPUT || 
			method == IOMethod.DB_INPUT){
			checkReturn = true;
		}
		
		return checkReturn;
	}
	
	/**
	 * Check if the chosen output method is valid for output.
	 * Valid output methods are: CONSOLE, CSV, HTML, XML.
	 * 
	 * @param method - the output method to be checked
	 * @return  'false' if method is not valid output method, else 'true'
	 */
	private boolean checkIfOutputMethodValid(IOMethod method){
		
		boolean checkReturn = false;
		
		if (method == IOMethod.CONSOLE_OUTPUT || 
			method == IOMethod.CSV_OUTPUT ||
			method == IOMethod.HTML_OUTPUT ||
			method == IOMethod.XML_OUTPUT){
			checkReturn = true;
		}
		
		return checkReturn;
	}
	
	/**
	 * Handle input methods from console.
	 * 
	 * @param inputArgs - arguments from console
	 */
	private void handleInputArguments(String[] inArgs){
		IOMethod input = IOMethod.NONE; 
		IOMethod output = IOMethod.NONE;
		int argSequence = 0;

		try{
			
			
			//input method
			input = input.parseInputMethod(inArgs[argSequence++]);
			if (checkIfInputMethodValid(input) == false){
				
				this.output.println(Errors.ERROR_CHECK_INPUT_ARG.getErrorText() + inArgs[argSequence - 1]);
				throw new DecathlonException();
			}
			else{
				
				//set input argument for CSV or DB
				if (input == IOMethod.CSV_INPUT ||
					input == IOMethod.DB_INPUT){
					
					String arg = inArgs[argSequence++];
					
					//check if there is input argument, input argument does not start with '-'
					if (arg.startsWith("-") != true){
						
						input.setIOArgument(arg);
					}
					else{
						
						this.output.println(Errors.ERROR_NO_INPUT_ARG_PARAM_FOUND.getErrorText());
						throw new DecathlonException();
					}
				}		
				
				//set output method
				output = output.parseOutputMethod(inArgs[argSequence++]);
				if (checkIfOutputMethodValid(output) == false){
					
					this.output.println(Errors.ERROR_CHECK_OUTPUT_ARG.getErrorText() + inArgs[argSequence - 1]);
					throw new DecathlonException();
				}
				else{
					
					//set output argument for CSV,XML or HTML
					if (output == IOMethod.CSV_OUTPUT ||
						output == IOMethod.XML_OUTPUT ||
						output == IOMethod.HTML_OUTPUT){
						
						
						//check if there is output argument, max nof arguments suppose to be 4
						if (inArgs[argSequence].length() != 4){
							
							output.setIOArgument(inArgs[argSequence]);
						}
						else{
							
							this.output.println(Errors.ERROR_NO_OUTPUT_ARG_PARAM_FOUND.getErrorText());
							throw new DecathlonException();
						}
					}	
					
					//start processing of data
					new DecathlonCalculator(input, output).calculate();
				}
			}
		}
		catch (Exception e){
			
			//print error description
			this.output.println(Errors.ERROR_IO_ARGS_NOT_SET.getErrorText());
			this.output.println();
			
			//print out current user arguments
			this.output.print("Your arguments:");
			for (String string : inArgs) {
				this.output.print(" " + string);
			}
			this.output.println();
			
			//print small help for user
			this.output.println();
			this.output.println("Argument description:");
			this.output.println("  <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
			this.output.println("where");
			this.output.println("  * <program> is your main class, e.g. java net.azib.java.students.txxxxxx.homework.DecathlonCalculator");
			this.output.println("  * <input-method> is the name of the input method preceded by dash (-): -console, -csv, -db");
			this.output.println("  * [input-parameters] are optional parameters depending on the specified input method:");
			this.output.println("       o -console - no parameters");
			this.output.println("       o -csv - input file name or path");
			this.output.println("       o -db - competition id or name - both should work (DB connection string must be read from db.properties in the same package as the main class)"); 
			this.output.println("  * <output-method> is the name of the output method preceded by dash (-): -conole, -csv, -xml, -html");
			this.output.println("  * [output-parameters] are optional parameters depending on the specified output method:");
			this.output.println("       o -conole - no parameters");
			this.output.println("       o -csv - output file name or path");
			this.output.println("       o -xml - output file name or path");
			this.output.println("       o -html - output file name or path");
			this.output.println("Example:");
			this.output.println("  -console -xml results.xml");
			this.output.println("  -db 2 -html /tmp/results.html");
			this.output.println("  -csv my_input.csv -console");


		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Homework decathlon = new Homework();
		
		try{
			decathlon.handleInputArguments(args);		
		}
		catch(Exception e){
			decathlon.output.println(Errors.ERROR_MAJOR_ERROR.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_MAJOR_ERROR.getErrorText() + e.getMessage());
		}
	}
}
