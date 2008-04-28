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

	private static final String ERROR = "Error:";

	private static final String HELP_MSG;

	private static final String LN = System.getProperty("line.separator");

	static {
		StringBuilder sb = new StringBuilder();
		sb.append("Decathlon points calculator by 030633").append(LN).append("usage: ").append(
				DecathlonPointsCalculator.class.getSimpleName()).append(" input output").append(LN);
		sb.append(" possible inputs: ");
		for (InputMethod im : InputMethod.values()) {
			sb.append(im.name()).append(" ");
		}
		sb.append(LN).append(" possible outputs: ");
		for (OutputMethod om : OutputMethod.values()) {
			sb.append(om.name()).append(" ");
		}
		sb.append(LN).append(" file format: athletes.[in|out].[csv|xml|html]");
		HELP_MSG = sb.toString();
	}

	public static void main(String[] args) {
		try {
			new DecathlonPointsCalculator().run(args);
		}
		catch (RuntimeException e) {
			System.out.println(HELP_MSG);
		}
	}

	private void run(String[] args) {
		Input input = null;
		Output output = null;
		try {
			input = InputMethod.valueOf("CSV").getInput();
			output = OutputMethod.valueOf("CONSOLE").getOutput();
			calculate(input, output);
		}
		catch (IOException e) {
			System.out.println(ERROR);
			System.out.println(e.getMessage());
		}
		finally {
			try {
				input.close();
				output.close();
			}
			catch (IOException e) { // close quietly
			}
		}

	}

	public void calculate(Input input, Output output) throws IOException {
		List<Athlete> athletes;
		athletes = input.builder(new DecathlonAthleteBuilder(new DecathlonChecker(), new AddingCalculator())).read();
		Collections.sort(athletes);
		output.write(athletes);
	}

}
