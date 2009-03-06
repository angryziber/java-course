/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.hometasks.lecture2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karl
 */
public class TurtleTest {

     Animal turtle = new Turtle("Turtle", 100, "grass");

    @Test
    public void makeNoiseTest() {
        assertEquals(null, turtle.makeNoise());
    }

    @Test
    public void toStringTest() {
        String expected = "I'm turtle named Turtle and I'm 100 years old. I eat grass";
        String actual = turtle.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void waveTailTest() {
        assertEquals("I'm waving my turtle's tail", turtle.waveTail());
    }

}