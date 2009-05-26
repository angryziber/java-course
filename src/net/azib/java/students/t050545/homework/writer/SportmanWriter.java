package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;

/**
 * SportmanWriter
 *
 * @author libricon
 */
public interface SportmanWriter {
	
	/** Method  should write to it's outStream all result
	 * @param array with competition table
	 */
	void printResultTable(Competition competition) throws Exception;
	void close();

}
