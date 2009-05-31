package net.azib.java.students.t090437.homework;

/**
 * Decathlon
 *
 * @author Ronald
 */
public class DecathlonCalculator {
	private static final String[] input_methods = {"-console", "-csv", "-db"};
	private static final String[] output_methods = {"-console", "-csv", " -xml", "-html"};
	
	private static String input_arg;
	private static String output_arg;
	
	private static String inputMethod;
	private static String outputMethod;
	
	public static void main(String[] args) {
//		CompetitionDataLoader loader;
//		CompetitionResultsProducer producer;
		
		parseArguments(args);
		
		System.out.println(inputMethod);
		System.out.println(input_arg);
		System.out.println(outputMethod);
		System.out.println(output_arg);
//		
//		//loader = new CompetitionFromCSV("C:\\data.csv");
//		loader = new CompetitionFromDB("DECATHLON4BEER");
//		//producer = new CompetitionToXML("C:\\results.xml");
//		producer = new CompetitionToHTML("C:\\results.html");
//		
//		try {
//			loader.loadAndProcessData();
//		} catch(DataLoadException e) {
//			System.out.println("Failed to load data!\r\n" + e);
//			return;
//		}
//		
//		producer.setCompetitionResults(loader.getResults());
//		producer.produceResults();
	}
	
	private static void parseArguments(String[] args) {
		int i;
		int startOfInputArgument = 0, endOfInputArgument = -1;
		
		SearchForInputMethodLoop:
			for(i = 1;i < args.length - 1;i++) {
				for(int j = 0;j < input_methods.length;j++) {
					if(args[i].equals(input_methods[j])) {
						inputMethod = input_methods[j];
						startOfInputArgument = i + 1;
						break SearchForInputMethodLoop;
					}
				}
			}
		
		SearchForOutputMethodLoop:
			for(;i < args.length;i++) {
				for(int j = 0;j < output_methods.length;j++) {
					if(args[i].equals(output_methods[j])) {
						outputMethod = output_methods[j];
						endOfInputArgument = i - 1;
						break SearchForOutputMethodLoop;
					}
				}
			}
			
		input_arg = "";
		for(int j = startOfInputArgument; j <= endOfInputArgument;j++) {
			input_arg = input_arg + args[j] + " ";
		}
		if(startOfInputArgument <= endOfInputArgument) {
			input_arg = input_arg.substring(0, input_arg.length() - 2);
		}
		
		output_arg = "";
		for(;i < args.length;i++) {
			output_arg = output_arg + args[i] + " ";
		}
		if(endOfInputArgument + 1 < args.length) {
			output_arg = output_arg.substring(0, input_arg.length() - 2);
		}	
	}
}
