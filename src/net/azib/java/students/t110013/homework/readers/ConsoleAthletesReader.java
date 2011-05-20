package net.azib.java.students.t110013.homework.readers;

import net.azib.java.students.t110013.homework.model.Athlete;
import net.azib.java.students.t110013.homework.model.Decathlon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static net.azib.java.students.t110013.homework.model.AthleteUtils.*;

/**
 * @author Vadim
 */
public class ConsoleAthletesReader implements AthletesReader {
    private static final String UTF8_CHARSET = "UTF-8";
    private static final SimpleDateFormat CONSOLE_DATE_FORMAT = (SimpleDateFormat) DateFormat.getDateInstance();

	ConsoleAthletesReader() {
	}

	public List<Athlete> getAthletes() {
        Scanner scanner = new Scanner(System.in, UTF8_CHARSET);
        List<Athlete> athletes = new ArrayList<Athlete>();

        boolean proceed;
        do {
            athletes.add(buildAthlete(scanner));
            System.out.print("Do you want to add more athletes to the list (yes/no)? ");
            proceed = scanner.nextLine().toLowerCase().startsWith("y");
        } while (proceed);

        return athletes;
    }

    Athlete buildAthlete(Scanner scanner) {
        Athlete athlete = new Athlete();

        System.out.println("\nPlease provide following information about the athlete:");

        athlete.setName(readName(scanner));
        athlete.setDateOfBirth(readDateOfBirth(scanner, CONSOLE_DATE_FORMAT));
        athlete.setCountry(readCountry(scanner));

        for (Decathlon event : Decathlon.values()) {
            athlete.setPerformanceResult(readPerformanceResult(scanner, event.getName()));
        }

        return athlete;
    }

    String readName(Scanner scanner) {
        String name = null;

        while (name == null) {
            System.out.print("Full name: ");

            try {
                name = validateName(scanner.nextLine());
            }
            catch (IllegalArgumentException ignore) {}
        }

        return name;
    }

    Date readDateOfBirth(Scanner scanner, SimpleDateFormat dateFormat) {
        Date date = null;

        while (date == null) {
            System.out.print("Date of birth: ");

            try {
                date = validateAndParseDate(scanner.nextLine(), dateFormat);
            }
            catch (IllegalArgumentException ignore) {}
        }

        return date;
    }

    String readCountry(Scanner scanner) {
        String country = null;

        while (country == null) {
            System.out.print("Country code: ");

            try {
                country = validateCountry(scanner.nextLine());
            }
            catch (IllegalArgumentException ignore) {}
        }

        return country;
    }

    double readPerformanceResult(Scanner scanner, String event) {
        Double result = null;

        while (result == null) {
            System.out.print(event + " result: ");

            try {
                result = validateAndParsePerformanceResult(scanner.nextLine());
            }
            catch (IllegalArgumentException ignore) {}
        }

        return result;
    }
}
