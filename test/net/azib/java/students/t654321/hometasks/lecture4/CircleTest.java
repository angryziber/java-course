/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karl
 */
public class CircleTest {

    @Test
    public void creationWithNegativeInput() {
        double radius = -1;
        try {
            Circle circle = new Circle(radius);
            fail("exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Radius cannot be negative!", e.getMessage());
        }
    }

    @Test
    public void areaCalculationWithCorrectInput() {
        double expectedArea = 314.1592653590;
        double radius = 10.0;
        assertEquals(expectedArea, new Circle(radius).area(), 0.00001);
    }

    @Test
    public void areaCalculationWithZeroInput() {
        double expectedArea = 0;
        double radius = 0;
        assertEquals(expectedArea, new Circle(radius).area(), 0.00001);
    }

    @Test
    public void testEqualsAndHashCode() {
        int expectedHash = 141;
        assertEquals(new Circle(10), new Circle(10));
        assertEquals(expectedHash, new Circle(10).hashCode(),0);
    }

    @Test
    public void testToString() {
        assertEquals("This is circle with radius 10.0", new Circle(10).toString());
    }

    @Test
    public void testCompareTo() {
        Circle c1 = new Circle(10.00000000);
        Circle c2 = new Circle(10.00000015);
        assertEquals(0, c1.compareTo(c2),0);
    }
}