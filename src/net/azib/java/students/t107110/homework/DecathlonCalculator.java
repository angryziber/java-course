package net.azib.java.students.t107110.homework;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.*;

/**
 * @author Eduard Shustrov
 */
public class DecathlonCalculator {
	private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class);

	private final Map<Result, String> results;

	public DecathlonCalculator(final ResultReader reader) throws DecathlonException {
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

	private static Collection<Result> readResults(final ResultReader reader) throws DecathlonException {
		final Collection<Result> results = new LinkedList<Result>();
		try {
			Result result;
			while ((result = reader.read()) != null) results.add(result);
		} finally {
			reader.close();
		}
		return results;
	}

	private static Map<Result, String> rateResults(final Collection<Result> readResults) throws DecathlonException {
		if (readResults.isEmpty()) return Collections.emptyMap();

		final Map<Result, String> results = new LinkedHashMap<Result, String>(readResults.size());
		final List<Result> resultsToRate = new ArrayList<Result>(readResults);
		Collections.sort(resultsToRate);
		for (int current = 0; current < resultsToRate.size(); ) {
			final int lastWithSamePoints = getLastIndexWithSamePoints(resultsToRate, current);
			final String place = indexToPlace(current, lastWithSamePoints);
			do results.put(resultsToRate.get(current), place); while (current++ != lastWithSamePoints);
		}
		return Collections.unmodifiableMap(results);
	}

	private static int getLastIndexWithSamePoints(final List<Result> sortedResults, final int currentIndex) {
		final int points = sortedResults.get(currentIndex).getPoints();
		final int last = sortedResults.size() - 1;
		for (int tested = currentIndex; tested < last; tested++)
			if (sortedResults.get(tested + 1).getPoints() != points) return tested;
		return last;
	}

	private static String indexToPlace(final int startPlace, final int endPlace) {
		final StringBuilder place = new StringBuilder();
		place.append(startPlace + 1);
		if (startPlace != endPlace) place.append('-').append(endPlace + 1);
		return place.toString();
	}
}
