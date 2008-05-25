package net.azib.java.students.t010588.homework;

/**
 * Class representing result of Field type decathlon event
 *
 * @author Vjatseslav Rosin, 010588
 */
public class FieldEventResult extends Result {

	protected Float value;

	private int index;

	private int points;

	/**
	 * @param index
	 *            of event starting (one of: 1, 2, 3, 6, 7, 8)
	 * @param value
	 *            of event result
	 */
	public FieldEventResult(int index, float value) {
		this.index = index;
		this.value = value;
		this.points = scorePoints(this.value);
	}

	public Float getValue() {
		return value;
	}

	public String toString() {
		return value + "";
	}

	public EventType getEvent() {
		return EventType.FIELD;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public int getPoints() {
		return points;
	}
}
