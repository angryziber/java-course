package net.azib.java.students.t103784.homework;


import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class InputTest extends Input {

	/**
	 * Tests whether the console input works.
	 * <p/>
	 * By feeding some preset valid data into the system using
	 * an input stream, I check if the input works properly.
	 */
	@org.junit.Test
	public void testConsoleInput() {
		InputStream in = null;
		try {
			in = new FileInputStream(("src/net/azib/java/students/t103784/homework/tests/consoleTest.txt"));
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

	/**
	 * Tests whether the CSV input works.
	 * <p/>
	 * By feeding some preset valid data into the system using
	 * a reader, I check if the input works properly.
	 */
	@org.junit.Test
	public void testCSVInput() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src/net/azib/java/students/t103784/homework/tests/CSVTest.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("CSV input failed (no such test file)\n");
		}
		readAthleteFromCSV(reader);
	}

	/**
	 * Tests whether the database input works.
	 * <p/>
	 * By feeding some preset valid data into the system using
	 * a database, I check if the input works properly.
	 */
	@org.junit.Test
	public void testDBInput() {
		try {
			parameter = "1";
			readAthleteFromDB();
		} catch (SQLException e) {
			System.out.println("DB input failed (SQL error)");
		} catch (ParseException e) {
			System.out.println("DB input failed (Parse error)");
		} catch (IOException e) {
			System.out.println("DB input failed (IO error)");
		}
	}
}
