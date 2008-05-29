package net.azib.java.students.t030604.homework.util;

import java.text.NumberFormat;

/**
 * formatter used to format time to mm:sec format
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public final class TimeFormat {
	
	private TimeFormat() {
		//intended
	}
	
	/**
	 * serial version uid.
	 */
	private static final long serialVersionUID = -5242406833228604663L;
	
	private static final NumberFormat numberFormat;
	private static final NumberFormat timeFormat;
	
	static {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
		
		timeFormat = NumberFormat.getNumberInstance();
		timeFormat.setMinimumIntegerDigits(2);
	}

	public static String format(float number) {
		if (number > 60F) {
			int minutes = (int) (number / 60F);
			float seconds = (float) number - minutes*60;
			return minutes+":"+timeFormat.format(seconds);
		}
		
		return numberFormat.format(number);
	}

	public static Float parse(String raw) {
		Float result = null;
		//firstly try to parse simple seconds
		try {
			result = Float.valueOf(raw);
		} catch (NumberFormatException ignored) {
			//ouch, let's try smth else
		}
		String[] splitted = raw.split(":");
		if (splitted.length == 2) {
			Float minutes = null;
			Float seconds = null;
			try {
				minutes = new Float(splitted[0]);
				seconds = new Float(splitted[1]);
			} catch (NumberFormatException ignored) {
				//well, better luck next time
			}
			//simple sane check
			if (minutes > 0F && seconds > 0F && seconds < 60F) {
				result = minutes * 60F + seconds;
			}
		}
		return result;
	}

}
