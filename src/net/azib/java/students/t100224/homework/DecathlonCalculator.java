package net.azib.java.students.t100224.homework;

import net.azib.java.students.t100224.homework.io.ResultsLoader;
import net.azib.java.students.t100224.homework.io.ResultsPrinter;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static net.azib.java.students.t100224.homework.model.Decathlon.countPoints;

public class DecathlonCalculator {

	List<Result> results;

	ResultsLoader loader;
	ResultsPrinter printer;

	String inputParam;
	String outputParam;

	public DecathlonCalculator(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		for (int i = 0; i < args.length; i++) {
			if (args[i].startsWith("-")) {
				if (i == 0)
					loader = (ResultsLoader) Class.forName(getClassPath(args[i]) + "Loader").newInstance();
				else
					printer = (ResultsPrinter) Class.forName(getClassPath(args[i]) + "Printer").newInstance();
			} else {
				if (i == 1) inputParam = args[i];
				else
					outputParam = args[i];
			}
		}
	}

	private String getClassPath(String arg) {
		arg = arg.substring(1);
		arg = arg.substring(0, 1).toUpperCase() + arg.substring(1).toLowerCase();
		return DecathlonCalculator.class.getPackage().getName() + ".io." + arg;
	}

	private void process() {
		results = loader.loadResults(inputParam);
		countTotalScores();
		sort();
		printer.printResults(results, outputParam);
	}

	private void countTotalScores() {
		for (Result result : results) {
			int totalScore = 0;
			for (Map.Entry<String, Float> map : result.getPerformances().entrySet()) {
				totalScore += countPoints(map.getKey(), map.getValue());
			}
			result.setTotalScore(totalScore);
		}
	}

	private void sort() {
		Collections.sort(results);
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (args.length < 2) {
			System.err
					.println("Usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
		} else {
			DOMConfigurator.configure(DecathlonCalculator.class.getResource("log4j.xml"));
			DecathlonCalculator c = new DecathlonCalculator(args);
			c.process();
		}

	}

}
