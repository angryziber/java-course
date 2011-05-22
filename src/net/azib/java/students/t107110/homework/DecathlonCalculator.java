package net.azib.java.students.t107110.homework;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Eduard Shustrov
 */
public class DecathlonCalculator {
	private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class);

	private final Map<Result, String> results;

	public DecathlonCalculator(final ResultReader reader) throws DecathlonException, IOException {
		results = rateResults(readResults(reader));
	}

	public void save(final ResultWriter writer) throws DecathlonException {
		try {
			for (final Map.Entry<Result, String> result : results.entrySet())
				writer.write(result.getValue(), result.getKey());
		} finally {
			writer.close();
		}
	}

	public static void main(final String[] args) {
		DOMConfigurator.configure(DecathlonCalculator.class.getResource("log4j.xml").getPath());
		try {
			final CommandLineParser parser = new CommandLineParser(args);
			final DecathlonCalculator calculator = new DecathlonCalculator(parser.getReader());
			calculator.save(parser.getWriter());
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
		}
	}

	private static Map<Result, String> readResults(final ResultReader reader) throws DecathlonException, IOException {
		Result result;
		final Map<Result, String> results = new TreeMap<Result, String>();
		try {
			while ((result = reader.read()) != null) results.put(result, null);
		} finally {
			reader.close();
		}
		return results;
	}

	private static Map<Result, String> rateResults(final Map<Result, String> results)
			throws DecathlonException, IOException {
		int place = 1;
		for (final Result result : results.keySet()) {
			results.put(result, Integer.toString(place++));
		}
		return Collections.unmodifiableMap(results);
	}
}
