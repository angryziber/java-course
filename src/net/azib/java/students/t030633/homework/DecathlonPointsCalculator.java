package net.azib.java.students.t030633.homework;

import net.azib.java.students.t030633.homework.model.AddingCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder;
import net.azib.java.students.t030633.homework.model.DecathlonChecker;
import net.azib.java.students.t030633.homework.view.Input;
import net.azib.java.students.t030633.homework.view.InputMethod;
import net.azib.java.students.t030633.homework.view.Output;
import net.azib.java.students.t030633.homework.view.OutputMethod;
import net.azib.java.students.t030633.homework.view.in.CSV;
import net.azib.java.students.t030633.homework.view.out.Console;

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

	public static void main(String in, String out) {
		// TODO do something with possible incorrect arguments
		new DecathlonPointsCalculator(InputMethod.valueOf(in).getInput(), 
				OutputMethod.valueOf(out).getOutput()).calculate();
	}

	public static void main(String[] args) {
		// TODO this is a test main
		new DecathlonPointsCalculator(new CSV(), new Console()).calculate();
	}

	public void calculate() {

		List<Athlete> athletes;
		try {
			athletes = input.builder(new DecathlonAthleteBuilder(new DecathlonChecker(), 
					new AddingCalculator())).read();
			Collections.sort(athletes);
			output.write(athletes);
		}
		catch (IOException e) {
			System.err.println("IO Error");
		}

	}

}
