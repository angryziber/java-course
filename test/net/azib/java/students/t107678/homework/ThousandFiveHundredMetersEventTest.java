package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThousandFiveHundredMetersEventTest {

    ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(30.1);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(3050,thousandFiveHundredMetersEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(30.1, thousandFiveHundredMetersEvent.getPerformance(),0);

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("ThousandFiveHundredMeters", thousandFiveHundredMetersEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("sec",thousandFiveHundredMetersEvent.getEventUnits());

    }
}
