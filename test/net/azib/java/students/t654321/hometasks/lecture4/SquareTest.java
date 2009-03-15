/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karl
 */
public class SquareTest {

    double lenghtOfSide = 10;

    @Test
    public void creationWithNegativeInput() {
        lenghtOfSide = -1;
        try {
            Square square = new Square(lenghtOfSide);
            fail("exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Lenght of side cannot be negative!", e.getMessage());
        }
    }

    @Test
    public void areaCalculationWithCorrectInput() {
        double expectedArea = 100;
        assertEquals(expectedArea, new Square(lenghtOfSide).area(), 0.00001);
    }

    @Test
    public void areaCalculationWithZeroInput() {
        double expectedArea = 0;
        lenghtOfSide = 0;
        assertEquals(expectedArea, new Square(lenghtOfSide).area(), 0.00001);
    }

    @Test
    public void testEqualsAndHashCode() {
        int expectedHash = 249;
        assertEquals(new Square(lenghtOfSide), new Square(lenghtOfSide));
        assertEquals(expectedHash, new Square(lenghtOfSide).hashCode(),0);
    }

    @Test
    public void testToString() {
        assertEquals("This is square with side lenght 10.0", new Square(lenghtOfSide).toString());
    }

    @Test
    public void testCompareTo() {
        Square sq1 = new Square(10.00000000);
        Square sq2 = new Square(10.00000049);
        assertEquals(0, sq1.compareTo(sq2),0);
    }
}