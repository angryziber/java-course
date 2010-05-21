package net.azib.java.students.t093052.homework.action.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

import net.azib.java.students.t093052.homework.Athlete;

/**
 * This class holds the common methods of console and csv input actions
 * */
public abstract class AbstractInputStreamAction extends AbstractInputAction {
	private static final String DELIMITER = ",";
	
	/**
	 * @return the competitor's input stream
	 * */
	abstract InputStream getInputStream() throws IOException;
	/**
	 * Reads the next line from the input stream
	 * @return the string of data
	 * */
	abstract String nextLine(Scanner scanner);
	
	public Set<Athlete> handleData() throws Exception {
		Scanner scanner = new Scanner(getInputStream());
		
		Set<Athlete> athletes = createAthleteSet();
		
		try {
			String line = null;
			while((line = nextLine(scanner)) != null) {
				Athlete athlete = createAthlete(line.trim().split(DELIMITER));
				athletes.add(athlete);
			}
		} finally {
			scanner.close();
		}
		return athletes;
	}
}
