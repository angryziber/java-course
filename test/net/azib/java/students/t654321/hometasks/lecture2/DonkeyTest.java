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
public class DonkeyTest {

    Animal donkey = new Donkey("Eeyore", 4, 60f, 1f);

    @Test
    public void makeNoiseTest() {
        assertEquals("Hee-Haw", donkey.makeNoise());
    }

    @Test
    public void toStringTest() {
        String expected = "I'm donkey named Eeyore and I'm 4 years old. Strategic parameters (weight,height): 60.0 , 1.0";
        String actual = donkey.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void waveTailTest() {
        assertEquals("I'm waving my donkey's tail", donkey.waveTail());
    }
}