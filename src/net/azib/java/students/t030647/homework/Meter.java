package net.azib.java.students.t030647.homework;

import java.util.StringTokenizer;
/**
 * Meter
 * This class allows to store event's result in meters
 * @author Igor
 */
public class Meter {
	
	private int m; //meter
	private float cm; //centimeter
	
	/**
	 * @param event's result
	 */
	public Meter(String input) {
		
		StringTokenizer tok = new StringTokenizer(input, ".");
		m = Integer.parseInt(tok.nextToken());
		String sm = tok.nextToken();
		if (!sm.contains("0") && Float.parseFloat(sm) <10) {
			cm = Float.parseFloat(sm.concat("0"));
		}
		else cm = Float.parseFloat(sm);
		
	}
	
	/**
	 * @return meters
	 */
	public int getMeters() {
		return m;
	}
	
	/**
	 * @return centimeters
	 */
	public float getCentimeters() {
		return cm;
	}
	
	/**
	 * returns result as string
	 */
	public String toString() {
		if (cm == 0) {
			return m+"."+(int)cm+"0";
		}
		else return m+"."+(int)cm;
	}

}
