package net.azib.java.students.t020632.homework;

/**
 * EventInfo
 *
 * @author Marek Soobik
 */
public enum EventInfo {
	RUN_100M			(25.437F, 18.0F, 1.81F),
	LONG_JUMP			(0.14354F, 220.0F, 1.40F),
	SHOT_PUT 			(51.39F, 1.5F, 1.05F),
	HIGH_JUMP 			(0.8465F, 75.0F, 1.42F),
	RUN_400M 			(1.53775F, 82.0F, 1.81F),
	RUN_110M_HURDLES 	(5.74352F, 28.5F, 1.92F),
	DISCUS_THROW 		(12.91F, 4.0F, 1.1F),
	POLE_VAULT 			(0.2797F, 100.0F, 1.35F),
	JAVELIN_THROW 		(10.14F, 7.0F, 1.08F),
	RUN_1500M 			(0.03768F, 480.0F, 1.85F);
	
	private final float A;
	private final float B;
	private final float C;
	
	private EventInfo(float A, float B, float C){
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public float getA(){
		return A;
	}
	
	public float getB(){
		return B;
	}
	
	public float getC(){
		return C;
	}
	
}
