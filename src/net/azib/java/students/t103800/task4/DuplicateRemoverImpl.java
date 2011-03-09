package net.azib.java.students.t103800.task4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * User: Jaan Aigro
 * Date: 9.03.11
 * Time: 10:39
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

    public static void main(String[] args) {
        String[] array = {"koer", "maja", "auto", "mojo", "maja", "mojo", "mojo", "koer", "auto"};
        DuplicateRemoverImpl dupremover = new DuplicateRemoverImpl();
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + Arrays.toString(dupremover.removeDuplicateStrings(array)));
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
