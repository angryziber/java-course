package net.azib.java.students.t093759.hometasks.sixth;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 31.03.11 1:20
 *
 * @author dionis
 */
public class BirthdayTest {
	@Test
	public void birthdayDateFormatIsNotLocalDependent() {
		assertThat(Birthday.FORMAT, is("yyyy-MM-dd"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void unableToCreateBirthdayFromBadlyFormattedDate() {
		new Birthday("12-März-2009");
	}

	@Test(expected = IllegalArgumentException.class)
	public void birthdayCanNotBeInFuture() {
		String currentDateFormatString = getCurrentYear() + 1 + "-" + getCurrentMonth() + "-" + getCurrentDayOfMonth();

		new Birthday(currentDateFormatString);
	}

	@Test(expected = IllegalArgumentException.class)
	public void peopleDoNotLiveMoreThan120Years() {
		int oneHundredTwentyOneYearsAgo = getCurrentYear() - 121;
		String dateFormatString = oneHundredTwentyOneYearsAgo + "-" + getCurrentMonth() + "-" + getCurrentDayOfMonth();

		new Birthday(dateFormatString);
	}

	@Test
	public void stringRepresentationOfBirthdayIsLocaleDependent() throws ParseException {
		String currentDateFormatString = getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDayOfMonth();
		String localeDependentFormat = new SimpleDateFormat().format(new SimpleDateFormat(Birthday.FORMAT).parse(currentDateFormatString));

		assertThat(new Birthday(currentDateFormatString).toString(), equalTo(localeDependentFormat));
	}

	@Test
	public void stringRepresentationAndFormattedBirthdayDateAreTheSame() throws ParseException {
		String currentDateFormatString = getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDayOfMonth();

		Birthday birthday = new Birthday(currentDateFormatString);
		assertThat(birthday.toString(), equalTo(birthday.getFormattedBirthdayDate()));
	}

	@Test
	public void birthdaysWithTheSameDateAreEqual() {
		String dateFormat = "1970-12-25";
		assertThat(new Birthday(dateFormat), equalTo(new Birthday(dateFormat)));
	}

	private int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	private int getCurrentDayOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	private int getCurrentMonth() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}
}
