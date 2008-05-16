package net.azib.java.students.t030604.homework;

import net.azib.java.students.t030604.homework.domain.AthleteScore;
import net.azib.java.students.t030604.homework.parser.ParserException;

import java.util.List;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataParser {
	
	/**
	 * configures itself to be able to parse data
	 * @param args any configuration parameters
	 */
	void setup(String... args) throws ParserException;
	
	/**
	 * parses the dataSource and returns a <code> valid </valid> list of PlayerResults.
	 * @return 
	 */
	List<AthleteScore> parseData() throws ParserException;
	
	/**
	 * cleans the mess after parsing the data
	 */
	void cleanup() throws ParserException;

}
