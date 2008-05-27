package net.azib.java.students.t010588.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if DecathlonSummarizer counts score in a right way
 *
 * @author Vjatseslav Rosin, 010588
 */
public class DecathlonSummarizerTest {

	private DecathlonSummarizer summarizer;

	private static final Result[] RESULTS1 = new Result[] { new RunningEventResult(0, 11.07f), new FieldEventResult(1, 6.42f),
			new FieldEventResult(2, 6f), new FieldEventResult(3, 1.75f), new RunningEventResult(4, 50.47f),
			new RunningEventResult(5, 13.5f), new FieldEventResult(6, 40f), new FieldEventResult(7, 4.0f),
			new FieldEventResult(8, 60f), new RunningEventResult(9, 4 * 60 + 20) };

	private static final Result[] RESULTS2 = new Result[] { new RunningEventResult(0, 10.11f), new FieldEventResult(1, 7.20f),
			new FieldEventResult(2, 6.1f), new FieldEventResult(3, 1.92f), new RunningEventResult(4, 50.01f),
			new RunningEventResult(5, 13.4f), new FieldEventResult(6, 40f), new FieldEventResult(7, 4.0f),
			new FieldEventResult(8, 60f), new RunningEventResult(9, "3:11.02") };

	@Before
	public void initComparator() {
		summarizer = new DecathlonSummarizer();
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.DecathlonSummarizer#summarize(java.util.List)}.
	 */
	@Test
	public void testSummarize() {
		Athlete a1 = new Athlete();
		Athlete a2 = new Athlete();

		a1.setResults(RESULTS1);
		a2.setResults(RESULTS2);

		List<Athlete> athletes = new LinkedList<Athlete>();
		athletes.add(a1);
		athletes.add(a2);

		summarizer.summarize(athletes);

		Athlete summarized1 = athletes.get(0);
		Athlete summarized2 = athletes.get(1);

		assertEquals(1, summarized1.getFirstPlace());
		assertEquals(1, summarized1.getLastPlace());

		assertEquals(2, summarized2.getFirstPlace());
		assertEquals(2, summarized2.getLastPlace());

		assertTrue(summarized1.getScore() > summarized2.getScore());

		a1.setResults(RESULTS1);
		a2.setResults(RESULTS1);

		athletes.clear();
		athletes.add(a1);
		athletes.add(a2);

		summarizer.summarize(athletes);

		summarized1 = athletes.get(0);
		summarized2 = athletes.get(1);

		assertEquals(1, summarized1.getFirstPlace());
		assertEquals(2, summarized1.getLastPlace());

		assertEquals(1, summarized2.getFirstPlace());
		assertEquals(2, summarized2.getLastPlace());

		assertTrue(summarized1.getScore() == summarized2.getScore());
	}
}
