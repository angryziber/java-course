package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This class represents the console input action.
 * */
public class ConsoleInputAction extends AbstractInputStreamAction {
	@Override
	InputStream getInputStream() throws IOException {
		return System.in;
	}

	@Override
	void addAthletes(Set<Athlete> athletes, Scanner scanner) throws Exception {
		String line = null;
		do {
			System.out.println("Press \"ENTER\" to add next competitor " +
				"or type \"OK\" if all of those are added...");
			line = scanner.nextLine();

			if (line != null && "OK".equals(line.toUpperCase())) {
				return;
			}
		
			if ("".equals(line)) {
				athletes.add(createNextAthlete(scanner));
			}
		} while(true);
	}

	private Athlete createNextAthlete(Scanner scanner) throws ParseException {
		List<String> values = new ArrayList<String>();
		
		values.add(getValue("Athlete name: ", scanner, ".+"));
		values.add(getValue("Date of birth: ", scanner, "\\d{1,2}\\.\\d{1,2}\\.\\d{4}"));
		values.add(getValue("Country: ", scanner, "[A-Za-z]{2}"));
		values.add(getValue("100m sprint: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("Long jump: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("Shot put: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("High jump: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("400m sprint: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("110m hurdles: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("Discus throw: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("Pole vault: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("Javelin throw: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		values.add(getValue("1500m race: ", scanner, "(\\d+:)?\\d+\\.\\d+"));
		
		return createAthlete(values.toArray(new String[values.size()]));
	}

	private String getValue(String title, Scanner scanner, String pattern) {
		String line;
		do {
			System.out.println(title);
			line = scanner.nextLine();
			
			if (line.matches(pattern)) {
				return line;
			}
			
			System.out.println("Value is invalid...");
		} while(true);
	}
}
