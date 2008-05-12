package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads decathlon input athletes and their results from a comma separated file.
 * 
 * @author t030633
 */
public class CSV implements Input {

	private String fileName;
	private String filePath;
	private BufferedReader reader;

	public CSV() {
	}

	public CSV(BufferedReader reader) {
		this.reader = reader;
	}

	public List<Athlete> read(AthleteBuilder builder) throws IOException {

		if (reader == null) {
			if (fileName == null)
				throw new IOException("Input file not specified.");
			InputStream input;
			try {
				input = new FileInputStream(new File(filePath, fileName));
			}
			catch (FileNotFoundException e) {
				throw new IOException("Input file not found.");
			}
			reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
		}
		List<Athlete> list = new LinkedList<Athlete>();
		String line;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			try {
				list.add(parseAthlete(builder, line));
			}
			catch (ParseException e) {
				throw new IOException("Unable to parse athlete from file. Line: " + line);
			}
		}
		return list;

	}

	private Athlete parseAthlete(AthleteBuilder builder, String line) throws ParseException {
		String[] fields = line.split(",");
		String[] stringResults = new String[Event.values().length];
		System.arraycopy(fields, 3, stringResults, 0, Event.values().length);
		double[] doubleResults = parseResults(stringResults);
		int i = 0;
		for (Event e : Event.values()) {
			builder.addResult(e, doubleResults[i++]);
		}
		return builder.name(parseName(fields[0])).date(parseDate(fields[1])).country(fields[2]).build();
	}

	private Date parseDate(String date) throws ParseException {
		// Using system date format, which the user probably assumes
		DateFormat df = DateFormat.getDateInstance();
		try {
			return df.parse(date);
		}
		catch (ParseException e) {
			throw new ParseException("Unable to parse date.", e.getErrorOffset());
		}
	}

	private double[] parseResults(String[] results) {
		double[] numbers = new double[results.length];
		for (int i = 0; i < results.length; i++) {
			if (results[i].contains(":")) {
				String[] minutes = results[i].split(":");
				numbers[i] = Integer.parseInt(minutes[0]) * 60 + Double.parseDouble(minutes[1]);
			}
			else if (results.length > i)
				numbers[i] = Double.parseDouble(results[i]);
		}
		return numbers;
	}

	private String parseName(String name) {
		// remove all quotation marks from the string and replace them with
		// spaces, then remove leading and trailing spaces
		return name.replace('"', ' ').trim();
	}

	public void setParameters(String... param) {
		fileName = param[1]; // Parameter 1 should be a file name
		filePath = param[0]; // Parameter 0 should be file path
	}

}
