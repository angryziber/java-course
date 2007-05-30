package net.azib.java.students.t050657.homework.ctrl.dataOutput;

import net.azib.java.students.t050657.homework.model.Competition;

import java.io.IOException;

/**
 * DataWritter
 *
 * @author Boriss
 */
public interface DataWriter {
	
	public String path = "";

	public void writeCompetition(Competition competition) 
			throws IOException;
}
