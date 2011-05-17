package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class HundredMetersEventTest {

    HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(2);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(3844,hundredMetersEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(2.0,hundredMetersEvent.getPerformance());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("HundredMeters", hundredMetersEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("sec", hundredMetersEvent.getEventUnits());

    }
}
