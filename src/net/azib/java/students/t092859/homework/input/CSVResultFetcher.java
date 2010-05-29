package net.azib.java.students.t092859.homework.input;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

/**
 * CSVResultFetcher
 *
 * @author konstantin
 */
public class CSVResultFetcher implements DecathlonResultFetcher {

	Reader csvInput;
	
	/**
	 * @param csvInput - input CSV file reader
	 */
	public CSVResultFetcher(Reader csvInput) {
		this.csvInput = csvInput;
	}

	/**
	 * Fetches decathlon results from CSV file.
	 */
	@Override
	public List<DecathlonResult> fetchResults() {
		List<DecathlonResult> results = new ArrayList<DecathlonResult>();
		
		Scanner scanner = new Scanner(csvInput);
		String[] parameters;
		while(scanner.hasNextLine())
		{
			parameters = scanner.nextLine().split(",");
			parameters[0] = parameters[0].replaceAll("\"", "");
			DecathlonResult result = new DecathlonResult(parameters);
			int incorrectParam;
			if((incorrectParam = result.getValidationResult()) == -1)
				results.add(result);
			else
				System.err.println("Could not accept result: incorrect parameter " + incorrectParam);
		}
		
		IOUtils.closeQuietly(csvInput);
		return results;
	}
}
