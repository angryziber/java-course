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
	 * @param arguments console unused parameters
	 * @throws LoadException 
	 */
	void init(Stack<String> arguments) throws LoadException;
		
	/**  @return argument with prefix */
	public String getArgum();
	
	/** @return short description*/
	public String getDescription();
}
