package main.java.homework;

import java.util.List;

import main.java.homework.domain.PlayerScore;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataParser {
	
	/**
	 * configures itself to be able to parse data
	 * @param args any configuration parameters
	 */
	void setup(String... args);
	
	/**
	 * parses the dataSource and returns a <code> valid </valid> list of PlayerResults.
	 * @return 
	 */
	List<PlayerScore> parseData();
	
	/**
	 * cleans the mess after parsing the data
	 */
	void cleanup();

}
