package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static net.azib.java.students.t107110.homework.Utils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shsutrov
 */
public class CSVResultWriterTest {
	private ResultBuilder builder = new ResultBuilder();
	private String tempFileName;
	private ResultWriter writer;

	@Before
	public void prepareFile() throws IOException {
		tempFileName = generateTempFileName();
		writer = new CSVResultWriter(tempFileName);
	}

	@Before
	public void prepareResut() throws IOException {
		builder.setAthleteName("X").setBirthDay(date(1, 2, 3)).setCountry("XX");
		builder.setSprint100m(1.0).setLongJump(2.01).setShotPut(3.02).setHighJump(4.03).setSprint400m(5.04);
		builder.setHurdles110m(6.05).setDiscusThrow(7.06).setPoleVault(8.07).setJavelinThrow(9.08).setRace1500m(10.09);
	}

	@Test
	public void checkSmallResult() throws DecathlonException, IOException {
		writer.write("", builder.getResult());
		writer.close();
		final String result = readLineFromTempFile(tempFileName).replaceFirst("(.*?,){2}", "");
		assertThat(result, is("\"X\",03.02.0001,XX,1.00,2.01,3.02,4.03,5.04,6.05,7.06,8.07,9.08,10.09"));
	}

	@Test
	public void checkLongRace1500m() throws DecathlonException, IOException {
		builder.setRace1500m(70.09);
		writer.write("", builder.getResult());
		writer.close();
		final String result = readLineFromTempFile(tempFileName).replaceFirst("(.*?,){2}", "");
		assertThat(result, is("\"X\",03.02.0001,XX,1.00,2.01,3.02,4.03,5.04,6.05,7.06,8.07,9.08,1:10.09"));
	}

	@Test
	public void checkLongSprint400m() throws DecathlonException, IOException {
		builder.setSprint400m(65.04);
		writer.write("", builder.getResult());
		writer.close();
		final String result = readLineFromTempFile(tempFileName).replaceFirst("(.*?,){2}", "");
		assertThat(result, is("\"X\",03.02.0001,XX,1.00,2.01,3.02,4.03,1:05.04,6.05,7.06,8.07,9.08,10.09"));
	}
}
