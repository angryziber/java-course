package net.azib.java.students.t030620.homework.input;

import java.util.Properties;

/**
 * InputProviderFactory
 *
 * @author Maksim Konstantinov 030620
 */
public class InputProviderFactory {
	
	/**
	 * @param type the input type for desired provider
	 * @param props input type specific properties
	 * @return InputProvider instance capable of processing the application input 
	 * @throws Exception
	 */
	public static InputProvider getInputProvider(InputType type, Properties props) throws Exception{
		
		switch(type) {
			case CONSOLE: return new ConsoleInputProvider();
			case CSV:	  return new CSVInputProvider();
			case DB:	  return new DBInputProvider(props);
		}
		return null;
	}

}
