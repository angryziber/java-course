package net.azib.java.students.t980814.homework;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The main class of DecathlonCalculator program.
 * This class implements the main method and reads the command line parameters and parses them.
 * According to this information this class calls the constructors and output methods of
 * Competition class to input and output the results. 
 *
 * @author Allan Berg
 */
public class DecathlonCalculator {

	private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class.getName());
	final static String LN = System.getProperty("line.separator");

	private Competition competition;
	private DecaIOMethod ioMethod;
	
	/**
	 * Creates competition object, uses the stored <b>ioMethod</b> to determine from where to read
	 * the input data. If the data must be reed from database then reads the connection information
	 * from "db.properties" file and creates a connection.
	 * @param ioMethod 
	 * @throws DecaCalcException - if exception was thrown from Competition class or if it was
	 * impossible to create a connection to database or if the "db.properties" file was inaccessible 
	 */
	public DecathlonCalculator(DecaIOMethod ioMethod) throws DecaCalcException {
		this.ioMethod = ioMethod;
		
		if (ioMethod.inputMethod == DecaIOMethod.DecaInputMethod.CONSOLE) {
			LOG.info("Reading input from console");
			competition = new Competition(System.out, System.in);			
		}
		else if (ioMethod.inputMethod == DecaIOMethod.DecaInputMethod.CSV) {
			LOG.info("Reading input from CSV, file=" + ioMethod.inputParameter);
			competition = new Competition(new File(ioMethod.inputParameter));
		}
		else if (ioMethod.inputMethod == DecaIOMethod.DecaInputMethod.DATABASE) {
			LOG.info("Reading input from database, id=" + ioMethod.inputParameter);
			Connection connection = null;
			try {
				Properties deca_db = new Properties();
				deca_db.load(DecathlonCalculator.class.getResourceAsStream("db.properties"));
				LOG.info("Reading decathlon_db: " + deca_db.getProperty("decathlon_db") + LN +
				         "Reading db_user: " + deca_db.getProperty("db_user") + LN +
				         "Reading db_password: " + deca_db.getProperty("db_password"));
				connection = DriverManager.getConnection(deca_db.getProperty("decathlon_db"),
														 deca_db.getProperty("db_user"),
														 deca_db.getProperty("db_password"));
				competition = new Competition(connection, ioMethod.inputParameter);
			}
			catch (SQLException e) {				
				LOG.log(Level.SEVERE, "Exception!", e);
				throw new DecaCalcException("Unable to open connection to DB");			
			}
			catch (NullPointerException e) {
				LOG.log(Level.SEVERE, "Exception!", e);
				throw new DecaCalcException("Unable to find \"db.properties\" file");			
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Exception!", e);
				throw new DecaCalcException("Unable to find \"db.properties\" file");			
			}
			finally {
				try {
					connection.close();
				}
				catch (Exception e) {
				}
			}
		}
	}
	
	/**
	 * Outputs decathlon results.
	 * @throws DecaCalcException - if exception was thrown from Competition class or if the 
	 * competition object was not created
	 */
	public void outputCalculatedData() throws DecaCalcException {
		if (competition != null) {
			if (ioMethod.outputMethod == DecaIOMethod.DecaOutputMethod.CONSOLE)
				System.out.println(competition);
			else if (ioMethod.outputMethod == DecaIOMethod.DecaOutputMethod.CSV)
				competition.toStringCSV(new File(ioMethod.outputParameter));
			else if (ioMethod.outputMethod == DecaIOMethod.DecaOutputMethod.XML)
				competition.toXML(new File(ioMethod.outputParameter));
			else if (ioMethod.outputMethod == DecaIOMethod.DecaOutputMethod.HTML)
				competition.toHTML(new File(ioMethod.outputParameter));
		}
		else
			throw new DecaCalcException("There is no data to process.");
	}
	
	/**
	 * Helper method for parsing command line parameters and putting them into
	 * DecaIOMethod object.
	 * @param args - command line parameters
	 * @return DecaIOMethod - parsed command line parameters
	 */
	public static DecaIOMethod readCommandLineParams(String[] args) {
		int paramCount = 0;
		DecaIOMethod ioMethod = new DecaIOMethod();
		
		if (args.length >= 2) {
			if (args[paramCount].matches("-db"))
				ioMethod.setInputMethod(DecaIOMethod.DecaInputMethod.DATABASE, args[++paramCount]);
			else if (args[paramCount].matches("-csv"))
				ioMethod.setInputMethod(DecaIOMethod.DecaInputMethod.CSV, args[++paramCount]);
			else if (args[paramCount].matches("-console"))
				ioMethod.setInputMethod(DecaIOMethod.DecaInputMethod.CONSOLE, null);
				
			paramCount++;

			if ((args.length > paramCount) &&
				(args[paramCount].matches("-console")))
				ioMethod.setOutputMethod(DecaIOMethod.DecaOutputMethod.CONSOLE, null);
			else if (args.length > (paramCount + 1)) {
				if (args[paramCount].matches("-csv"))
					ioMethod.setOutputMethod(DecaIOMethod.DecaOutputMethod.CSV, args[++paramCount]);
				else if (args[paramCount].matches("-xml"))
					ioMethod.setOutputMethod(DecaIOMethod.DecaOutputMethod.XML, args[++paramCount]);
				else if (args[paramCount].matches("-html"))
					ioMethod.setOutputMethod(DecaIOMethod.DecaOutputMethod.HTML, args[++paramCount]);
			}
		}
		
		return ioMethod;
	}
	
	/**
	 * Outputs message to console about error in command line parameters  
	 */
	public static void outputCommandLineError() {
		final String errorMessage = new String(
				"Unsupported command line parameter configuration." + LN +
				"Use following configuration:" + LN +
				"    -<input-method> [input-parameters] -<output-method> [output-parameters]" + LN +
				"where" + LN +
			    "* <input-method> is the name of the input method preceded by dash (-): -console, -csv, -db" + LN +
			    "* [input-parameters] are optional parameters depending on the specified input method:" + LN +
			    "      o -console - no parameters" + LN +
			    "      o -csv - input file name or path" + LN +
			    "      o -db - competition id or name" + LN + 
			    "* <output-method> is the name of the output method preceded by dash (-): -conole, -csv, -xml, -html" + LN +
			    "* [output-parameters] are optional parameters depending on the specified output method:" + LN +
			    "      o -conole - no parameters" + LN +
			    "      o -csv - output file name or path" + LN +
			    "      o -xml - output file name or path" + LN +
			    "      o -html - output file name or path ");
		System.out.println(errorMessage);
	}
	
	/**
	 * The main method of this program. Parses command line parameters,
	 * verifies them and creates an instance of DecathlonCalculator if they were OK.
	 * Otherwise outputs error message about error in command line parameters.
	 * @param args - command line parameters
	 */
	public static void main(String[] args) {		
		try {
			DecaIOMethod ioMethod = readCommandLineParams(args);
			if (ioMethod.isIOMethodLegal()) {
				DecathlonCalculator deca = new DecathlonCalculator(ioMethod);
				deca.outputCalculatedData();
			} else
				outputCommandLineError();
		}
		catch (DecaCalcException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Unexpected error.");
			LOG.log(Level.SEVERE, "Unexpected error!", e);
		}
	}
}
