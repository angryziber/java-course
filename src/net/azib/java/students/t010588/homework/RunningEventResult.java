package net.azib.java.students.t010588.homework;

import java.text.DecimalFormat;

/**
 * Class representing result of Running type decathlon event.
 *
 * @author Vjatseslav Rosin, 010588
 */
public class RunningEventResult extends Result {

	private DecimalFormat decimalFormat = new DecimalFormat("00.00");

	protected float value;

	private int index;

	private int points;

	/**
	 * @param index
	 *            of event starting (one of: 0, 4, 5, 9)
	 * @param value
	 *            of event result in a textual form
	 */
	public RunningEventResult(int index, String value) {
		this.index = index;
		this.value = evaluateTime(value);
		this.points = scorePoints(this.value);
	}

	/**
	 * @param index
	 *            of event starting (one of: 0, 4, 5, 9)
	 * @param value
	 *            of event result
	 */
	public RunningEventResult(int index, float value) {
		this.index = index;
		this.value = value;
		this.points = scorePoints(this.value);
	}

	/**
	 * @param time
	 *            as string (m:s)
	 * @return time in seconds
	 */
	private float evaluateTime(String value) {
		String[] time = value.split("[:]");
		float s = 0, // Seconds
		m = 0; // Minutes

		switch (time.length) {
		case 1: // Milliseconds only
			s = Float.parseFloat(time[0]);
			break;
		default: // Seconds and milliseconds
			m = Integer.parseInt(time[0]);
			s = Float.parseFloat(time[1]);
		}

		return m * 60 + s;
	}

	public Float getValue() {
		return value;
	}

	public EventType getEvent() {
		return EventType.RUNNING;
	}

	public String toString() {
		return formatTime();
	}

	/**
	 * @return time in adequate format
	 */
	private String formatTime() {
		int m = (int) Math.floor(value / 60);

		float s = value - m * 60;

		String sString = decimalFormat.format(s);
		sString = sString.replaceAll(",", ".");

		String time = sString + "";
		if (m > 0)
			time = m + ":" + sString;
		return time;
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
