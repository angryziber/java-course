package net.azib.java.students.t104971.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class WordFrequencyCalculatorImplTest {
    @Test
    public void calculateFrequenciesOf() throws Exception {
        Map<String, Integer> map = new WordFrequencyCalculatorImpl().calculateFrequenciesOf("asd asd qwe qwe 123 qwe qwe");
        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
        Map.Entry<String, Integer> entry;

        assertEquals(3, map.size());

        entry = entries.next();
        assertEquals("123", entry.getKey());
        assertEquals(new Integer(1), entry.getValue());

        entry = entries.next();
        assertEquals("asd", entry.getKey());
        assertEquals(new Integer(2), entry.getValue());

        entry = entries.next();
        assertEquals("qwe", entry.getKey());
        assertEquals(new Integer(4), entry.getValue());
    }
}
