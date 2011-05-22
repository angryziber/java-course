package net.azib.java.students.t107110.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static net.azib.java.students.t107110.homework.Utils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Eduard Shustrov
 */
public class CSVResultReaderTest {
	private ResultReader reader;

	@Before
	public void prepareCVSFile() throws DecathlonException, FileNotFoundException {
		reader = new CSVResultReader(new FileInputStream(getObjectFolder(this) + "/test.csv"));
	}

	@After
	public void closeCVSFile() {
		reader.close();
	}

	@Test(expected = DecathlonException.class)
	public void failOnIncompleteResult() throws DecathlonException {
		readOneResult("X,1.1.1,XX,1,1,1,1,1,1,1,1,1");
	}

	@Test(expected = DecathlonException.class)
	public void failOnTooMuchData() throws DecathlonException {
		readOneResult("X,1.1.1,XX,1,1,1,1,1,1,1,1,1,1,1");
	}

	@Test(expected = DecathlonException.class)
	public void failOnWrongBirthdayFormat() throws DecathlonException {
		readOneResult("X,1-1-1,XX,1,1,1,1,1,1,1,1,1,1,1,1");
	}

	@Test
	public void athleteNames() throws DecathlonException {
		assertThat(reader.read().getAthleteName(), is("Siim Susi"));
		assertThat(reader.read().getAthleteName(), is("Beata Kana"));
		assertThat(reader.read().getAthleteName(), is("José Mañana Perez"));
		assertThat(reader.read().getAthleteName(), is("Василий Пупкин"));
		noMoreData();
	}

	@Test
	public void birthdays() throws DecathlonException {
		assertThat(reader.read().getBirthday(), is(date(1976, 1, 1)));
		assertThat(reader.read().getBirthday(), is(date(1982, 2, 29)));
		assertThat(reader.read().getBirthday(), is(date(1972, 4, 3)));
		assertThat(reader.read().getBirthday(), is(date(1980, 10, 21)));
		noMoreData();
	}

	@Test
	public void countries() throws DecathlonException {
		assertThat(reader.read().getCountry(), is("EE"));
		assertThat(reader.read().getCountry(), is("ZA"));
		assertThat(reader.read().getCountry(), is("ES"));
		assertThat(reader.read().getCountry(), is("UA"));
		noMoreData();
	}

	@Test
	public void spring100m() throws DecathlonException {
		assertThat(reader.read().getSprint100m(), is(12.61));
		assertThat(reader.read().getSprint100m(), is(13.04));
		assertThat(reader.read().getSprint100m(), is(13.75));
		assertThat(reader.read().getSprint100m(), is(13.43));
		noMoreData();
	}

	@Test
	public void longJump() throws DecathlonException {
		assertThat(reader.read().getLongJump(), is(5.00));
		assertThat(reader.read().getLongJump(), is(4.53));
		assertThat(reader.read().getLongJump(), is(4.84));
		assertThat(reader.read().getLongJump(), is(4.35));
		noMoreData();
	}

	@Test
	public void shotPut() throws DecathlonException {
		assertThat(reader.read().getShotPut(), is(9.22));
		assertThat(reader.read().getShotPut(), is(7.79));
		assertThat(reader.read().getShotPut(), is(10.12));
		assertThat(reader.read().getShotPut(), is(8.64));
		noMoreData();
	}

	@Test
	public void highJump() throws DecathlonException {
		assertThat(reader.read().getHighJump(), is(1.50));
		assertThat(reader.read().getHighJump(), is(1.55));
		assertThat(reader.read().getHighJump(), is(1.50));
		assertThat(reader.read().getHighJump(), is(1.50));
		noMoreData();
	}

	@Test
	public void spring400m() throws DecathlonException {
		assertThat(reader.read().getSprint400m(), is(59.39));
		assertThat(reader.read().getSprint400m(), is(64.72));
		assertThat(reader.read().getSprint400m(), is(68.44));
		assertThat(reader.read().getSprint400m(), is(66.06));
		noMoreData();
	}

	@Test
	public void hurdles110m() throws DecathlonException {
		assertThat(reader.read().getHurdles110m(), is(16.43));
		assertThat(reader.read().getHurdles110m(), is(18.74));
		assertThat(reader.read().getHurdles110m(), is(19.18));
		assertThat(reader.read().getHurdles110m(), is(19.05));
		noMoreData();
	}

	@Test
	public void discusThrow() throws DecathlonException {
		assertThat(reader.read().getDiscusThrow(), is(21.60));
		assertThat(reader.read().getDiscusThrow(), is(24.20));
		assertThat(reader.read().getDiscusThrow(), is(30.85));
		assertThat(reader.read().getDiscusThrow(), is(24.89));
		noMoreData();
	}

	@Test
	public void poleVault() throws DecathlonException {
		assertThat(reader.read().getPoleVault(), is(2.60));
		assertThat(reader.read().getPoleVault(), is(2.40));
		assertThat(reader.read().getPoleVault(), is(2.80));
		assertThat(reader.read().getPoleVault(), is(2.20));
		noMoreData();
	}

	@Test
	public void javelinThrow() throws DecathlonException {
		assertThat(reader.read().getJavelinThrow(), is(35.81));
		assertThat(reader.read().getJavelinThrow(), is(28.20));
		assertThat(reader.read().getJavelinThrow(), is(33.88));
		assertThat(reader.read().getJavelinThrow(), is(33.48));
		noMoreData();
	}

	@Test
	public void race1500m() throws DecathlonException {
		assertThat(reader.read().getRace1500m(), is(325.72));
		assertThat(reader.read().getRace1500m(), is(410.76));
		assertThat(reader.read().getRace1500m(), is(382.75));
		assertThat(reader.read().getRace1500m(), is(411.01));
		noMoreData();
	}

	@Test(expected = DecathlonException.class)
	public void failOnReadError() throws IOException, DecathlonException {
		final InputStream stream = mock(InputStream.class);
		new CSVResultReader(stream).read();
	}

	private void readOneResult(String resultLine) throws DecathlonException {
		new CSVResultReader(toInputStream(resultLine)).read();
	}

	private void noMoreData() throws DecathlonException {
		assertThat(reader.read(), is(nullValue(Result.class)));
	}
}
