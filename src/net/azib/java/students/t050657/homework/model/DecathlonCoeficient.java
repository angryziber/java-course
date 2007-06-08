package net.azib.java.students.t050657.homework.model;

import java.util.regex.Pattern;

/**
 * DecathlonCoeficient class represents ten events of dechatlon competition. 
 * Each DechatlonCoeficient event has A, B and C coeficients, 
 * that helps calculate evaluate points for concrete event.
 * Class has functions for reducing to needed format and evaluating event points.    
 *
 * @author Boriss
 */
public enum DecathlonCoeficient{
	
	M_100(true, 25.437, 18.0, 1.81, "100 m sprint", "sec"),
	LONG_JUMP(false,  0.14354, 220, 1.40, "Long jump", "cm"),
	SHOT_PUT(false, 51.39, 1.5, 1.05, "Shot put", "m"),
	HIGH_JUMP(false,  0.8465, 75, 1.42, "High jump", "cm"),
	M_400(true, 1.53775, 82, 1.81, "400 m sprint", "sec"),
	M_110_HURDLES(true, 5.74352, 28.5, 1.92, "110 m hurdles", "sec"),
	DISCUS_THROW(false, 12.91, 4.0, 1.1, "Discus throw", "m"),
	POLE_VAULT(false, 0.2797, 100, 1.35, "Pole vault", "cm"),
	JAVELIN_THROW(false, 10.14, 7.0, 1.08, "Javelin throw", "m"),
	M_1500(true, 0.03768, 480, 1.85, "1500 m race", "sec");
	
	/**
	 * Final static field contains quantity of Dechatlon competition events 
	 */
	public static final int EVENT_QUANT = 10;

	private final boolean runEvent;
	private final double A;
	private final double B;
	private final double C;
	private final String title;
	private String format;
	
	/**
	 * DecathlonCoeficient constructor creates new instance of concrete decathlon event
	 * @param runEvent contains information about event type 
	 * @param A coeficient for calculating final score
	 * @param B coeficient for calculating final score
	 * @param C coeficient for calculating final score
	 * @param title contains full event title
	 * @param format, result need to be in to evaluate event score 	
	 */
	DecathlonCoeficient(boolean runEvent, double A, double B, double C, String title, String format) {
		this.runEvent = runEvent;
		this.A = A;
		this.B = B;
		this.C = C;
		this.title = title;
		this.format = format;
	}
	
	/**
	 * Function evaluating points for event
	 * @param result value in decathlon event 
	 * @return points getted with event result  	
	 */
	public double evalPoints(double result) {
		if(runEvent) {
			return evalRunPoints(result);
		}
		else{
			return evalNonrunPoints(result);
		}
	}
	
	/**
	 * Allows to reduce event result to needed in calculation format.
	 * If format is congruent with needed returns it double value 
	 * Can reduce
	 * <ul>
	 * 	<li>(m) meeters to sentimeeters</li>
	 *  <li>(min:sec) minutes and seconds to seconds</li>
	 * </ul>
	 * @param value that should be reduced
	 * @param valueFormat format, which representing the value in 	
	 * @return value in needed format
	 * @throws IllegalArgumentException is thrown, if inappropriate format is used
	 */
	public double reduceToFormat(String value, String valueFormat) throws IllegalArgumentException{
		if(valueFormat.equals(format)) {
			return Double.parseDouble(value);
		}
		else if(valueFormat.equals("m") && this.format.equals("cm")) {
			return mToCm(value);
		}
		else if(valueFormat.equals("min:sec") && this.format.equals("sec")) {
			return minSecToSec(value);
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Getter for event type
	 * @return true, if event is running, false otherwise
	 */
	public boolean isRunEvent() {
		return runEvent;
	}
	
	/**
	 * Getter for event full title
	 * @return fuul event title
	 */
	public String getTitle() {
		return title;
	}
	
	private double evalRunPoints(double result){
		return A * Math.pow((B - result), C);
	}
	
	private double evalNonrunPoints(double result){
		return A * Math.pow((result - B), C);
	}
	
	/**
	 * Getter for event format
	 * @return format, in which should be result to succesfull points calculation 
	 */
	public String getFormat() {
		return format;
	}

	private double mToCm(String value) throws NumberFormatException{
		return ((double)(int)(Double.parseDouble(value)*10000))/100;
	}
	
	private double minSecToSec(String value) throws NumberFormatException{
		
		Pattern minSec = Pattern.compile("[0-9]+:[0-9]{1,2}\\.[0-9]{1,2}");
		Pattern sec = Pattern.compile("[0-9]*\\.[0-9]{1,2}");
		
		if(minSec.matcher(value).matches()) {
			String[] v = value.split(":");
			double mins = Double.parseDouble(v[0])*60;
			double secs = Double.parseDouble(v[1]);
			return ((double)(int)((mins + secs)*100))/100;
		}
		else if(sec.matcher(value).matches()) {
			return ((double)(int)Double.parseDouble(value)*100)/100;
		}
		else {
			System.out.println(value);
			throw new NumberFormatException();
		}
		
	}
	
}
