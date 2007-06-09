package net.azib.java.students.t030726.homework.def;

import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.input.InputController;
import net.azib.java.students.t030726.homework.input.InputType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.azib.java.students.t030726.homework.output.OutputController;
import net.azib.java.students.t030726.homework.output.OutputType;

import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.RatedDecathlonCompetition;

public class Application {
	
	/**
	 * Asks the user for the input type and returns an answer as an int
	 * @param userIn
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	private static int askForInputType(BufferedReader userIn) throws NumberFormatException, Exception {
		int out = 0;
		System.out.print("Where would you like to get the data from? (1 - Keyboard. 2 - CSV file. 3 - Database):");
		out = Integer.parseInt(userIn.readLine());
		return out;
	}

	/**
	 * Asks the user for the CSV file path
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForCSVPath(BufferedReader userIn) throws Exception {
		String out = null;
		System.out.print("Please enter a full path to the CSV file you wish to use: ");
		out = userIn.readLine();
		return out;
	}
	
	/**
	 * Asks the user for the mysql server IP or DNS, Database schema namd and Port. Forms a mysql connection string
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForMySQLURL(BufferedReader userIn) throws Exception {
		String out = null;
		String server = null;
		String database = null;
		int port = 0;
		System.out.print("Please enter the MySQL server IP or DNS: ");
		server = userIn.readLine();
		
		System.out.print("Please enter the MySQL server schema name: ");
		database = userIn.readLine();

		System.out.print("Please enter the MySQL server port: ");
		port = Integer.parseInt(userIn.readLine());
		
		out = "jdbc:mysql://" + server + ":" + String.valueOf(port) + "/" + database; 
		
		return out;
	}
	
	/**
	 * Asks for the mysql username, with which to connect to the database
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForMySQLUser(BufferedReader userIn) throws Exception {
		String out = null;
		System.out.print("Please enter the MySQL username: ");
		out = userIn.readLine();
		return out;
	}
	
	/**
	 * Asks for mysql user password to connect to the database
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForMySQLPassword(BufferedReader userIn) throws Exception {
		String out = null;
		System.out.print("Please enter the MySQL password: ");
		out = userIn.readLine();
		return out;
	}
	
	/**
	 * Asks for a target competition from the database. There can be many.
	 * @param userIn
	 * @return An int representing a competition in the database
	 * @throws Exception
	 */
	private static int askForTargetCompetition(BufferedReader userIn) throws Exception {
		int out = 0;
		System.out.print("Please enter the target competition ID from the database: ");
		out = Integer.parseInt(userIn.readLine());
		return out;
	}
	
