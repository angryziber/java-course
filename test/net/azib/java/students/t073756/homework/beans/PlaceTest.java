package net.azib.java.students.t073756.homework.beans;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: anton
 * Date: 4/19/11
 * Time: 10:00 PM
 */
public class PlaceTest {

    @Test
    public void testToString() throws Exception {
        Place p = new Place(1);
        assertEquals("1", p.toString());

        p.incrementEnd();
        assertEquals("1-2", p.toString());

        for (int i = 0; i < 10; i++) {
            p.incrementEnd();
        }
        assertEquals("1-12", p.toString());
    }
}
