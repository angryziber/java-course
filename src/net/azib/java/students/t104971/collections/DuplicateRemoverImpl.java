package net.azib.java.students.t104971.collections;


import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.*;

/**
 * @author Jaroslav Judin
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

    /**
     * implemented TreeSet - collection is sorted in natural order (for String)
     * @param array - input data scope
     * @return - sorted array without duplicates
     */
    public String[] removeDuplicateStrings(String... array) {
        Set<String> elements = new TreeSet<String>();
        elements.addAll(Arrays.asList(array));
        return elements.toArray(new String[elements.size()]);
    }
}
