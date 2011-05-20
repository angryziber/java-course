package net.azib.java.students.t110013.homework.model;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static net.azib.java.students.t110013.homework.model.AthleteUtils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class AthleteUtilsTest {
	private static final SimpleDateFormat CSV_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private static final SimpleDateFormat US_DATE_FORMAT = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);

	@Test(expected = IllegalArgumentException.class)
	public void numbersAreNotAllowedInNames() {
		validateName("Thomas 3");
	}

	@Test(expected = IllegalArgumentException.class)
	public void specialCharsAreNotAllowedInNames() {
		validateName("Jack@Jones");
	}

	@Test
	public void dotsParenthesisAndDashesAreAllowedInNames() {
		validateNames("Anna-Maria Elizabeth", "Henry V. Putnam", "Jack Jones (III)");
	}

	@Test
	public void validateUnicodeNames() {
		assertThat(validateName("宗弘金子 (Munehiro Kaneko)"), returns("宗弘金子 (Munehiro Kaneko)"));
		assertThat(validateName("José Mañana Perez"), returns("José Mañana Perez"));
		assertThat(validateName("Василий Пупкин"), returns("Василий Пупкин"));
		assertThat(validateName("Mumbalele-Nsowu Mensah-Bonsu Pops"), returns("Mumbalele-Nsowu Mensah-Bonsu Pops"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void csvDateFormatWillNotParseUSDate() throws ParseException {
		validateAndParseDate("Nov 01, 2002", CSV_DATE_FORMAT);
	}

	@Test(expected = IllegalArgumentException.class)
	public void usDateFormatWillNotParseCSVDate() throws ParseException {
		validateAndParseDate("30.06.2000", US_DATE_FORMAT);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidDatesAreNotAllowed() throws ParseException {
		validateAndParseDate("27082000", CSV_DATE_FORMAT);
	}

	@Test
	public void validateCSVDate() throws ParseException {
		Date expectedCSVDate = CSV_DATE_FORMAT.parse("01.11.2002");

		assertThat(validateAndParseDate("01.11.2002", CSV_DATE_FORMAT), is(expectedCSVDate));
	}

	@Test
	public void validateUSDate() throws ParseException {
		Date expectedUSDate = US_DATE_FORMAT.parse("Jun 30, 2000");

		assertThat(validateAndParseDate("Jun 30, 2000", US_DATE_FORMAT), is(expectedUSDate));
	}

	@Test
	public void countryCodeShouldConsistOfTwoLetters() {
		assertThat(validateCountry("EE"), returns("EE"));
		assertThat(validateCountry("US"), returns("US"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void differentCountryFormatsAreNotAllowed() {
		validateCountry("Estonia");
	}

	@Test(expected = IllegalArgumentException.class)
	public void onlyValidPerformanceResultCanBeParsedAsDouble() {
		validateAndParsePerformanceResult("William");
	}

	@Test(expected = IllegalArgumentException.class)
	public void hourMinSecMillisFormatCannotBeParsedAsDouble() {
		validateAndParsePerformanceResult("5:5:5.400");
	}

	@Test
	public void parseSecMillisFormatAsDouble() {
		assertThat(validateAndParsePerformanceResult("5"), is(5.0));
		assertThat(validateAndParsePerformanceResult("30.200"), is(30.200));
	}

	@Test
	public void parseMinSecMillisFormatAsDouble() {
		assertThat(validateAndParsePerformanceResult("1:25.02"), is(85.02));
		assertThat(validateAndParsePerformanceResult("6.5.300"), is(365.300));
	}

	private Matcher<String> returns(String expected) {
		return is(expected);
	}

	private void validateNames(String... names) {
		for(String name : names) {
			validateName(name);
		}
	}
}
