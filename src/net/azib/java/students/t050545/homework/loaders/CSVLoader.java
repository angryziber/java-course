package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.LoadException;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Score;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t050545.homework.sport.PointSystem.Discipline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Stack;

/**
 * Loader from csv file "," is separator, all data in line
 * 
 * @author libricon
 */
public class CSVLoader extends DataChecker implements AthleteLoader {

	/** InputStream for file input, */
	private BufferedReader reader;

	private String argument = "-csv";
	private String description = "<filename> file with athletes results";
	
	@Override
	public String getArgum() {
		return argument;
	}

	@Override
	public String getDescription() {
		return description;
	}

	/** Opens file argument name
	 * @param arguments list of console arguments
	 * @throws LoadException 
	 */
	public void init(Stack<String> arguments) throws LoadException{
		try {
			String fileName = arguments.pop();
			reader = new BufferedReader(new FileReader(fileName));
		}
		catch (FileNotFoundException e) {
			throw new LoadException("Wrong file name or file not exist");
		}
	}

	/**
	 * Method return Sportman object, what get from file
	 * @return next sportman in file
	 * @throws IOException file opening exception
	 * @throws ParseException parse exception
	 */
	public Sportman nextSportman() throws IOException, ParseException {
		String line = reader.readLine();
		//System.out.println(line);
		if (line != null && line.length() != 0) {

			String name;
			GregorianCalendar birthDate = null;
			String country;

			String[] arrayOfData = line.split("\\,");
			arrayOfData[0] = arrayOfData[0].replace("\"", "");
			name = arrayOfData[0];

			if (isValidDate(arrayOfData[1])) {
				birthDate = toParseBirthDay(arrayOfData[1]);
			}
			else {
				throw new ParseException("BIRTH DATE\n"+line, 0);
			}

			if (isValidCountry(arrayOfData[2])) {
				country = addCountry(arrayOfData[2]);
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

				if (!isCorrectResult(resultTable[dis.ordinal()]))
					throw new ParseException("RESULT IS NEGATIVE, IT'S INCORRECT\n"+line, 0);

			}

			return (new Sportman(new Score(resultTable), new Person(name, country, birthDate)));

		}
		else {
			reader.close();
			return null;
		}
	}

	public void close() {
		try {
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
