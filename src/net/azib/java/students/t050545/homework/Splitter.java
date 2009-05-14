package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Person;
import net.azib.java.students.t050545.homework.sportman.Sportman;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Splitter
 * 
 * @author libricon
 */
public class Splitter {
	private Splitter() {
	}

	public static Sportman splitLine(String line) throws ParseException {
		String[] arrayOfData = line.split("\\,");
		arrayOfData[0] = arrayOfData[0].replace("\"", "");
		String name = arrayOfData[0];
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		String birthDay = arrayOfData[1];
		GregorianCalendar birthDate = new GregorianCalendar();
		birthDate.setTime(df.parse(birthDay));
		String country = arrayOfData[2].toUpperCase();

		float[] resultTable = new float[10];

		for (int i = 3; i < 12; i++) {
			String[] split = arrayOfData[i].split("\\:");
			if (split.length == 1)
				resultTable[i - 3] = Float.parseFloat(arrayOfData[i]);
			else
				resultTable[9] = Float.parseFloat(split[0]) * 60f + Float.parseFloat(split[1]);
		}
		// String[] split = arrayOfData[12].split("\\:");
		// resultTable[9] = Float.parseFloat(split[0]) * 60f +
		// Float.parseFloat(split[1]);
		Person person = new Person(name, country, birthDate);
		Sportman sportman = new Sportman(resultTable, person);
		return sportman;

	}
}