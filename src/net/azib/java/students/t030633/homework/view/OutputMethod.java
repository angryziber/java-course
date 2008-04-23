package net.azib.java.students.t030633.homework.view;

import net.azib.java.students.t030633.homework.view.out.Console;
import net.azib.java.students.t030633.homework.view.out.XML;

/**
 * Decathlon output method - all possible output methods and classes that
 * implement them.
 * 
 * @author t030633
 */
public enum OutputMethod {

	CONSOLE(Console.class), CSV(null), XML(XML.class), HTML(null);

	private final Class<? extends Output> outputClass;

	private OutputMethod(Class<? extends Output> clazz) {
		this.outputClass = clazz;
	}

	/**
	 * @return instance of a class that implements Output
	 */
	public Output getOutput() {
		try {
			return outputClass.newInstance();
		}
		catch (Exception e) {
			System.err.println("Unable to instantiate " + outputClass.getName());
			return null;
		}
	}

}
