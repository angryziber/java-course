package net.azib.java.students.t092859.homework.output;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.util.List;

/**
 * DecathlonResultWriter
 *
 * @author konstantin
 */
public interface DecathlonResultWriter {
	void writeResults(List<DecathlonResult> results, List<String> places);
}
