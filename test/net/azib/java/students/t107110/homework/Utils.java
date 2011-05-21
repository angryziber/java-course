package net.azib.java.students.t107110.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

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

	public static String generateTempFileName() throws IOException {
		final File tempFile = File.createTempFile("t107110", null);
		tempFile.deleteOnExit();
		return tempFile.getAbsolutePath();
	}

	public static String createTempFileWithText(final String data) throws IOException {
		final String tempFileName = generateTempFileName();
		final BufferedWriter writer =
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFileName), "UTF-8"));
		try {
			writer.write(data);
		} finally {
			IOUtils.closeQuietly(writer);
		}
		return tempFileName;
	}

	public static String readLineFromTempFile(final String tempFileName) throws IOException {
		final BufferedReader reader =
				new BufferedReader(new InputStreamReader(new FileInputStream(tempFileName), "UTF-8"));
		final String line = reader.readLine();
		IOUtils.closeQuietly(reader);
		return line;
	}
}
