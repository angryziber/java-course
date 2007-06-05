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
		*
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
	
	protected boolean readDbInput() {
		String db;
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUser;
		String dbPass;
		if (commandLine.containsKey(CommandLineKeys.IN_DB)) {
			db = (String)commandLine.get(CommandLineKeys.IN_DB);
		} else {
			db = consoleIn.readValue(System.in, System.out, "Enter input database address: ");
		}
		if (commandLine.containsKey(CommandLineKeys.IN_DB_USER)){
			dbUser = (String)commandLine.get(CommandLineKeys.IN_DB_USER);
		} else {
			dbUser = consoleIn.readValue(System.in, System.out, "Enter input database user: ");
		}
		if (commandLine.containsKey(CommandLineKeys.IN_DB_PASS)){
			dbPass = (String)commandLine.get(CommandLineKeys.IN_DB_PASS);
		} else {
			dbPass = consoleIn.readValue(System.in, System.out, "Enter input database password: ");
		}
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
		String dbCompId = null;
		if (commandLine.containsKey(CommandLineKeys.IN_DB_COMP_ID)) {
			dbCompId = (String)commandLine.get(CommandLineKeys.IN_DB_COMP_ID);
		}
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
		}
		catch (SQLException e) {
			System.out.println("Error querying database!");
			return false;
		}
		return true;
	}
	
	protected void parseParams(String[] args) {
		//Pattern pParamName = new Pattern(".+=");
		for (String s:args) {
			//(pParamName.matcher(s));
			Vector<String> param = splitArg(s);
			if (param.size()==2){
				System.out.print(param.elementAt(0)+" ");
				System.out.println(param.elementAt(1));
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
