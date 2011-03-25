package net.azib.java.students.t107675.hometask3;


import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.TreeSet;

public class DuplicateRemoverImpl implements DuplicateRemover{
	public static void main(String[] args) {
		String[] array = {"Sam","Rad","Sam","Samet","Deneme","deneme","Deneme","Samet","Try","try","Try","try"};
		System.out.println("Current array is: " + Arrays.toString(array));
		DuplicateRemoverImpl duplicateRemover = new DuplicateRemoverImpl();
		System.out.println("Removed array is: " + Arrays.toString(duplicateRemover.removeDuplicateStrings(array)));

	}


	public String[] removeDuplicateStrings(String... array) {
        TreeSet<String> set = new TreeSet<String>(Arrays.asList(array));
        String[] s = new String[set.size()];
        set.toArray(s);
        return s;}}