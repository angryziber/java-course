package net.azib.java.students.t040719.homework.io;


/**
 * OutputMethod - enum for holding different data output methods
 *
 * @version 1.0
 * @author Romi Agar
 */
public enum OutputMethod {
	K("Console", ConsoleOutput.class),
	C("CSV file", FileOutput.class),
	X("XML file", XMLOutput.class),
	H("HTML file", FileOutput.class);
	
	private final String source;
	private final Class<? extends DataOutput> outputClass;
	
	OutputMethod(String src, Class<? extends DataOutput> clazz){
		source = src;
		outputClass = clazz;
	}
	
	public String getSource(){
		return source;
	}
	
	public DataOutput getOutput() {
		try {
			return outputClass.newInstance();
		}
		catch (Exception e) {
			System.err.println("Technical error, unable to instantiate " + outputClass.getName());
			return null;
		}
	}
}
