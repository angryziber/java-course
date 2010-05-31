package net.azib.java.students.t092851.homework;

import java.util.Locale;


/**
 * DecathlonCalculator
 *
 * @author Lauri
 */
public class DecathlonCalculator {

	/**
	 * @param args - program arguments:
	 * 				-<input-method> [input-parameters]
	 *				-<output-method> [output-parameters]
	 */
	public static void main(String[] args) {
		DecathlonDataInput  input;
		DecathlonDataOutput output;
		DecathlonData       data;
		IOSelector          io;
		
		try {
			// In general all data is entered and displayed as in English
			Locale.setDefault(new Locale("en"));
			
			System.out.println("Analyzing command line options...");
			io = new IOSelector(args);
			
			if (io.isValid()) {
				input  = io.createDataInput();
				System.out.println("Reading input data...");
				data   = input.readData();
				if (data != null) {
					data.rankParticipants();
					output = io.createDataOutput();
					System.out.println("Writing output...");
					if (output.writeData(data))
						System.out.println("Successfully done!");
				}
				else {
					System.out.println("No input data available - output not written.");
				}
			}
			else {
				System.out.println("Invalid command line options. Please check!");
				io.printHelp();
			}
		}		
		catch (Exception e) {
			System.out.println("Unexpected error: \"" + e.toString() + "\". Program terminates.");
			e.printStackTrace();
		}
	}
	
}
