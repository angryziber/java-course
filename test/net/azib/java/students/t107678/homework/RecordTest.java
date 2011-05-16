package net.azib.java.students.t107678.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecordTest {

    @Test
     public void testGetPoints(){
        Participant mockParticipant = mock(Participant.class);
        Event e1 = mock(Event.class);
        Set<Event> events = new HashSet<Event>();
        events.add(e1);

        when(e1.getPoints()).thenReturn(20);

        Record rec = new Record(mockParticipant, events);

        assertEquals(20,rec.getTotalPoints());

    }
}
