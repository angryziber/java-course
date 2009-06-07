package net.azib.java.students.t050545.homework;

import java.util.List;

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
	void init(List<String> arguments) throws LoadException;
		
	/**
	 *  Argument for command line 
	 */
	String getArgum();
	
	/**
	 *  Description  for -help argument
	 */
	String getDescription();
}
