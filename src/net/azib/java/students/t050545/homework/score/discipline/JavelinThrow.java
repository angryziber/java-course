package net.azib.java.students.t050545.homework.score.discipline;

/**
 * JavelinThrow
 * 
 * @author libricon
 */
public class JavelinThrow {
	private JavelinThrow() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((result - b), c));
	}

	private final static float a = 10.14f;
	private final static float b = 7f;
	private final static float c = 1.08f;

}