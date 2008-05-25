package net.azib.java.students.t010588.homework;

/**
 * Abstract result class contains common functionality for any decathlon event
 *
 * @author Vjatseslav Rosin, 010588
 */
public abstract class Result {

	/**
	 * @return event result value
	 */
	public abstract Float getValue();

	/**
	 * @return event type
	 */
	public abstract EventType getEvent();

	public abstract String toString();

	/**
	 * @return index of event
	 */
	public abstract int getIndex();

	/**
	 * @return points scored for event
	 */
	public abstract int getPoints();

	/**
	 * @param value
	 *            of event result
	 * @return points scored for event
	 */
	protected int scorePoints(float value) {
		float p = value;

		if ((getIndex() == 1) || (getIndex() == 3) || (getIndex() == 7)) {
			// Event result should be converted to cm
			p *= 100;
		}

		int score = 0;

		if (DecathlonConstants.EVENTS[getIndex()] == EventType.RUNNING) {
			score = new Double(DecathlonConstants.CONSTANT_A[getIndex()]
					* Math.pow(DecathlonConstants.CONSTANT_B[getIndex()] - p, DecathlonConstants.CONSTANT_C[getIndex()]))
					.intValue();
		}
		else {
			score = new Double(DecathlonConstants.CONSTANT_A[getIndex()]
					* Math.pow(p - DecathlonConstants.CONSTANT_B[getIndex()], DecathlonConstants.CONSTANT_C[getIndex()]))
					.intValue();
		}

		return score;
	}
}