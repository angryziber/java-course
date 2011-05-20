package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;


public class HundredMetersEventTest {

    HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(2);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(3844,hundredMetersEvent.getPoints());

    }

    @Test
    public void getInCorrectPoints() throws Exception {

        assertNotSame(4844,hundredMetersEvent.getPoints());

    }

    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(2.0,hundredMetersEvent.getPerformance());

    }

    @Test
    public void getIncorrectPerformance() throws Exception {

        assertNotSame(2.1, hundredMetersEvent.getPerformance());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("HundredMeters", hundredMetersEvent.getEventName());
        assertNotSame("hundredMeters",hundredMetersEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("sec", hundredMetersEvent.getEventUnits());
        assertNotSame("seconds", hundredMetersEvent.getEventUnits());

    }
}
