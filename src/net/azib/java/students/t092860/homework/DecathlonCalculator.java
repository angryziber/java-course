package net.azib.java.students.t092860.homework;

/**
 * Program
 *
 * @author scythe
 */

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class DecathlonCalculator {
	
	private static Logger logger = Logger.getLogger("global");
	
	private static boolean validateArguments(String args[])
	{
		boolean retValue = true;
		
		if(args.length >= 2 && args[0].equals("-console"))
		{
			input_method = args[0];
			if(args.length == 2 && args[1].equals("-console")) 
			{
				output_method = args[1];
			}
			else if(args.length == 3 && 
					(args[1].equals("-csv") || 
					args[1].equals("-xml") || 
					args[1].equals("-html")))
			{
				output_method = args[1];
				output_parameter = args[2];
			}
			else
				retValue = false;
		}
		else if(args.length >= 3 &&
				(args[0].equals("-csv") || 
				args[0].equals("-db")))
		{
			input_method = args[0];
			input_parameter = args[1];
			if(args.length == 3 && args[2].equals("-console")) 
			{
				output_method = args[2];
			}
			else if(args.length == 4 && 
					(args[2].equals("-csv") || 
					args[2].equals("-xml") || 
					args[2].equals("-html")))
			{
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
	
	private static List<Input.Data> getInput() throws Exception
	{
		Input input;
		if (input_method.equals("-console"))
			input = new InputFromConsole();
		else if (input_method.equals( "-csv"))
			input = new InputFromCSV(new File(input_parameter));
	    else if (input_method.equals("-db"))
	    	input = new InputFromDB(input_parameter);
	    else
	    	return null;
		
		return input.get();
	}
	
	private static void setOutput(List<Output.Data> data) throws Exception
	{
		Output output;
		if (output_method.equals("-console"))
			output = new OutputToConsole();
		else if (output_method.equals( "-csv"))
			output = new OutputToCSV(new File(output_parameter));
	    else if (output_method.equals("-xml"))
	    	output = new OutputToXML(new File(output_parameter));
	    else if (output_method.equals("-html"))
	    	output = new OutputToHTML(new File(output_parameter));
	    else
	    	return;
		
		output.set(data);
	}
	
	/**
	 * @param args 
	 */	
	public static void main(String[] args)
	{
		logger.setLevel(Level.OFF);
		
		//validate program arguments
		if(!validateArguments(args))
		{
			System.out.println("Invalid use of arguments!\n");
			return;
		}
		logger.info("Input params validation passed");
		
		try
		{
			List<Input.Data> inputData = getInput();
			Calculator calculator = new Calculator();
			List<Output.Data> outputData = calculator.calcResults(inputData);
			setOutput(outputData);
		}
		catch (Exception e) {
			System.out.print(e.getMessage()+"\n");
		}
		
		System.out.print("Exit success");
	}
	
	private static String input_method;
	private static String input_parameter;
	private static String output_method;
	private static String output_parameter;
}
