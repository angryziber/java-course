package net.azib.java.students.t100228.Homework;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit test for the {@link DbResultsFetcher} class
 * @author Martin
 */
public class DbResultsFetcherTest {
	/**
	 * Test for the method {@link DbResultsFetcher#fetchResults(ArrayList, String)}
	 */
	@Test
	public void fetchResults() throws Exception {
		DbResultsFetcher fetcher = new DbResultsFetcher();

		ArrayList<Record> listRecords = new ArrayList<Record>();

		fetcher.fetchResults(listRecords, "1");
		assertEquals(false, listRecords.isEmpty());
	}
}
