package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.LoadException;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.PointSystem;
import net.azib.java.students.t050545.homework.sport.Score;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t050545.homework.sport.PointSystem.Discipline;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * ConsoleLoader
 * 
 * @author libricon
 */
public class ConsoleLoader extends DataChecker implements AthleteLoader {

	/** this is a console scanner */
	private Scanner scanner;
	
	private String argument = "-console";
	private String description = "Input takes from console";
	
	/**
	 *  Take resource
	 */
	public ConsoleLoader() {
	}

	/** Return new sportman, or null if no anyone else
	 * @return Sportman object or null, if no more
	 * @throws ParseException exeption, if input is wrong
	 */
	public Sportman nextSportman() throws ParseException {

		System.out.println("Please enter essential sportman's data");

		String name;
		String country;
		String birthDay;
		float[] results = new float[PointSystem.Discipline.values().length];

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
		while (!isValidDate(birthDay));
		GregorianCalendar birthDate = toParseBirthDay(birthDay);

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

		return new Sportman(new Score(results), new Person(name, country, birthDate));

	}


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

	@Override
	public void close() {
		scanner.close();	
	}

}
