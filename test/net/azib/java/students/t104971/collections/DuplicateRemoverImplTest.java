package net.azib.java.students.t104971.collections;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class DuplicateRemoverImplTest {
    @Test
    public void testRemoveDuplicateStrings() throws Exception {
        String[] strings = new DuplicateRemoverImpl().removeDuplicateStrings("FGH", "ABC", "ABC", "111", "FGH");
        assertEquals(3, strings.length);
        assertEquals("111", strings[0]);
        assertEquals("ABC", strings[1]);
        assertEquals("FGH", strings[2]);
    }
}
