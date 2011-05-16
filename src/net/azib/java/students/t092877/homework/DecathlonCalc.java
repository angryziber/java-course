package net.azib.java.students.t092877.homework;

import java.io.File;

public class DecathlonCalc {

	public static void main(String[] args) {

		boolean outputToHtml = false;
		Competition decathlon = new Competition();

		if (args.length == 0)
			System.out.println("\nERROR: the command-line parameter list is empty");

		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-console")) {

				if (i == 0) {
					decathlon.setAthletesList(Console.input(decathlon));
				} else
					Console.output(decathlon);

			} else if (args[i].equals("-csv")) {

				if (i == 0) {
					String srcPath = args[++i];
					decathlon.setAthletesList(Csv.input(decathlon, new File(srcPath)));

				} else {

					String dstPath = args[++i];
					Csv.output(decathlon, new File(dstPath));
				}

			} else if (args[i].equals("-db")) {

				if (i == 0) {
					String userInput = args[++i];
					decathlon.setAthletesList(Database.input(decathlon, userInput));
				}

			} else if (args[i].equals("-xml")) {

				String dstPath = args[++i];
				outputToHtml = false;
				Xml.output(decathlon, new File(dstPath), outputToHtml);

			} else if (args[i].equals("-html")) {

				String dstPath = args[++i];
				outputToHtml = true;
				Xml.output(decathlon, new File(dstPath), outputToHtml);

			} else {

				System.out.println("\n>>> ERROR: Invalid command-line parameter: " + args[i]);
				break;
			}
		}

		System.out.println("\nThank you, come again!");
	}
}