package net.azib.java.students.t960644.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
//import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.script.SimpleBindings;

/**
 * Decathlon
 *
 * @author Lembit
 */
public class Decathlon {
	protected SimpleBindings commandLine = new SimpleBindings();
	protected ConsoleInput consoleIn = new ConsoleInput();
	protected Competition competition;
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, ClassNotFoundException, SQLException {
		Decathlon decathlon = new Decathlon();
		decathlon.parseParams(args);
		boolean isInputRead = false;
		if (decathlon.commandLine.containsKey(CommandLineKeys.IN_DB)){
			isInputRead = decathlon.readDbInput();
		} else
		if (decathlon.commandLine.containsKey(CommandLineKeys.IN_CSV)){
			isInputRead = decathlon.readCSVInput();
		}
		
		if (isInputRead) {
			decathlon.competition.sortResults();
			PrintStream printOut = new PrintStream(System.out,true,"UTF-8");
			ConsoleOutput co = new ConsoleOutput();
			co.writeData(printOut,decathlon.competition);
			
		}
			
		/*CSVInput csv = new CSVInput();
		csv.initReader("dec.csv");
		Competition competition = new Competition();
		csv.readResults(competition);
		/*
		DBInput dbInput = new DBInput();
		dbInput.initConnection("com.mysql.jdbc.Driver", "jdbc:mysql://srv.azib.net:3306/decathlon", "java", "java");
		Competition competition = dbInput.readCompetition();
		dbInput.readAthletes(competition);
		dbInput.readResults(competition);
		dbInput.releaseConnection();
		
		competition.sortResults();
		PrintStream printOut = new PrintStream(System.out,true,"UTF-8");
		ConsoleOutput co = new ConsoleOutput();
		co.writeData(printOut,competition);
		CSVOutput cso = new CSVOutput();
		cso.writeData(printOut,competition);
		PrintStream fileOut = new PrintStream(new FileOutputStream("test.csv"),true,"UTF-8");
		cso.writeData(fileOut,competition);
		XMLOutput xo = new XMLOutput();
		xo.writeData(competition);
		xo.printXML(printOut);
		xo.printXML(new FileOutputStream("test.xml"));
		// */
	}
	protected boolean readCSVInput() {
		String csv = readParamConsole(CommandLineKeys.IN_CSV,"Enter csv file location: ");
		CSVInput csvIn = new CSVInput();
		try {
			csvIn.initReader(csv);
			competition = new Competition();
			csvIn.readResults(competition);
		} catch (Exception e) {
			System.out.println("Error reading "+csv);
			return false;
		}
		return true;
	}
	
	protected boolean readDbInput() {
		String db = readParamConsole(CommandLineKeys.IN_DB,"Enter input database address: ");
		String dbUser = readParamConsole(CommandLineKeys.IN_DB_USER,"Enter input database user: ");
		String dbPass = readParamConsole(CommandLineKeys.IN_DB_PASS, "Enter input database password: ");
		String dbDriver = readParamDefault(CommandLineKeys.IN_DB_DRIVER, "com.mysql.jdbc.Driver");
		DBInput dbInput = new DBInput();
		try {
			dbInput.initConnection(dbDriver, db, dbUser, dbPass);			
		} catch (ClassNotFoundException e){
			System.out.println("No driver for: "+dbDriver);
			return false;
		} catch (SQLException e) {
			System.out.println("Error querying database!");
			return false;
		}
		String dbCompId = readParamDefault(CommandLineKeys.IN_DB_COMP_ID, null);
		if (dbCompId==null) {
			List<Competition> competitions;
			try {
				competitions = dbInput.readCompetitions();
			}
			catch (SQLException e) {
				System.out.println("Error querying database!");
				return false;
			}
			List<String> options = new ArrayList<String>();
			for (Competition comp:competitions){
				options.add(comp.getStringDate()+" "+comp.getCountryCode()+" "+comp.getDescription());
			}
			Integer optionVal = consoleIn.readOption(System.in, System.out, options, "Pick competition:");
			if (optionVal==null){
				System.out.println("Exiting");
				return false;
			}
			competition = competitions.get(optionVal);
		} else {
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
	protected String readParamDefault(String key,String defaultValue) {
		if (commandLine.containsKey(key)) {
			return (String)commandLine.get(key);
		} else {
			return defaultValue;
		}
	}
	
	protected String readParamConsole(String key,String msg){
		if (commandLine.containsKey(key)) {
			return (String)commandLine.get(key);
		} else {
			return consoleIn.readValue(System.in, System.out, msg);
		}		
	}
	
	protected void parseParams(String[] args) {
		//Pattern pParamName = new Pattern(".+=");
		for (String s:args) {
			//(pParamName.matcher(s));
			Vector<String> param = splitArg(s);
			if (param.size()==2){
				commandLine.put(param.elementAt(0), param.elementAt(1));
			}
		}
	}
	protected Vector<String> splitArg(String src){
		Vector<String> res = new Vector<String>();
		Scanner sc = new Scanner(src).useDelimiter("=");
		while (sc.hasNext()){
			res.add(sc.next());
		}
		return res;		
	}
}
/*
in.db=jdbc:mysql://srv.azib.net:3306/decathlon
in.db.pass=java
in.db.user=java
in.db.comp=2
in.csv="c:\java\java\dec.csv"
*/