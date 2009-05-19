package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Person;
import net.azib.java.students.t050545.homework.sportman.Sportman;

import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ConsoleLoader
 * 
 * @author libricon
 */
public class ConsoleLoader implements SportmanLoader {

	/** 
	 * @return Sportman object or null, if no more 
	 * @throws ParseException exeption, if input is wrong
	 */
	public Sportman nextSportman() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter essential sportman's data");

		String name;
		String country;
		String birthDay;

		System.out.println("Sportman's name:");
		name = scanner.next();

		do {
			System.out.println("Country:");
			country = Parser.addCountry(scanner.next());
		}
		while (!Parser.isValidCountry(country));
		

		do {
			System.out.println("Please enter a birthDay:");
			birthDay = scanner.next();
		}
		while (!Parser.isValidDate(birthDay));

		GregorianCalendar birthDate = Parser.toParseBirthDay(birthDay);
		Person person = new Person(name, country, birthDate);

		return null;// new Sportman(scores, person);

	}

	/**
	 * @param args command line arguments
	 * @throws ParseException appear when string format is incorrect
	 */
	public static void main(String[] args) throws ParseException {
		ConsoleLoader console = new ConsoleLoader();
		console.nextSportman();
	}
}
