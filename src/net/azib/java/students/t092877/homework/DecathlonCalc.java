package net.azib.java.students.t092877.homework;

import java.io.File;
import java.util.List;

public class DecathlonCalc {

	public static void main(String[] args) {

		List<Athlete> athletes = null;
		
		if (args.length == 0)
			System.out.println("\nERROR: the command-line parameter list is empty");

		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-console")) { // console read and write
				
				if (i == 0) {
					athletes = Console.input();
				} else 
					Console.output(athletes);
				
			} else if (args[i].equals("-csv")) { // csv read and write
				
				if (i == 0) {
					String srcPath = args[++i];
					athletes = CSV.input(new File(srcPath));
					
				} else {
					
					String dstPath = args[++i];
					CSV.output(athletes, new File(dstPath));
				}
				
			} else if (args[i].equals("-db")) { // db read
				
				if (i == 0) {
					String userInput = args[++i];
					athletes = Database.input(userInput);
				}
				
			} else if (args[i].equals("-xml")) { // xml write
				
				String dstPath = args[++i];
				XML.output(athletes, new File(dstPath));
				System.out.println("\nOutput to XML hasn't been implemented yet");
				
			} else if (args[i].equals("-html")) { // html write
				
				String dstPath = args[++i];
				HTML.output(athletes, new File(dstPath));
				System.out.println("\nOutput to HTML hasn't been implemented yet");
				
			} else {
				
				System.out.println("\nInvalid command-line parameter: " + args[i]);
				break;
			}
		}

		System.out.println("\nThank you, come again!");
	}
}