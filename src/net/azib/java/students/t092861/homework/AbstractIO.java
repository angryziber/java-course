package net.azib.java.students.t092861.homework;

import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Abstract class that hold common for all inputs/outputs methods.
 * 
 * @author Stanislav / 092861
 * 
 */
public abstract class AbstractIO {

	/**
	 * Controller instance.
	 */
	public Controller ctrl;
	/**
	 * Holds the input data from file/console. Each element consists of 13 comma separated values.
	 */
	public ArrayList<String> inputData;
	
	/**
	 * System.out local variable. 
	 */
	public static PrintStream out = System.out;

	/**
	 * Default constructor.
	 * 
	 * @param ctrl - controller
	 */
	public AbstractIO(Controller ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * Reads the data from the input source (console, csv or db). 
	 * 
	 * @return ArrayList of all the athletes
	 */
	abstract ArrayList<Athlete> input();

	/**
	 *  Writes athletes data to the output source (conole, csv, xml, html).
	 * 
	 * @param athletes
	 *            ArrayList of type Athletes
	 */
	abstract void output(ArrayList<Athlete> athletes);
	
	/**
	 * Gets the IO parameters.
	 * 
	 * @return parameters as String
	 */
	public abstract String getParameters();

	/**
	 * Arranging the athletes in descending order of the total score (ascending
	 * order of their places).
	 * 
	 * @param athletes
	 *            - non arranged list.
	 * @return ascending ordered list.
	 */
	public ArrayList<Athlete> arrangeInOrder(ArrayList<Athlete> athletes) {
		// modified merge sort
		Collections.sort(athletes, new Comparator<Athlete>() {
			@Override
			public int compare(Athlete a, Athlete b) {
				if (a.getScore() < b.getScore()) {
					return 1; // greater than
				} else if (a.getScore() > b.getScore()) {
					return -1; // less than
				} else {
					return 0; // equal to
				}
			}
		});
		int athletePoints = 0, athletePlace = 0;

		for (Athlete athlete : athletes) {
			if (athletePlace == 0) {
				athletePlace = 1;
				athletePoints = athlete.getScore();
				athlete.setPlace(athletePlace);

			} else if (athlete.getScore() != athletePoints) {
				athletePlace++;
			}
			athletePoints = athlete.getScore();
			athlete.setPlace(athletePlace);
		}
		return athletes;
	}

	/**
	 * Processes the parameters. Checks if the output directory exits. Creates
	 * one if not.
	 * 
	 * @param outputParameters
	 *            for output file. Example: /tmp/results.html or results.xml
	 * @return File that is used as output
	 */
	public File getOutputFile(String outputParameters) {
		File file;
		String dir = getDirectory(outputParameters);
		String filename = getFilename(outputParameters);
		if (!dir.equals(getParameters())) {
			createDirectory(Const.PACKAGE + dir);
			file = new File(Const.PACKAGE + dir + filename);
		} else {
			file = new File(Const.PACKAGE + filename);
		}
		return file;
	}

	/**
	 * Separates the filename from the path.
	 * 
	 * @param path
	 *            to the file.
	 * @return the filename as string if it exist.
	 */
	private String getFilename(String path) {
		// if parameter contains a separation slash / or \
		if (path.contains(Const.SEPARATOR)) {
			return path.substring(path.lastIndexOf(Const.SEPARATOR) + 1, path
					.length());
		} else {
			return path;
		}
	}

	/**
	 * Separates the path from the filename.
	 * 
	 * @param path
	 *            to the file.
	 * @return the path as string if it exist.
	 */
	private String getDirectory(String path) {
		if (path.contains(Const.SEPARATOR)) {
			return path.substring(1, path.lastIndexOf(Const.SEPARATOR) + 1);
		} else {
			return path;
		}
	}

	/**
	 * Creates new directory.
	 * 
	 * @param dir
	 *            that should be created
	 * @return true if directory was successfully created
	 */
	private boolean createDirectory(String dir) {
		try {
			File f = new File(dir);
			if (!f.exists()) {
				f.mkdir();
				System.out
						.println("New directory " + dir + " has been created");
			}
		} catch (Exception e) {
			System.out.println("Error creating directory");
			return false;
		}
		return true;
	}

	/**
	 * Formats a Date into a dd.MM.yyyy string.
	 * 
	 * @param date
	 *            the time value to be formatted into a time string.
	 * @return the formatted time string.
	 */
	public String convertDateToString(Date date) {
		if (date == null) {
			return "";
		}
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		return formatter.format(date);
	}

	/**
	 * Formats Float time values to ##:##.## representation.
	 * 
	 * @param time
	 *            in seconds
	 * @return time in String format
	 */
	public String convertTimeToString(Float time) {
		DecimalFormat df = new DecimalFormat("##.##");
		DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		String fraction = df.format(Float.valueOf(time % 60));

		return (time > 60 ? Integer.valueOf(time.intValue() / 60) + ":" : "") + fraction;
	}

	/**
	 * Formats Date to another format.
	 * 
	 * @param date to be converted
	 * @return the date in dd.MM.yyyy format.
	 */
	public String convertDateDMY(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(date);
	}
}
