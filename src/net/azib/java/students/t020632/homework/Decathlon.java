package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Decathlon is the main class for decathlon points calculating program.
 * Program waits for the user input. If the input is correct a new 
 * DecathlonCompetition object is created to read the input data, calculate
 * scores and write outout data.
 *
 * @author Marek Soobik t020632
 */
public class Decathlon {

	
	/**
	 * Interacts with user and gives information how to use the program  
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserInput user;
		DecathlonCompetition competition;
		String s;
		String t;
		
		if(args.length == 2){
			s = args[0] + " " + args[1];
			user = new UserInput(s);
			if(user.parseUserInput().equals("Input OK")){
				competition = new DecathlonCompetition(user.getInput(), user.getOutput());
				competition.processCompetition();
			}
		}
		else{
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("*********************** Decathlon points computation **********************\n");
			System.out.println("Enter parameters for input and output data separated by space character\n");
			System.out.println("For example, following command reads input data from csv file and prints output to console");
			System.out.println("\t C:/results.csv console");
			System.out.println("To read input data from database and write output to xml file, type:");
			System.out.println("\t database \"C:/Documents and Settings/results.xml\"");
			System.out.println("Valid file types for output are csv (for input also), xml and xsl (xml file is also created) ");
			System.out.println("Make sure you use full paths!");
		
		
			try {
				while((s = in.readLine()) != null){
					if(s.trim().equals(""))
						break;
	
					user = new UserInput(s);
					t = user.parseUserInput();
					if(t.equals("Input OK")){
						competition = new DecathlonCompetition(user.getInput(), user.getOutput());
						competition.processCompetition();
					}
					else{
						System.out.println(t);
					}
					System.out.println("\nType another command or press enter to exit");
				}
				System.out.println("Program has finished!");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
