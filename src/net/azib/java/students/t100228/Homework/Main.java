package net.azib.java.students.t100228.Homework;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * The main class of the program. Contains the method which actually does the program's job
 * @author Martin
 */
public class Main {
	/**
	 * Main method of the program
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		ArrayList<Integer> arrayListScores;
		ArrayList<Record> arrayListRecords = new ArrayList<Record>(); // each element is the raw record of one competitor
		CommandLineParser parser = new CommandLineParser(args);
		if(!parser.hasValidArguments)
		{
			System.out.println("Found invalid command line arguments. Make sure the command line is in the form ");
			System.out.println("-<input-method> [input-parameters] -<output-method> [output-parameters]");
			System.out.println("and all file paths and database parameters are valid");
			return;
		}

		InputOutputParams params = parser.getInputOutputParams();

		ConsoleResultsManager consoleResultsManager = new ConsoleResultsManager();
		CsvResultsManager csvResultsManager = new CsvResultsManager();

		try
		{
			switch(params.getInputMethod())
			{
				case INPUT_METHOD_CONSOLE:
					consoleResultsManager.fetchResults(arrayListRecords,  new InputStreamReader(System.in));
					break;
				case INPUT_METHOD_DB:
					DbResultsFetcher dbResultsFetcher = new DbResultsFetcher();
					dbResultsFetcher.fetchResults(arrayListRecords, params.getCompetitionIdOrName());
					break;
				case INPUT_METHOD_CSV:
					csvResultsManager.fetchResults(arrayListRecords, params.getInputFilePath());
					break;
			}
		}
		catch (Exception ex)
		{
			System.out.println("Could not fetch results from the input stream.");
			return;
		}

		ResultsCalculator resultsCalculator = new ResultsCalculator();
		try
		{
			resultsCalculator.calculateResults(arrayListRecords);
			resultsCalculator.calculatePlaces(arrayListRecords);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		try
		{
			switch(params.getOutputMethod())
			{
				case OUTPUT_METHOD_CONSOLE:
					consoleResultsManager.outputResults(arrayListRecords, new OutputStreamWriter(System.out));
					break;
				case OUTPUT_METHOD_CSV:
					csvResultsManager.outputResults(params.getOutputFilePath(), arrayListRecords);
					break;
				case OUTPUT_METHOD_XML:
					XmlResultsManager xmlResultsManager = new XmlResultsManager();
					xmlResultsManager.outputResults(params.getOutputFilePath(), arrayListRecords);
					break;
				case OUTPUT_METHOD_HTML:
					HtmlResultsManager htmlResultsManager = new HtmlResultsManager();
					htmlResultsManager.outputResults(params.getOutputFilePath(), arrayListRecords);
					break;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
