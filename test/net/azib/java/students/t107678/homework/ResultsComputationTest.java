package net.azib.java.students.t107678.homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultsComputationTest {

	ResultsComputation resultsComputation = new ResultsComputation();

	@Test
	public void testComputeRecordsResultsAndGetRecords() throws Exception {

		Participant mockParticipantOne = mock(Participant.class);
		when(mockParticipantOne.getName()).thenReturn("First Participant");
		Event e1 = mock(Event.class);
		Collection<Event> events = new ArrayList<Event>();
		events.add(e1);
		Record recOne = new Record(mockParticipantOne, events);
		when(recOne.getTotalPoints()).thenReturn(100);

		Participant mockParticipantTwo = mock(Participant.class);
		when(mockParticipantTwo.getName()).thenReturn("Second Participant");
		Event e2 = mock(Event.class);
		events.add(e2);
		Record recTwo = new Record(mockParticipantTwo, events);
		when(recTwo.getTotalPoints()).thenReturn(50);

		ArrayList records = new ArrayList<Record>();
		records.add(recOne);
		records.add(recTwo);

		resultsComputation.records = records;
		resultsComputation.computeRecordsResults();


		assertTrue(resultsComputation.getRecords().get(0).getEvents().contains(e1));
		assertTrue(resultsComputation.getRecords().get(0).getEvents().contains(e2));

		assertEquals("First Participant",resultsComputation.getRecords().get(0).getParticipant().getName());
		assertEquals("Second Participant",resultsComputation.getRecords().get(1).getParticipant().getName());

	}


}
