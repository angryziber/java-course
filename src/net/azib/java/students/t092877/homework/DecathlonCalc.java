package net.azib.java.students.t092877.homework;

import java.io.File;

public class DecathlonCalc {

	public static void main(String[] args) {

		boolean htmlTransformSelected = false;
		Competition competition = null;

		if (args.length == 0)
			System.err.println("\n>>> ERROR: the command-line parameter list is empty");
		else {
			competition = new Competition();
		}

		Mode mode = null;

		try {
			for (int i = 0; i < args.length; i++) {

				if (args[i].equals(Strategy.CONSOLE)) {

					if (i == 0) {

						mode = new Mode(new ReadFromStandardInput());
						mode.executeStrategy(competition);

					} else {

						mode = new Mode(new WriteToStandardOutput());
						mode.executeStrategy(competition);
					}

				} else if (args[i].equals(Strategy.CSV_FILE)) {

					if (i == 0) {

						String srcPath = args[++i];
						mode = new Mode(new ReadFromCsvFile(new File(srcPath)));
						mode.executeStrategy(competition);

					} else {

						String dstPath = args[++i];
						mode = new Mode(new WriteToCsvFile(new File(dstPath)));
						mode.executeStrategy(competition);
					}

				} else if (args[i].equals(Strategy.INPUT_FROM_DATABASE)) {

					if (i == 0) {

						String parameter = args[++i];
						mode = new Mode(new ReadFromDatabase(parameter));
						mode.executeStrategy(competition);
					}

				} else if (args[i].equals(Strategy.OUTPUT_TO_XML)) {

					String dstPath = args[++i];
					htmlTransformSelected = false;
					mode = new Mode(new WriteToXmlFile(new File(dstPath), htmlTransformSelected));
					mode.executeStrategy(competition);

				} else if (args[i].equals(Strategy.OUTPUT_TO_HTML)) {

					String dstPath = args[++i];
					htmlTransformSelected = true;
					mode = new Mode(new WriteToXmlFile(new File(dstPath), htmlTransformSelected));
					mode.executeStrategy(competition);

				} else {

					System.err.println("\n>>> ERROR: invalid command-line parameter: " + args[i]);
					break;
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("\n>>> ERROR: parameter value for the specified operation mode is missing");
		}

		System.out.println("\nThank you, come again!");
	}
}
