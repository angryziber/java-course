package net.azib.java.students.t001370.homework;


import java.io.PrintStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonCalculator
 * Collects data from input and route's it the output.
 * @author maksim
 */
public class DecathlonCalculator {
	private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class.getName());

	private IOMethod inputMethod;
	private IOMethod outputMethod;
	private final PrintStream output;

	/**
	 * DecathlonCalculator constructor. 
	 * Set the input and output methods
	 * @param input - IOMethod. Input method to use for reading decathlon data
	 * @param output - IOMethod. Output method to write decathlon data to
	 */
	DecathlonCalculator(IOMethod input, IOMethod output){
		this.inputMethod = input;
		this.outputMethod = output;
		this.output = System.out;
	}
	
	/**
	 * DecathlonCalculator constructor. 
	 * Set the input and output methods, and print stream
	 * @param input - IOMethod. Input method to use for reading decathlon data
	 * @param output - IOMethod. Output method to write decathlon data to
	 * @param out - PrintStream. Mostly for testing purpose
	 */
	public DecathlonCalculator(IOMethod input, IOMethod output, PrintStream out){
		this.inputMethod = input;
		this.outputMethod = output;
		this.output = out;
	}

	
	/**
	 * Calculate decathlon data according to input data and write processed 
	 * data to given output.
	 * The input and output are set by calling class constructor.
	 */
	public void calculate(){
		LOG.log(Level.INFO, "Calcutator entered");
		
		//check if io methods are available
		if (inputMethod != null && outputMethod != null){
			
			Collection<Athlete> compResults = null;
			
			try {
				//get competition results
				compResults = new DecathlonDataReader(inputMethod).getData();
				
				if (compResults != null) {
					//write competition results to appropriate output
					new DecathlonDataWriter(outputMethod, compResults).writeData();
				}
				else{
					output.println(Errors.ERROR_COULD_NOT_GET_DATA_FROM_INPUT.getErrorText());
				}
			}
			catch (DecathlonException e) {
				//in case some error occurred during reading or writing
				output.println(Errors.ERROR_WHILE_PROCESSING_DATA.getErrorText());
			}
			
		}
		else{
			output.println(Errors.ERROR_I_OR_O_METHOD_NOT_SET.getErrorText());
		}
		
		LOG.log(Level.INFO, "Calcutator exited");
	}
}
