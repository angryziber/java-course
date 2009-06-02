package net.azib.java.students.t090437.homework;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * MyDouble
 * 
 * Container class for keeping double values of competition results.
 * This class is convenient way to store the double values and convert 
 * these to strings with 2 decimal points and to parse strings to doubles.
 * 
 * For simplicity, only non-negative values are allowed.
 * 
 * @author Ronald
 */
public class MyDouble {
	private double value;
	private String str;
	
	private MyDouble() {
		value = 0.0;
	}
	
	/**
	 * When the object was created with parseDouble, returns the string 
	 * used as the parameter, otherwise will return the double as string with 
	 * 2 decimal places.
	 */
	public String toString() {
		return str;
	}
	
	public double getValue() {
		return value;
	}
	
	/**
	 * Creates new MyDouble object from parameter string.
	 * It keeps the parameter for use with toString().
	 * 
	 * @param str
	 * @return
	 * @throws BadDataFormatException
	 */
	public static MyDouble parseDouble(String str) throws BadDataFormatException {
		MyDouble obj = new MyDouble();
		try {
			obj.value = Double.parseDouble(str);
			if(obj.value < 0.0) {
				throw new BadDataFormatException("Double values below zero are not allowed");
			}
		} catch(NumberFormatException e) {
			throw new BadDataFormatException("Bad format for double " + str);
		}
		obj.str = str;
		return obj;		
	}
	
	/**
	 * Creates new MyDouble object.
	 * @param value
	 * @return
	 */
	public static MyDouble createObj(double value) {
		MyDouble obj = new MyDouble();
		
		DecimalFormat formatter = new DecimalFormat("0.00");
		DecimalFormatSymbols formatterSymbols = new DecimalFormatSymbols();
		formatterSymbols.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(formatterSymbols);
		
		obj.value = value;
		obj.str = formatter.format(value);
		
		return obj;
	}
}
