package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.interfaces.IResultsLoader;
import net.azib.java.students.t100224.homework.interfaces.IResultsPrinter;
import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CsvIO implements IResultsLoader, IResultsPrinter {

	private static final Logger LOG = Logger.getLogger("IO");
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	private String filename;

	public CsvIO(String filename) {
		this.filename = filename;
	}

	@Override
	public List<Result> loadResults() {
		List<Result> results = new ArrayList<Result>();
		try {
			Scanner scanner = new Scanner(new File(filename))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				results.add(readLine(scanner.next()));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			LOG.error("File " + filename + " does not exists!");
		}
		return results;
	}

	@Override
	public void printResults(List<Result> results) {
		Writer fileWriter;
		PrintWriter out;
		try {
			fileWriter = new FileWriter(filename);
			out = new PrintWriter(fileWriter);

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
			out.close();
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
	}

	public static Result readLine(String line) {
		Result result = new Result();
		Athlete athlete = new Athlete();
		//	String TIME_FORMAT = "([0-9]{1,2}\\:)*[0-5][0-9]\\.[0-9][0-9]";
		String time;
		Scanner lineScanner = new Scanner(line).useDelimiter(", *");
		lineScanner.useLocale(Locale.US); //used the "Locale.US" to make sure that the PERIOD is used as decimal separator.
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

			time = lineScanner.next();
			result.setSprint400(convertToSeconds(time));

			result.setHurdles110(lineScanner.nextFloat());
			result.setDiscusThrow(lineScanner.nextFloat());
			result.setPoleVault(lineScanner.nextFloat());
			result.setJavelinThrow(lineScanner.nextFloat());

			time = lineScanner.next();
			result.setRace1500(convertToSeconds(time));

		} catch (InputMismatchException e) {
			e.printStackTrace();
		}

		result.setAthlete(athlete);
		return result;
	}

	private static float convertToSeconds(String time) {
		float seconds = 0;
		int minutesParsed;

		if (time.indexOf(":") == -1) {
			try {
				seconds = Float.parseFloat(time);
			} catch (NumberFormatException e) {
				LOG.error(e.getMessage());
			}
		} else {
			try {
				String minutes = time.substring(0, 1);
				minutesParsed = Integer.parseInt(minutes);
				seconds = Float.parseFloat(time.substring(2, time.length()));
				seconds += minutesParsed * 60;
			} catch (NumberFormatException e) {
				LOG.error(e.getMessage());
			}
		}

		return seconds;
	}

}
