package net.azib.java.students.t001370.homework;

import net.azib.java.students.t001370.lectures.lec13.UtilLoggingDemo;

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
	
	private static final Logger LOG = Logger.getLogger(UtilLoggingDemo.class.getName());

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

		//input method
		input = input.parseInputMethod(inArgs[argSequence++]);
		if (checkIfInputMethodValid(input) == false){
			
			this.output.println(Errors.ERROR_0009.getErrorText() + inArgs[argSequence - 1]);

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
					this.output.println(Errors.ERROR_0026.getErrorText());
//					this.output.println("Please insert input argument: ");
//					input.setIOArgument(new Scanner(System.in).next());
				}
			}		
			
			//set output method
			output = output.parseOutputMethod(inArgs[argSequence++]);
			if (checkIfOutputMethodValid(output) == false){
				
				this.output.println(Errors.ERROR_0010.getErrorText() + inArgs[argSequence - 1]);

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
						this.output.println(Errors.ERROR_0027.getErrorText());
//						this.output.println("Please insert output argument: ");
//						output.setIOArgument(new Scanner(System.in).next());
					}
				}	
				
				//start processing of data
				new DecathlonCalculator(input, output).calculate();
			}
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
			decathlon.output.println(Errors.ERROR_0008.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_0008.getErrorText() + e.getMessage());
			System.exit(1);
		}
	}
}
