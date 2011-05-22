package net.azib.java.students.t107110.homework;

//import org.apache.log4j.Logger;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Arrays.asList;
import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class CSVResultReader implements ResultReader {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("d.M.y");

	private final BufferedReader reader;

	public CSVResultReader(final InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
	}

	@Override
	public Result read() throws DecathlonException {
		final String line = readLine();
		if (line == null) return null;

		final Iterator<String> iterator = asList(line.split(",")).iterator();
		final ResultBuilder builder = new ResultBuilder();
		try {
			builder.setAthleteName(removeSurroundingQuotes(iterator.next()));
			builder.setBirthDay(parseDate(iterator.next()));
			builder.setCountry(iterator.next());
			builder.setSprint100m(parseNumber(iterator.next()));
			builder.setLongJump(parseNumber(iterator.next()));
			builder.setShotPut(parseNumber(iterator.next()));
			builder.setHighJump(parseNumber(iterator.next()));
			builder.setSprint400m(parseTime(iterator.next()));
			builder.setHurdles110m(parseNumber(iterator.next()));
			builder.setDiscusThrow(parseNumber(iterator.next()));
			builder.setPoleVault(parseNumber(iterator.next()));
			builder.setJavelinThrow(parseNumber(iterator.next()));
			builder.setRace1500m(parseTime(iterator.next()));
		} catch (NoSuchElementException exception) {
			throw decathlonException(exception, Message.INCOMPLETE_RESULT, line);
		} catch (ParseException exception) {
			throw decathlonException(exception, Message.WRONG_DATA_FORMAT, line);
		}
		if (iterator.hasNext()) throw decathlonException(Message.TOO_MUCH_DATA, line);
		return builder.getResult();
	}

	@Override
	public void close() {
		IOUtils.closeQuietly(reader);
	}

	private String readLine() throws DecathlonException {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw decathlonException(e, Message.CANNOT_READ);
		}
	}

	private static String removeSurroundingQuotes(String string) {
		return string.replaceFirst("^\\s*\"(.*?)\"\\s*$", "$1");
	}

	private static Date parseDate(String string) throws ParseException {
		return DATE_FORMAT.parse(string);
	}

	private static double parseNumber(String string) {
		return Double.parseDouble(string);
	}

	private static double parseTime(String string) {
		return parseMinutes(string) * 60.0 + parseSeconds(string);
	}

	private static double parseMinutes(final String string) {
		int index = string.indexOf(':');
		if (index < 0) return 0.0;
		return Double.parseDouble(string.substring(0, index));
	}

	private static double parseSeconds(final String string) {
		int index = string.indexOf(':');
		if (index < 0) return Double.parseDouble(string);
		return Double.parseDouble(string.substring(index + 1));
	}
}
