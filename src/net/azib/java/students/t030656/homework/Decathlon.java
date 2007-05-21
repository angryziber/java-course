package net.azib.java.students.t030656.homework;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Decathlon. Main class
 *
 * @author Sprot
 */
public class Decathlon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int Run = 1;
		//input reader
		InputStream inStream = System.in;
		Scanner inScan = new Scanner(inStream);
		
		//welcome user
		System.out.println("***[Decaathlon]***");
		System.out.println();
		
		while(Run == 1){
			//Get the input type
			getInput(inScan);
			//Get the output type
			getOutput(inScan);
			//Quit?
			Run =getQuit(inScan);
		}

	}

	/**
	 * get the user choise
	 * @param inScan
	 */
	private static int getQuit(Scanner inScan) {
		while(true){
			System.out.println("Do you want to insert another competition?");
			System.out.println("\t[1] Yes");
			System.out.println("\t[2] No");
			int cont = inScan.nextInt();
			
			if(cont == 1 || cont == 2){
				return cont;
			}
			System.out.println("Unknown input. Please try again.\n:");
		}
	}

	/**
	 * get the user choise about output
	 * @param inScan
	 */
	private static void getOutput(Scanner inScan) {
		while(true)
		{
			System.out.println("Which ouput you'd like to use?");
			System.out.println("\t[1] On screen");
			System.out.println("\t[2] To CSV");
			System.out.println("\t[3] To XML");
			System.out.println("\t[4] To HTML");
			
			switch(inScan.nextInt()){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					System.out.println("Unknown input. Please try again.\n:");
					break;
			}
		}
	}

	/**
	 * get the user choise about input
	 * @param inScan
	 */
	private static void getInput(Scanner inScan) {
		
		while(true){
			System.out.println("Which input you'd like to use?");
			System.out.println("\t[1] Directly from keyboard");
			System.out.println("\t[2] From CSV");
			System.out.println("\t[3] From database\n");
			
			switch(inScan.nextInt()){
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					System.out.println("Unknown input. Please try again.\n:");
					break;
			}
		}
	}

}
