package net.azib.java.students.t092855.homework;

/**
 * DecathlonCalculator
 * The main module of the program
 * @author t092855
 */
public class DecathlonCalculator {

	/**
	 * The program starts to run from this method.
	 *
	 * @param args todo
	 */
	public static void main(String[] args) {
		InputStrategy inputStrategy;
		OutputStrategy outputStrategy;
		Competition competition;

		// todo choose input strategy from parameters and use it to create athlete list
		inputStrategy = new ConsoleInput();
		competition = inputStrategy.getData();

		// todo choose output strategy from parameters and use it
		outputStrategy = new ConsoleOutput();
		outputStrategy.writeOutput(competition);
	}
}
