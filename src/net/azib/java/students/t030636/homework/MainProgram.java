package net.azib.java.students.t030636.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * MainProgram for Decathlon points calculation
 *
 * @author Martin
 */
public class MainProgram {

	/**
	 * Main method for Decathlon points calculation
	 * Creates the user interface and outputs the results in the desired format
	 * 
	 * @param args - by default no command line pramaters needed
	 */
	public static void main(String[] args) {
		DisplayInstructionFile di = new DisplayInstructionFile();
		di.display("instructions.txt");
	    BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		}
		catch (UnsupportedEncodingException e1) {
			System.out.println("Unsupported encoding");
			System.exit(0);
		}
	    String [] read = null;
	    int input1 = 0;
		try {
			input1 = Integer.parseInt(br.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Something is wrong - start over");
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Something is wrong - start over");
			System.exit(0);
		}
		switch (input1) {
			case 1:
				System.out.println("You have chosen the file input option\nPlease input the filename (path):");
				InputReader rf = new InputReader();
				try {
					read = rf.readFile(br.readLine());
				}
				catch (IOException e) {
					System.out.println("Couldn't read file");
					System.exit(0);
				}
				break;
			case 2:
				System.out.println("You have chosen the database input option\nPlease input database informaton");
				System.out.println("Database URL: (example: srv.azib.net/decathlon)");
				String url = null;
				try {
					url = br.readLine();
				}
				catch (IOException e4) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				System.out.println("Database user:");
				String user = null;
				try {
					user = br.readLine();
				}
				catch (IOException e4) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				System.out.println("Database password:");
				String pwd = null;
				try {
					pwd = br.readLine();
				}
				catch (IOException e4) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				DatabaseReader dbr = new DatabaseReader();
				try {
					dbr.initializeConnection("jdbc:mysql://"+url, user, pwd);
				}
				catch (Exception e) {
					System.out.println("Can't connect to database");
					System.exit(0);
				}
				try {
					dbr.displayCompetitionsFromDatabase();
				}
				catch (SQLException e3) {
					System.out.println("Can't read from database");
					e3.printStackTrace();
				}
				String comp = null;
				try {
					comp = br.readLine();
				}
				catch (IOException e1) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				try {
					read = dbr.readDatabase(comp);
				}
				catch (SQLException e2) {
					System.out.println("Can't get data from database");
					System.exit(0);
				}
				break;
			case 3:	
				System.out.println("You have chosen the console input option\n");
				InputReader rc = new InputReader();
				read = rc.readFromConsole();
				break;
		}

		ArrayList <Competitor> competitors = new ArrayList<Competitor>();
		PointsForObjects pfo = new PointsForObjects();
		try {
			competitors = pfo.calculatePoints(read);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			System.exit(0);
		}
		
		System.out.println("Select a output method:\nTo file - press 1\nTo console - press 2\nTo XML - press 3\nTo HTML - press 4");
		int input2 = 0;
		try {
			input2 = Integer.parseInt(br.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Something is wrong - start over");
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Something is wrong - start over");
			System.exit(0);
		}
		switch(input2){
			case 1:
				System.out.println("Insert filename for the output text file (+path):");
				String filenameTxt = null;
				try {
					filenameTxt = br.readLine();
				}
				catch (IOException e) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				OutputWriter wf = new OutputWriter();
				wf.writeToFile(filenameTxt, competitors);
				break;
			case 2:
				OutputWriter wc = new OutputWriter();
				wc.writeToConsole(competitors);
				break;
			case 3:
				System.out.println("Insert filename for the output XML file (+path):");
				String filenameXml = null;
				try {
					filenameXml = br.readLine();
				}
				catch (IOException e) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				OutputWriter wxml = new OutputWriter();
				wxml.writeToXML(filenameXml, competitors);
				break;
			case 4:
				System.out.println("Insert filename for the output HTML file (+path):");
				String filenameHtml = null;
				try {
					filenameHtml = br.readLine();
				}
				catch (IOException e) {
					System.out.println("Error in console input");
					System.exit(0);
				}
				OutputWriter whtml = new OutputWriter();
				whtml.writeToHTML(filenameHtml, competitors);
				break;
			
		}
	}
}
