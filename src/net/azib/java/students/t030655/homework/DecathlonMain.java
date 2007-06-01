package net.azib.java.students.t030655.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;

/**
 * DecathlonMain
 *
 * @author Triin Nestor
 */
public class DecathlonMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("This program calculates decathlon points according to the results.\n" +
				"Results can be read from comsole, CSV file or MyySQL database and \n" +
				"calculated points and places can be written to console, CSV file, \n" +
				"XML file and HTML file.\n");
		System.out.println("Available input data sources: \n\t1 - console " +
				"\n\t2 - CSV file \n\t3 - MySQL database \n\t0 - close program");
		System.out.println("Please select input source (or exit): ");
		BufferedReader in = null;
		int inputSource = 0;
		try {
			in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			inputSource = Integer.parseInt(in.readLine());
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding!");
			e.printStackTrace();
		}
		catch (IOException e) {
			// shouldn't happen
			e.printStackTrace();
		}
		PriorityQueue<Competitor> competitorsQueue = new PriorityQueue<Competitor>();
		switch (inputSource){
			case (0): 
				System.out.println("You have chosen to exit. Goodbye!");
				return;
			case (1): 
				System.out.println("\nYou have chosen console input option!\n");
				System.out.println("-----NB!-----\n" +
						"Data must be inserted in CSV (comma-separated values)format!\n" +
						"Every competitor must be inserted in separate row. If all competitors are inserted\n" +
						"press ENTER. Information about competitors must be in correct order and\n" +
						"separated with commas, no spaces used. Results must be in meters or minutes:seconds or\n" +
						"seconds, decimal separator is '.'. Information order must be the following:\n" +
						"NAME(surrounded with double quotes)\nDATE OF BIRTH(dd.mm.yyyy or yyyy-mm-dd)\n" +
						"COUNTRY CODE(two letter code)\n100M SPRINT\nLONG JUMP\nSHOT PUT\nHIGH JUMP\n" +
						"400M SPRINT\n110M HURDLES\nDISCUS THROW\nPOLE VAULT\nJAVLINE THROW\n1500M RACE\n");
				System.out.println("EXAMPLE:\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72\n");
				System.out.println("Please insert competitors data:");
				DecathlonInputReader dataFromConsole = new DecathlonInputReader();
				competitorsQueue.addAll(dataFromConsole.readInputStream(System.in));
				System.out.println("Inserting is completed!");
				for (Competitor comp : competitorsQueue){
					System.out.println(comp.getString());
				}
				break;
			case (2): 
				System.out.println("\nYou have chosen CSV file input option!\n\n" +
						"Please insert file name with path:");
				try {
					String file = in.readLine();
					FileInputStream inStream = new FileInputStream(file);
					DecathlonInputReader dataFromFile = new DecathlonInputReader();
					competitorsQueue.addAll(dataFromFile.readInputStream(inStream));
					PriorityQueue<Competitor> pq = new PriorityQueue<Competitor>(competitorsQueue);
					System.out.println(competitorsQueue.size());
					System.out.println("File is read!");
					Competitor comp = null;
					int i = 0;
					while ((comp = pq.poll())!= null){
						System.out.println(comp.getString());
						i++;
					}
				}
				catch (IOException e) {
					//shouldn't happen
					e.printStackTrace();
				}
				break;
			case (3): ;
		}
		
		

	}

}
