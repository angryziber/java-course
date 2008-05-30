package net.azib.java.students.t001370.homework;

/**
 * DecathlonException
 * is thrown if some error occurs during decathlon data process 
 * @author maksim
 */
public class DecathlonException extends Exception {

	/**
	 * Default constructor
	 */
	public DecathlonException(){
	}
	
	/**
	 * Constructor
	 * @param s - the detail message 
	 */
	public DecathlonException(String s){
		super(s);
	}
}
