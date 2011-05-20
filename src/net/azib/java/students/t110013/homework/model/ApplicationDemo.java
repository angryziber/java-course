package net.azib.java.students.t110013.homework.model;

/**
 * A simple class with one method - main. The class serves two purposes: (1) to demonstrate the Decathlon application,
 * and (2) to provide quick access to the starting method of the application.
 * @author Vadim
 */
public class ApplicationDemo {

	/**
	 * Starts the application.
	 * Usage: program -input-method [input-parameters] -output-method [output-parameters].
	 * Example: -console -xml results.xml
	 *
	 * @param args input and output method and their parameters
	 */
    public static void main(String[] args) {
        new Application().run(args);
    }
}
