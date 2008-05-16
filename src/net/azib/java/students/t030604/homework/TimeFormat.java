package net.azib.java.students.t030604.homework;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * formatter used to format time to mm:sec format
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class TimeFormat extends NumberFormat {
	
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

	/* (non-Javadoc)
	 * @see java.text.NumberFormat#format(double, java.lang.StringBuffer, java.text.FieldPosition)
	 */
	@Override
	public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
		if (number > 60F) {
			int minutes = (int) (number / 60F);
			float seconds = (float) number - minutes*60;
			return toAppendTo.append(minutes+":"+timeFormat.format(seconds));
		}
		
		return toAppendTo.append(numberFormat.format(number));
	}

	/* (non-Javadoc)
	 * @see java.text.NumberFormat#format(long, java.lang.StringBuffer, java.text.FieldPosition)
	 */
	@Override
	public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
		return format((double) number, toAppendTo, pos);
	}

	/* (non-Javadoc)
	 * @see java.text.NumberFormat#parse(java.lang.String, java.text.ParsePosition)
	 */
	@Override
	public Number parse(String raw, ParsePosition parsePosition) {
		Float result = null;
		//firstly try to parse simple seconds
		try {
			result = new Float(raw);
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
