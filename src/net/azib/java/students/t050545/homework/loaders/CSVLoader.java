package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.sport.Discipline;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Score;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
import static net.azib.java.students.t050545.homework.utils.DataChecker.*;
import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 * Loader from csv file
 * 
 * @author libricon
 */
public class CSVLoader implements AthleteLoader {

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

	/** Opens file
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
	 * Method return Sportsman from file
	 * @return Sportsman  or null
	 * @throws ReadException 
	 * @throws ParseException parse exception
	 */
	public AthleteScore nextAthleteScore() throws ReadException, ParseException {
		String line;
		try{
			line = reader.readLine();
		}catch(IOException e){
			throw new ReadException("Can't read from file");
		}
		if (line != null && line.length() != 0) {

			String name;
			Date birthDate = null;
			String country;

			String[] arrayOfData = line.split("\\,");
			arrayOfData[0] = arrayOfData[0].replace("\"", "");
			name = arrayOfData[0];
			
			if (isValidDate(arrayOfData[1], DateFormat.getDateInstance())) {
				birthDate = toParseBirthDay(arrayOfData[1], new SimpleDateFormat("dd.MM.yyyy"));
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

			return (new AthleteScore(new Score(resultTable), new Person(name, country, birthDate)));

		}
		else {
			try {
				reader.close();
			}
			catch (IOException e) {
				throw new ReadException("Can't close file");
			}
			return null;
		}
	}

	/** Close fileReade */
	public void close() {
		try {
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
