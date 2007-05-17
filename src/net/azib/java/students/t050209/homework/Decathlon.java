package net.azib.java.students.t050209.homework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Decathlon
 * 
 * This is program for computing decathlon scores.
 *
 * @author Kaupo Laan
 */
public class Decathlon {
	
	/**
	 * Main function of the program.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		boolean validData = false;
		List<Sportsman> sportsmanList = new LinkedList<Sportsman>();
		
		System.out.println("Program started.");
		
		while(validData == false){
			try{
				switch(HandleDecathlonIO.selectDataInputType()) {
		
				/* data is inserted through console*/
				case 1:
					System.out.println("Console input selected");
					sportsmanList = HandleConsoleIO.handleConsoleInput();
					validData = true;
					break;
		
				/* data is read from CSV file */
				case 2:
					System.out.println("CSV input selected");
					sportsmanList = HandleFileIO.handleCSVInput();
					validData = true;
					break;
			
				/* data is read from database */
				case 3:
					System.out.println("MySQL input selected");
					sportsmanList = HandleMySQLConnection.handleMySQLConnection();
					validData = true;
					break;
			
				default:
				/* illegal option */
					System.out.println("Insert 1, 2 or 3!");
					validData = false;
					break;
				}
			}
			catch (NumberFormatException nfe){
				System.out.println("Number must be inserted!");
				validData = false;
			}
		}
		
		validData = false; // set to false again
		Collections.sort(sportsmanList);			
		Collections.reverse(sportsmanList);
		
		while(validData == false){
			try{
				switch(HandleDecathlonIO.selectDataOutputType()) {
				/* show data on screen (console) */
				case 1:
					HandleConsoleIO.handleConsoleOutput(sportsmanList);
					validData = true;
					break;
		
				/* write data to CSV file */
				case 2:
					HandleFileIO.handleCSVOutput(sportsmanList);
					validData = true;
					break;
		
				/* write data to XML file */
				case 3:
					HandleFileIO.handleXMLOutput(sportsmanList, false, null);
					validData = true;
					break;
		
				/* write data to HTML file */
				case 4:
					HandleFileIO.handleHTMLOutput(sportsmanList);
					validData = true;
					break;
			
				default:
					System.out.println("Insert 1, 2, 3 or 4!");
					validData = false;
					break;
				}
			}
			catch (NumberFormatException nfe){
				System.out.println("Number must be inserted!");
				validData = false;
			}
		}
		System.out.println("Program ended");
	}

}
