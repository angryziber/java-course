package net.azib.java.students.t092860.homework;

/**
 * Class to validate and store arguments
 * 
 */
public class ArgumentHandler {

	/**
	 * Constructor
	 * 
	 * @param  args list of arguments to be handled
	 * @throws Exception if any of the arguments is invalid
	 */
	public ArgumentHandler(String[] args) throws Exception {
		boolean retValue = true;

		if (args.length >= 2 && args[0].equals("-console")) {
			this.input_method = args[0];
			if (args.length >= 2 && args[1].equals("-console")) {
				this.output_method = args[1];
			}
			else if (args.length >= 3 && (args[1].equals("-csv") || args[1].equals("-xml") || args[1].equals("-html"))) {
				this.output_method = args[1];
				this.output_parameter = args[2];
			}
			else
				retValue = false;
		}
		else if (args.length >= 3 && (args[0].equals("-csv") || args[0].equals("-db"))) {
			this.input_method = args[0];
			this.input_parameter = args[1];
			if (args.length == 3 && args[2].equals("-console")) {
				this.output_method = args[2];
			}
			else if (args.length >= 4 && (args[2].equals("-csv") || args[2].equals("-xml") || args[2].equals("-html"))) {
				this.output_method = args[2];
				this.output_parameter = args[3];
			}
			else
				retValue = false;
		}
		else
			retValue = false;

		if (retValue == false)
			throw new Exception("Invalid use of arguments");
	}
	
	/**
	 * Gets input method from arguments parsed
	 * 
	 * @return  input method
	 */
	public String GetInputMethod(){
		return this.input_method;
	}
	
	/**
	 * Gets input parameter from arguments parsed
	 * 
	 * @return  input parameter
	 */
	public String GetInputParam(){
		return this.input_parameter;
	}
	
	/**
	 * Gets output method from arguments parsed
	 * 
	 * @return  output method
	 */
	public String GetOutputMethod(){
		return this.output_method;
	}
	
	/**
	 * Gets output parameter from arguments parsed
	 * 
	 * @return  output parameter
	 */
	public String GetOutputParam(){
		return this.output_parameter;
	}
	
	private String input_method;
	private String input_parameter;
	private String output_method;
	private String output_parameter;
}
