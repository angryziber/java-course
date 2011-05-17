package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JavelinThrowEventTest {
    JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(60.6);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(747,javelinThrowEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(60.6,javelinThrowEvent.getPerformance(),0);

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("JavelinThrow",javelinThrowEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m", javelinThrowEvent.getEventUnits());

    }
}
