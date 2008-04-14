package net.azib.java.students.t030633.homework.view;

/**
 * Decathlon input method - all possible input methods and classes that implement them.
 * 
 * @author t030633
 */
public enum InputMethod {

	KEYBOARD(null), CSV(null), DATABASE(null);

	private final Class<? extends Input> inputClass;

	InputMethod(Class<? extends Input> clazz) {
		this.inputClass = clazz;
	}

	/**
	 * @return instance of a class that implements Input
	 */
	public Input getInput() {
		try {
			return inputClass.newInstance();
		}
		catch (Exception e) {
			System.err.println("Unable to instantiate " + inputClass.getName());
			return null;
		}
	}

}
