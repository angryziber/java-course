package net.azib.java.students.t030520.homework.event;


/**
 * FieldEvent. The enum providing the info about field events.
 *
 * @author t030520
 */
public enum FieldEvent implements Event {

	LONGJUMP(0.14354f, 220f, 1.4f),

	SHOTPUT(51.39f, 1.5f, 1.05f),

	HIGHJUMP(0.8465f, 75f, 1.42f),

	DISCUSTHROW(12.91f, 4f, 1.1f),

	POLEVAULT(0.2797f, 100f, 1.35f),

	JAVELINTHROW(10.14f, 7f, 1.08f);

	private final float a;

	private final float b;

	private final float c;

	private FieldEvent(float a, float b, float c) {
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
