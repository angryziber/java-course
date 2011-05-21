package net.azib.java.students.t107110.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static net.azib.java.students.t107110.homework.Utils.createTempFileWithText;
import static net.azib.java.students.t107110.homework.Utils.date;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class CSVResultReaderTest {
	private ResultReader reader;

	@Before
	public void prepareCVSFile() throws IOException {
		reader = new CSVResultReader(getClass().getResource("test.csv").getPath());
	}

	@After
	public void closeCVSFile() throws IOException {
		reader.close();
	}

	@Test(expected = DecathlonException.class)
	public void failOnIncompleteResult() throws IOException, DecathlonException {
		final String resultLine = "X,1.1.1,XX,1,1,1,1,1,1,1,1,1";
		reader = new CSVResultReader(createTempFileWithText(resultLine));
		reader.read();
	}

	@Test(expected = DecathlonException.class)
	public void failOnTooMuchData() throws IOException, DecathlonException {
		final String resultLine = "X,1.1.1,XX,1,1,1,1,1,1,1,1,1,1,1";
		reader = new CSVResultReader(createTempFileWithText(resultLine));
		reader.read();
	}

	@Test(expected = DecathlonException.class)
	public void failOnWrongBirthdayFormat() throws IOException, DecathlonException {
		final String resultLine = "X,1-1-1,XX,1,1,1,1,1,1,1,1,1,1,1,1";
		reader = new CSVResultReader(createTempFileWithText(resultLine));
		reader.read();
	}

	@Test
	public void checkAthleteNames() throws IOException, DecathlonException {
		assertThat(reader.read().getAthleteName(), is("Siim Susi"));
		assertThat(reader.read().getAthleteName(), is("Beata Kana"));
		assertThat(reader.read().getAthleteName(), is("José Mañana Perez"));
		assertThat(reader.read().getAthleteName(), is("Василий Пупкин"));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}

	@Test
	public void checkBirthdays() throws IOException, DecathlonException {
		assertThat(reader.read().getBirthday(), is(date(1976, 1, 1)));
		assertThat(reader.read().getBirthday(), is(date(1982, 2, 29)));
		assertThat(reader.read().getBirthday(), is(date(1972, 4, 3)));
		assertThat(reader.read().getBirthday(), is(date(1980, 10, 21)));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}

	@Test
	public void checkCountries() throws IOException, DecathlonException {
		assertThat(reader.read().getCountry(), is("EE"));
		assertThat(reader.read().getCountry(), is("ZA"));
		assertThat(reader.read().getCountry(), is("ES"));
		assertThat(reader.read().getCountry(), is("UA"));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}

	@Test
	public void checkSpring100m() throws IOException, DecathlonException {
		assertThat(reader.read().getSprint100m(), is(12.61));
		assertThat(reader.read().getSprint100m(), is(13.04));
		assertThat(reader.read().getSprint100m(), is(13.75));
		assertThat(reader.read().getSprint100m(), is(13.43));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}

	@Test
	public void checkSpring400m() throws IOException, DecathlonException {
		assertThat(reader.read().getSprint400m(), is(59.39));
		assertThat(reader.read().getSprint400m(), is(64.72));
		assertThat(reader.read().getSprint400m(), is(68.44));
		assertThat(reader.read().getSprint400m(), is(66.06));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}

	@Test
	public void checkRace1500m() throws IOException, DecathlonException {
		assertThat(reader.read().getRace1500m(), is(325.72));
		assertThat(reader.read().getRace1500m(), is(410.76));
		assertThat(reader.read().getRace1500m(), is(382.75));
		assertThat(reader.read().getRace1500m(), is(411.01));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}

	@Test
	public void checkPoints() throws IOException, DecathlonException {
		assertThat(reader.read().getPoints(), is(4234));
		assertThat(reader.read().getPoints(), is(3199));
		assertThat(reader.read().getPoints(), is(3494));
		assertThat(reader.read().getPoints(), is(3099));
		assertThat(reader.read(), is(nullValue(Result.class)));
	}
}
