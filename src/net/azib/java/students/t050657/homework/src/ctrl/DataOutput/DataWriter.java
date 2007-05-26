package net.azib.java.students.t050657.homework.src.ctrl.DataOutput;

import net.azib.java.students.t050657.homework.src.model.Competition;

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
