package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HighJumpEventTest {


    HighJumpEvent highJumpEvent = new HighJumpEvent(120);

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(120, highJumpEvent.getPerformance(), 0);

    }

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(188, highJumpEvent.getPoints());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("HighJump", highJumpEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m", highJumpEvent.getEventUnits());

    }
}