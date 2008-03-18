package net.azib.java.students.t030633;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import static org.easymock.EasyMock.*;
import net.azib.java.lessons.io.FileCopier;

import org.junit.Test;

/**
 * CopyPerformanceTimerTest
 *
 * @author t030633
 */
public class CopyPerformanceTimerTest {

	private final File src = new File(CopyPerformanceTimer.SOURCE_ADDRESS);
	private final File dest = new File(CopyPerformanceTimer.DESTINATION_ADDRESS);

	@Test
	public void timeIsLong() throws IOException {
		FileCopier mockCopier = createMock(FileCopier.class);
		long measuredTime = new CopyPerformanceTimer(src, dest).measureCopyTime(mockCopier);
		assertTrue((Long) measuredTime instanceof Long);
	}

}
