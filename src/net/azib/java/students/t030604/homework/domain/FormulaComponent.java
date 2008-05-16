package net.azib.java.students.t030604.homework.domain;

/**
 * Container for various formula related constants.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public enum FormulaComponent {
	SPRINT100(25.437F, 18F, 1.81F, true, 1F),
	LONG_JUMP(0.14354F, 220F, 1.40F, false, 100F),
	SHOT_PUT(51.39F, 1.5F, 1.05F, false, 1F),
	HIGH_JUMP(0.8465F, 75F, 1.42F, false, 100F),
	SPRINT400(1.53775F, 82F, 1.81F, true, 1F),
	HURDLES110(5.74352F, 28.5F, 1.92F, true, 1F),
	DISCUS_THROW(12.91F, 4.0F, 1.1F, false, 1F),
	POLE_VAULT(0.2797F, 100F, 1.35F, false, 100F),
	JAVELIN_THROW(10.14F, 7.0F, 1.08F, false, 1F),
	RACE1500(0.03768F, 480F, 1.85F, true, 1F);
	
	private float a;
	private float b;
	private float c;
	private boolean running;
	// often results must be processed in non-standard units (cm)
	// result coeficient allows to convert from standard SI system to 
	// required
	private float siCoeficient;
	
	/**
	 * @param a formula a component
	 * @param b formula b component
	 * @param c formula c component
	 * @param running running event flag
	 * @param resultMultiplier result multiplier to use
	 */
	private FormulaComponent(float a, float b, float c, boolean running, float siCoeficient) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.running = running;
		this.siCoeficient = siCoeficient;
	}

	/**
	 * @return the a
	 */
	public float getA() {
		return a;
	}

	/**
	 * @return the b
	 */
	public float getB() {
		return b;
	}

	/**
	 * @return the c
	 */
	public float getC() {
		return c;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @return the siCoeficient
	 */
	public float getSiCoeficient() {
		return siCoeficient;
	}
}
