package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.score.PointSystem;
import net.azib.java.students.t050545.homework.score.PointSystem.Discipline;
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
	 * @throws ParseException
	 *             exeption, if input is wrong
	 */
	public Sportman nextSportman() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter essential sportman's data");

		String name;
		String country;
		String birthDay;
		float[] results = new float[PointSystem.Discipline.values().length];

		System.out.print("Sportman's name: ");
		name = scanner.next();

		do {
			System.out.print("Country: ");
			country = Parser.addCountry(scanner.next());
		}
		while (!Parser.isValidCountry(country));
		

		do {
			System.out.print("Please enter a birthDay: ");
			birthDay = scanner.next();
		}
		while (!Parser.isValidDate(birthDay));
		GregorianCalendar birthDate = Parser.toParseBirthDay(birthDay);
		
		System.out.println("Now enter results, or -1 to finish");
		
		for (Discipline dis : Discipline.values()) {
			float number = 0;
			do{
				System.out.print("The " + dis.name() +" is: ");
				if(scanner.hasNextFloat()){
					number = scanner.nextFloat();
					if((number+1)<=0.000001) return null;
				} else {
					System.out.println("You should enter a valid float number !");
					scanner.next();
				}
					
			}while(!Parser.isCorrectResult(number));
			results[dis.ordinal()] = number;
		}
		
		return new Sportman(results, new Person(name, country, birthDate));

	}

	/**
	 * @param args
	 *            command line arguments
	 * @throws ParseException
	 *             appear when string format is incorrect
	 */
	public static void main(String[] args) throws ParseException {
		try {
			ConsoleLoader console = new ConsoleLoader();
			System.out.println(console.nextSportman());
			System.exit(0);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
