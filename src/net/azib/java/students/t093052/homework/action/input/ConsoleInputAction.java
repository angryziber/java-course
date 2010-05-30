package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.CompetitionType;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This class represents the console input action.
 * */
public class ConsoleInputAction extends AbstractInputStreamAction {
	@Override
	InputStream getInputStream() {
		return System.in;
	}

	@Override
	void addAthletes(Set<Athlete> athletes, Scanner scanner) {
		String line = null;
		do {
			line = nextLine(scanner);

			if (line != null && "OK".equals(line.toUpperCase())) {
				return;
			}
		
			if ("".equals(line)) {
				athletes.add(createNextAthlete(scanner));
			}
		} while(true);
	}

	String nextLine(Scanner scanner) {
		System.out.println("Press \"ENTER\" to add next competitor " +
			"or type \"OK\" if all of those are added...");
		return scanner.nextLine();
	}
	
	private Athlete createNextAthlete(Scanner scanner) {
		List<String> values = new ArrayList<String>();
		
		values.add(getValue("Athlete name", scanner, ".+"));
		values.add(getValue("Date of birth", scanner, "\\d{1,2}\\.\\d{1,2}\\.\\d{4}"));
		values.add(getValue("Country", scanner, "[A-Za-z]{2}"));
		
		CompetitionType[] competitionTypes = CompetitionType.values();
		for (int i = 0; i < competitionTypes.length; i++) {
			values.add(getValue(scanner, competitionTypes[i]));
		}
		
		return createAthlete(values.toArray(new String[values.size()]));
	}

	String getValue(Scanner scanner, CompetitionType competitionType) {
		return getValue(competitionType.getName(), scanner, 
				competitionType.getValuePattern());
	}
	
	String getValue(String title, Scanner scanner, String pattern) {
		String line;
		do {
			System.out.println(title + ": ");
			line = scanner.nextLine();
			
			if (line.matches(pattern)) {
				return line;
			}
			
			System.out.println("Value is invalid...");
		} while(true);
	}
}
