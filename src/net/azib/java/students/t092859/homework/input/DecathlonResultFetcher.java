package net.azib.java.students.t092859.homework.input;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.util.List;

/**
 * DecathlonResultFetcher
 *
 * @author konstantin
 */
public interface DecathlonResultFetcher {

	List<DecathlonResult> fetchResults() throws Exception;
	
}
