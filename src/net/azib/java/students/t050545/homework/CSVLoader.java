package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Person;
import net.azib.java.students.t050545.homework.sportman.Sportman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * Splitter
 * 
 * @author libricon
 */
public class CSVLoader implements SportmanLoader {

	public CSVLoader(File file) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(file));
	}

	public CSVLoader(String fileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(fileName));
	}

	@Override
	public Sportman nextSportman() throws IOException, ParseException {
		String line = reader.readLine();

		if (line != null && line.length() != 0) {

			String[] arrayOfData = line.split("\\,");
			arrayOfData[0] = arrayOfData[0].replace("\"", "");
			String name = arrayOfData[0];
			SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			String birthDay = arrayOfData[1];
			GregorianCalendar birthDate = new GregorianCalendar();
			birthDate.setTime(df.parse(birthDay));
			String country = arrayOfData[2].toUpperCase();

			float[] resultTable = new float[10];

			for (int i = 3; i < 13; i++) {
				String[] split = arrayOfData[i].split("\\:");
				System.out.print(Arrays.toString(split));
				if (split.length == 1)
					resultTable[i - 3] = Float.parseFloat(arrayOfData[i]);
				else
					resultTable[i - 3] = Float.parseFloat(split[0]) * 60f + Float.parseFloat(split[1]);
				//System.out.println("result is : " + resultTable[i - 3]);
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

	private BufferedReader reader;

	public static void main(String[] args) throws IOException, ParseException {
		CSVLoader loader = new CSVLoader("c:\\sport_utf8.txt");
		Sportman sportman;
		while (true) {
			if ((sportman = loader.nextSportman()) != null) {
				System.out.println(sportman.toString());
			}
			else {
				System.err.println("All");
				System.exit(1);
			}

		}

	}

}
