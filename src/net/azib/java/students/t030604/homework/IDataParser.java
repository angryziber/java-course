package net.azib.java.students.t030604.homework;

import net.azib.java.students.t030604.homework.parser.ParserException;

import java.util.List;

/**
 * Interface for parsing data from different data sources
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataParser {
	
	/**
	 * configures itself to be able to parse data
	 * @param args any configuration parameters
	 * @throws ParserException, in case setup fails
	 */
	void setup(String... args) throws ParserException;
	
	/**
	 * parses the dataSource and returns a <code> valid </valid> list of player scores.
	 * @return valid list of players
	 * @throws in case any athlete fails validation - exception is thrown
	 */
	List<AthleteScore> parseData() throws ParserException;
	
	/**
	 * cleans the mess after parsing the data
	 * @throws ParserException, in case cleanup fails.
	 */
	void cleanup() throws ParserException;

}
