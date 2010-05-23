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
	
	private static List<Input.Data> getInput() throws Exception {
		Input input;
		if (argumentHandler.GetInputMethod().equals("-console")) {
			System.out.print("Insert decathlon results per athlete (press enter when done)\n");
			System.out.print("Example: \"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n");
			input = new InputFromStream(System.in);
		}
		else if (argumentHandler.GetInputMethod().equals("-csv"))
			input = new InputFromStream(new FileInputStream(argumentHandler.GetInputParam()));
		else if (argumentHandler.GetInputMethod().equals("-db"))
			input = new InputFromDB(argumentHandler.GetInputParam());
		else
			return null;

		return input.get();
	}
	
	private static void setOutput(List<Output.Data> data) throws Exception {
		Output output;
		if (argumentHandler.GetOutputMethod().equals("-console"))
			output = new OutputToStream(System.out);
		else if (argumentHandler.GetOutputMethod().equals("-csv"))
			output = new OutputToStream(new FileOutputStream(argumentHandler.GetOutputParam()));
		else if (argumentHandler.GetOutputMethod().equals("-xml"))
			output = new OutputToXML(new FileOutputStream(argumentHandler.GetOutputParam()));
		else if (argumentHandler.GetOutputMethod().equals("-html"))
			output = new OutputToHTML(new FileOutputStream(argumentHandler.GetOutputParam()));
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

		try {
			argumentHandler = new ArgumentHandler(args);
			logger.info("Input params validation passed");
			
			List<Input.Data> inputData = getInput();
			Calculator calculator = new Calculator();
			List<Output.Data> outputData = calculator.calcResults(inputData);
			setOutput(outputData);
		}
		catch (Exception e) {
			System.out.print(e.getMessage() + "\n");
		}
	}
	
	static private ArgumentHandler argumentHandler;
}
