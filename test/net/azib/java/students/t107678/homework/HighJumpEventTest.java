package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class HighJumpEventTest {


    HighJumpEvent highJumpEvent = new HighJumpEvent(120);

    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(120, highJumpEvent.getPerformance(), 0);

    }

    @Test
    public void getIncorrectPerformance () throws Exception{
        assertNotSame(100, highJumpEvent.getPerformance());
    }

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(188, highJumpEvent.getPoints());

    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(187, highJumpEvent.getPoints());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("HighJump", highJumpEvent.getEventName());
        assertNotSame("ExtreamlyHighJump", highJumpEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m", highJumpEvent.getEventUnits());
        assertNotSame("meters", highJumpEvent.getEventUnits());

    }
}