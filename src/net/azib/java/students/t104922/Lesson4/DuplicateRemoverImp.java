package net.azib.java.students.t104922.Lesson4;
import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class DuplicateRemoverImp implements DuplicateRemover{
    public String[] removeDuplicateStrings(String... array) {
        HashSet set = new LinkedHashSet(Arrays.asList(array));
        return (String[]) set.toArray(new String[set.size()]);
    }

    public static void main(String[] args) {
        String[] s = new String[] {"a", "a", "b", "b" };
        System.out.println("Before =" +Arrays.toString(s));
        DuplicateRemoverImp rem = new DuplicateRemoverImp();
        System.out.println("After =" +Arrays.toString(rem.removeDuplicateStrings(s)));

    }
}
