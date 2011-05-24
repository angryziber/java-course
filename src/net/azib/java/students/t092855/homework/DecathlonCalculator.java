package net.azib.java.students.t092855.homework;

/**
 * DecathlonCalculator
 * The main module of the program
 * @author t092855
 */
public class DecathlonCalculator {

	/**
	 * The program starts to run from this method.
	 *
	 * @param args todo
	 */
	public static void main(String[] args) {
		InputStrategy inputStrategy;
		OutputStrategy outputStrategy;
		Competition competition;

		// todo choose input strategy from parameters and use it to create athlete list
		inputStrategy = new InputConsole();
		competition = inputStrategy.getData();

//		inputStrategy = new InputCSV();
//		competition = inputStrategy.getData("decathlon_data.csv");

//		inputStrategy = new InputDB();
//		competition = inputStrategy.getData("DECATHLON4BEER");

		// todo choose output strategy from parameters and use it
		outputStrategy = new OutputConsole();
		outputStrategy.writeOutput(competition);

//		outputStrategy = new OutputXML();
//		outputStrategy.writeOutput(competition, "decathlon.xml");

//		outputStrategy = new OutputCSV();
//		outputStrategy.writeOutput(competition, "decathlon_out.csv");

//		outputStrategy = new OutputHTML();
//		outputStrategy.writeOutput(competition, "decathlon.html");
	}
}
