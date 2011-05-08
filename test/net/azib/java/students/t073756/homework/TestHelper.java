package net.azib.java.students.t073756.homework;

import net.azib.java.students.t073756.homework.io.TestInputProcessor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestHelper {

	public static final String legalCsvLine = "Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
	private static TestInputProcessor p = new TestInputProcessor(null);

	public static File createTempFile() throws IOException {
		File f = File.createTempFile("tmp", null);
		f.deleteOnExit();
		return f;
	}

	public static Athlete createAthlete() {
		return createAthleteList().get(0);
	}

	public static List<Athlete> createAthleteList() {
		List<Athlete> athletes = p.readAthletes();
		for (Athlete a : athletes) {
			setScoreAndPlace(a);
		}
		return athletes;
	}

	public static String getFileContent(File target) throws IOException {
		List<String> lines = FileUtils.readLines(target, "UTF-8");
		StringBuilder result = new StringBuilder();
		for (String line : lines) {
			result.append(line).append("\n");
		}
		return result.toString().trim();
	}

	private static void setScoreAndPlace(Athlete a) {
		a.getResult().setOverallResult(5000);
		a.getResult().setPlace(new Place(5));
	}
}
