package net.azib.java.students.t030633.homework.IO;

import net.azib.java.students.t030633.homework.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon input interface.
 * 
 * @author t030633
 */
public interface DecathlonInput {

	List<Athlete> read() throws IOException;

}
