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
	 * Writes data to the specified source (by calling class constructor)
	 */
	public void writeData(){
		LOG.log(Level.INFO, "writeData entered");

		DecathlonOutput destination = null;
		
		try {
			switch (outputSource) {
				
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
					output.println(Errors.ERROR_0007.getErrorText() + outputSource.name());
					
					LOG.log(Level.INFO, Errors.ERROR_0007.getErrorText() + outputSource.name());
					System.exit(1);
				break;
			}
			
			destination.writeData(this.athletes, 
					(outputSource.getIOArgument() != null) ? new File(outputSource.getIOArgument()) : null);
		}
		catch (Exception e) {
			output.println(Errors.ERROR_0003.getErrorText() + outputSource.name());
			
			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}

		output.println("Everithing is done!");
	}
}
