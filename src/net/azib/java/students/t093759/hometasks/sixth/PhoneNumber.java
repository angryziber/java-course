package net.azib.java.students.t093759.hometasks.sixth;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * 31.03.11 3:02
 *
 * @author dionis
 */
public class PhoneNumber {
	String formattedPhoneNumber;

	public PhoneNumber(String phoneNumber) {
		if (!isValid(phoneNumber)) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": You entered incorrect phone number.");
		}
		formattedPhoneNumber = getFormattedPhoneNumber(phoneNumber);
	}

	@Override
	public String toString() {
		return formattedPhoneNumber;
	}

	public static boolean isValid(String phoneNumber) {
		return phoneNumber.replace(" ", "").matches("^\\d{2,30}$");
	}

	private String getFormattedPhoneNumber(String phoneNumber) {
		DecimalFormat format = new DecimalFormat();
		format.setGroupingSize(3);
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
		formatSymbols.setGroupingSeparator('-');
		format.setDecimalFormatSymbols(formatSymbols);
		return format.format(new BigInteger(phoneNumber.replace(" ", "")));
	}
}
