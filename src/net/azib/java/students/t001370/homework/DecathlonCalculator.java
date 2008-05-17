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
		
		if (inputMethod != null && outputMethod != null){
			Collection<Athlete> compResults = new DecathlonDataReader(inputMethod).getData();
			
			if (compResults != null) {
				new DecathlonDataWriter(outputMethod, compResults).writeData();
			}
			else
			{
				output.println(Errors.ERROR_0011.getErrorText());
			}
		}
		else{
			output.println(Errors.ERROR_0028.getErrorText());
		}
		
		LOG.log(Level.INFO, "Calcutator exited");
	}
}
