package net.azib.java.students.t072073.homework;

/**
 * UserArguments
 *
 * @author janika
 * @description holds input and output arguments, which user entered on command line
 */
public class UserArguments {
	private String inputMethod;
	private String inputParams;
	private String outputMethod;
	private String outputParams;
	
	/**
	 * 
	 * @param validatedArgs - user given arguments, which have been validated by
	 * ArgumentValidator
	 */
	public UserArguments(ArgumentValidator validatedArgs) {
		this.inputMethod = validatedArgs.getInputMethod();
		this.inputParams = validatedArgs.getInputParam();
		this.outputMethod = validatedArgs.getOutputMethod();
		this.outputParams = validatedArgs.getOutputParam();
	}
	
	
	/**
	 * @return the inputMethod
	 */
	public String getInputMethod() {
		return inputMethod;
	}

	/**
	 * @return the inputParams
	 */
	public String getInputParams() {
		return inputParams;
	}

	/**
	 * @return the outputMethod
	 */
	public String getOutputMethod() {
		return outputMethod;
	}

	/**
	 * @return the outputParams
	 */
	public String getOutputParams() {
		return outputParams;
	}

	/**
	 * 
	 * @return true if the user wanted to input the data from console
	 */
	public boolean consoleInput(){
		return DecathlonConstants.isConsole(inputMethod);
	}
	/**
	 * 
	 * @return true if the user wanted to input the data from csv file
	 */
	public boolean csvInput(){
		return DecathlonConstants.isCsv(inputMethod);
	}
	
	/**
	 * 
	 * @return true if the user wanted to input the data from database
	 */
	public boolean databseInput(){
		return DecathlonConstants.isDatabase(inputMethod);
	}
	
	/**
	 * 
	 * @return true if the user wanted to output the data to console
	 */
	public boolean consoleOutput(){
		return DecathlonConstants.isConsole(outputMethod);
	}
	
	/**
	 * 
	 * @return true if the user wanted to output the data to csv file
	 */
	public boolean csvOutput(){
		return DecathlonConstants.isCsv(outputMethod);
	}
	
	/**
	 * 
	 * @return true if the user wanted to output the data to xml file
	 */
	public boolean xmlOutput(){
		return DecathlonConstants.isXml(outputMethod);
	}
	
	/**
	 * 
	 * @return true if the user wanted to output the data to html file
	 */
	public boolean htmlOutput(){
		return DecathlonConstants.isHtml(outputMethod);
	}
}
