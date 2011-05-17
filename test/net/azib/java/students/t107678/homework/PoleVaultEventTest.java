package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PoleVaultEventTest {

    PoleVaultEvent poleVaultEvent = new PoleVaultEvent(222.8);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(184,poleVaultEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(222.8,poleVaultEvent.getPerformance(),0);

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("PoleVault", poleVaultEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m",poleVaultEvent.getEventUnits());

    }
}
