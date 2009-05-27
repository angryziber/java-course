package net.azib.java.students.t030520.homework.providers;

import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Provides the access to the ReadersWriters.
 *
 * @author t030520
 */
public class InputProvider {

	private static ConsoleReaderWriter consoleReaderWriter = new ConsoleReaderWriter();

	private static FileReaderWriter csvReaderWriter = new FileReaderWriter();

	private static DatabaseReader databaseReader = new DatabaseReader(); 

	/**
	 * @return the list of Sportsman's results.
	 * @throws IOException
	 */
	public static List<SportsmanWithResults> getResultsFromConsole() throws IOException {
		return consoleReaderWriter.readSportsmanResultsFromConsole();
	}

	/**
	 * @param fileName the csv filename.
	 * @return the list of Sportsman's results.
	 * @throws IOException
	 */
	public static List<SportsmanWithResults> getResultFromCsv(String fileName) throws IOException {
		return csvReaderWriter.readSportspenResultsFromConsole(fileName);
	}

	/**
	 * @param id the id of competition.
	 * @return the list of Sportsman's results.
	 * @throws SQLException
	 */
	public static List<SportsmanWithResults> getResultFromBDByCompetitionId(long id) throws SQLException {
		return databaseReader.readSportsmanResultsFromDatabaseByCompetitionId(id);
	}

	/**
	 * @param name the name of competition.
	 * @return the list of Sportsman's results.
	 * @throws SQLException
	 */
	public static List<SportsmanWithResults> getResultFromBDByCompetitionName(String name) throws SQLException {
		return databaseReader.readSportsmanResultsFromDatabaseByCompetitionName(name);
	}
}
