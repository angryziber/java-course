package net.azib.java.students.t030520.homework.event;


/**
 * TrackEvent. The enum providing the info about field events.
 *
 * @author t030520
 */
public enum TrackEvent implements Event {

	SPRINT100(25.4347f, 18f, 1.81f),

	SPRINT400(1.53775f, 82f, 1.81f),

	HURDLES110(5.74352f, 28.5f, 1.92f),

	RACE1500(0.03768f, 480f, 1.85f);

	private final float a;

	private final float b;

	private final float c;

	private TrackEvent(float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * @return the A coefficient.
	 */
	public float getA() {
		return this.a;
	}

	/**
	 * @return the B coefficient.
	 */
	public float getB() {
		return this.b;
	}

	/**
	 * @return the C coefficient.
	 */
	public float getC() {
		return this.c;
	}

	/**
	 * @return the name of event enum type.
	 */
	public String getName() {
		return this.name();
	}

	/**
	 * @param the event to compare.
	 * @return true if events are equal.
	 */
	@Override
	public boolean equals(Event event) {
		return event != null && event.getName().equals(event.getName());
	}
}
