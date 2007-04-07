package net.azib.java.students.t050657.homework.src;

public enum DecathlonCoeficient{
	
	M_100(true, true, 25.437, 18.0, 1.81),
	LONG_JUMP(false, true, 0.14354, 220, 1.40),
	SHOT_PUT(false, true,51.39, 1.5, 1.05),
	HIGH_JUMP(false, true, 0.8465, 75, 1.42),
	M_400(true, true, 1.53775, 82, 1.81),
	M_110_HURDLES(true, false, 5.74352, 28.5, 1.92),
	DISCUS_THROW(false, false, 12.91, 4.0, 1.1),
	POLE_VAULT(false, false, 0.2797, 100, 1.35),
	JAVELIN_THROW(false, false, 10.14, 7.0, 1.08),
	M_1500(true, false, 0.03768, 480, 1.85);
	
	public static final int EVENT_QUANT = 10;
	
	private final boolean runEvent;
	private final boolean firstDayEvent;
	private final double A;
	private final double B;
	private final double C;
	
	DecathlonCoeficient(boolean runEvent, boolean firstDayEvent, double A, double B, double C) {
		this.runEvent = runEvent;
		this.firstDayEvent = firstDayEvent;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public double evalPoints(double result) {
		if(runEvent) {
			return evalRunPoints(result);
		}
		else{
			return evalNonrunPoints(result);
		}
	}
	
	private double evalRunPoints(double result){
		return A * Math.pow((B - result), C);
	}
	
	private double evalNonrunPoints(double result){
		return A * Math.pow((result - B), C);
	}

	public boolean isRunEvent() {
		return runEvent;
	}
	
	public boolean isFirstDayEvent() {
		return firstDayEvent;
	}
	
	
}
