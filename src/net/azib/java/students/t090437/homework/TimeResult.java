package net.azib.java.students.t090437.homework;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * TimeResult is a convenient container for data about 
 * time measured in seconds and minutes. It contains 
 * a static parse function what checks whether the string 
 * supplied represents seconds and in case of valid string, 
 * returns a new TimeResult object or throws BadDataFormatException 
 * when the string format is invalid. The objects of this 
 * class are immutable.
 *
 * @author Ronald
 */
public class TimeResult {
	private String txt;
	private double sec;
	/**
	 * Returns the amount of seconds specified by the object.
	 */
	public double getSec() {
		return sec;
	}

	public String toString() {
		return txt;
	}

	/** 
	 * Parses string in form "min:sec"(example: 5:39.10) or "sec"(example 2.0)
	 * and return MyTime object. The method toString() will return the same string 
	 * what was given as parameter for this method.
	 * @param txt
	 * @return
	 * @throws BadDataFormatException
	 */
	public static TimeResult createObj(String txt) throws BadDataFormatException {
		int col_pos = txt.indexOf(':');
		TimeResult obj = new TimeResult();
		
		DecimalFormat formatter = formatterTo2Decimal();
		
		//obj.txt = txt;
		
		try {
			if(col_pos == -1) {
				obj.sec = Double.parseDouble(txt);
				obj.txt = formatter.format(obj.sec);
			} else {
				obj.sec = 60*Integer.parseInt(txt.substring(0, col_pos)) +
					Double.parseDouble(txt.substring(col_pos + 1, txt.length()));
				obj.txt = txt.substring(0, col_pos) + ":" + formatter.format(obj.sec);
			}
		} catch(NumberFormatException e) {
			throw new BadDataFormatException("Bad time format : " + txt);
		}		
		return obj;			
	}
	
	/**
	 * Creates MyTime object from seconds specified in the parameter.
	 * The created object will have method toString, what returns seconds with 
	 * accuracy of 2 decimal places. If the amount of seconds specified is 
	 * greater than 60, minutes will also be shown.
	 * @param sec
	 * @return
	 */
	public static TimeResult createObj(double sec) {
		TimeResult obj = new TimeResult();
		obj.sec = sec;
		int min = (int) (sec - sec%60.0)/60;
		
		DecimalFormat formatter = formatterTo2Decimal();		
		
		if(min > 0) {
			obj.txt = Integer.toString(min) + ":" + formatter.format(sec%60.0);
		} else {
			obj.txt = formatter.format(sec%60.0);
		}	
		
		return obj;
	}

	/**
	 * @return
	 */
	private static DecimalFormat formatterTo2Decimal() {
		DecimalFormat formatter = new DecimalFormat("0.00");
		DecimalFormatSymbols formatterSymbols = new DecimalFormatSymbols();
		formatterSymbols.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(formatterSymbols);
		return formatter;
	}
}
