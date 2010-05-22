package net.azib.java.students.t050720.homework;



/**
 * <b>InputFactory</b></br>
 * 
 * Creates an appropriate input object.
 *
 * @author Marek
 */
public class InputFactory {
	
	/**
	 * Creates and returns the requested type of input object that gets created with the required parameter.
	 * @param type is the input object type, -csv, -db, -console, of which -console is the default.
	 * @param parameters is the parameter for the input object constructor. For -console, it is optional,
	 * otherwise mandatory.
	 * @return input object of the appropriate type.
	 * @throws Exception
	 */
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
