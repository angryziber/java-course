package net.azib.java.students.t107110.homework;

import java.io.IOException;
import java.util.Iterator;

import static java.util.Arrays.asList;
import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class CommandLineParser {
	private static final String CONSOLE_METHOD = "-console";
	private static final String CSV_METHOD = "-csv";
	private static final String DB_METHOD = "-db";
	private static final String XML_METHOD = "-xml";
	private static final String HTML_METHOD = "-html";

	private final ResultReader reader;
	private final ResultWriter writer;

	public CommandLineParser(final String... args) throws IOException, DecathlonException {
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

	private ResultReader createReader(final Iterator<String> argIterator) throws IOException, DecathlonException {
		assertNext(argIterator, Message.NO_INPUT);
		final String inputMethod = argIterator.next();
		if (inputMethod.equalsIgnoreCase(CONSOLE_METHOD))
			return new ConsoleResultReader();
		if (inputMethod.equalsIgnoreCase(CSV_METHOD)) {
			assertNext(argIterator, Message.NO_INPUT_FILE);
			return new CSVResultReader(argIterator.next());
		}
		if (inputMethod.equalsIgnoreCase(DB_METHOD)) {
			assertNext(argIterator, Message.NO_COMPETITION);
			return new DBResultReader(argIterator.next());
		}
		throw decathlonException(Message.UNKNOWN_INPUT, inputMethod);
	}

	private ResultWriter createWriter(Iterator<String> argIterator) throws IOException, DecathlonException {
		assertNext(argIterator, Message.NO_OUTPUT);
		final String outputMethod = argIterator.next();
		if (outputMethod.equalsIgnoreCase(CONSOLE_METHOD))
			return new ConsoleResultWriter();
		if (outputMethod.equalsIgnoreCase(CSV_METHOD)) {
			assertNext(argIterator, Message.NO_OUTPUT_FILE);
			return new CSVResultWriter(argIterator.next());
		}
		if (outputMethod.equalsIgnoreCase(XML_METHOD)) {
			assertNext(argIterator, Message.NO_OUTPUT_FILE);
			return new XMLResultWriter(argIterator.next());
		}
		if (outputMethod.equalsIgnoreCase(HTML_METHOD)) {
			assertNext(argIterator, Message.NO_OUTPUT_FILE);
			return new HTMLResultWriter(argIterator.next());
		}
		throw decathlonException(Message.UNKNOWN_OUTPUT, outputMethod);
	}

	private void assertNext(final Iterator<String> argIterator, final Message messageID) throws DecathlonException {
		if (!argIterator.hasNext()) throw decathlonException(messageID);
	}

	private void assertNoNext(final Iterator<String> argIterator, final Message messageID) throws DecathlonException {
		if (argIterator.hasNext()) throw decathlonException(messageID);
	}
}
