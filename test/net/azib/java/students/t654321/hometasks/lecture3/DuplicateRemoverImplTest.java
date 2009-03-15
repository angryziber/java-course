/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture3;

import net.azib.java.lessons.collections.DuplicateRemover;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Karl
 */
public class DuplicateRemoverImplTest {

    DuplicateRemover remover;

    @Before
    public void init(){
        remover = new DuplicateRemoverImpl();
    }

    /**
     * Test of removeDuplicateStrings method, of class DuplicateRemoverImpl.
     */
    @Test
    public void testRemoveDuplicateStrings() {
        String[] initialString = {"I", "a", "1", "0", "1"};
        String[] referenceString = {"i", "a", "1", "0"};
        assertArrayEquals(referenceString, remover.removeDuplicateStrings(initialString));
    }

    @Test
    public void emptyInputArray() {
        String[] initialString = {};
        assertEquals(0, remover.removeDuplicateStrings(initialString).length);
    }

    @Test
    public void mixedCaseWords() {
        String[] initialString = {"I", "am", "very", "Very", "VERY", "tired"};
        String[] referenceString = {"i", "am", "very", "tired"};
        assertArrayEquals(referenceString, remover.removeDuplicateStrings(initialString));
    }
}