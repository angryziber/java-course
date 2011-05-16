package net.azib.java.students.t104607.homework;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

/**
 * @author 104607 IASM
 */
public class Decathlon {
	static boolean CommandLine (String[] args) throws IOException, SQLException, ParseException, TransformerException, ParserConfigurationException, SAXException {
		int i = 0;
		List<Athlete> athletes = null;
		Integer previousPoint = 0;
		Integer previousPlace = 0;
		Integer currentPlace = 1;
		String placeText;

		try {
			if (args[i].compareToIgnoreCase("-console") == 0) {
				new InputConsole();
			} else if (args[i].compareToIgnoreCase("-csv") == 0) {
				i++;
				athletes = new InputCsv().load(new FileInputStream(args[i]));
			} else if (args[i].compareToIgnoreCase("-db") == 0) {
				i++;
				athletes = new InputDb().load(args[i],Decathlon.class.getResourceAsStream("db.properties"));
			} else {
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
				new OutputHtml(args[i]);
			} else {
				return false;
			}
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException, SQLException, ParseException, TransformerException, ParserConfigurationException, SAXException {
		System.out.println("HomeWork from 104607 IASM !\n");
		if (!CommandLine(args)) {
			System.out.println("Use program:\n" +
					"\tDecathlon -<input-method> [input-parameters] -<output-method> [output-parameters]");
		}
	}
}
