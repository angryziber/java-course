package net.azib.java.students.t050545.homework;

import java.util.List;
import java.util.Stack;

/**
 * ArgumentParser
 *
 * @author libricon
 */
public interface ArgumentParser {
	/**
	 * setup function
	 * @param argument next console parametr
	 */
	void init(Stack<String> arguments) throws LoadException;
		
	/**
	 *  Argument for command line 
	 */
	String getArgum();
	
	/**
	 *  Description  for -help argument
	 */
	String getDescription();
}
