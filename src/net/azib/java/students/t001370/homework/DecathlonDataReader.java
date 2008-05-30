package net.azib.java.students.t001370.homework;


import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonDataReader
 * Gets decathlon competition data from appropriate input
 *
 * @author maksim
 */
public class DecathlonDataReader {
	private static final Logger LOG = Logger.getLogger(DecathlonDataReader.class.getName());
	
	private IOMethod inputSource;
	private final PrintStream output;

	
	/**
	 * DecathlonDataReader constructor
	 * @param inMethod - IO method from where the data will be read
	 */
	DecathlonDataReader(IOMethod inMethod){
		LOG.log(Level.INFO, "DecathlonDataReader created");
		
		this.inputSource = inMethod;
		this.output = System.out;
	}

	/**
	 * DecathlonDataReader constructor
	 * @param inMethod - IO method
	 * @param out - ui output stream
	 * @param in - ui input stream
	 */
	DecathlonDataReader(IOMethod inMethod, PrintStream out, Scanner in){
		LOG.log(Level.INFO, "DecathlonDataReader (extended) created");

		this.inputSource = inMethod;
		this.output = out;
	}
	
	/**
	 * Gets valid input for given IO method. 
	 * @param inMethod - input channel
	 * @return Decathlon data input channel 
	 * @throws Exception - In case the input method is not valid
	 */
	private DecathlonInput getSource(IOMethod inMethod) throws Exception{
		
		DecathlonInput dataSource = null;
		
		switch (inMethod) {
		
			case CONSOLE_INPUT:
				dataSource = new DecathlonInputConsole();
			break;
			
			case CSV_INPUT:
				dataSource = new DecathlonInputCSV();
			break;
			
			case DB_INPUT:
				dataSource = new DecathlonInputDB();
			break;
	
			default:
				throw new Exception(Errors.ERROR_INPUT_METHOD_NOT_VALID.getErrorText() + inputSource.name());
		}
		
		return dataSource;
	}
	
	/**
	 * Get athletes data from input specified by calling class constructor
	 * @return Collection of athletes
	 * @throws DecathlonException throws if data could not be read from input
	 */
	public Collection<Athlete> getData() throws DecathlonException{
		LOG.log(Level.INFO, "getData entered");
		
		Collection<Athlete> competitionResults = null;
		
		
		try {
			DecathlonInput resultSource = getSource(inputSource);
			
			competitionResults = resultSource.getData(inputSource.getIOArgument());
		}
		catch (Exception e) {
			output.println(Errors.ERROR_COULD_NOT_GET_DATA_FROM_INPUT.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_COULD_NOT_GET_DATA_FROM_INPUT.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			
			throw new DecathlonException();
		}
		
		return competitionResults;
	}
}
