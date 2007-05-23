package net.azib.java.students.t050657.homework.src.model;

/**
 * InsufficientResultsException class 
 * 
 * @author Boriss
 */
public class InsufficientResultsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	InsufficientResultsException(String msg){
		super(msg);
	}
	
	InsufficientResultsException(){
		super();
	}
}
