package net.azib.java.students.t980814.homework;

import net.azib.java.students.t980814.homework.DecaInputOutputMethod.DecaInputMethod;
import net.azib.java.students.t980814.homework.DecaInputOutputMethod.DecaOutputMethod;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DecathlonCalculator
 *
 * @author dell
 */
public class DecathlonCalculator {

	private Results results;
	private DecaInputOutputMethod ioMethod;
	
	public DecathlonCalculator(DecaInputOutputMethod ioMethod) {
		this.ioMethod = ioMethod;
		
		if (ioMethod.inputMethod == DecaInputMethod.CONSOLE) {
			results = new Results(System.in);			
		}
		else if (ioMethod.inputMethod == DecaInputMethod.CSV) {
			try {
				results = new Results(new File(ioMethod.inputParameter));
			}
			catch (IOException e) {
				System.out.println("Err... CSV");
			}
		}
		else if (ioMethod.inputMethod == DecaInputMethod.DATABASE) {
			Connection connection = null;
			try {
//				 - both should work (DB connection string must be read from db.properties in the same package as the main class)
				connection = DriverManager.getConnection("jdbc:mysql://srv.azib.net:3306/decathlon", "java", "java");
				results = new Results(connection, ioMethod.inputParameter);
			}
			catch (SQLException e) {
				System.out.println("Unable to load data from DB");			
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
	
	public void outputCalculatedData() {
		if (results != null) {
			if (ioMethod.outputMethod == DecaOutputMethod.CONSOLE)
				System.out.println(results);
			else if (ioMethod.outputMethod == DecaOutputMethod.CSV) {
				// What to do if there is no data to output... create an empty file?
				System.out.println("Not implemented");
			}
			else if (ioMethod.outputMethod == DecaOutputMethod.XML) {
				// What to do if there is no data to output... create an empty file?
				System.out.println("Not implemented");
			}
			else if (ioMethod.outputMethod == DecaOutputMethod.HTML) {
				// What to do if there is no data to output... create an empty file?
				System.out.println("Not implemented");
			}
		}
		else
			System.err.println("No data to output");
	}
	
	
	public static DecaInputOutputMethod readCommandLineParams(String[] args) {
		int paramCount = 0;
		DecaInputOutputMethod ioMethod = new DecaInputOutputMethod();
		
		if (args.length >= 2) {
			if (args[paramCount].matches("-db"))
				ioMethod.setInputMethod(DecaInputMethod.DATABASE, args[++paramCount]);
			else if (args[paramCount].matches("-csv"))
				ioMethod.setInputMethod(DecaInputMethod.CSV, args[++paramCount]);
			else if (args[paramCount].matches("-console"))
				ioMethod.setInputMethod(DecaInputMethod.CONSOLE, null);
				
			paramCount++;

			if ((args.length > paramCount) &&
				(args[paramCount].matches("-console")))
				ioMethod.setOutputMethod(DecaOutputMethod.CONSOLE, null);
			else if (args.length > (paramCount + 1)) {
				if (args[paramCount].matches("-csv"))
					ioMethod.setOutputMethod(DecaOutputMethod.CSV, args[++paramCount]);
				else if (args[paramCount].matches("-xml"))
					ioMethod.setOutputMethod(DecaOutputMethod.XML, args[++paramCount]);
				else if (args[paramCount].matches("-html"))
					ioMethod.setOutputMethod(DecaOutputMethod.HTML, args[++paramCount]);
			}
		}
		
		return ioMethod;
	}
	
	public static void outputCommandLineError() {
		final String LN = System.getProperty("line.separator");
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
	
	public static void main(String[] args) {
		try {
			DecaInputOutputMethod ioMethod = readCommandLineParams(args);
			if (ioMethod.isIOMethodLegal()) {
				DecathlonCalculator deca = new DecathlonCalculator(ioMethod);
				deca.outputCalculatedData();
			} else
				outputCommandLineError();
		}
		catch (Exception e) {
			System.out.println("Unexpected error.");
			e.printStackTrace();
		}
	}
}
