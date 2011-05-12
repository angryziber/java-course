package net.azib.java.students.t107110.homework;

import java.util.Iterator;

import static java.util.Arrays.asList;

/**
 * @author Eduard Shustrov
 */
public class CommandLineParser {
	private static final MessageLoader MESSAGES = new MessageLoader(CommandLineParser.class);

	private static final String CONSOLE_METHOD = "-console";
	private static final String CSV_METHOD = "-csv";
	private static final String DB_METHOD = "-db";
	private static final String XML_METHOD = "-xml";
	private static final String HTML_METHOD = "-html";

	private static final String NO_INPUT_ID = "no_input";
	private static final String NO_INPUT_FILE_ID = "no_input_file";
	private static final String NO_COMPETITION_ID = "no_competition";
	private static final String UNKNOWN_INPUT_ID = "unknown_input";
	private static final String NO_OUTPUT_ID = "no_output";
	private static final String NO_OUTPUT_FILE_ID = "no_output_file";
	private static final String UNKNOWN_OUTPUT_ID = "unknown_output";
	private static final String TOO_MANY_ID = "too_many";

	private final ResultReader reader;
	private final ResultWriter writer;

	public CommandLineParser(final String... args) {
		final Iterator<String> argIterator = asList(args).iterator();
		reader = createReader(argIterator);
		writer = createWriter(argIterator);
		assertNoNext(argIterator, TOO_MANY_ID);
	}

	public ResultReader getReader() {
		return reader;
	}

	public ResultWriter getWriter() {
		return writer;
	}

	private ResultReader createReader(final Iterator<String> argIterator) {
		assertNext(argIterator, NO_INPUT_ID);
		final String inputMethod = argIterator.next();
		if (inputMethod.equalsIgnoreCase(CONSOLE_METHOD))
			return new ConsoleResultReader();
		if (inputMethod.equalsIgnoreCase(CSV_METHOD)) {
			assertNext(argIterator, NO_INPUT_FILE_ID);
			return new CSVResultReader(argIterator.next());
		}
		if (inputMethod.equalsIgnoreCase(DB_METHOD)) {
			assertNext(argIterator, NO_COMPETITION_ID);
			return new DBResultReader(argIterator.next());
		}
		throw MESSAGES.argumentException(UNKNOWN_INPUT_ID, inputMethod);
	}

	private ResultWriter createWriter(Iterator<String> argIterator) {
		assertNext(argIterator, NO_OUTPUT_ID);
		final String outputMethod = argIterator.next();
		if (outputMethod.equalsIgnoreCase(CONSOLE_METHOD))
			return new ConsoleResultWriter();
		if (outputMethod.equalsIgnoreCase(CSV_METHOD)) {
			assertNext(argIterator, NO_OUTPUT_FILE_ID);
			return new CSVResultWriter(argIterator.next());
		}
		if (outputMethod.equalsIgnoreCase(XML_METHOD)) {
			assertNext(argIterator, NO_OUTPUT_FILE_ID);
			return new XMLResultWriter(argIterator.next());
		}
		if (outputMethod.equalsIgnoreCase(HTML_METHOD)) {
			assertNext(argIterator, NO_OUTPUT_FILE_ID);
			return new HTMLResultWriter(argIterator.next());
		}
		throw MESSAGES.argumentException(UNKNOWN_OUTPUT_ID, outputMethod);
	}

	private void assertNext(final Iterator<String> argIterator, final String messageKey) {
		if (!argIterator.hasNext()) throw MESSAGES.argumentException(messageKey);
	}

	private void assertNoNext(final Iterator<String> argIterator, final String messageKey) {
		if (argIterator.hasNext()) throw MESSAGES.argumentException(messageKey);
	}
}
