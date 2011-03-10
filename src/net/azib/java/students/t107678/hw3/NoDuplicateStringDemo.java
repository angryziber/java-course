package net.azib.java.students.t107678.hw3;

import java.util.*;

public class NoDuplicateStringDemo {
    public static void main(String[] args) {
        String[] input = {"House", "Door", "Window", "House", "Roof", "Roof"};
        NoDuplicateString example = new NoDuplicateString();
        System.out.println(Arrays.toString(example.removeDuplicateStrings(input)));

    }
}
