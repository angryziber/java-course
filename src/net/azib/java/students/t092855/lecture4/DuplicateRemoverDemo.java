package net.azib.java.students.t092855.lecture4;


import java.util.Arrays;

public class DuplicateRemoverDemo {
	public static void main(String[] args) {
		String[] stringArray = {"Dog", "Cat", "Dog", "Alligator", "Parrot", "Alligator", "Dog"};
		System.out.println(Arrays.toString(stringArray));
		String[] uniqueStrings = new DuplicateRemoverImpl().removeDuplicateStrings(stringArray);
		System.out.println(Arrays.toString(uniqueStrings));
	}
}
