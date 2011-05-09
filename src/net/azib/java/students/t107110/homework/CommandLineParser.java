package net.azib.java.students.t107110.homework;

import java.util.Iterator;

import static java.util.Arrays.asList;

/**
 * @author Eduard Shustrov
 */
public class CommandLineParser {
	private static final String CONSOLE_METHOD = "-console";
	private static final String CSV_METHOD = "-csv";
	private static final String DB_METHOD = "-db";
	private static final String XML_METHOD = "-xml";
	private static final String HTML_METHOD = "-html";

	private final MessageLoader messages;

	private final ResultReader reader;
	private final ResultWriter writer;

	public CommandLineParser(final String... args) {
		messages = new MessageLoader(getClass());

		final Iterator<String> argIterator = asList(args).iterator();
		reader = createReader(argIterator);
		writer = createWriter(argIterator);
		assertNoNext(argIterator, "too_many");
	}

	public ResultReader getReader() {
		return reader;
	}

	public ResultWriter getWriter() {
		return writer;
	}

	private ResultReader createReader(final Iterator<String> argIterator) {
		assertNext(argIterator, "no_input");
		final String inputMethod = argIterator.next();
		if (inputMethod.equalsIgnoreCase(CONSOLE_METHOD))
			return new ConsoleResultReader();
		if (inputMethod.equalsIgnoreCase(CSV_METHOD)) {
			assertNext(argIterator, "no_input_file");
			return new CSVResultReader(argIterator.next());
		}
		if (inputMethod.equalsIgnoreCase(DB_METHOD)) {
			assertNext(argIterator, "no_competition");
			return new DBResultReader(argIterator.next());
		}
		throw exception("unknown_input", inputMethod);
	}

	private ResultWriter createWriter(Iterator<String> argIterator) {
		assertNext(argIterator, "no_output");
		final String outputMethod = argIterator.next();
		if (outputMethod.equalsIgnoreCase(CONSOLE_METHOD))
			return new ConsoleResultWriter();
		if (outputMethod.equalsIgnoreCase(CSV_METHOD)) {
			assertNext(argIterator, "no_output_file");
			return new CSVResultWriter(argIterator.next());
		}
		if (outputMethod.equalsIgnoreCase(XML_METHOD)) {
			assertNext(argIterator, "no_output_file");
			return new XMLResultWriter(argIterator.next());
		}
		if (outputMethod.equalsIgnoreCase(HTML_METHOD)) {
			assertNext(argIterator, "no_output_file");
			return new HTMLResultWriter(argIterator.next());
		}
		throw exception("unknown_output", outputMethod);
	}

	private void assertNext(final Iterator<String> argIterator, final String messageKey) {
		if (!argIterator.hasNext()) throw exception(messageKey);
	}

	private void assertNoNext(final Iterator<String> argIterator, final String messageKey) {
		if (argIterator.hasNext()) throw exception(messageKey);
	}

	private IllegalArgumentException exception(final String message, final String... args) {
		return new IllegalArgumentException(messages.getMessage(message, args));
	}
}
