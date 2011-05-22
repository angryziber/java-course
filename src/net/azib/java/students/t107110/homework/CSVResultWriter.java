package net.azib.java.students.t107110.homework;

import org.apache.commons.io.IOUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.*;
import java.util.Date;
import java.util.Locale;

import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class CSVResultWriter implements ResultWriter {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private static final NumberFormat NUMBER_FORMAT =
			new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.ROOT));
	private static final NumberFormat SECONDS_FORMAT =
			new DecimalFormat("00.00", DecimalFormatSymbols.getInstance(Locale.ROOT));

	private final BufferedWriter writer;

	public CSVResultWriter(final OutputStream stream) {
		writer = new BufferedWriter(new OutputStreamWriter(stream, Charset.forName("UTF-8")));
	}

	@Override
	public void write(final String place, final Result result) throws DecathlonException {
		try {
			writer.write(place + ",");
			writer.write(result.getPoints() + ",");
			writer.write(formatName(result.getAthleteName()) + ",");
			writer.write(formatDate(result.getBirthday()) + ",");
			writer.write(result.getCountry() + ",");
			writer.write(formatNumber(result.getSprint100m()) + ",");
			writer.write(formatNumber(result.getLongJump()) + ",");
			writer.write(formatNumber(result.getShotPut()) + ",");
			writer.write(formatNumber(result.getHighJump()) + ",");
			writer.write(formatTime(result.getSprint400m()) + ",");
			writer.write(formatNumber(result.getHurdles110m()) + ",");
			writer.write(formatNumber(result.getDiscusThrow()) + ",");
			writer.write(formatNumber(result.getPoleVault()) + ",");
			writer.write(formatNumber(result.getJavelinThrow()) + ",");
			writer.write(formatTime(result.getRace1500m()));
			writer.newLine();
		} catch (IOException e) {
			IOUtils.closeQuietly(writer);
			throw decathlonException(e, Message.CANNOT_WRITE);
		}
	}

	@Override
	public void close() throws DecathlonException {
		try {
			writer.close();
		} catch (IOException e) {
			throw decathlonException(e, Message.CANNOT_WRITE);
		}
	}

	private static String formatName(final String name) {
		return "\"" + name + "\"";
	}

	private static String formatDate(final Date date) {
		return DATE_FORMAT.format(date);
	}

	private static String formatNumber(final double number) {
		return NUMBER_FORMAT.format(number);
	}

	private static String formatTime(final double time) {
		final int minutes = (int) Math.floor(time) / 60;
		final double seconds = time - minutes * 60;
		if (minutes == 0) return NUMBER_FORMAT.format(time);
		return Integer.toString(minutes) + ":" + SECONDS_FORMAT.format(seconds);
	}
}
