package net.azib.java.students.t050545.homework.score.discipline;

/**
 * Jug400m
 * 
 * @author libricon
 */
public class Jug400m {
	private Jug400m() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((b - result), c));
	}

	private final static float a = 1.53775f;
	private final static float b = 82f;
	private final static float c = 1.81f;

}