	/**
	 * Asks the user to enter all the information about athletes
	 * @return An ArrayList of DecathlonChampionship, which are already initialized and ready for use
	 * @throws Exception
	 */
	private static ArrayList<DecathlonChampionship> performFullConsoleRead() throws Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
		InputController inControl = new InputController(InputType.CONSOLE_INPUT);
		while(inControl.hasNext()) {
			out.add(inControl.getNext());
		}
		return out;
	}
	
	/**
	 * Sorts all the DecathlonChampionship objects and assignes them places
	 * @param participators
	 * @return
	 */
	private static RatedDecathlonCompetition processAndRateParticipators(ArrayList participators) {
		RatedDecathlonCompetition out = new RatedDecathlonCompetition();
		for(Iterator it = participators.iterator(); it.hasNext();) {
			out.addRawResult((DecathlonChampionship) it.next());
		}
		return out;
	}
	
	/**
	 * Reads all lines from the CSV file and loads them into an ArrayList of DecathlonChampionship
	 * @param filePath
	 * @return ArrayList of DecathlonChampionship
	 * @throws Exception
	 */
	private static ArrayList<DecathlonChampionship> performFullCSVRead(String filePath) throws Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
		InputController inControl = new InputController(InputType.CSV_INPUT, filePath);
		do {
			try {
				out.add(inControl.getNext());
			} catch (Exception ex) {
				throw ex;
			}
			
		} while(inControl.hasNext());
		return out;
	}
	
	/**
	 * Reads all rows from the database and loads all the information into an ArrayList of DecathlonChampionship
	 * @param url
	 * @param username
	 * @param password
	 * @param competitionID
	 * @return ArrayList of DecathlonChampionship
	 * @throws Exception
	 */
	private static ArrayList<DecathlonChampionship> performFullDatabaseRead(String url, String username, String password, int competitionID) throws Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
		InputController inControl = new InputController(InputType.MYSQL_INPUT, url, username, password, competitionID);
		while(inControl.hasNext()) {
			out.add(inControl.getNext());
		}
		return out;
	}
	
	
	/**
	 * Asks the user for the output type and returns an int representing his selection
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static int askForOutputType(BufferedReader userIn) throws Exception {
		int out =0;
		System.out.print("Please choose what output would you like (1 - Screen, 2 - CSV file, 3 - XML, 4 - HTML):  ");
		out = Integer.parseInt(userIn.readLine());
		return out;
	}
	
	/**
	 * Asks the user for a path to save the csv file. The file has to be writable
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForCSVSavePath(BufferedReader userIn) throws Exception {
		String out = null;
		System.out.print("Please enter a path where to save the CSV file:  ");
		out = userIn.readLine();
		return out;
	}
	
	/**
	 * Asksfor a path to save the xml file. The path must be writable
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForXMLSavePath(BufferedReader userIn) throws Exception {
		String out = null;
		System.out.print("Please enter a path where to save the XML file:  ");
		out = userIn.readLine();
		return out;
	}
	
	/**
	 * Asks for a path to save the html file
	 * @param userIn
	 * @return
	 * @throws Exception
	 */
	private static String askForHTMLSavePath(BufferedReader userIn) throws Exception {
		String out = null;
		System.out.print("Please enter a path where to save the HTML file:  ");
		out = userIn.readLine();
		return out;
	}
	
	/**
	 * Dumps all output on the screen
	 * @param result
	 * @param outputType
	 * @throws Exception
	 */
	private static void doOutputOnScreen(RatedDecathlonCompetition result, OutputType outputType) throws Exception {
		OutputController outControl = new OutputController(result, outputType);
		outControl.flush();
	}
	
	/**
	 * Dumps all output to the specified location on the filesystem, using the specified outputType
	 * @param result
	 * @param outputType
	 * @param filePath
	 * @throws Exception
	 */
	private static void doOutputOnFileSystem(RatedDecathlonCompetition result, OutputType outputType, String filePath) throws Exception {
		OutputController outControl = new OutputController(result, outputType, filePath);
		outControl.flush();
	}
	
	/** Handles and controls user input.
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		Logger log = Logger.getLogger(JavaUtilLogging.class.getName());
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			URL loggingConfig = JavaUtilLogging.class.getClassLoader().getResource("logging.properties");
			System.setProperty("java.util.logging.config.file", loggingConfig.getPath());
			
			BufferedReader userIn = new BufferedReader(new InputStreamReader( System.in ) );
			int userInputChoice = askForInputType(userIn);
			int userOutputChoice = 0;
			RatedDecathlonCompetition result = null;
			switch(userInputChoice) {
			case 1:
				result = processAndRateParticipators(performFullConsoleRead());
				break;
			case 2:
				result = processAndRateParticipators(performFullCSVRead(askForCSVPath(userIn)));
				break;
			case 3:
				result = processAndRateParticipators(performFullDatabaseRead(askForMySQLURL(userIn), askForMySQLUser(userIn), 
						askForMySQLPassword(userIn), askForTargetCompetition(userIn)));
				break;
			}
			userOutputChoice = askForOutputType(userIn);
			switch(userOutputChoice) {
			case 1:
				//Screen
				doOutputOnScreen(result, OutputType.SCREEN_OUTPUT);
				break;
			case 2:
				//CSV
				doOutputOnFileSystem(result, OutputType.CSV_OUTPUT, askForCSVSavePath(userIn));
				break;
			case 3:
				//XML
				doOutputOnFileSystem(result, OutputType.XML_OUTPUT, askForXMLSavePath(userIn));
				break;
			case 4:
				//HTML
				doOutputOnFileSystem(result, OutputType.HTML_OUTPUT, askForHTMLSavePath(userIn));
				break;
			
			}
		} catch (Exception ex) {
			log.log(Level.SEVERE, "Application got halted", ex);
			System.out.println("An error or several errors have occured (see log for details). Please double check your input and try again. Application Halted!");
		}
		
		}
		
		
		

	}
