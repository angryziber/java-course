package net.azib.java.students.t030633;

import net.azib.java.lessons.io.FileCopier;

import static org.easymock.EasyMock.createMock;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * CopyPerformanceTimerTest
 *
 * @author t030633
 */
public class CopyPerformanceTimerTest {

	@Test
	public void timeIsLong() throws IOException {
		FileCopier mockCopier = createMock(FileCopier.class);
		long measuredTime = new CopyPerformanceTimer().measureCopyTime(mockCopier);
		assertTrue((Long) measuredTime instanceof Long);
	}

}
