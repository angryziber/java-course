package net.azib.java.students.t001370.homework;


import java.io.File;
import java.io.PrintStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * DecathlonDataWriter
 * Handles writing competition data to the appropriate output
 * @author maksim
 */
public class DecathlonDataWriter {
	private static final Logger LOG = Logger.getLogger(DecathlonDataWriter.class.getName());
	
	private final IOMethod outputSource;
	private final Collection<Athlete> athletes;
	private final PrintStream output;

	/**
	 * DecathlonDataWriter constructor
	 * @param outputSource - IO method
	 * @param athletes - Collection of athletes
	 */
	DecathlonDataWriter(IOMethod outputSource, Collection<Athlete> athletes){
		LOG.log(Level.INFO, "DecathlonDataWriter created");

		this.outputSource = outputSource;
		this.athletes = athletes;
		
		this.output = System.out;
	}
	
	/**
	 * DecathlonDataWriter constructor
	 * @param outputSource - IO method
	 * @param athletes - Collection of athletes
	 * @param output - output stream
	 */
	DecathlonDataWriter(IOMethod outputSource, Collection<Athlete> athletes, PrintStream output){
		LOG.log(Level.INFO, "DecathlonDataWriter created");

		this.outputSource = outputSource;
		this.athletes = athletes;
		this.output= output;
	}

	/**
	 * Gets valid output for given IO method. In case the output method is not valid throws exception
	 * @param method - output channel
	 * @return Decathlon output channel
	 * @throws Exception
	 */
	private DecathlonOutput getDecathlonOutput(IOMethod method) throws Exception{
		
		DecathlonOutput destination = null;
		
		switch (method) {
		
			case CONSOLE_OUTPUT:
				destination = new DecathlonOutputConsole();
			break;
			
			case CSV_OUTPUT:
				destination = new DecathlonOutputCSV();
			break;
			
			case XML_OUTPUT:
				destination = new DecathlonOutputXML();
			break;
			
			case HTML_OUTPUT:
				destination = new DecathlonOutputHTML();
			break;
	
			default:
				throw new Exception(Errors.ERROR_OUTPUT_METHOD_NOT_VALID.getErrorText());
		}
	
		return destination;
	}

	/**
	 * Writes data to the specified source (by calling class constructor)
	 * @throws DecathlonException throws if data could not be written
	 */
	public void writeData() throws DecathlonException{
		LOG.log(Level.INFO, "writeData entered");
		
		try {
			DecathlonOutput destination = getDecathlonOutput(outputSource);
			
			//write data to output
			//if output method needs parameter then it is file path
			destination.writeData(this.athletes, 
					(outputSource.getIOArgument() != null) ? new File(outputSource.getIOArgument()) : null);
		}
		catch (Exception e) {
			output.println(Errors.ERROR_COULD_NOT_WRITE_DATA_TO.getErrorText() + outputSource.name());
			
			LOG.log(Level.INFO, e.getMessage());
			throw new DecathlonException();
		}

		output.println("Everithing is done!");
	}
}
