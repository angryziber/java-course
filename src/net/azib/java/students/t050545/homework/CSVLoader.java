package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.score.PointSystem.Discipline;
import net.azib.java.students.t050545.homework.sportman.Person;
import net.azib.java.students.t050545.homework.sportman.Sportman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.GregorianCalendar;

/**
 * Splitter
 * 
 * @author libricon
 */
public class CSVLoader implements SportmanLoader {

	/**
	 * @param file
	 *            filename, what content sportmans data
	 * @throws FileNotFoundException
	 *             exception, if file name is wrong or file cannot be accessed.
	 */
	public CSVLoader(File file) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(file));
	}

	/**
	 * @param fileName
	 *            filename, what content sportmans data
	 * @throws FileNotFoundException
	 *             exception, if file name is wrong or file cannot be accessed.
	 */
	public CSVLoader(String fileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(fileName));
	}

	/**
	 * Method return Sportman object, what get from file
	 * 
	 * @return next sportman in file
	 * @throws IOException
	 *             file opening exception
	 * @throws ParseException
	 *             parse exception
	 */
	public Sportman nextSportman() throws IOException, ParseException {
		String line = reader.readLine();

		if (line != null && line.length() != 0) {

			String name;
			GregorianCalendar birthDate = null;
			String country;

			String[] arrayOfData = line.split("\\,");
			arrayOfData[0] = arrayOfData[0].replace("\"", "");
			name = arrayOfData[0];

			if (Parser.isValidDate(arrayOfData[1])) {
				birthDate = Parser.toParseBirthDay(arrayOfData[1]);
			}
			else {
				throw new ParseException("COUNTRY DATE\n"+line, 0);
			}

			if (Parser.isValidCountry(arrayOfData[2])) {
				country = Parser.addCountry(arrayOfData[2]);
			}
			else {
				throw new ParseException("COUNTRY WRONG\n"+line, 0);
			}

			float[] resultTable = new float[Discipline.values().length];

			/*
			 * This code takes 10 results: one for every discipline, in String[]
			 * result start from index 3, because of name,date,country, results
			 * for iteration is used for-each loop with enumeration iterator In
			 * case, result is in X:xx.xx format, used if-else construction
			 */

			for (Discipline dis : Discipline.values()) {

				String[] split = arrayOfData[dis.ordinal() + 3].split("\\:");

				if (split.length == 1)
					resultTable[dis.ordinal()] = Float.parseFloat(arrayOfData[dis.ordinal() + 3]);
				else
					resultTable[dis.ordinal()] = Float.parseFloat(split[0]) * 60f + Float.parseFloat(split[1]);

				if (!Parser.isCorrectResult(resultTable[dis.ordinal()]))
					throw new ParseException("RESULT IS NEGATIVE, IT'S INCORRECT\n"+line, 0);

			}

			return (new Sportman(resultTable, new Person(name, country, birthDate)));

		}
		else {
			reader.close();
			return null;
		}
	}

	/** InputStream for file input, */
	private BufferedReader reader;

	/**
	 * @param args
	 *            command line arguments
	 * @throws IOException
	 *             this exception throw problems with files
	 * @throws ParseException
	 *             appear when string format is incorrect
	 */
	public static void main(String[] args) throws IOException, ParseException {
		try {
			CSVLoader loader = new CSVLoader("c:\\sport_utf8.txt");
			Sportman sportman;
			while ((sportman = loader.nextSportman()) != null) {
				System.out.println(sportman.toString());
			}
			System.out.println("ALL");
			System.exit(0);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
			pe.getMessage();
			System.exit(1);
		}
	}

}
