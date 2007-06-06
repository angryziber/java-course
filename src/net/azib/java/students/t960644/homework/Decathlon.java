package net.azib.java.students.t960644.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

import javax.script.SimpleBindings;

/**
 * Decathlon
 * 
 * @author Lembit
 */
public class Decathlon {
	SimpleBindings commandLine = new SimpleBindings();
	ConsoleInput consoleIn = new ConsoleInput();
	PrintStream printOut;
	InputStreamReader reader;
	Competition competition;

	public Decathlon() throws UnsupportedEncodingException {
		printOut = new PrintStream(System.out, true, "UTF-8");
		reader = new InputStreamReader(System.in,"UTF-8");
	}

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException,
			SQLException {
		Locale.setDefault(Locale.US);
		Decathlon decathlon = new Decathlon();
		decathlon.parseParams(args);
		boolean isInputRead = false;
		if (decathlon.commandLine.containsKey(CommandLineKeys.IN_DB)) {
			isInputRead = decathlon.readDbInput();
		}
		else if (decathlon.commandLine.containsKey(CommandLineKeys.IN_CSV)) {
			isInputRead = decathlon.readCSVInput();
		}
		else {
			isInputRead = decathlon.readConsoleInput();
		}

		if (isInputRead) {
			decathlon.competition.sortResults();

			String consoleOut = decathlon.readParamDefault(CommandLineKeys.OUT_CONSOLE, "1");
			if (consoleOut.equals("1")) {
				decathlon.writeConsoleOutput();
			}
			if (decathlon.commandLine.containsKey(CommandLineKeys.OUT_CSV)) {
				decathlon.writeCSVOutput();
			}
			if (decathlon.commandLine.containsKey(CommandLineKeys.OUT_XML)) {
				decathlon.writeXMLOutput();
			}
		}
	}

	protected void writeXMLOutput() {
		String xml = readParamConsole(CommandLineKeys.OUT_XML, "Enter output xml file location: ");
		XMLOutput xmlOut = new XMLOutput();
		try {
			xmlOut.writeData(competition);
			xmlOut.printXML(new FileOutputStream(xml));
		}
		catch (Exception e) {
			System.out.println("Error writing " + xml);
		}
	}

	protected void writeConsoleOutput() {
		try {
			PrintStream printOut = new PrintStream(System.out, true, "UTF-8");
			ConsoleOutput co = new ConsoleOutput();
			co.writeData(printOut, competition);
		}
		catch (Exception e) {
			System.out.println("Error writing to console!");
			// e.printStackTrace();
		}
	}

	protected boolean readCSVInput() {
		String csv = readParamConsole(CommandLineKeys.IN_CSV, "Enter input csv file location: ");
		CSVInput csvIn = new CSVInput();
		try {
			csvIn.initReader(csv);
			competition = new Competition();
			csvIn.readResults(competition);
		}
		catch (Exception e) {
			System.out.println("Error reading " + csv);
			return false;
		}
		return true;
	}

	protected void writeCSVOutput() {
		String csv = readParamConsole(CommandLineKeys.OUT_CSV, "Enter output csv file location: ");
		CSVOutput csvOut = new CSVOutput();
		try {
			PrintStream fileOut = new PrintStream(new FileOutputStream(csv), true, "UTF-8");
			csvOut.writeData(fileOut, competition);
		}
		catch (Exception e) {
			System.out.println("Error writing " + csv);
		}

	}

	protected boolean readConsoleInput() {
		competition = new Competition();
		try {
			PrintStream printOut = new PrintStream(System.out, true, "UTF-8");
			InputStreamReader readIn = new InputStreamReader(System.in, "UTF-8");
			consoleIn.readResults(readIn, printOut, competition);
		}
		catch (Exception e) {
			System.out.println("Error reading console!");
		}
		return competition.getResults().size() > 0;
	}

	protected boolean readDbInput() {
		String db = readParamConsole(CommandLineKeys.IN_DB, "Enter input database address: ");
		String dbUser = readParamConsole(CommandLineKeys.IN_DB_USER, "Enter input database user: ");
		String dbPass = readParamConsole(CommandLineKeys.IN_DB_PASS, "Enter input database password: ");
		String dbDriver = readParamDefault(CommandLineKeys.IN_DB_DRIVER, "com.mysql.jdbc.Driver");
		DBInput dbInput = new DBInput();
		try {
			dbInput.initConnection(dbDriver, db, dbUser, dbPass);
		}
		catch (ClassNotFoundException e) {
			System.out.println("No driver for: " + dbDriver);
			return false;
		}
		catch (SQLException e) {
			System.out.println("Error querying database!");
			return false;
		}
		String dbCompId = readParamDefault(CommandLineKeys.IN_DB_COMP_ID, null);
		if (dbCompId == null) {
			List<Competition> competitions;
			try {
				competitions = dbInput.readCompetitions();
			}
			catch (SQLException e) {
				System.out.println("Error querying database!");
				return false;
			}
			List<String> options = new ArrayList<String>();
			for (Competition comp : competitions) {
				options.add(comp.getStringDate() + " " + comp.getCountryCode() + " " + comp.getDescription());
			}
			Integer optionVal = consoleIn.readOption(reader, printOut, options, "Pick competition:");
			if (optionVal == null) {
				System.out.println("Exiting");
				return false;
			}
			competition = competitions.get(optionVal);
		}
		else {
			try {
				competition = dbInput.readCompetition(dbCompId);
			}
			catch (SQLException e) {
				System.out.println("Error querying database!");
				return false;
			}
		}
		try {
			dbInput.readAthletes(competition);
			dbInput.readResults(competition);
			dbInput.releaseConnection();
		}
		catch (SQLException e) {
			System.out.println("Error querying database!");
			return false;
		}
		return true;
	}

	protected String readParamDefault(String key, String defaultValue) {
		if (commandLine.containsKey(key)) {
			return (String) commandLine.get(key);
		}
		else {
			return defaultValue;
		}
	}

	protected String readParamConsole(String key, String msg) {
		if (commandLine.containsKey(key)) {
			return (String) commandLine.get(key);
		}
		else {
			return consoleIn.readValue(reader, printOut, msg);
		}
	}

	protected void parseParams(String[] args) {
		for (String s : args) {
			Vector<String> param = splitArg(s);
			if (param.size() == 2) {
				commandLine.put(param.elementAt(0), param.elementAt(1));
			}
		}
	}

	protected Vector<String> splitArg(String src) {
		Vector<String> res = new Vector<String>();
		Scanner sc = new Scanner(src).useDelimiter("=");
		while (sc.hasNext()) {
			res.add(sc.next());
		}
		return res;
	}
}
/*
 * in.db=jdbc:mysql://srv.azib.net:3306/decathlon in.db.pass=java
 * in.db.user=java in.db.comp=2 in.csv="c:\java\java\dec.csv"
 * 
 * out.csv="c:\java\java\decathlon results.csv" out.console=0
 * out.xml="c:\java\java\decathlon_results.xml"
 */