package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.model.Result;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.azib.java.students.t100224.homework.io.CsvLoader.readLine;

public class ConsoleLoader implements ResultsLoader, ResultsPrinter {

	private PrintStream out = System.out;

	@Override
	public List<Result> loadResults(String p) {
		List<Result> results = new ArrayList<Result>();
		out.println("Enter a line of text (type 'stop' to exit): ");
		Scanner scanner = new Scanner(System.in);
		String line;

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (!line.equalsIgnoreCase("stop"))
				results.add(readLine(line));
			else break;
		}
		scanner.close();
		return results;
	}

	@Override
	public void printResults(List<Result> results, String p) {
		out.println("Here are the results: ");
		for (Result result : results) {
			//TODO
		}
	}
}
