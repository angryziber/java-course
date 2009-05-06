package net.azib.java.students.t050545.homework.score.discipline;

/**
 * PoleVault
 * 
 * @author libricon
 */
public class PoleVault {
	private PoleVault() {
	}

	public static int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((100 * result - b), c));
	}

	private final static float a = 0.2797f;
	private final static float b = 100f;
	private final static float c = 1.35f;

}