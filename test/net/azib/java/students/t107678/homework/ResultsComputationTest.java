package net.azib.java.students.t107678.homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultsComputationTest {

		ResultsComputation resultsComputation = new ResultsComputation();

	@Test
	public void testComputeRecordsResults() throws Exception {

		Participant mockParticipantOne = mock(Participant.class);
		Event e1 = mock(Event.class);
		Collection<Event> events = new ArrayList<Event>();
		events.add(e1);
		when(e1.getPoints()).thenReturn(20);
        Record recOne = new Record(mockParticipantOne, events);

		Participant mockParticipantTwo = mock(Participant.class);
		Event e2 = mock(Event.class);
		events.add(e2);
		when(e2.getPoints()).thenReturn(40);
        Record recTwo = new Record(mockParticipantOne, events);

		ArrayList records = new ArrayList<Record>();
		records.add(recOne);
		records.add(recTwo);

		// TODO check state before


		resultsComputation.computeRecordsResults();

		// TODO check state in order after



	}

	@Test
	public void testGetRecords() throws Exception {

	}
}
