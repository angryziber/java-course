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
public class PigTest {

    Animal pig = new Pig("Piglet", 5, "pink");

    @Test
    public void makeNoiseTest() {
        assertEquals("Oink-Oink", pig.makeNoise());
    }

    @Test
    public void toStringTest() {
        String expected = "I'm pig named Piglet and I'm 5 years old. I'm pink";
        String actual = pig.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void waveTailTest() {
        assertEquals("I'm waving my pig's tail", pig.waveTail());
    }

}