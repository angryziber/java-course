package net.azib.java.students.t103784.homework;

import java.io.*;
import java.util.List;

public class CSVOutputTest extends Output {
	@org.junit.Test
	public void testOutputs () {
		List<Athlete> contestants;
		Input input = new Input();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src\\net\\azib\\java\\students\\t103784\\homework\\tests\\CSVTest.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Test input failed (no such test file)");
		}
		contestants = input.readAthleteFromCSV(reader);
		try {
			outputToCSV(contestants);
		} catch (FileNotFoundException e) {
			System.out.println("Test output failed (no such file)");
		}
	}
}
