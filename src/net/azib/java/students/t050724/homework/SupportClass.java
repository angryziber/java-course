package net.azib.java.students.t050724.homework;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * ConversionHelper
 * 
 * @author xom
 */
public class SupportClass {

	/**
	 * Converts the parameter double value to String for outputting. The purpose
	 * of this conversion is to make the result value look like minutes and
	 * seconds.
	 * 
	 * @param result
	 *            Double value which to convert to String.
	 * @return String representation of the parameter "result" value, if larger
	 *         than 60, consists of "minutes" and "seconds".
	 */
	protected String getAthleteResultWithMins(double result) {

		DecimalFormat form = new DecimalFormat("00.00");
		DecimalFormatSymbols dfs = form.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		form.setDecimalFormatSymbols(dfs);

		if (result > 60) {

			Integer temp1Result;
			String temp2Result;
			String resultWithMins;

			temp1Result = (int) ((result - (result % 60)) / 60);
			temp2Result = form.format((result % 60));

			resultWithMins = temp1Result.toString() + ":" + temp2Result;

			return resultWithMins;

		}
		else
			return form.format(result);
	}

	/**
	 * Checks if the parameter name is valid.
	 * 
	 * @param name
	 *            String to check
	 * @return Parameter value "name", if it is valid.
	 * @throws Exception
	 *             If parameter name is not valid.
	 */
	protected String checkAthleteName(String name) throws Exception {

		if (name.matches("[^0-9]+")) {
			return name;
		}
		else {
			throw new Exception();
		}

	}

	/**
	 * Tries to parse parameter String into Date.
	 * 
	 * @param inDate
	 *            String which to convert.
	 * @return Date that has been parsed from input parameter.
	 * @throws java.text.ParseException
	 *             When the parameter cannot be parsed into Date.
	 */
	protected Date checkAthleteDate(String inDate) throws java.text.ParseException {

		SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");

		return date.parse(inDate);

	}

	/**
	 * Checks if the parameter String is a 2-letter country code defined in ISO
	 * 3166 and returns it when so.
	 * 
	 * @param inCountry
	 *            String which to check
	 * @return Parameter value "inCountry" if it is 2-letter country code.
	 * @throws Exception
	 *             If the parameter "inCountry" is not a 2-letter country code.
	 */
	protected String checkAthleteCountry(String inCountry) throws Exception {

		for (String locale : Locale.getISOCountries()) {
			if (locale.equals(inCountry))
				return inCountry;
		}
		throw new Exception();

	}

	/**
	 * If the parameter String is "minutes:seconds" representation, tries to
	 * convert it into Double (seconds) and if it already matches number
	 * representation, tries to parse it into Double.
	 * 
	 * @param inResult
	 *            String which to convert into Double
	 * @return Parameter inResult parsed into Double.
	 * @throws Exception
	 *             When parameter "inResult" cannot be parsed into Double or
	 *             when it doesn't match the "minutes:seconds" or "seconds"
	 *             pattern.
	 */
	protected double setAthleteResultDoubleWithMins(String inResult) throws Exception {

		if (inResult.matches("[0-9]+:{1}[0-9]+\\.?[0-9]*")) {
			String[] tempResult = inResult.split(":");
			return (Double.parseDouble(tempResult[0]) * 60) + Double.parseDouble(tempResult[1]);
		}
		else if (inResult.matches("[0-9]+\\.?[0-9]*")) {

			return Double.parseDouble(inResult);
		}
		else {
			throw new Exception();
		}

	}

	/**
	 * Converts the parameter ArrayList<Athlete> into ArryList<String>. Formats
	 * its variables that are not String into String.
	 * 
	 * @param athletes
	 *            ArrayList<Athlete> which to convert.
	 * @return ArrayList<String> in which elements are data from parameter
	 *         "athletes" presented as a String.
	 */
	protected ArrayList<String> createAthleteStrings(ArrayList<Athlete> athletes) {

		DecimalFormat format = new DecimalFormat("#.00");
		DecimalFormatSymbols dfs = format.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		format.setDecimalFormatSymbols(dfs);
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy");

		ArrayList<String> athleteStrings = new ArrayList<String>();
		for (Athlete athlete : athletes) {
			athleteStrings.add(athlete.getPlace() + ", " + athlete.getScore() + ", " + athlete.getName() + ", "
					+ simpleDate.format(athlete.getDate()) + ", " + athlete.getCountry() + ", " + format.format(athlete.getHm())
					+ ", " + format.format(athlete.getLongJump()) + ", " + format.format(athlete.getShotPut()) + ", "
					+ format.format(athlete.getHighJump()) + ", " + getAthleteResultWithMins(athlete.getFhm()) + ", "
					+ format.format(athlete.getHtmHurdles()) + ", " + format.format(athlete.getDiscusThrow()) + ", "
					+ format.format(athlete.getPoleVault()) + ", " + format.format(athlete.getJavelinThrow()) + ", "
					+ getAthleteResultWithMins(athlete.getTfhm()));
		}
		return athleteStrings;
	}

	/**
	 * Converts the parameter String into absolute pathname.
	 * 
	 * @param path
	 *            String of which to get the absolute pathname.
	 * @return String that represents absolute pathname of the parameter "path".
	 */
	protected String setFilePath(String path) {
		File dir = new File(path);
		path = dir.getAbsolutePath();
		return path;
	}

}
