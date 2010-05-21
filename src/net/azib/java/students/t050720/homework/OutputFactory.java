package net.azib.java.students.t050720.homework;

/**
 * OutputFactory
 *
 * @author Marek
 */
public class OutputFactory {
	
	public Output getOutputPlugin(String type, String parameters)
	{
		if(type.equals("-console")) return new ConsoleOutput();
		else if(type.equals("-csv")) return new CSVOutput(parameters);
		else if(type.equals("-xml")) return new XMLOutput(parameters);
		else if(type.equals("-html")) return new HTMLOutput(parameters);
		else return new ConsoleOutput();
	}

}
