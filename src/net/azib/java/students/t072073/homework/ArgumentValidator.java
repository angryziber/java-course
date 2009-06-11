package net.azib.java.students.t072073.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.zip.DataFormatException;


/**
 * ArgumentValidator gets program parameters and validates them 
 *
 * @author janika
 */
public class ArgumentValidator {
	private Set <String> inputMethods = DecathlonConstants.inputMethods();
	private Set <String> outputMethods = DecathlonConstants.outputMethods();
	private String inputMethod;
	private String inputParam;
	private String outputMethod;
	private String outputParam;
	

	private void initialize(String inputMethod,String inputParam,String outputMethod,String outputParam) {
		this.inputMethod = inputMethod;		
		this.inputParam = inputParam;
		this.outputMethod = outputMethod;
		this.outputParam = outputParam;
		
	}

	/**
	 * @return the inputMethod
	 */
	public String getInputMethod() {
		return inputMethod;
	}

	/**
	 * @return the inputParam
	 */
	public String getInputParam() {
		return inputParam;
	}

	/**
	 * @return the outputMethod
	 */
	public String getOutputMethod() {
		return outputMethod;
	}

	/**
	 * @return the outputParam
	 */
	public String getOutputParam() {
		return outputParam;
	}

	/**
	 * 
	 * @param args - program parameters as string array
	 * @throws DataFormatException
	 * @description checks that there are enough parameters, parameters are valid.
	 */
	public ArgumentValidator(String [] args) throws DataFormatException{
		if (args.length < 2 || args.length > 5){
			throw new DataFormatException("There are not enough or too many arguments for this application to operate.");
		}
		if(hasFourValidParameters(args)){
			initialize(args[0], args[1], args[2], args[3]);
 
		}
		else if (hasOneConsoleParameter(args)){
			if(firstParameterConsole(args)){
				initialize(args[0], null, args[1], args[2]);
			}
			else if(secondParameterConsole(args)){
				initialize(args[0], args[1], args[2], null);

			}
			else{
				throw new DataFormatException("Parameters are invalid.");
			}
		}
		else if (hasTwoConsoleParameters(args)){
			initialize(args[0], null, args[1], null);

		}
		else {
			throw new DataFormatException("Parameters are invalid.");
		}

	}
	
	/**
	 * 
	 * @param args - program parameters
	 * @return true if the first element in string array is "-console"
	 */
	private boolean firstParameterConsole(String [] args){
		return (DecathlonConstants.isConsole(args[0]) && outputMethods.contains(args[1]));
	}
	
	/**
	 * 
	 * @param args - program parameters
	 * @return true if the second element in string array is "-console"
	 */
	private boolean secondParameterConsole(String [] args){
		return (inputMethods.contains(args[0]) && DecathlonConstants.isConsole(args[2]));
	}
	
	/**
	 * 
	 * @param args - program parameters
	 * @return true if there are four element in string array and the first and the second parameter
	 *  match allowed input and putput methods 
	 */
	private boolean hasFourValidParameters(String [] args){
		return (args.length == 4 && inputMethods.contains(args[0]) && outputMethods.contains(args[2]));
	}
	
	/**
	 * 
	 * @param args - program parameters
	 * @return true if there are 3 elements in string array (if parameters are valid, then one of them is console)
	 */
	private boolean hasOneConsoleParameter(String [] args){
		return args.length == 3;
	}
	
	/**
	 * 
	 * @param args - program parameters as string array
	 * @return true if there are only two elements in string array and both of them are "-console"
	 */
	private boolean hasTwoConsoleParameters(String [] args){
		return (args.length == 2 && DecathlonConstants.isConsole(args[0]) && DecathlonConstants.isConsole(args[1]));
	}


}
