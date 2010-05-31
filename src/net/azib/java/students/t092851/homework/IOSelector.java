package net.azib.java.students.t092851.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * IOSelector
 *
 * @author Lauri
 */
public class IOSelector {
	
	private String           inputParameter;
	private String           outputParameter;
	private boolean          validIO;
	private DataInputMethod  dataInputMethod;
	private DataOutputMethod dataOutputMethod;
	
	private enum DataInputMethod {
		CONSOLE  { @Override public DecathlonDataInput getInput(String parameter) { return new DecathlonDataInputConsole();      } },
		CSV      { @Override public DecathlonDataInput getInput(String parameter) { return new DecathlonDataInputCSV(parameter); } },
		DATABASE { @Override public DecathlonDataInput getInput(String parameter) { return new DecathlonDataInputDB(parameter);  } };
		
		abstract public DecathlonDataInput getInput(String parameter); 
	}

	private enum DataOutputMethod {
		CONSOLE  { @Override public DecathlonDataOutput getOutput(String parameter) { return new DecathlonDataOutputConsole(); } },
		CSV      { @Override public DecathlonDataOutput getOutput(String parameter) { return new DecathlonDataOutputCSV(parameter); } },
		XML      { @Override public DecathlonDataOutput getOutput(String parameter) { return new DecathlonDataOutputXML(parameter); } },
		HTML     { @Override public DecathlonDataOutput getOutput(String parameter) { return new DecathlonDataOutputHTML(parameter); } };
		
		abstract public DecathlonDataOutput getOutput(String parameter); 
	}
	
	/**
	 * Initializes passive IOSelector object
	 */
	public IOSelector() {
		validIO = false;
	}
	
	/**
	 * Configures DecathlonCalculator data input/output
	 * @param args command line arguments
	 */
	public IOSelector(String[] args) {
		validIO = parseOptions(args);
	}
	
	/**
	 * Configures DecathlonCalculator data input/output
	 * @param args command line arguments
	 * @return true on success, false otherwise
	 */
	public boolean configureIO(String[] args) {
		validIO = parseOptions(args);
		return validIO;
	}

	
	/**
	 * Writes command line options description to System.out 
	 */
	public void printHelp() {
		System.out.println("Command line format:");		
		System.out.println("\t<program> -<input-method> [input-parameter] -<output-method> [output-parameter]");
		System.out.println("where:");
		System.out.println("\t<program> is 'java net.azib.java.students.t092851.homework.DecathlonCalculator'");
		System.out.println("\t-<input-method> is one of the follows:");
		System.out.println("\t\t-console - data is interactively entered from console; [input-parameter] is omitted");
		System.out.println("\t\t-db      - data is read from database; [input-parameter] is competition id or name");
		System.out.println("\t\t-csv     - data is read from CSV file; [input-parameter] is input file name");
		System.out.println("\t-<output-method> is one of the follows:");
		System.out.println("\t\t-console - output data is displayed in console; [output-parameter] is omitted");
		System.out.println("\t\t-csv     - data is written to CSV file; [output-parameter] is output file name");
		System.out.println("\t\t-xml     - data is written to XML file; [output-parameter] is output file name");
		System.out.println("\t\t-html    - data is written to HTML file; [output-parameter] is output file name");
	}


	/**
	 * @return true if command line options successfully read, false otherwise
	 */
	public boolean isValid() {
		return validIO;
	}


	/**
	 * @return object which reads decathlon data from selected source.
	 * 		null is returned if data input has not been configured.
	 */
	public DecathlonDataInput createDataInput() {
		if (validIO)			
			return dataInputMethod.getInput(inputParameter);
		
		return null;
	}


	/**
	 * @return object which writes decathlon data to selected destination
	 * 		null is returned if data output has not been configured.
	 */
	public DecathlonDataOutput createDataOutput() {
		if (validIO)
			return dataOutputMethod.getOutput(outputParameter);
		
		return null;
	}

	
	private boolean parseOptions(String[] args) {
		List<String>     list         = Arrays.asList(args); 
		Iterator<String> iterator     = list.iterator();
		String           inputMethod  = null;
		String           outputMethod = null;
		
		if (iterator.hasNext())
			inputMethod = iterator.next();
		else {
			System.out.println("-<input-method> is not specified.");
			return false;
		}
			
		try {		
			if (inputMethod.equals("-console")) {
				inputParameter  = null;
				dataInputMethod = DataInputMethod.CONSOLE;
			}
			else if (inputMethod.equals("-db")) {
				inputParameter  = iterator.next();
				dataInputMethod = DataInputMethod.DATABASE;
			}
			else if  (inputMethod.equals("-csv")) {
				inputParameter  = iterator.next();
				dataInputMethod = DataInputMethod.CSV;
			}
			else {
				System.out.println("-<input-method> \"" + inputMethod + "\" is not a reqonized option.");
				return false;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("[input-parameter] is not specified.");
			return false;
		}
			
		if (iterator.hasNext())
			outputMethod = iterator.next();
		else {
			System.out.println("[input-parameter] or -<output-method> is not specified.");
			return false;
		}
		
		try {
			if (outputMethod.equals("-console")) {
				outputParameter  = null;
				dataOutputMethod = DataOutputMethod.CONSOLE;
			}
			else if  (outputMethod.equals("-csv")) {
				outputParameter  = iterator.next();
				dataOutputMethod = DataOutputMethod.CSV;
			}
			else if (outputMethod.equals("-xml")) {
				outputParameter  = iterator.next();
				dataOutputMethod = DataOutputMethod.XML;
			}
			else if (outputMethod.equals("-html")) {
				outputParameter  = iterator.next();
				dataOutputMethod = DataOutputMethod.HTML;
			}
			else {
				System.out.println("-<output-method> \"" + outputMethod + "\" is not a reqonized option.");
				return false;
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("[output-parameter] is not specified.");
			return false;
		}
			
		if (iterator.hasNext()) {
			System.out.println("Warning: there are redundant command line option(s) (starting from \"" + iterator.next() + "\")");
		}
		
		return true;		
	}
	
}
