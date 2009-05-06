package net.azib.java.students.t050545.homework.score.discipline;

/**
 * HighJump
 * 
 * @author libricon
 */
public class HighJump {
	private HighJump() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((100 * result - b), c));
	}

	private final static float a = 0.8465f;
	private final static float b = 75f;
	private final static float c = 1.42f;

}