package net.azib.java.students.t100224.homework.controller;

import net.azib.java.students.t100224.homework.db.DBReader;
import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Result;
import net.azib.java.students.t100224.homework.xml.XMLWriter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DecathlonController {

	private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private final String TIME_FORMAT = "([0-9]{1,2}:)?[0-5][0-9]\\.[0-9][0-9]";
	private PrintStream out = System.out;
	private ArrayList<Result> results = new ArrayList<Result>();

	public DecathlonController(String[] args) {
		if (args[0].equalsIgnoreCase("-console")) {

			readConsole();

		} else if (args[0].equalsIgnoreCase("-csv")) {

			readFile(args[1]);

		} else if (args[0].equalsIgnoreCase("-db")) {

			readDB(args[1]);

		} else {
			out.println("");
		}


//		switch (args.length) {
//			case 1:
//			case 2:
//		}

	}

	public void calculateScores() {
		for (Result result : results) {
			result.countTotalScore();
		}
	}

	public void sortAthletes() {
		Collections.sort(results);
	}

	public void readConsole() {
		out.println("Enter a line of text (type 'stop' to exit): ");
		Scanner scanner = new Scanner(System.in);
		String line;

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (!line.equalsIgnoreCase("stop"))
				readLine(line);
			else break;
		}
		scanner.close();
	}

	public void readFile(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				readLine(scanner.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void readLine(String line) {
		Result result = new Result();
		Athlete athlete = new Athlete();
		Scanner lineScanner = new Scanner(line).useDelimiter(", *");
		lineScanner.useLocale(Locale.US);
		athlete.setName(lineScanner.next());
		try {
			athlete.setDateOfBirth(DATE_FORMAT.parse(lineScanner.next()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		athlete.setCountry(lineScanner.next());
		try {
			result.setSprint100(lineScanner.nextFloat());
			result.setLongJump(lineScanner.nextFloat());
			result.setShotPut(lineScanner.nextFloat());
			result.setHighJump(lineScanner.nextFloat());

			lineScanner.next(TIME_FORMAT);
			// result.setSprint400();

			result.setHurdles110(lineScanner.nextFloat());
			result.setDiscusThrow(lineScanner.nextFloat());
			result.setPoleVault(lineScanner.nextFloat());
			result.setJavelinThrow(lineScanner.nextFloat());

			lineScanner.next();

			// result.setRace1500(lineScanner.nextFloat());
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

		result.setAthlete(athlete);
		results.add(result);
	}

	public void readDB(String competition) {
		DBReader db = new DBReader(competition);
		results = db.loadResults();
	}

	public void printResultsIntoXML(String filename) {
		XMLWriter xml = new XMLWriter();
		try {

			xml.createXML(filename, results);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public void printResultsIntoHTML(String filename) {
		XMLWriter xml = new XMLWriter();
		try {

			xml.createHTML(filename, results);

		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void printResults() {
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
