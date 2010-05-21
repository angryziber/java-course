package net.azib.java.students.t050720.homework;

import java.io.FileNotFoundException;


/**
 * InputFactory
 *
 * @author Marek
 */
public class InputFactory {
	
	public Input getInputPlugin(String type, String parameters) throws Exception
	{
		if(type.equals("-console"))
		{
			return new ConsoleInput();
		}
		else if(type.equals("-csv"))
		{
			return new CSVInput(parameters);
		}
		else if(type.equals("-db" ))
		{
			return new DatabaseInput(parameters);
		}
		else return new ConsoleInput();
	}

}
