package net.azib.java.students.t072073.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * DecathlonConstants
 *
 * @author janika
 * @description used for checking the program arguments
 */
public class DecathlonConstants {
	
	
	public static final String CONSOLE_INPUT_INSTRUCTIONS = "You should enter athlete's data and results in one row as follows:\n" +
		" name, date of birth, country (ISO code),\n 100 m sprint (seconds)," +
		"long jump (meters),\n shot put (meters), high jump (meters),\n " +
		"400 m sprint (min:sec), 110 m hurdles (seconds),\n discus throw (meters)," +
		"pole vault (meters),\n javelin throw (meters), 1500 m race (min:sec).\n" +
		"Separate all values with commas!\nExample:\n " +
		"Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59:39,16.43,21.60,2.60,35.81,5:25.72\n" +
		"Press enter and start typing. To exit write the word 'exit'.";
	
	public static final String CONSOLE = "-console";
	public static final String CSV = "-csv";
	public static final String DATABASE = "-db";
	public static final String XML = "-xml";
	public static final String HTML = "-html";
	
	public static Set <String> inputMethods(){
		String [] input_methods = {CSV, DATABASE};
		return new HashSet<String>(Arrays.asList(input_methods));
	}
	
	public static Set <String> outputMethods(){
		String [] output_methods = {CSV, XML, HTML};
		return new HashSet<String>(Arrays.asList(output_methods));
	}
	
	/**
	 * 
	 * @param argument
	 * @return if the argument is "-console"
	 */
	public static boolean isConsole(String argument){
		return (0 == CONSOLE.compareTo(argument));
	}	
	
	public static boolean isCsv(String argument){
		return (0 == CSV.compareTo(argument));
	}	
	
	public static boolean isDatabase(String argument){
		return (0 == DATABASE.compareTo(argument));
	}	
	
	public static boolean isXml(String argument){
		return (0 == XML.compareTo(argument));
	}	
	
	public static boolean isHtml(String argument){
		return (0 == HTML.compareTo(argument));
	}	
}
