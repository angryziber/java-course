package net.azib.java.students.t093052.homework;

/**
 * Class which contains measurment values of kinds of sport
 * */
public enum Measure {
	SECONDS(60, "(\\d+:)?\\d+\\.\\d+"),
	CENTIMETRES(100, "\\d+\\.\\d+"),
	METRES(1, "\\d+\\.\\d+");
	
	private int factor;
	private String valuePattern;
	
	private Measure(int factor, String valuePattern) {
		this.factor = factor;
		this.valuePattern = valuePattern;
	}
	
	/**
	 * Converts the input data into required format
	 * */
	public double convert(double result) {
		return result * factor;
	}
	
	/**
	 * Defines expected value pattern which depends on measure unit
	 */
	public String getValuePattern() {
		return valuePattern;
	}
}
