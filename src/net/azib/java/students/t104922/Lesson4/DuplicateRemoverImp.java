package net.azib.java.students.t104922.Lesson4;
import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateRemoverImp implements DuplicateRemover{
    public String[] removeDuplicateStrings(String... array) {
        HashSet set = new HashSet(Arrays.asList(array));
        String[] s = new String[set.size()];
        set.toArray(s);
        return s;
    }

    public static void main(String[] args) {
        String[] s = new String[] {"a", "a", "b", "b" };
        System.out.println("Before =" +Arrays.toString(s));
        DuplicateRemoverImp rem = new DuplicateRemoverImp();
        System.out.println("After =" +Arrays.toString(rem.removeDuplicateStrings(s)));

    }
}
