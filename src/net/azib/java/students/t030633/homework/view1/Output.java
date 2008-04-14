package net.azib.java.students.t030633.homework.view1;

import net.azib.java.students.t030633.homework.model1.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon output interface - all outputs write a list of athletes.
 * 
 * @author t030633
 */
public interface Output {

	void write(List<Athlete> out) throws IOException;
	
}
