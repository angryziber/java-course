package net.azib.java.students.t104607.homework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * This program -
 * <li>Load raw results of athletes who has participated in competitions</li>
 * <li>Compute decathlon scores according to the formula</li>
 * <li>Save the correctly ordered results with scores</li>
 * <br>
 * Use format:<br>
 * &nbsp;&nbsp;&nbsp;<i>Decathlon</i> -&lt;input-method&gt; [input-parameters] -&lt;output-method&gt; [output-parameters]
 *
 * @author 104607 IASM
 */
public class Decathlon {

	static boolean commandLine (String[] args) {
		int i = 0;
		List<Athlete> athletes = null;
		Integer previousPoint = 0;
		Integer previousPlace = 0;
		Integer currentPlace = 1;
		String placeText;
		Logger LOG = Logger.getLogger(Decathlon.class.getName());

		try {
			if (args[i].compareToIgnoreCase("-console") == 0) {
				athletes = new InputConsole().load(System.in, System.out);
			} else if (args[i].compareToIgnoreCase("-csv") == 0) {
				i++;
				try {
					InputStream inputStream = new FileInputStream(args[i]);
					athletes = new InputCsv().load(inputStream);
				} catch (IOException e) {
					LOG.error("Open input stream", e);
					return true;
				}
			} else if (args[i].compareToIgnoreCase("-db") == 0) {
				i++;
				athletes = new InputDb().load(args[i],Decathlon.class.getResourceAsStream("db.properties"));
			} else {
				LOG.error("No input definition");
				return false;
			}

			i++;

			Collections.sort(athletes, Collections.reverseOrder());
			for (Athlete athlete : athletes) {
				if (athlete.getScore() == previousPoint)	{
					placeText = previousPlace.toString() + "-" + currentPlace.toString();
					for (int j = previousPlace-1; j<currentPlace; j++) {
						athletes.get(j).setPosition(placeText);
					}
				} else {
					previousPlace = currentPlace;
					athlete.setPosition(currentPlace.toString());
				}
				currentPlace++;
				previousPoint = athlete.getScore();
			}

			if (args[i].compareToIgnoreCase("-console") == 0) {
				new OutputConsole().save(System.out, athletes);
			} else if (args[i].compareToIgnoreCase("-csv") == 0) {
				i++;
				try {
					OutputStream outputStream = new FileOutputStream(args[i]);
					new OutputCsv().save(outputStream, athletes);
				} catch (FileNotFoundException e) {
					LOG.error("Open output stream", e);
				}
			} else if (args[i].compareToIgnoreCase("-xml") == 0) {
				i++;
				try {
					OutputStream outputStream = new FileOutputStream(args[i]);
					new OutputXml().save(outputStream, athletes);
				} catch (FileNotFoundException e) {
					LOG.error("Open output stream", e);
				}
			} else if (args[i].compareToIgnoreCase("-html") == 0) {
				i++;
				try {
					OutputStream outputStream = new FileOutputStream(args[i]);
					new OutputHtml().save(outputStream, athletes);
				} catch (FileNotFoundException e) {
					LOG.error("Open output stream", e);
				}
			} else {
				LOG.error("No output definition");
				return false;
			}
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			LOG.error("Wrong input/output definition",e);
			return false;
		}
	}

	/**
     * main method of decathlon computing program
	 * <p>
     * @param args comman line arguments
	 */
	public static void main(String[] args) {
		Logger LOG = Logger.getLogger(Decathlon.class.getName());
		PropertyConfigurator.configure(Decathlon.class.getResource("log4j.properties"));
		LOG.info("Starting");

		if (!commandLine(args)) {
			System.out.println("\nUse program:\n" +
					"\tDecathlon -<input-method> [input-parameters] -<output-method> [output-parameters]");
		}
	}
}
