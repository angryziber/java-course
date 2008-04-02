package net.azib.java.students.t030633.homework.IO;

import net.azib.java.students.t030633.homework.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon output interface.
 * 
 * @author t030633
 */
public interface DecathlonOutput {

	boolean write(List<Athlete> out) throws IOException; // true if output complete
	
}
