package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class FourHundredMetersEventTest {

    FourHundredMetersEvent fourHundredMetersEvent = new FourHundredMetersEvent(11.0);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(3448,fourHundredMetersEvent.getPoints());

    }

    @Test
    public void getInCorrectPoints() throws Exception {

        assertNotSame(3449, fourHundredMetersEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(11.0, fourHundredMetersEvent.getPerformance(),0);
        assertNotSame(12.0,fourHundredMetersEvent.getPerformance());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("FourHundredMeters", fourHundredMetersEvent.getEventName());
        assertNotSame("FiveHundredMeters", fourHundredMetersEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("sec",fourHundredMetersEvent.getEventUnits());
        assertNotSame("seconds", fourHundredMetersEvent.getEventUnits());

    }
}
