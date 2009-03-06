/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.hometasks.lecture3;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karl
 */
public class WordFrequencyCalculatorImplTest {

    /**
     * Test of calculateFrequenciesOf method, of class WordFrequencyCalculatorImpl.
     */
    @Test
    public void longerText() {
        String text = "I am very very tired 2 2 2 1";
        Map expected = new TreeMap();
        expected.put("1",1);
        expected.put("2",3);
        expected.put("i",1);
        expected.put("am",1);
        expected.put("tired",1);
        expected.put("very",2);
        assertEquals(expected, new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text));
    }

    @Test
    public void mixedCaseWords() {
        String text = "Hello hello HELLO";
        Map expected = new TreeMap();
        expected.put("hello", 3);
        assertEquals(expected, new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text));
    }

    @Test
    public void moreThanOneWhitespaceSequentially() {
        String text = "Hello   world";
        Map expected = new TreeMap();
        expected.put("hello", 1);
        expected.put("world", 1);
        assertEquals(expected, new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text));
    }

    @Test
    public void emptyText() {
        String text = "";
        assertTrue(new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text).isEmpty());
    }
}