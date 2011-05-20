package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ThousandFiveHundredMetersEventTest {

    ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(30.1);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(3050,thousandFiveHundredMetersEvent.getPoints());

    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(3050.01, thousandFiveHundredMetersEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(30.1, thousandFiveHundredMetersEvent.getPerformance(),0);
        assertNotSame(30.2, thousandFiveHundredMetersEvent.getPerformance());

    }

    @Test
    public void getCorrectEventName() throws Exception {

        assertEquals("ThousandFiveHundredMeters", thousandFiveHundredMetersEvent.getEventName());

    }

    @Test
    public void getIncorrectEventName() throws Exception {

        assertNotSame("ThousandSixHundredMeters", thousandFiveHundredMetersEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("sec",thousandFiveHundredMetersEvent.getEventUnits());
        assertNotSame("seconds", thousandFiveHundredMetersEvent.getEventUnits());

    }
}
