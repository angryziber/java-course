package net.azib.java.students.t100224.homework.controller;

import net.azib.java.students.t100224.homework.db.DBLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsPrinter;
import net.azib.java.students.t100224.homework.io.ConsoleIO;
import net.azib.java.students.t100224.homework.io.CsvIO;
import net.azib.java.students.t100224.homework.model.Result;
import net.azib.java.students.t100224.homework.xml.HTMLPrinter;
import net.azib.java.students.t100224.homework.xml.XMLPrinter;

import java.util.Collections;
import java.util.List;


public class DecathlonController {

	public IResultsLoader loader;
	public IResultsPrinter printer;

	private List<Result> results;

	public DecathlonController(String[] args) {
		if (args[0].equals("-console")) {
			loader = new ConsoleIO();

			if (args[1].equals("-console")) printer = new ConsoleIO();
			if (args[1].equals("-csv")) printer = new CsvIO(args[2]);
			if (args[1].equals("-xml")) printer = new XMLPrinter(args[2]);
			if (args[1].equals("-html")) printer = new HTMLPrinter(args[2]);

		} else {
			if (args[0].equals("-csv")) loader = new CsvIO(args[1]);
			if (args[0].equals("-db")) loader = new DBLoader(args[1]);
			if (args[2].equals("-console")) printer = new ConsoleIO();
			if (args[2].equals("-csv")) printer = new CsvIO(args[3]);
			if (args[2].equals("-xml")) printer = new XMLPrinter(args[3]);
			if (args[2].equals("-html")) printer = new HTMLPrinter(args[3]);
		}

	}

	public void getDecathlonResults() {
		results = loader.loadResults();
		calculateScores();
		sortResults();
		printer.printResults(results);
	}

	private void calculateScores() {
		for (Result result : results) {
			result.countTotalScore();
		}
	}

	private void sortResults() {
		Collections.sort(results);
	}

}
