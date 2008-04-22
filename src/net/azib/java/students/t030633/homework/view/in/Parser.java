package net.azib.java.students.t030633.homework.view.in;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Parses input strings.
 * 
 * @author t030633
 */
public class Parser {

	// TODO comment
	public Date parseDate(String date) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale(System.getProperty("user.country")));
		try {
			return df.parse(date);
		}
		catch (ParseException e) {
			return null;
		}
	}

	// TODO Comment
	public double[] parseResults(String[] results) {
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

	/**
	 * @param string
	 * @return String - string without quotation marks
	 */
	public String parseName(String name) {
		return name.replace('"', ' ').trim();
	}

}
