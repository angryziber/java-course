package net.azib.java.students.t030633.homework;

import net.azib.java.students.t030633.homework.model.AddingCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder;
import net.azib.java.students.t030633.homework.model.DecathlonChecker;
import net.azib.java.students.t030633.homework.view.Input;
import net.azib.java.students.t030633.homework.view.InputMethod;
import net.azib.java.students.t030633.homework.view.Output;
import net.azib.java.students.t030633.homework.view.OutputMethod;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * DecathlonPointsCalculator
 * 
 * @author t030633
 */
public class DecathlonPointsCalculator {

	private Input input;
	private Output output;

	/**
	 * @param input -
	 *            decathlon input
	 * @param output -
	 *            decathlon output
	 */
	public DecathlonPointsCalculator(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	public static void main(String[] args) {
		// TODO do something with possible incorrect arguments
		// TODO help
		// Files.CSV_INPUT_FILENAME = args[2];
		// Files.XML_OUTPUT_FILENAME = args[3];
		// args[0], args[1]
		new DecathlonPointsCalculator(InputMethod.valueOf("CSV").getInput(), OutputMethod.valueOf("CONSOLE").getOutput())
				.calculate();
	}

	public void calculate() {

		List<Athlete> athletes;
		try {
			athletes = input.builder(new DecathlonAthleteBuilder(new DecathlonChecker(), new AddingCalculator())).read();
			Collections.sort(athletes);
			output.write(athletes);
		}
		catch (IOException e) {
			System.err.println("IO Error.");
		}

	}

}
