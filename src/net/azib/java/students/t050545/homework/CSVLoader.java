package net.azib.java.students.t050545.homework;

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
	 * @param file filename, what content sportmans data
	 * @throws FileNotFoundException exception, if file name is wrong or file cannot be accessed.
	 */
	public CSVLoader(File file) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(file));
	}

	/**
	 * @param fileName filename, what content sportmans data
	 * @throws FileNotFoundException exception, if file name is wrong or file cannot be accessed.
	 */
	public CSVLoader(String fileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(fileName));
	}

	/**
	 *  Method return Sportman object, what get from file
	 * @return next sportman in file
	 * @throws IOException file opening exception
	 * @throws ParseException parse exception
	 */
	public Sportman nextSportman() throws IOException, ParseException{
		String line = reader.readLine();
		
		if (line != null && line.length() != 0) {
			
			String name;
			GregorianCalendar birthDate = null;
			String country;

			String[] arrayOfData = line.split("\\,");
			arrayOfData[0] = arrayOfData[0].replace("\"", "");
			name = arrayOfData[0];

			if(Parser.isValidDate(arrayOfData[1])){
				birthDate = Parser.toParseBirthDay(arrayOfData[1]);
				//System.out.println(arrayOfData[1]);
			}else {
				throw new ParseException("COUNTRY DATE", 0);
			}
			
			if (Parser.isValidCountry(arrayOfData[2])) {
				country = Parser.addCountry(arrayOfData[2]);
			}
			else {
				throw new ParseException("COUNTRY WRONG", 0);
			}

			float[] resultTable = new float[10];

			for (int i = 3; i < 13; i++) {
				String[] split = arrayOfData[i].split("\\:");
				if (split.length == 1)
					resultTable[i - 3] = Float.parseFloat(arrayOfData[i]);
				else
					resultTable[i - 3] = Float.parseFloat(split[0]) * 60f + Float.parseFloat(split[1]);
			}
			Person person = new Person(name, country, birthDate);
			Sportman sportman = new Sportman(resultTable, person);
			return sportman;

		}
		else {
			reader.close();
			return null;
		}
	}

	/** InputStream for file input, */
	private BufferedReader reader;

	/**
	 * @param args ommand line arguments
	 * @throws IOException this exception throw problems with files
	 * @throws ParseException appear when string format is incorrect
	 */
	public static void main(String[] args) throws IOException, ParseException {
		try{
		CSVLoader loader = new CSVLoader("c:\\sport_utf8.txt");
		Sportman sportman;
		while ((sportman = loader.nextSportman()) != null) {
			   System.out.println(sportman.toString());
			}
                   System.out.println("ALL");
                   System.exit(0);
		}catch(ParseException pe){
			pe.printStackTrace();
			pe.getMessage();
			System.exit(1);
		}
	}

	

}
