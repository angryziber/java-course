package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.interfaces.IResultsLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsPrinter;
import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class IOProcessor implements IResultsLoader, IResultsPrinter {

	private final Logger LOG = Logger.getLogger(getClass().getName());

	private final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	List<Result> results;

	@Override
	public List<Result> loadResults(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				readLine(scanner.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			LOG.error("File " + filename + " does not exists!");
		}
		return results;
	}

	@Override
	public void printResults(String filename, List<Result> results) {
		// TODO Auto-generated method stub

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
			LOG.error("Invalid date format");
		}
		athlete.setCountry(lineScanner.next());
		try {
			result.setSprint100(lineScanner.nextFloat());
			result.setLongJump(lineScanner.nextFloat());
			result.setShotPut(lineScanner.nextFloat());
			result.setHighJump(lineScanner.nextFloat());
			// TODO
			String TIME_FORMAT = "([0-9]{1,2}:)?[0-5][0-9]\\.[0-9][0-9]";
			lineScanner.next(TIME_FORMAT);
			// result.setSprint400();

			result.setHurdles110(lineScanner.nextFloat());
			result.setDiscusThrow(lineScanner.nextFloat());
			result.setPoleVault(lineScanner.nextFloat());
			result.setJavelinThrow(lineScanner.nextFloat());

			// TODO
			lineScanner.next();

			// result.setRace1500(lineScanner.nextFloat());
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

		result.setAthlete(athlete);
		results.add(result);
	}

}
