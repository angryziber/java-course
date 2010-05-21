package net.azib.java.students.t092860.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class consisting DecathlonCalculator start method (main)
 */
public class DecathlonCalculator {
	
	private static Logger logger = Logger.getLogger("global");
	
	private static boolean validateArguments(String args[]) {
		boolean retValue = true;

		if (args.length >= 2 && args[0].equals("-console")) {
			input_method = args[0];
			if (args.length == 2 && args[1].equals("-console")) {
				output_method = args[1];
			}
			else if (args.length == 3 && (args[1].equals("-csv") || args[1].equals("-xml") || args[1].equals("-html"))) {
				output_method = args[1];
				output_parameter = args[2];
			}
			else
				retValue = false;
		}
		else if (args.length >= 3 && (args[0].equals("-csv") || args[0].equals("-db"))) {
			input_method = args[0];
			input_parameter = args[1];
			if (args.length == 3 && args[2].equals("-console")) {
				output_method = args[2];
			}
			else if (args.length == 4 && (args[2].equals("-csv") || args[2].equals("-xml") || args[2].equals("-html"))) {
				output_method = args[2];
				output_parameter = args[3];
			}
			else
				retValue = false;
		}
		else
			retValue = false;

		return retValue;
	}
	
	private static List<Input.Data> getInput() throws Exception {
		Input input;
		if (input_method.equals("-console")) {
			System.out.print("Insert decathlon results per athlete (press enter when done)\n");
			System.out.print("Example: \"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n");
			input = new InputFromConsole(System.in);
		}
		else if (input_method.equals("-csv"))
			input = new InputFromCSV(new FileInputStream(input_parameter));
		else if (input_method.equals("-db"))
			input = new InputFromDB(input_parameter);
		else
			return null;

		return input.get();
	}
	
	private static void setOutput(List<Output.Data> data) throws Exception {
		Output output;
		if (output_method.equals("-console"))
			output = new OutputToConsole(System.out);
		else if (output_method.equals("-csv"))
			output = new OutputToCSV(new FileOutputStream(output_parameter));
		else if (output_method.equals("-xml"))
			output = new OutputToXML(new FileOutputStream(output_parameter));
		else if (output_method.equals("-html"))
			output = new OutputToHTML(new FileOutputStream(output_parameter));
		else
			return;

		output.set(data);
	}
	
	/**
	 * main of Decathlon Calculator
	 * 
	 * @param  args as follows: -<input-method> [input-parameters] -<output-method> [output-parameters]
	 */
	public static void main(String[] args) {
		logger.setLevel(Level.OFF);

		// validate program arguments
		if (!validateArguments(args)) {
			System.out.println("Invalid use of arguments!\n");
			return;
		}
		logger.info("Input params validation passed");

		try {
			List<Input.Data> inputData = getInput();
			Calculator calculator = new Calculator();
			List<Output.Data> outputData = calculator.calcResults(inputData);
			setOutput(outputData);
		}
		catch (Exception e) {
			System.out.print(e.getMessage() + "\n");
		}

		System.out.print("Exit success");
	}
	
	private static String input_method;
	private static String input_parameter;
	private static String output_method;
	private static String output_parameter;
}
