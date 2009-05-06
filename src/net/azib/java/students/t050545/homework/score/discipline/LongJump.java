package net.azib.java.students.t050545.homework.score.discipline;

/**
 * LongJump
 * 
 * @author libricon
 */
public class LongJump {
	private LongJump() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((100 * result - b), c));
	}

	private final static float a = 0.14354f;
	private final static float b = 220f;
	private final static float c = 1.4f;

}