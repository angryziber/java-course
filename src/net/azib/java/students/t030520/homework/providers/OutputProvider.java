package net.azib.java.students.t030520.homework.providers;

import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;

import java.io.IOException;
import java.util.List;

/**
 * Provides the output.
 *
 * @author t030520
 */
public class OutputProvider {
	private static ConsoleReaderWriter consoleReaderWriter = new ConsoleReaderWriter();

	private static FileReaderWriter fileReaderWriter = new FileReaderWriter();

	/**
	 * Writes results into console.
	 * @param results the Sportsman's results.
	 */
	public static void writeResultToConsole(List<SportsmanWithResults> results) {
		consoleReaderWriter.writeSportsmanResultsToConsole(results);
	}

	/**
	 * Writes the result into csv file.
	 * @param results the Sportsman's results.
	 * @param filename the name of file to write the result.
	 * @throws IOException
	 */
	public static void writeResultToCsvFile(List<SportsmanWithResults> results, String filename) throws IOException {
		fileReaderWriter.writeSportsmenResultToCsv(results, filename);
	}

	/**
	 * Writes the result into xml file.
	 * @param results the Sportsman's results.
	 * @param filename the name of file to write the result.
	 * @throws IOException
	 */
	public static void writeResultToXmlFile(List<SportsmanWithResults> results, String filename) throws IOException {
		fileReaderWriter.writeSportsmenResultToXml(results, filename);
	}

	/**
	 * Writes the result into html file.
	 * @param results the Sportsman's results.
	 * @param filename the name of file to write the result.
	 * @throws IOException
	 */
	public static void writeResultToHtmlFile(List<SportsmanWithResults> results, String filename) throws IOException {
		fileReaderWriter.writeSportsmenResultToHtml(results, filename);
	}
}
