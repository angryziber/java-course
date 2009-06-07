package net.azib.java.students.t050545.homework.utils;


import java.util.Stack;

/**
 * ArgumentParser
 *
 * @author libricon
 */
public interface ArgumentParser {
	/**
	 * setup function, initialise loader or writer and cut's arguments
	 * @param arguments console unused paramenters
	 * @throws LoadException 
	 */
	void init(Stack<String> arguments) throws LoadException;
		
	/**  Argument for command line */
	public String getArgum();
	
	/** Description  for -h argument */
	public String getDescription();
}
