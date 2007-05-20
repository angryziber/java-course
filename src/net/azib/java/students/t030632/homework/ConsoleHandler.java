package net.azib.java.students.t030632.homework;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ConsoleHandler
 *
 * @author Toni
 */
public class ConsoleHandler {
	private Scanner scanner;
	private List<Competitor> competitorsList;
	public ConsoleHandler(InputStream in){
		competitorsList= new LinkedList<Competitor>();
		scanner = new Scanner(in);
		System.out.println("Decathlon results analyzer!!!");
		printInputOptions();
		String inputCommand = scanner.nextLine();
		handleInput(inputCommand);
		
	}
	private void printInputOptions(){
		
		System.out.println("Help, Input options:");
		System.out.println("\t c <results>: results are read from console");
		System.out.println("\t f <filename>: results are in CSV file");
		System.out.println("\t d <username:password>: results are taken from DB");
	}
	private void printOutputOptions(){
		System.out.println("Help, Output options:");
		System.out.println("\t o : results are printed out to console");
		System.out.println("\t i <filename>: results are saved to CSV file");
		System.out.println("\t h <html filename>: results are saved in html file");
	}
	private void printExitOptions(){
		System.out.println("Exit options: ");
		System.out.println("\t q : quit");
		System.out.println("\t u : continue with input options");
		System.out.println("\t t : continue with output options");
	}
	private void handleInput(String inputCommand){
		String[] inputStrs = inputCommand.split(" ");
		
		char key = inputCommand.charAt(0);
		switch (key) {
		case 'c':
			System.out.println("input from console");
			String dataStr;
			/*add entered competitors to the existing list*/
			while(!(dataStr = scanner.nextLine()).equals("")){
				competitorsList.add(new Competitor(dataStr));
			}
			
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		case 'f':
			System.out.println("input from file");
			/*add entered competitors to the existing list*/
			for(Competitor champ: new FileProcessor(new File(inputStrs[1])).getCompetitors()){
				competitorsList.add(champ);
			}
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		case 'd':
			System.out.println("input from database");
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;			
		default:
			System.out.println("INVALID OPTION SELECTED...");
			printInputOptions();
			handleInput(scanner.nextLine());
			break;
		}
	}
	private void handleOutput(String outputCommand){
		String fileName ;
		List places = new PlaceCalculator(competitorsList).getPlaces();
		char key = outputCommand.charAt(0);
		switch (key) {
		case 'o':
			System.out.println("Rated results to console: ");
			try {
					PrintStream out = new PrintStream(System.out, true, "UTF-8");
					for(Competitor champ: competitorsList){
						System.out.println(places.size() - places.indexOf(champ.getPoints())+") ");
						out.println(champ.toString());
					}
				}
				catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		case 'i':
			fileName= outputCommand.substring(outputCommand.indexOf(" ")).trim();
			
			File outputFile;
			if(fileName.contains(".csv")){
				outputFile = new File(fileName);
			}else{
				outputFile = new File(fileName+".csv");
			}
			new outFileWriter(outputFile, competitorsList);
			System.out.println("Rated results to "+outputFile.getAbsolutePath()+" file: ");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		case 'h':
			fileName = outputCommand.substring(outputCommand.indexOf(" ")).trim();
			System.out.println("Rated results html file ");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;			
		default:
			System.out.println("INVALID OPTION SELECTED...");
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		}
	}
	private void handleExit(String exitcommand){
		char key = exitcommand.charAt(0);
		switch (key) {
		case 'q':
			//scanner.nextLine();
			System.out.println("Exited successfully!");
			break;
		case 'u':
			printInputOptions();
			handleInput(scanner.nextLine());
			
			break;
		case 't':
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		default:
			System.out.println("INVALID OPTION SELECTED...");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		}
	}
}
