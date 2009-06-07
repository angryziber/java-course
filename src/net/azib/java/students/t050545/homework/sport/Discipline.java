package net.azib.java.students.t050545.homework.sport;

/**
 * Disciplines enumeration calculate points
 * <code>returnPoints(float results)</code> return type is integer
 * <pre>
 *         Points = INT(A*(B-P)C) for track events
 *         Points = INT(A*(P-B)C) for field events
 * </pre>
 * 
 * @author libricon
 */
public enum Discipline {

	/** Jug100m */
	Race_100m(25.4347f, 18f, 1.81f, 1),
	/** LongJump */
	Long_jump(0.14354f, 220f, 1.4f, -1),
	/** ShotPut */
	Shot_put(51.39f, 1.5f, 1.05f, -1),
	/** HighJump */
	High_jump(0.8465f, 75f, 1.42f, -1),
	/** Jug400m */
	Race_400m(1.53775f, 82f, 1.81f, 1),
	/** Hurdles110m */
	Hurdles_110m(5.74352f, 28.5f, 1.92f, 1),
	/** DiscusThrow */
	Discus_throw(12.91f, 4f, 1.1f, -1),
	/** PoleVault */
	Pole_vault(0.2797f, 100f, 1.35f, -1),
	/** JavelinThrow */
	Javelin_throw(10.14f, 7f, 1.08f, -1),
	/** Jug1500m */
	Race_1500m(0.03768f, 480f, 1.85f, 1);

	/**
	 * To initialise each discipline need 3 constants to calculate points.. A B C
	 * @param koef determine calculation for each discipline: races 1, polevault -1
	 */
	Discipline(float a, float b, float c, int koef) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.koef = koef;
	}

	final int koef;
	final float a;
	final float b;
	final float c;

	/** Calculate points for each discipline
	 * @param result athlete result
	 * @return score points according to results
	 */
	int returnPoints(float result) {
		return (int) Math.round(a * Math.pow((koef * (b - result)), c));
	}

}