package net.azib.java.students.t103784.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 14.05.11
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class Input {

	List<Athlete> contestants = new ArrayList<Athlete>();
	SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);

	public static void main(String[] args) {
		Input input = new Input();
		Scanner scanner = new Scanner(System.in);
		input.scanAthlete(new Athlete(), scanner);
	}



	public void addAthlete(Athlete athlete) {
		contestants.add(athlete);
	}


	public Athlete scanAthlete(Athlete athlete, Scanner scanner) {

	while (athlete.getName() == null) {
            System.out.print("Full name: ");
            athlete.setName(checkName(scanner.nextLine()));
        }

        while (athlete.getBirthDate() == null) {
            System.out.print("Date of Birth " + "(" + format.toPattern() + "): ");
		    athlete.setBirthDate(checkDate(scanner.nextLine()));
        }

        while (athlete.getCountry() == null) {
            System.out.print("Country: ");
            athlete.setCountry(checkCountry(scanner.nextLine()));
        }

		while (athlete.getHundredMeters() == null) {
            System.out.print("100m: ");
			try {
				athlete.setHundredMeters(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setHundredMeters(null);
			}
		}

		while (athlete.getLongJump() == null) {
            System.out.print("Long jump: ");
            try {
				athlete.setLongJump(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setHundredMeters(null);
			}
        }

		while (athlete.getShotPut() == null) {
            System.out.print("Shot put: ");
            try {
				athlete.setShotPut(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setShotPut(null);
			}
        }

		while (athlete.getHighJump() == null) {
            System.out.print("High Jump: ");
            try {
				athlete.setHighJump(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setHighJump(null);
			}
        }

		while (athlete.getFourHundredMeters() == null) {
            System.out.print("400m: ");
            try {
				athlete.setFourHundredMeters(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setFourHundredMeters(null);
			}
        }

		while (athlete.getHurdles() == null) {
            System.out.print("110m hurdles: ");
            try {
				athlete.setHurdles(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setHurdles(null);
			}
        }

		while (athlete.getDiscus() == null) {
            System.out.print("Discus throw: ");
            try {
				athlete.setDiscus(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setDiscus(null);
			}
        }

		while (athlete.getPoleVault() == null) {
            System.out.print("Pole vault: ");
            try {
				athlete.setPoleVault(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setPoleVault(null);
			}
        }

		while (athlete.getJavelin() == null) {
            System.out.print("Javelin throw: ");
            try {
				athlete.setJavelin(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setJavelin(null);
			}
        }

		while (athlete.getRace() == null) {
            System.out.print("1500m race: ");
            try {
				athlete.setRace(checkMeters(Double.valueOf(scanner.nextLine())));
			} catch (NumberFormatException e) {
				athlete.setRace(null);
			}
        }

		System.out.println("\n" + athlete.name + "\n" + athlete.birthDate + "\n" + athlete.country + "\n" + athlete.hundredMeters + "\n" + athlete.longJump + "\n" + athlete.discus + "\n" + athlete.javelin + "\n" + athlete.race + "\n" + athlete.poleVault + "\n" + athlete.hurdles + "\n" + athlete.fourHundredMeters + "\n" + athlete.highJump + "\n" + athlete.shotPut);
		return athlete;
	}


	public String checkName(String name) {
		if (name.matches("[A-Z][a-z]+(\\s[A-Z]\\.)*\\s[A-Z][a-z]+"))
			return name;
		else
			return null;
	}

	public String checkDate(String birthDate) {
		if (birthDate.toString().matches("^([1-9]|0[1-9]|[12][0-9]|3[01])[.]?([1-9]|[01][1-2])[. ]?(18|19|20)\\d{2}$"))
			return birthDate;
		else
			System.out.println("toString");
			return null;
	}

	public String checkCountry(String country) {
		if (country.matches("[A-Z]{2,2}"))
			return country;
		else
			return null;
	}

	public Double checkMeters(Double meters) {
		if (meters.isNaN())
			return null;
		else
			return meters;
	}












}
