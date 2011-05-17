package net.azib.java.students.t104607.homework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author 104607 IASM
 */
public class Decathlon {

	static boolean commandLine (String[] args) throws Exception {
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
				athletes = new InputCsv().load(new FileInputStream(args[i]));
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
				new OutputCsv().save(new FileOutputStream(args[i]), athletes);
				//new OutputCsv().save(System.out, athletes);
			} else if (args[i].compareToIgnoreCase("-xml") == 0) {
				i++;
				new OutputXml().save(new FileOutputStream(args[i]), athletes);
				//new OutputXml().save(System.out, athletes);
			} else if (args[i].compareToIgnoreCase("-html") == 0) {
				i++;
				new OutputHtml().save(new FileOutputStream(args[i]), athletes);
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

	public static void main(String[] args) throws Exception {
		Logger LOG = Logger.getLogger(Decathlon.class.getName());
		PropertyConfigurator.configure(Decathlon.class.getResource("log4j.properties"));
		LOG.info("Starting");

		if (!commandLine(args)) {
			System.out.println("\nUse program:\n" +
					"\tDecathlon -<input-method> [input-parameters] -<output-method> [output-parameters]");
		}
	}
}
