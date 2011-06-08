package net.azib.java.students.t100224.homework.controller;

import net.azib.java.students.t100224.homework.db.DBLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsPrinter;
import net.azib.java.students.t100224.homework.io.IOProcessor;
import net.azib.java.students.t100224.homework.model.Result;
import net.azib.java.students.t100224.homework.xml.HTMLPrinter;
import net.azib.java.students.t100224.homework.xml.XMLPrinter;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;


public class DecathlonController {

	private final Logger LOG = Logger.getLogger(getClass().getName());

	private IResultsLoader loader;
	private IResultsPrinter printer;

	private List<Result> results;

	public DecathlonController(String[] args) {
		if (args[0].equals("-console")) {
			// TODO loader = new ...

			if (args[1].equals("-console")) //TODO printer = new ...
			if (args[1].equals("-csv")) printer = new IOProcessor();
			if (args[1].equals("-xml")) printer = new XMLPrinter();
			if (args[1].equals("-html")) printer = new HTMLPrinter();

		} else {
			if (args[0].equals("-csv")) loader = new IOProcessor();
			if (args[0].equals("-db")) loader = new DBLoader();
			if (args[2].equals("-console")) //TODO printer = new ...
			if (args[2].equals("-csv")) printer = new IOProcessor();
			if (args[2].equals("-xml")) printer = new XMLPrinter();
			if (args[2].equals("-html")) printer = new HTMLPrinter();
		}

	}

	public void getDecathlonResults() {
		results = loader.loadResults("");
		calculateScores();
		sortResults();
		printer.printResults("", results);
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
