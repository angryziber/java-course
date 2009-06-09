package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.sport.Discipline;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Score;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
import static net.azib.java.students.t050545.homework.utils.DataChecker.*;
import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

/**
 * ConsoleLoader
 * 
 * @author libricon
 */
public class ConsoleLoader implements AthleteLoader {

	private Scanner scanner;
	private String argument = "-console";
	private String description = "You input all athlete throught console";


	/**
	 * @return AthleteScore or null, if no more
	 * @throws ReadException 
	 */
	public AthleteScore nextAthleteScore() throws ReadException {

		System.out.println("Please enter essential sportman's data");

		String name;
		String country;
		String birthDay;
		float[] results = new float[Discipline.values().length];

		System.out.print("Sportman's name, or -1: ");
		name = scanner.next();
		if (name.equals("-1"))
			return null;

		do {
			System.out.print("Country, or -1: ");
			country = addCountry(scanner.next());
			if (country.equals("-1"))
				return null;
		}
		while (!isValidCountry(country));

		do {
			System.out.print("Please enter a birthDay, or -1: ");
			birthDay = scanner.next();
			if (birthDay.equals("-1"))
				return null;
		}
		while (!isValidDate(birthDay, DateFormat.getDateInstance()));
		Date birthDate;
		
		try {
			birthDate = toParseBirthDay(birthDay, DateFormat.getDateInstance());
		}
		catch (ParseException e) {
			throw new ReadException("Can't parse birthDay, check format");
		}

		System.out.println("Now enter results, or -1 to finish");

		for (Discipline dis : Discipline.values()) {
			float number = 0;
			do {
				System.out.print("The " + dis.name() + " is: ");
				if (scanner.hasNextFloat()) {
					number = scanner.nextFloat();
					if ((number + 1) <= 0.000001)
						return null;
				}
				else {
					System.out.println("You should enter a valid float number !");
					scanner.next();
				}

			}
			while (!isCorrectResult(number));
			results[dis.ordinal()] = number;
		}

		return new AthleteScore(new Score(results), new Person(name, country, birthDate));

	}

	/** Create a new Scanner */
	@Override
	public void init(Stack<String> arguments) throws LoadException {
		scanner = new Scanner(System.in);
	}

	@Override
	public String getArgum() {
		return argument;
	}

	@Override
	public String getDescription() {
		return description;
	}

	/** Close opened resources */
	@Override
	public void close() {
		scanner.close();
	}

}
