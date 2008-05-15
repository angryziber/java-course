package net.azib.java.students.t040719.homework.io;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * OutputMethod - enum for holding different data output methods
 *
 * @version 1.0
 * @author Romi Agar
 */
public enum OutputMethod {
	K("Console", ConsoleOutput.class),
	C("CSV file", FileOutput.class),
	X("XML file", FileOutput.class),
	H("HTML file", FileOutput.class);
	
	private static final Logger LOG = Logger.getLogger(OutputMethod.class.getSimpleName());			
	
	private final String source;
	private final Class<? extends DataOutput> outputClass;
	
	OutputMethod(String src, Class<? extends DataOutput> clazz){
		source = src;
		outputClass = clazz;
	}
	
	public String getOutputName(){
		return source;
	}
	
	public DataOutput getOutput() {
		try {
			return outputClass.newInstance();
		}
		catch (Exception e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Technical error, unable to instantiate " + outputClass.getName(),e);
			else
				LOG.log(Level.SEVERE, "Technical error, unable to instantiate " + outputClass.getName());
			System.exit(2);
		}
		return null;
	}
}
