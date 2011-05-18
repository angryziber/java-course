package net.azib.java.students.t103784.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {

	public static void main(String[] args) throws IOException {		
	
		Input input;		
		List<Athlete> contestants = null;
		String filename = "J:\\Projects\\src\\net\\azib\\java\\students\\t103784\\homework\\sample.csv";
		BufferedReader reader = null;
		input = new Input();
		Output output = new Output();
		
		if (args.length > 0 && args[0].equals("-console")) {
			contestants = input.readAthleteFromConsole();						
		} 
		else if (args.length > 0 && args[0].equals("-csv")){
			if (args.length > 1) {
				try {
					reader = new BufferedReader(new FileReader(filename));
					contestants = input.readAthleteFromCSV(reader);
				}
				catch (Exception e) {
					System.out.println("You have specified CSV input, but no CSV file found");					
				}
			}
			
			else {
				System.out.println("You have specified CSV input, but no CSV file specified");
				return;
			}
		}
		else if (args.length > 0 && args[0].equals("-db")){
			//reader = new BufferedReader(reader);
		}
		else {
			System.out.println("No input selected");
			return;
		}
		int j=0;
		for (int i = 0; i < input.contestants.size(); i++) {
			System.out.println("\nFinal: " + Arrays.toString(new double[]{input.contestants.get(i).getPerformance(j)}));
        }
		
		if (args.length > 1 && args[1].equals("-console")){
			output.outputToConsole(contestants);
		}
		else if (args.length > 1 && args[1].equals("-csv")){}
		else if (args.length > 1 && args[1].equals("-xml")){
			try {
				output.outputToXML(contestants);
			} catch (ParserConfigurationException e) {

				e.printStackTrace();
			} catch (TransformerException e) {

				e.printStackTrace();
			}
		}
		else if	(args.length > 1 && args[1].equals("-html")){}
		else {System.out.println("No output selected");return;}

	}
}
