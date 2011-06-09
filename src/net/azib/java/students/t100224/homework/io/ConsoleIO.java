package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.interfaces.IResultsLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsPrinter;
import net.azib.java.students.t100224.homework.model.Result;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.azib.java.students.t100224.homework.io.CsvIO.readLine;

public class ConsoleIO implements IResultsLoader, IResultsPrinter {

	private PrintStream out = System.out;

	@Override
	public List<Result> loadResults() {
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
	public void printResults(List<Result> results) {
		out.println("Here are the results: ");
		for (Result result : results) {
			out.printf("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s \n",
					results.indexOf(result) + 1,
					result.getTotalScore(),
					result.getAthlete().getName(),
					result.getAthlete().getDateOfBirth(),
					result.getAthlete().getCountry(),
					result.getSprint100(),
					result.getLongJump(),
					result.getShotPut(),
					result.getHighJump(),
					result.getSprint400(),
					result.getHurdles110(),
					result.getDiscusThrow(),
					result.getPoleVault(),
					result.getJavelinThrow(),
					result.getRace1500());
		}
	}
}
