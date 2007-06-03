package net.azib.java.students.t030656.homework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Decathlon. Main class
 *
 * @author Sprot
 */
public class Decathlon {

	private static Competition competition;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//input reader
		InputStream inStream = System.in;
		Scanner inScan = new Scanner(inStream);
		
		//welcome user
		System.out.println("***[Decathlon]***");
		System.out.println();
		boolean run = true;
		while(run){
			//Get the input type
			getInput(inScan);
			//Get the output type
			getOutput(inScan);
			//Quit?
			run =getQuit(inScan);
			System.out.println("***[End Decathlon]***");
		}
		try {
			inStream.close();
		}
		catch (IOException e) {
			System.out.println("Unable to close stram in main method");
			e.printStackTrace();
		}

	}

	/**
	 * get the user choise
	 * @param inScan
	 */
	private static boolean getQuit(Scanner inScan) {
		while(true){
			System.out.println("Do you want to insert another competition?");
			System.out.println("\t[1] Yes");
			System.out.println("\t[2] No");
			System.out.print(": ");
			switch(inScan.nextInt()){
				case 1:
					return true;
				case 2:
					return false;
				default:
					System.out.println("Unknown input. Please try again.\n:");
			}
		}
	}

	/**
	 * get the user choise about output
	 * @param inScan
	 */
	private static void getOutput(Scanner inScan) {
		boolean condition = true;
		while(condition)
		{
			System.out.println("Which ouput you'd like to use?");
			System.out.println("\t[1] On screen");
			System.out.println("\t[2] To CSV");
			System.out.println("\t[3] To XML");
			System.out.println("\t[4] To HTML");
			System.out.print(": ");
			
			switch(inScan.nextInt()){
				case 1:
					Writer.writeToScreen(competition);
					condition = false;
					break;
				case 2:
					Writer.writeToFile(competition);
					condition = false;
					break;
				case 3:
					Writer.writeToXML(competition, false);
					condition = false;
					break;
				case 4:
					Writer.writeToXML(competition, true);
					condition = false;
					break;
				default:
					System.out.print("Unknown input. Please try again.\n:");
					break;
			}
		}
	}

	/**
	 * get the user choise about input.
	 * @param inScan
	 */
	private static void getInput(Scanner inScan) {
		boolean condition = true;
		while(condition){
			System.out.println("Which input you'd like to use?");
			System.out.println("\t[1] Directly from keyboard");
			System.out.println("\t[2] From CSV");
			System.out.println("\t[3] From database\n");
			System.out.print(": ");
			
			switch(inScan.nextInt()){
				case 1:
					competition = Reader.readFromScreen();
					condition = false;
					break;
				case 2:
					competition = Reader.ReadFromCSV();
					condition = false;
					break;
				case 3:
					competition = Reader.ReadFromSQL();
					condition = false;
					break;
				default:
					System.out.print("Unknown input. Please try again.\n:");
					break;
			}
		}
	}
}
