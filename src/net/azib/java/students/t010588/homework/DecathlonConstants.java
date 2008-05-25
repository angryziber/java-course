package net.azib.java.students.t010588.homework;


/**
 * Basic decathlon constants
 *
 * @author Vjatseslav Rosin, 010588
 */
public interface DecathlonConstants {

	/** Values of A decathlon constants */
	public static final float[] CONSTANT_A = new float[] { 25.437f, 0.14354f, 51.39f, 0.8465f, 1.53775f, 5.74352f, 12.91f,
			0.2797f, 10.14f, 0.03768f };

	/** Values of B decathlon constants */
	public static final float[] CONSTANT_B = new float[] { 18.0f, 220f, 1.5f, 75f, 82f, 28.5f, 4.0f, 100f, 7.0f, 480f };

	/** Values of C decathlon constants */
	public static final float[] CONSTANT_C = new float[] { 1.81f, 1.40f, 1.05f, 1.42f, 1.81f, 1.92f, 1.1f, 1.35f, 1.08f, 1.85f };

	/** Types of 10 decathlon events */
	public static EventType[] EVENTS = new EventType[] { EventType.RUNNING, EventType.FIELD, EventType.FIELD, EventType.FIELD,
			EventType.RUNNING, EventType.RUNNING, EventType.FIELD, EventType.FIELD, EventType.FIELD, EventType.RUNNING };
}
