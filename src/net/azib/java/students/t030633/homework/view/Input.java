package net.azib.java.students.t030633.homework.view;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon input interface - all inputs provide a list of athletes.
 * 
 * @author t030633
 */
public interface Input {
	
	Input builder(AthleteBuilder builder);

	List<Athlete> read() throws IOException;

}
