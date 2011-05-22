package net.azib.java.students.t107110.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;

import static java.util.Arrays.asList;
import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class CommandLineParser {
	private static final String XSLT_TEMPLATE = "rated-results.xslt";

	private static enum Method {CONSOLE, CSV, DB, XML, HTML}

	private final ResultReader reader;
	private final ResultWriter writer;

	public CommandLineParser(final String... args) throws DecathlonException {
		final Iterator<String> argIterator = asList(args).iterator();
		reader = createReader(argIterator);
		writer = createWriter(argIterator);
		assertNoNext(argIterator, Message.TOO_MANY_ARGS);
	}

	public ResultReader getReader() {
		return reader;
	}

	public ResultWriter getWriter() {
		return writer;
	}

	private ResultReader createReader(final Iterator<String> argIterator) throws DecathlonException {
		try {
			switch (getInputMethod(argIterator)) {
				case CONSOLE:
					return new ConsoleResultReader();
				case CSV:
					assertNext(argIterator, Message.NO_INPUT_FILE);
					return new CSVResultReader(new FileInputStream(argIterator.next()));
				case DB:
					assertNext(argIterator, Message.NO_EVENT);
					return new DBResultReader(argIterator.next());
				default:
					throw decathlonException(Message.INPUT_NOT_SUPPORTED);
			}
		} catch (FileNotFoundException e) {
			throw decathlonException(e, Message.INPUT_FILE_NOT_FOUND);
		}
	}

	private ResultWriter createWriter(Iterator<String> argIterator) throws DecathlonException {
		try {
			switch (getOutputMethod(argIterator)) {
				case CONSOLE:
					return new ConsoleResultWriter();
				case CSV:
					assertNext(argIterator, Message.NO_OUTPUT_FILE);
					return new CSVResultWriter(new FileOutputStream(argIterator.next()));
				case XML:
					assertNext(argIterator, Message.NO_OUTPUT_FILE);
					return new XMLResultWriter(new FileOutputStream(argIterator.next()));
				case HTML:
					assertNext(argIterator, Message.NO_OUTPUT_FILE);
					final InputStream template = getClass().getResourceAsStream(XSLT_TEMPLATE);
					return new XMLResultWriter(new FileOutputStream(argIterator.next()), template);
				default:
					throw decathlonException(Message.OUTPUT_NOT_SUPPORTED);
			}
		} catch (FileNotFoundException e) {
			throw decathlonException(e, Message.CANNOT_WRITE);
		}
	}

	private static Method getInputMethod(final Iterator<String> argIterator) throws DecathlonException {
		return getMethod(argIterator, Message.NO_INPUT, Message.UNKNOWN_INPUT);
	}

	private static Method getOutputMethod(final Iterator<String> argIterator) throws DecathlonException {
		return getMethod(argIterator, Message.NO_OUTPUT, Message.UNKNOWN_OUTPUT);
	}

	private static Method getMethod(final Iterator<String> argIterator,
	                                final Message noMethodMessage, final Message unknownMethodMessage)
			throws DecathlonException {
		assertNext(argIterator, noMethodMessage);
		final String arg = argIterator.next();
		if (!arg.startsWith("-")) throw decathlonException(noMethodMessage);

		try {
			return Method.valueOf(arg.replaceFirst("^-", "").toUpperCase());
		} catch (IllegalArgumentException e) {
			throw decathlonException(unknownMethodMessage, arg);
		}
	}

	private static void assertNext(final Iterator<String> argIterator, final Message messageID)
			throws DecathlonException {
		if (!argIterator.hasNext()) throw decathlonException(messageID);
	}

	private static void assertNoNext(final Iterator<String> argIterator, final Message messageID)
			throws DecathlonException {
		if (argIterator.hasNext()) throw decathlonException(messageID);
	}
}
