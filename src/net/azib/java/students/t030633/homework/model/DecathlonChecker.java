package net.azib.java.students.t030633.homework.model;

import java.util.EnumMap;

/**
 * Checks for logical correctness in decathlon results.
 *
 * @author t030633
 */
public class DecathlonChecker extends SimpleChecker {

	public EnumMap<Event, Double> checkResults(EnumMap<Event, Double> results) {
		if (results == null)
			return new EnumMap<Event, Double>(Event.class);
		else {
			for (Event e : results.keySet()) {
				Double result = results.get(e);
				switch (e) {
				case DISCUS: if (result > 100D) results.remove(e); break;
				case HIGH: if (result > 4D)	results.remove(e); break;
				case JAVELIN: if (result > 150D) results.remove(e); break;
				case LONG: if (result > 15D) results.remove(e); break;
				case POLE: if (result > 15D) results.remove(e); break;
				case R100M:	if (result < 6D) results.remove(e); break;
				case R110MH: if (result < 6D) results.remove(e); break;
				case R1500M: if (result < 150D)	results.remove(e); break;
				case R400M:	if (result < 30D) results.remove(e); break;
				case SHOT: if (result > 30D) results.remove(e); break;
				}
			}
			return results;
		}
	}

}
