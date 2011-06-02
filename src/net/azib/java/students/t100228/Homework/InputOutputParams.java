package net.azib.java.students.t100228.Homework;

import java.io.File;
import java.io.FileNotFoundException;


/**
 * Stores the command line parameters read from console during program startup
 */
public class InputOutputParams {

	Utils.enumInputMethod enumInputMethod;
	Utils.enumOutputMethod enumOutputMethod;
	String inputFilePath;
	String competitionIdOrName;
	String outputFilePath;

	/**
	 * Returns the input file path provided by the command line
	 * @return The input file path provided by the command line
	 */
	public String getInputFilePath(){
		return inputFilePath;
	}

	/**
	 * Stores the input file path. In case the file does not exist, throws an {@link FileNotFoundException}
	 * @param path The input file path which contains competition results
	 * @throws FileNotFoundException
	 */
	public void setInputFilePath(String path) throws FileNotFoundException{
		File f = new File(path);
		if(!f.exists()) throw new FileNotFoundException();
		inputFilePath = path;
	}

	/**
	 * Returns the input method (console, csv file, database) as an enum
	 * @return The input method (console, csv file, database) as an enum
	 */
	public Utils.enumInputMethod getInputMethod(){
		return enumInputMethod;
	}

	/**
	 * Stores the input method.
	 * @param method The input method as an enum
	 */
	public void setInputMethod(Utils.enumInputMethod method){
		enumInputMethod = method;
	}

	/**
	 * Returns the output method (console, csv file, HTML file, XML file) as an enum
	 * @return The output method (console, csv file, HTML file, XML file) as an enum
	 */
	public Utils.enumOutputMethod getOutputMethod(){
		return enumOutputMethod;
	}

	/**
	 * Stores the output method.
	 * @param method The output method as an enum
	 */
	public void setOutputMethod(Utils.enumOutputMethod method){
		enumOutputMethod = method;
	}

	/**
	 * Returns the competition ID or name used to select the competition from the database
	 * @return The competition ID or name used to select the competition from the database
	 */
	public String getCompetitionIdOrName(){
		return competitionIdOrName;
	}

	/**
	 * Stores the competition ID or name used to select the competition from the database
	 * @param compIdOrName The competition ID or name used to select the competition from the database
	 */
	public void setCompetitionIdOrName(String compIdOrName){
		competitionIdOrName = compIdOrName;
	}

	/**
	 * Returns the output file path provided by the command line
	 * @return The output file path provided by the command line
	 */
	public String getOutputFilePath(){
		return outputFilePath;
	}

	/**
	 * Stores the output file path provided by command line
	 * @param s The output file path
	 */
	public void setOutputFilePath(String s){
		outputFilePath = s;
	}
}
