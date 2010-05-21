package net.azib.java.students.t093052.homework;

/**
 * Class which contains measurment values of kinds of sport
 * */
public enum Measure {
	SECONDS(60),
	CENTIMETRES(100),
	METRES(1);
	
	private int factor;
	
	private Measure(int factor) {
		this.factor = factor;
	}
	
	/**
	 * Converts the input data into required format
	 * */
	public double convert(double result) {
		return result * factor;
	}
}
