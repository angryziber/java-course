package net.azib.java.students.t050545.homework.score.discipline;

/**
 * Jug1500m
 * 
 * @author libricon
 */
public class Jug1500m {
	private Jug1500m() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((b - result), c));
	}

	private final static float a = 0.03768f;
	private final static float b = 480f;
	private final static float c = 1.85f;

}