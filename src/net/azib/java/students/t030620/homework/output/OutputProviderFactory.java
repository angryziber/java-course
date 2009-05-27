package net.azib.java.students.t030620.homework.output;

import java.util.Properties;


/**
 * OutputProviderFactory
 *
 * @author Lord HellBunny
 */
public class OutputProviderFactory {
	
	public static OutputProvider getOutputProvider(OutputType type, Properties props) throws Exception{
		
		switch(type) {
			case CONSOLE: return new ConsoleOutputProvider();
			case CSV:	  return new CSVOutputProvider();
			case XML:	  return new XMLOutputProvider();
			case HTML:	  return new HTMLOutputProvider(props);
			      
		}
		
		return null;
		
	}

}
