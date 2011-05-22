package net.azib.java.students.t107110.homework;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Eduard Shustrov
 */
public class Utils {
	public static String getObjectFolder(final Object object) {
		return object.getClass().getResource(".").getPath();
	}

	public static Date date(final int year, final int month, final int day) {
		return new GregorianCalendar(year, month - 1, day).getTime();
	}

	public static InputStream toInputStream(final String text) {
		return new ByteArrayInputStream(text.getBytes(Charset.forName("UTF-8")));
	}

	public static Result getResultMock() {
		final Result result = mock(Result.class);
		when(result.getPoints()).thenReturn(11);
		when(result.getAthleteName()).thenReturn("A");
		when(result.getBirthday()).thenReturn(date(1, 2, 3));
		when(result.getCountry()).thenReturn("CC");
		when(result.getSprint100m()).thenReturn(1.0);
		when(result.getLongJump()).thenReturn(2.01);
		when(result.getShotPut()).thenReturn(3.02);
		when(result.getHighJump()).thenReturn(4.03);
		when(result.getSprint400m()).thenReturn(5.04);
		when(result.getHurdles110m()).thenReturn(6.05);
		when(result.getDiscusThrow()).thenReturn(7.06);
		when(result.getPoleVault()).thenReturn(8.07);
		when(result.getJavelinThrow()).thenReturn(9.08);
		when(result.getRace1500m()).thenReturn(10.09);
		return result;
	}
}
