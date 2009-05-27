package net.azib.java.students.t030620.homework.input;

import java.util.Properties;

/**
 * InputProviderFactory
 *
 * @author Lord HellBunny
 */
public class InputProviderFactory {
	
	public static InputProvider getInputProvider(InputType type, Properties props) throws Exception{
		
		switch(type) {
			case CONSOLE: return new ConsoleInputProvider();
			case CSV:	  return new CSVInputProvider();
			case DB:	  return new DBInputProvider(props);
		}
		return null;
	}

}
