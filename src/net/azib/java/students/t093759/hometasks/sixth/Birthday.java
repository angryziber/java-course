package net.azib.java.students.t093759.hometasks.sixth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 31.03.11 1:19
 *
 * @author dionis
 */
public class Birthday {
	public static final String FORMAT = "yyyy-MM-dd";
	DateFormat dateFormat = new SimpleDateFormat(FORMAT);
	private final String formattedBirthdayDate;


	public Birthday(String dateFormatString) {
		Date parsedBirthdayDate = getParsedDateFrom(dateFormatString);
		if (parsedBirthdayDate.after(new Date())) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": Birthday can't be in future.");
		}
		checkThatBirthdayWasLessThan120YearsAgoFromToday(parsedBirthdayDate);
		formattedBirthdayDate = new SimpleDateFormat().format(parsedBirthdayDate);
	}

	@Override
	public String toString() {
		return formattedBirthdayDate;
	}

	private void checkThatBirthdayWasLessThan120YearsAgoFromToday(Date parsedBirthdayDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parsedBirthdayDate);
		int differenceInYears = Calendar.getInstance().get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		if (differenceInYears > 120) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": People don't live more than 120 years.");
		}
	}

	private Date getParsedDateFrom(String dateFormatString) {
		try {
			return dateFormat.parse(dateFormatString);
		} catch (ParseException e) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": You entered birthday date in incorrect format.");
		}
	}
}
