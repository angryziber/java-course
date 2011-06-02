package net.azib.java.students.t100228.Homework;

/**
 * Handles extracting program options from the command line
 * @author Martin
 */
public class CommandLineParser {

	InputOutputParams inputOutputParams;
	boolean hasValidArguments = true;

	/**
	 * Constructor. Does the command line parsing
	 * @param args is the command line arguments of the program
	 */
	public CommandLineParser(String[] args){
		inputOutputParams = new InputOutputParams();
		if(args.length < 2)
		{
			hasValidArguments = false;
			return;
		}

		try
		{
			for(int i = 0; i < args.length; i++)
			{
				if(i == 0)
				{
					if(args[i].equals("-console"))
					{
						inputOutputParams.setInputMethod(Utils.enumInputMethod.INPUT_METHOD_CONSOLE);
					}

					else if(args[i].equals("-db"))
					{
						inputOutputParams.setInputMethod(Utils.enumInputMethod.INPUT_METHOD_DB);
						inputOutputParams.setCompetitionIdOrName(args[1]);
					}

					else if(args[i].equals("-csv"))
					{
						inputOutputParams.setInputMethod(Utils.enumInputMethod.INPUT_METHOD_CSV);
						inputOutputParams.setInputFilePath(args[1]);
					}
					else
					{
						hasValidArguments = false;
					}
				}
				else
				{
					if(args[i].equals("-console"))
					{
						inputOutputParams.setOutputMethod(Utils.enumOutputMethod.OUTPUT_METHOD_CONSOLE);
					}

					else if(args[i].equals("-csv"))
					{
						inputOutputParams.setOutputMethod(Utils.enumOutputMethod.OUTPUT_METHOD_CSV);
						inputOutputParams.setOutputFilePath(args[i + 1]);
					}

					else if(args[i].equals("-html"))
					{
						inputOutputParams.setOutputMethod(Utils.enumOutputMethod.OUTPUT_METHOD_HTML);
						inputOutputParams.setOutputFilePath(args[i + 1]);
					}

					else if(args[i].equals("-xml"))
					{
						inputOutputParams.setOutputMethod(Utils.enumOutputMethod.OUTPUT_METHOD_XML);
						inputOutputParams.setOutputFilePath(args[i + 1]);
					}
				}
			}
		}
		catch (Exception ex)
		{
			hasValidArguments = false;
		}
	}

	/**
	 * Indicates if the supplied command line arguments were valid
	 * @return Boolean value of the arguments were valid
	 */
	public boolean hasValidArguments()
	{
		return hasValidArguments;
	}

	/**
	 * Returns the {@link InputOutputParams} instance generated from the command line parameters
	 * @return The {@link InputOutputParams} instance generated from the command line parameters
	 */
	public InputOutputParams getInputOutputParams()
	{
		return inputOutputParams;
	}
}
