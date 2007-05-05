package net.azib.java.students.t020632.homework;

/**
 * EventInfo enum contains information for points calculation. 
 *
 * @author Marek Soobik t020632
 */
public enum EventInfo {
	RUN_100M			(25.437F, 18.0F, 1.81F, "sec", "runningEvent"),
	LONG_JUMP			(0.14354F, 220.0F, 1.40F, "cm", "fieldEvent"),
	SHOT_PUT 			(51.39F, 1.5F, 1.05F, "m", "fieldEvent"),
	HIGH_JUMP 			(0.8465F, 75.0F, 1.42F, "cm", "fieldEvent"),
	RUN_400M 			(1.53775F, 82.0F, 1.81F, "sec", "runningEvent"),
	RUN_110M_HURDLES 	(5.74352F, 28.5F, 1.92F, "sec", "runningEvent"),
	DISCUS_THROW 		(12.91F, 4.0F, 1.1F, "m", "fieldEvent"),
	POLE_VAULT 			(0.2797F, 100.0F, 1.35F, "cm", "fieldEvent"),
	JAVELIN_THROW 		(10.14F, 7.0F, 1.08F, "m", "fieldEvent"),
	RUN_1500M 			(0.03768F, 480.0F, 1.85F, "sec", "runningEvent");
	
	private final float A;
	private final float B;
	private final float C;
	private String units;
	private String type;
	
	private EventInfo(float A, float B, float C, String units, String type){
		this.A = A;
		this.B = B;
		this.C = C;
		this.units = units;
		this.type = type;
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
	
	public String getUnits(){
		return units;
	}
	
	public String getType(){
		return type;
	}
	
}
