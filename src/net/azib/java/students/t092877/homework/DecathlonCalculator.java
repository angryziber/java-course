package net.azib.java.students.t092877.homework;

public class DecathlonCalculator {

	public static void main(String[] args) {

		//System.out.println(Utility.convertToOriginalUnits(269.58, "running"));

		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-console")) { // console read and write
				if (i == 0) {
					Utility.athletes = Console.input();
				} else {
					Console.output(Utility.athletes);
				}
			} else if (args[i].equals("-csv")) { // csv read and write
				if (i == 0) {
					String source = args[++i];
					Utility.athletes = CSV.input(source);
					System.out.println("\nInput from csv hasn't been implemented yet");
				} else {
					String source = args[++i];
					CSV.output(Utility.athletes, source);
					System.out.println("\nOutput from csv hasn't been implemented yet");
				}
			} else if (args[i].equals("-db")) { // db read
				if (i == 0) {
					String id = args[++i];
					Database.input(id);
					System.out.println("\nInput from database hasn't been implemented yet");
				}
			} else if (args[i].equals("-xml")) { // xml write
				String destination = args[++i];
				XML.output(Utility.athletes, destination);
				System.out.println("\nOutput to XML hasn't been implemented yet");
			} else if (args[i].equals("-html")) { // html write
				String destination = args[++i];
				HTML.output(Utility.athletes, destination);
				System.out.println("\nOutput to HTML hasn't been implemented yet");
			} else {
				System.out.println("\nInvalid command-line parameter: " + args[i]);
				break;
			}
		}

		System.out.println("\nThank you, come again!");
	}
}
