package net.azib.java.students.t040719.homework.io;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * InputMethod - enum for holding different data input methods
 *
 * @version 1.0
 * @author Romi Agar
 */
public enum InputMethod {
	K("Console", ConsoleInput.class),
	C("CSV file", FileInput.class),
	D("SQL database", DatabaseInput.class);
	
	private static final Logger LOG = Logger.getLogger(InputMethod.class.getSimpleName());			

	private final String source;
	private final Class<? extends DataInput> inputClass;
	
	InputMethod(String src, Class<? extends DataInput> clazz){
		source = src;
		inputClass = clazz;
	}
	
	/**
	 * @return returns the input source name
	 */
	public String getInputName(){
		return source;
	}
	
	/**
	 * @return returns an instance of input class
	 */
	public DataInput getInput() {
		try {
			return inputClass.newInstance();
		}
		catch (Exception e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Technical error, unable to instantiate " + inputClass.getName(),e);
			else
				LOG.log(Level.SEVERE, "Technical error, unable to instantiate " + inputClass.getName());
			System.exit(1);
		}
		return null;
	}
}
