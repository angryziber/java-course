package net.azib.java.students.t030647.homework;

import java.util.StringTokenizer;

/**
 * Second
 * This class allows to store event's result in seconds
 * @author Igor
 */
public class Second {
	
	private int second;
	private int minute;
	private float millisecond;
	
	/**
	 * @param event's result
	 */
	public Second(String input) {
		StringTokenizer tok = new StringTokenizer(input, ":");
		if (tok.countTokens() < 2) { 
			tok = new StringTokenizer(input, ".");
			second = Integer.parseInt(tok.nextToken());
			String ms = tok.nextToken();
			if (!ms.contains("0") && Float.parseFloat(ms) <10) {
				millisecond = Float.parseFloat(ms.concat("0"));
			}
			else millisecond = Float.parseFloat(ms);
		}
		else {
			minute = Integer.parseInt(tok.nextToken());
			StringTokenizer tok2 = new StringTokenizer(tok.nextToken(), ".");
			second = Integer.parseInt(tok2.nextToken());
			String ms = tok2.nextToken();
			if (!ms.contains("0") && Float.parseFloat(ms) <10) {
				millisecond = Float.parseFloat(ms.concat("0"));
			}
			else millisecond = Float.parseFloat(ms);

		}
	}
	
	/**
	 * 
	 * @return minutes
	 */
	public int getMinutes() {
		return minute;
	}
	
	/**
	 * 
	 * @return seconds
	 */
	public int getSeconds() {
		return second;
	}
	
	/**
	 * 
	 * @return milliseconds
	 */
	public float getMilliseconds() {
		return millisecond;
	}
	
	/** 
	 * return result as string
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		if (minute!=0) {
			buf.append(minute+":");
			if (second<10) {
				buf.append("0");
				buf.append(second+".");
			}
		}
		else buf.append(second+".");
		if (millisecond<10) {
			buf.append("0");
			buf.append((int)millisecond);
		}
		else buf.append((int)millisecond);
		return buf.toString();
	}
	
}
