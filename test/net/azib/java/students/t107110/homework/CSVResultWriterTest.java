package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import static net.azib.java.students.t107110.homework.Utils.getResultMock;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @author Eduard Shustrov
 */
public class CSVResultWriterTest {
	private Result result;

	@Before
	public void prepare() {
		result = getResultMock();
	}

	@Test
	public void place() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 1), is("1"));
	}

	@Test
	public void points() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 2), is("11"));
	}

	@Test
	public void athlete() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 3), is("\"A\""));
	}

	@Test
	public void birthday() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 4), is("03.02.0001"));
	}

	@Test
	public void country() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 5), is("CC"));
	}

	@Test
	public void sprint100m() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 6), is("1.00"));

		when(result.getSprint100m()).thenReturn(61.0);
		assertThat(getResultFromOutput(writeResult(), 6), is("61.00"));
	}

	@Test
	public void longJump() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 7), is("2.01"));
	}

	@Test
	public void shotPut() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 8), is("3.02"));
	}

	@Test
	public void highJump() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 9), is("4.03"));
	}

	@Test
	public void sprint400m() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 10), is("5.04"));

		when(result.getSprint400m()).thenReturn(65.04);
		assertThat(getResultFromOutput(writeResult(), 10), is("1:05.04"));
	}

	@Test
	public void hurdles110m() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 11), is("6.05"));

		when(result.getHurdles110m()).thenReturn(66.05);
		assertThat(getResultFromOutput(writeResult(), 11), is("66.05"));
	}

	@Test
	public void discusThrow() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 12), is("7.06"));
	}

	@Test
	public void poleVault() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 13), is("8.07"));
	}

	@Test
	public void javelinThrow() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 14), is("9.08"));
	}

	@Test
	public void race1500m() throws DecathlonException, UnsupportedEncodingException {
		assertThat(getResultFromOutput(writeResult(), 15), is("10.09"));

		when(result.getRace1500m()).thenReturn(70.09);
		assertThat(getResultFromOutput(writeResult(), 15), is("1:10.09"));
	}

	@Test(expected = DecathlonException.class)
	public void failOnWriteError() throws DecathlonException, IOException {
		final OutputStream stream = mock(OutputStream.class);
		doThrow(new IOException()).when(stream).write(anyInt());
		doThrow(new IOException()).when(stream).write((byte[]) any());
		doThrow(new IOException()).when(stream).write((byte[]) any(), anyInt(), anyInt());
		final ResultWriter writer = new CSVResultWriter(stream);
		for (int i = 0; i < Integer.MAX_VALUE; i++)
			writer.write("", result);
	}

	@Test(expected = DecathlonException.class)
	public void failOnCloseError() throws DecathlonException, IOException {
		final OutputStream stream = mock(OutputStream.class);
		doThrow(new IOException()).when(stream).close();
		new CSVResultWriter(stream).close();
	}

	public String writeResult() throws DecathlonException, UnsupportedEncodingException {
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		final ResultWriter writer = new CSVResultWriter(stream);

		writer.write("1", result);
		writer.close();
		return stream.toString("UTF-8");
	}

	private static String getResultFromOutput(final String output, final int position) {
		return output.replace("\n", "").split(",")[position - 1];
	}
}
