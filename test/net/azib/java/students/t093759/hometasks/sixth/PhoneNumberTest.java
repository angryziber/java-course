package net.azib.java.students.t093759.hometasks.sixth;

import org.junit.Test;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 31.03.11 3:03
 *
 * @author dionis
 */
public class PhoneNumberTest {
	String[] correctPhoneNumbers = {"123", "45678912", "123 4 5 6", "1234 567"};
	String[] incorrectPhoneNumbers = {"abdaa123", "45678912.00", "123+4-5*6", "1234,567"};

	@Test
	public void phoneNumberShouldConsistOnlyOfDigits() {
		for (String correctPhoneNumber : correctPhoneNumbers) {
			assertTrue(correctPhoneNumber, PhoneNumber.isValid(correctPhoneNumber));
		}
	}

	@Test
	public void incorrectPhoneNumbersExamples() {
		for (String incorrectPhoneNumber : incorrectPhoneNumbers) {
			assertFalse(incorrectPhoneNumber, PhoneNumber.isValid(incorrectPhoneNumber));
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void unableToCreateIncorrectPhoneNumber() {
		for (String incorrectPhoneNumber : incorrectPhoneNumbers) {
			new PhoneNumber(incorrectPhoneNumber);
		}
	}

	@Test
	public void phoneNumberStringRepresentationIsFormatted() {
		DecimalFormat format = new DecimalFormat();
		setUpDecimalFormat(format);

		for (String correctPhoneNumber : correctPhoneNumbers) {
			String formattedPhoneNumber = format.format(cleanedCorrectPhoneNumber(correctPhoneNumber));
			assertThat(new PhoneNumber(correctPhoneNumber).toString(), is(formattedPhoneNumber));
		}
	}

	private void setUpDecimalFormat(DecimalFormat format) {
		format.setGroupingSize(3);
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
		formatSymbols.setGroupingSeparator('-');
		format.setDecimalFormatSymbols(formatSymbols);
	}

	private BigInteger cleanedCorrectPhoneNumber(String correctPhoneNumber) {
		return new BigInteger(correctPhoneNumber.replace(" ", ""));
	}
}
