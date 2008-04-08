package net.azib.java.students.t030633.homework;

import net.azib.java.students.t030633.homework.Model.Athlete;
import net.azib.java.students.t030633.homework.View.*;

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
		//TODO do something with possible incorrect arguments
		new DecathlonPointsCalculator(InputMethod.valueOf(in).getInput(), OutputMethod.valueOf(out).getOutput()).calculate();
	}

	public void calculate() {

		List<Athlete> athletes;
		try {
			athletes = input.read();
			Collections.sort(athletes);
			output.write(athletes);
		}
		catch (IOException e) {
			System.err.println("IO Error");
		}

	}

}
