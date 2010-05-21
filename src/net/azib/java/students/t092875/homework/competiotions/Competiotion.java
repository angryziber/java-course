package net.azib.java.students.t092875.homework.competiotions;

import java.util.regex.Pattern;

/**
 * Competiotions
 *
 * @author Mihhail
 */
public enum Competiotion {
    SPRINT_100M(25.4347,18,1.81),
    LONG_JUMP(0.14354,220,1.4),
    SHOT_PUT(51.39,1.5,1.05),
    HIGH_JUMP(0.8465,75,1.42),
    SPRINT_400M(1.53775,82,1.81),
    HURDLES_110M(5.74352,28.5,1.92),
    DISCUS_THROW(12.91,4,1.1),
    POLE_VAULT(0.2797,100,1.35),
    JAVELIN_THROW(10.14,7,1.08),
    RACE_1500M(0.03768,480,1.85);
    
    private final double A;
    private final double B;
    private final double C;
    
    public double A() { return A; }
    public double B() { return B; }
    public double C() { return C; }
    
    Competiotion(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    /**
	 * Calculates the result points for the individual event in the competition
	 * 
	 * @param result - The result in meters or seconds depending on the event
	 * @return returns the points for the individual result as an integer
	 */
    public int points(String result){
    	int event = ordinal();
    	if(event==0 || event==4 || event==5 || event==9){
			if(isWithMinutes(result)){
				String[] subResult = result.split(":");
				Double seconds = new Double(subResult[1])+new Double(subResult[0])*60;
				return (int) (A*Math.pow((B-seconds),C));
			}
			return (int) (A*Math.pow((B-new Double(result)),C));
		}else{
			Double length = new Double(result);
			
			if(event==1 || event==3 || event==7){
				length *= 100;
			}
			return (int) (A*Math.pow((length-B),C));
		}
    }
    /**
     * 
     * @return returns a readable name of the competition event
     */
    public String event(){
    	return values()[ordinal()].toString().replace("_", " ").toLowerCase();
    }
    
    /**
	 * Checks if the result is in minutes format
	 * 
	 * @param time - checks if the time is in minutes and not in seconds format
	 * @return a boolean value, which is true if the time is in minutes format. false otherwise. 
	 */
    boolean isWithMinutes(String time){
		return Pattern.matches("[0-9]{1,2}:[0-9]{1,2}\\.[0-9]{1,2}\\s*", time);
	}
}
