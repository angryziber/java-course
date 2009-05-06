package net.azib.java.students.t050545.homework.score.discipline;

/**
 * DiscusThrow
 * 
 * @author libricon
 */
public class DiscusThrow {
	private DiscusThrow() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((result - b), c));
	}

	private final static float a = 12.91f;
	private final static float b = 4f;
	private final static float c = 1.1f;

}
