package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.model.Athlete;
import net.azib.java.students.t100224.homework.model.Decathlon;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CsvLoader implements ResultsLoader, ResultsPrinter {

	private static final Logger LOG = Logger.getLogger("IO");
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

	@Override
	public List<Result> loadResults(String filename) {
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
	public void printResults(List<Result> results, String filename) {
		Writer fileWriter;
		PrintWriter out;
		try {
			fileWriter = new FileWriter(filename);
			out = new PrintWriter(fileWriter);

			for (Result result : results) {
				//TODO
			}
			out.close();
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
	}

	public static Result readLine(String line) {
		Result result = new Result();
		Athlete athlete = new Athlete();
		Map<String, Float> performances = new HashMap<String, Float>();
		//	String TIME_FORMAT = "([0-9]{1,2}\\:)*[0-5][0-9]\\.[0-9][0-9]";
		String time;
		Scanner lineScanner = new Scanner(line).useDelimiter(", *");
		lineScanner.useLocale(Locale.US); //used the "Locale.US" to make sure that the PERIOD is used as decimal separator.

		try {
			athlete.setName(lineScanner.next());
			athlete.setDateOfBirth(DATE_FORMAT.parse(lineScanner.next()));
			athlete.setCountry(lineScanner.next());
			for (int i = 0; i < Decathlon.Event.values().length; i++) {
				performances.put(Decathlon.Event.values()[i].name(), lineScanner.nextFloat());
			}

		} catch (ParseException e) {
			LOG.error("Invalid date format");
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
