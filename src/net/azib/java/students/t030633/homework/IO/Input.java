package net.azib.java.students.t030633.homework.IO;

import net.azib.java.students.t030633.homework.Event;

import java.io.IOException;
import java.util.List;

/**
 * Input
 * 
 * @author t030633
 */
public interface Input {

	List<Event> read() throws IOException;

}
