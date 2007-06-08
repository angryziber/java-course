package net.azib.java.students.t060401.homework.decathlon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * DecathlonResults
 * 
 * Vector which holds decathlon events with results
 * 
 * @author t060401
 */
public class DecathlonResults extends HashMap<DecathlonEventEnum, DecathlonEvent> {

	/** serialVersionUID */
	private static final long serialVersionUID = -3072730551585013502L;

	/**
	 * Puts decathlon event into the map and associates the specified event with
	 * its type in this map.
	 * 
	 * @param event
	 *            decathlon event object
	 */
	public DecathlonEvent put(DecathlonEvent event) {
		return super.put(event.getEventKey(), event);
	}

	/**
	 * Puts decathlon event into the map and associates the specified event with
	 * the specified key type in this map. Returns null if key type and and
	 * event type does not match
	 * 
	 * @param eventKey
	 *            specifies decathlon event type
	 * @param event
	 *            decathlon event object
	 */
	@Override
	public DecathlonEvent put(DecathlonEventEnum eventKey, DecathlonEvent event) {
		if (event.getEventKey() == eventKey) {
			return super.put(eventKey, event);
		}
		else {
			return null;
		}
	}

	/**
	 * @return returns <code>true</code> if all the events specified in
	 *         DecathlonEventEnum are set and performance for every event is
	 *         valid.
	 */
	public boolean isComplete() {
		boolean isComplete = true;
		DecathlonEventEnum[] events = DecathlonEventEnum.values();
		for (int i = 0; i < events.length; i++) {
			DecathlonEvent event = this.get(events[i]);
			if (event == null || event.getPerformance() < 0) {
				isComplete = false;
				break;
			}
		}
		return isComplete;
	}

	/**
	 * @return returns sum of the points calculated for every event
	 */
	public int getPoints() {
		int points = 0;
		Set<DecathlonEventEnum> eventSet = this.keySet();
		Iterator<DecathlonEventEnum> it = eventSet.iterator();
		while (it.hasNext()) {
			DecathlonEventEnum event = it.next();
			DecathlonEvent eventData = this.get(event);
			points += eventData.getPoints();
		}
		return points;
	}

	/**
	 * @return returns a vector of performances of events in this map
	 */
	public Vector<String> getResultsVector() {
		DecathlonEventEnum[] events = DecathlonEventEnum.values();
		String[] resultsArray = new String[events.length];
		if (this.size() == events.length) {
			for (int i = 0; i < events.length; i++) {
				DecathlonEvent event = this.get(events[i]);
				if (event != null) {
					int position = event.getEventKey().getPosition() - 1;
					if (position < events.length && position >= 0) {
						resultsArray[position] = event.toString();
					}
				}
			}
		}
		return new Vector<String>(Arrays.asList(resultsArray));
	}

}
