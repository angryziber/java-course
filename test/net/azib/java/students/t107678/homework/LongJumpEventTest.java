package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LongJumpEventTest {

    LongJumpEvent longJumpEvent = new LongJumpEvent(264.0);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(28,longJumpEvent.getPoints());
    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(28.0, longJumpEvent.getPoints(),0);

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("LongJump", longJumpEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m",longJumpEvent.getEventUnits());

    }
}
