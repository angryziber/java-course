package net.azib.java.students.t030633.homework.View;

import net.azib.java.students.t030633.homework.Model.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon input interface - all inputs provide a list of athletes.
 * 
 * @author t030633
 */
public interface Input {

	List<Athlete> read() throws IOException;

}
