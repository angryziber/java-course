package net.azib.java.students.t103784.homework;


import net.azib.java.lessons.db.PersonException;

import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;

public class InputTest extends Input{
	@org.junit.Test
	public void testConsoleInput () {
		InputStream in = null;
		try {
			in = new FileInputStream(("src\\net\\azib\\java\\students\\t103784\\homework\\consoleTest.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Console input failed (no such test file)\n");
		}
		System.setIn(in);
		try {
			readAthleteFromConsole();
		} catch (IOException e) {
			System.out.println("Console input failed (IO exception)\n");
		} catch (ParseException e) {
			System.out.println("Console input failed (ParseException)\n");
		}
	}
	@org.junit.Test
	public void testCSVInput () {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src\\net\\azib\\java\\students\\t103784\\homework\\CSVTest.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("CSV input failed (no such test file)\n");
		}
		readAthleteFromCSV(reader);
	}
	@org.junit.Test
	public void testDBInput () {
		try {
			parameter = "1";
			readAthleteFromDB();
		} catch (SQLException e) {
			System.out.println("DB input failed (SQL error)");
		} catch (ParseException e) {
			System.out.println("DB input failed (Parse error)");
		}
	}
}
