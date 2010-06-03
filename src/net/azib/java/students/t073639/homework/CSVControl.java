package net.azib.java.students.t073639.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * CSVControl class extends AthleteList.<br>
 * Instance of CSVControl class has methods to read or write csv files. 
 * 
 * 
 * @author t073639
 * @see AthleteList
 */
public class CSVControl extends AthleteList {

	/**
	 * <p>
	 * Create a new list of athletes, added from file(*.csv).
	 * 
	 * @param string
	 *            - File path or file name.
	 */
	public CSVControl(String string) {
		super();
		this.readAndCollectRecords(string);
	}

	/**
	 * <p>
	 * Create a new empty list of athletes.
	 */
	public CSVControl() {
		super();
	}

	/**
	 * <p>
	 * Create a new list of athletes, which is copy of parameter.
	 * 
	 * @param inputAthleteList
	 *            - List of athletes
	 */
	public CSVControl(List<Athlete> inputAthleteList) {
		super(inputAthleteList);
	}

	private void readAndCollectRecords(String string) {
		File file = new File(string);
		if (file.exists()) {
			System.out.println("\t*" + file.toURI() + "...OK");
			LineNumberReader reader = null;
			try {
				reader = new LineNumberReader(new FileReader(file));
			}
			catch (FileNotFoundException e) {
				System.out.println("\t*Error:Incorrect name\\path of input file");
			}
			String s;
			Pattern p = Pattern.compile("\"[\\D\\ ]+\"," + "[0-9]{1,2}\\.[0-9]{2}\\.[0-9]{4},[A-Z]{2}"
					+ "((\\,\\d{1,3}\\.\\d{1,2})|(\\,\\d{3}(\\.\\d{1,2})*)|(\\,\\d{1,2}(\\:\\d{1,2}\\.\\d{1,2}))){10}");
			Matcher m;
			try {
				while ((s = reader.readLine()) != null) {
					m = p.matcher(s);
					if (m.find()) {
						this.addNewAthlete(m.group());
					}
				}
			}
			catch (IOException e) {
				System.out.println("\t*Error:Problems with reading file");
			}
			finally {
				if (reader != null)
					try {
						reader.close();
					}
					catch (IOException e) {
						System.out.println("\t*Problem with closing LineNumberedReader");
					}
			}
		}
		else
			System.out.println("\t*\"" + file.toString() + "\"" + "...Error: File\\Path doesn't exists.");
		this.sortAndSetPlaces();
	}

	/**
	 * <p>
	 * Method writes data to file. <br>
	 * All errors or correct result are displayed to User with console messages.
	 * 
	 * @param sFile
	 *            - File path or file name.
	 */
	public void printResultsToFile(String sFile) {
		File file = new File(sFile);
		FileWriter writer = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
			}
			catch (IOException e) {
				System.out.println("\t*Error: Problems with creating New file.");
			}
		}
		else
			;
		try {
			writer = new FileWriter(sFile);
			Iterator<Athlete> it = this.getInputAthleteList().iterator();
			while (it.hasNext()) {
				writer.write(it.next().toStringWithFinal() + "\n");
			}
		}
		catch (IOException e) {
			System.out.println("\t*Error: Problems with creating FileWriter");
		}
		finally {
			if (writer != null)
				try {
					writer.flush();
					writer.close();
					System.out.println("Results are written in " + file.toURI() + "");
				}
				catch (IOException e) {
					System.out.println("\t*Error: Problems with closing FileWriter");
				}
		}
	}
}
