package net.azib.java.students.t050545.homework.score.discipline;

/**
 * Jug100m
 * 
 * @author libricon
 */
public class Jug100m {
	private Jug100m() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((b - result), c));
	}

	private final static float a = 25.4347f;
	private final static float b = 18f;
	private final static float c = 1.81f;
}
