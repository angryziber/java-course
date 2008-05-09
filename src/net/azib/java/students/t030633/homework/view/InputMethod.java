package net.azib.java.students.t030633.homework.view;

import net.azib.java.students.t030633.homework.view.in.CSV;
import net.azib.java.students.t030633.homework.view.in.Console;
import net.azib.java.students.t030633.homework.view.in.Database;

/**
 * Decathlon input method - all possible input methods and classes that
 * implement them. Handles instantiation errors.
 * 
 * @author t030633
 */
public enum InputMethod {

	CONSOLE(Console.class), CSV(CSV.class), DB(Database.class);

	private final Class<? extends Input> inputClass;

	private InputMethod(Class<? extends Input> clazz) {
		this.inputClass = clazz;
	}

	/**
	 * @return instance of a class that implements Input, return null if unable to instantiate
	 */
	public Input getInput() {
		try {
			return inputClass.newInstance();
		}
		catch (Exception e) {
			System.err.println(inputClass.getSimpleName() + " instantiation error. " + e.getMessage());
			return null;
		}
	}

}
