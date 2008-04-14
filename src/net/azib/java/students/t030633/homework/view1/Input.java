package net.azib.java.students.t030633.homework.view1;

import net.azib.java.students.t030633.homework.model1.Athlete;
import net.azib.java.students.t030633.homework.model1.AthleteBuilder;

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
