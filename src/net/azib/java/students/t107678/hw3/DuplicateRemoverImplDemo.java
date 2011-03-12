package net.azib.java.students.t107678.hw3;

import java.util.*;

public class DuplicateRemoverImplDemo {
    public static void main(String[] args) {
        String[] input = {"House", "Door", "Window", "House", "Roof", "Roof"};
        DuplicateRemoverImpl example = new DuplicateRemoverImpl();
        System.out.println(Arrays.toString(example.removeDuplicateStrings(input)));

    }
}
