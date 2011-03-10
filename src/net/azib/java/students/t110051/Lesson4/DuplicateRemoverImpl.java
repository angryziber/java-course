package net.azib.java.students.t110051.Lesson4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.sql.Array;
import java.util.*;

public class DuplicateRemoverImpl implements DuplicateRemover{

	public static void main(String[] args) {
		String [] original_array = new String[] {"A", "B", "a", "b", "5", "A", "A", "A", "5", "5", "a", "a"};

		System.out.print("Original array: ");

		for( String elem : original_array){
			System.out.print(elem + " ");
		}
		System.out.println("");

		DuplicateRemoverImpl remover = new DuplicateRemoverImpl();
		String[] modified_array = remover.removeDuplicateStrings(original_array);

		System.out.print("Modified array: ");

		for( String elem : modified_array){
			System.out.print( elem + " ");
		}

	}
	@Override
	public String[] removeDuplicateStrings(String... array) {
		SortedSet<String> temp = new TreeSet<String> ();
		for (String elem : array){
			temp.add(elem);
		}
		String[] size = new String[temp.size()]; //without size the array will have values "null" in it
		array =  temp.toArray(size);
		return array;
	}
}
