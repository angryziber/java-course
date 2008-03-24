package net.azib.java.students.t030633.homework.IO;

import net.azib.java.students.t030633.homework.Event;

import java.io.IOException;
import java.util.List;

/**
 * Output
 * 
 * @author t030633
 */
public interface Output {

	void write(List<Event> out) throws IOException;
	
}
