package net.azib.java.students.t050657.homework.src.model;

public enum DecathlonCoeficient{
	
	M_100(true, 25.437, 18.0, 1.81, "100 m sprint"),
	LONG_JUMP(false,  0.14354, 220, 1.40, "Long jump"),
	SHOT_PUT(false, 51.39, 1.5, 1.05, "Shot put"),
	HIGH_JUMP(false,  0.8465, 75, 1.42, "High jump"),
	M_400(true, 1.53775, 82, 1.81, "400 m sprint"),
	M_110_HURDLES(true, 5.74352, 28.5, 1.92, "110 m hurdles"),
	DISCUS_THROW(false, 12.91, 4.0, 1.1, "Discus throw"),
	POLE_VAULT(false, 0.2797, 100, 1.35, "Pole vault"),
	JAVELIN_THROW(false, 10.14, 7.0, 1.08, "Javelin throw"),
	M_1500(true, 0.03768, 480, 1.85, "1500 m race");
	
	public static final int EVENT_QUANT = 10;
	
	private final boolean runEvent;
	private final double A;
	private final double B;
	private final double C;
	private final String title;
	
	DecathlonCoeficient(boolean runEvent, double A, double B, double C, String title) {
		this.runEvent = runEvent;
		this.A = A;
		this.B = B;
		this.C = C;
		this.title = title;
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
	
	public String getTitle() {
		return title;
	}

}
