package net.azib.java.students.t050720.homework;

/**
 * <b>OutputFactory</b>
 * 
 * Creates the appropriate type of output object.
 *
 * @author Marek
 */
public class OutputFactory {
	
	/**
	 * Creates and returns the requested type of output object.
	 * 
	 * @param type is the output type. Possible output object types are -console, -html, -xml and -csv. The default is -console.
	 * @param parameters is the configuration parameter for the output object. For -console
	 * not needed, for others mandatory.
	 * @return output object of the requested type.
	 */
	public Output getOutputPlugin(String type, String parameters)
	{
		if(type.equals("-console")) return new ConsoleOutput();
		else if(type.equals("-csv")) return new CSVOutput(parameters);
		else if(type.equals("-xml")) return new XMLOutput(parameters);
		else if(type.equals("-html")) return new HTMLOutput(parameters);
		else return new ConsoleOutput();
	}

}
