package net.azib.java.students.t030620.homework.output;

import java.util.Properties;


/**
 * OutputProviderFactory
 *
 * @author Maksim Konstantinov 030620
 */
public class OutputProviderFactory {
	
	/**
	 * @param type type the output type for desired provider
	 * @param props output type type specific properties
	 * @return InputProvider instance capable of processing the application output
	 * @throws Exception
	 */
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
