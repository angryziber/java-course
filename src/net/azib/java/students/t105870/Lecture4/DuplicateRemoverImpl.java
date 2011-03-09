package net.azib.java.students.t105870.Lecture4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.*;

public class DuplicateRemoverImpl implements DuplicateRemover {

	public static void main(String[] args) {
        String[] array = {"auto", "kass", "lind", "linn", "kass", "auto", "lind", "lind", "loom"};
        DuplicateRemoverImpl duplicateRemover = new DuplicateRemoverImpl();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + Arrays.toString(duplicateRemover.removeDuplicateStrings(array)));
    }

    public DuplicateRemoverImpl() {
    }

    public String[] removeDuplicateStrings(String... array) {
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(array));
        String[] s = new String[set.size()];
        set.toArray(s);
        return s;
    }
}
