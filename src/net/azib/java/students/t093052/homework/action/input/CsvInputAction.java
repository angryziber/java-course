package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

/**
 * This class represents the csv input action.
 * */
public class CsvInputAction extends AbstractInputStreamAction {
	private static final String DELIMITER = ",";
	
	private String fileName;

	public CsvInputAction(String fileName) {
		this.fileName = fileName;
	}

	@Override
	InputStream getInputStream() throws IOException {
		return new FileInputStream(fileName);
	}

	@Override
	void addAthletes(Set<Athlete> athletes, Scanner scanner) throws Exception {
		while(scanner.hasNextLine()) {
			Athlete athlete = createAthlete(scanner.nextLine().trim().split(DELIMITER));
			athletes.add(athlete);
		}
	}
}
