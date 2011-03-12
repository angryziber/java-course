package net.azib.java.students.t107678.hw3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemoverImpl implements DuplicateRemover {

    public String[] removeDuplicateStrings(String[] array) {
        Set<String> noDupls = new LinkedHashSet<String>(Arrays.asList(array));
        return noDupls.toArray(new String[noDupls.size()]);
    }
}

