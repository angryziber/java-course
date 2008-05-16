package net.azib.java.students.t030604.homework;


import net.azib.java.students.t030604.homework.writer.WriterException;

import java.util.List;

/**
 * Interface for outputing parsed and sorted data
 * to different sources.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataWriter {
	
	/**
	 * initialize datawriter
	 * @param args init parameters
	 * @throws WriterException in case setup fails, or provided args are wrong
	 */
	void setup(String... args) throws WriterException;
	
	/**
	 * cleanup routine
	 * @throws WriterException in case cleanup fails
	 */
	void cleanup() throws WriterException;
	
	/**
	 * output the results to the datasource.
	 * @param results sorted lists of results
	 * @throws WriterException in case output fails
	 */
	void output(List<AthleteScore> results) throws WriterException;

}
