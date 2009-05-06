package net.azib.java.students.t050545.homework.score.discipline;

/**
 * ShotPut
 * 
 * @author libricon
 */
public class ShotPut {
	private ShotPut() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((result - b), c));
	}

	private final static float a = 51.39f;
	private final static float b = 1.5f;
	private final static float c = 1.05f;

}