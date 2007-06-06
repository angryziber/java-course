package net.azib.java.students.t050657.homework.ctrl.dataOutput;

import net.azib.java.students.t050657.homework.model.Competition;

import java.io.IOException;

/**
 * DataWriter provides functionality for competition writing
 *
 * @author Boriss
 */
public interface DataWriter {
	
	public String path = "src/net/azib/java/students/t050657/homework/view/xml/";
	
	/**
	 * Writes Competition to a file 
	 * @param competition to write
	 * @throws IOException
	 */
	public void writeCompetition(Competition competition) 
			throws IOException;
}
