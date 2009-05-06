package net.azib.java.students.t050545.homework.score.discipline;

/**
 * Hurdles110m
 * 
 * @author libricon
 */
public class Hurdles110m {
	private Hurdles110m() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((b - result), c));
	}

	private final static float a = 5.74352f;
	private final static float b = 28.5f;
	private final static float c = 1.92f;

}
