package net.azib.java.students.t030726.homework.def;

import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.input.InputController;
import net.azib.java.students.t030726.homework.input.InputType;

import java.io.BufferedReader;
import java.io.IOException;
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
	
	private static int askForInputType(BufferedReader userIn) throws NumberFormatException, IOException {
		int out = 0;
		System.out.print("Where would you like to get the data from? (1 - Keyboard. 2 - CSV file. 3 - Database):");
		out = Integer.parseInt(userIn.readLine());
		return out;
	}

	private static String askForCSVPath(BufferedReader userIn) throws IOException {
		String out = null;
		System.out.print("Please enter a full path to the CSV file you wish to use: ");
		out = userIn.readLine();
		return out;
	}
	
	private static String askForMySQLURL(BufferedReader userIn) throws IOException {
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
	
	private static String askForMySQLUser(BufferedReader userIn) throws IOException {
		String out = null;
		System.out.print("Please enter the MySQL username: ");
		out = userIn.readLine();
		return out;
	}
	
	private static String askForMySQLPassword(BufferedReader userIn) throws IOException {
		String out = null;
		System.out.print("Please enter the MySQL password: ");
		out = userIn.readLine();
		return out;
	}
	
	private static int askForTargetCompetition(BufferedReader userIn) throws IOException {
		int out = 0;
		System.out.print("Please enter the target competition ID from the database: ");
		out = Integer.parseInt(userIn.readLine());
		return out;
	}
	
	private static ArrayList performFullConsoleRead() throws Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
		InputController inControl = new InputController(InputType.CONSOLE_INPUT);
		while(inControl.hasNext()) {
			out.add(inControl.getNext());
		}
		return out;
	}
	
	private static RatedDecathlonCompetition processAndRateParticipators(ArrayList participators) {
		RatedDecathlonCompetition out = new RatedDecathlonCompetition();
		for(Iterator it = participators.iterator(); it.hasNext();) {
			out.addRawResult((DecathlonChampionship) it.next());
		}
		return out;
	}
	
	private static ArrayList performFullCSVRead(String filePath) throws Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
		InputController inControl = new InputController(InputType.CSV_INPUT, filePath);
		do {
			try {
				out.add(inControl.getNext());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} while(inControl.hasNext());
		return out;
	}
	
	private static ArrayList performFullDatabaseRead(String url, String username, String password, int competitionID) throws Exception {
		ArrayList<DecathlonChampionship> out = new ArrayList<DecathlonChampionship>();
		InputController inControl = new InputController(InputType.MYSQL_INPUT, url, username, password, competitionID);
		while(inControl.hasNext()) {
			out.add(inControl.getNext());
		}
		return out;
	}
	
	
	private static int askForOutputType(BufferedReader userIn) throws IOException {
		int out =0;
		System.out.print("Please choose what output would you like (1 - Screen, 2 - CSV file, 3 - XML, 4 - HTML):  ");
		out = Integer.parseInt(userIn.readLine());
		return out;
	}
	
	private static String askForCSVSavePath(BufferedReader userIn) throws IOException {
		String out = null;
		System.out.print("Please enter a path where to save the CSV file:  ");
		out = userIn.readLine();
		return out;
	}
	
	private static String askForXMLSavePath(BufferedReader userIn) throws IOException {
		String out = null;
		System.out.print("Please enter a path where to save the XML file:  ");
		out = userIn.readLine();
		return out;
	}
	
	private static String askForHTMLSavePath(BufferedReader userIn) throws IOException {
		String out = null;
		System.out.print("Please enter a path where to save the HTML file:  ");
		out = userIn.readLine();
		return out;
	}
	
	private static void doOutputOnScreen(RatedDecathlonCompetition result, OutputType outputType) throws Exception {
		OutputController outControl = new OutputController(result, outputType);
		outControl.flush();
	}
	
	private static void doOutputOnFileSystem(RatedDecathlonCompetition result, OutputType outputType, String filePath) throws Exception {
		OutputController outControl = new OutputController(result, outputType, filePath);
		outControl.flush();
	}
	
	/**
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
			ex.printStackTrace();
			log.log(Level.SEVERE, "Application got halted", ex);
			System.out.println("An error or several errors have occured (see log for details). Please double check your input and try again. Application Halted!");
		}
		
		}
		
		
		

	}
