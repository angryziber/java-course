package net.azib.java.students.t072073.tasks;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * DuplicateRemoverImpl
 *
 * @author janika
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		return (String[]) new LinkedHashSet(Arrays.asList(array)).toArray(new String[0]);
	}

	public static void main(String[] args) {
		String [] arrayWithDuplicates = new String[]{
		   "Esimene",
		   "Teine",
		   "Kolmas",
		   "Esimene",
		   "Kolmas"
		};
		DuplicateRemoverImpl dupRemover = new DuplicateRemoverImpl();	
		String[] resultStrings = dupRemover.removeDuplicateStrings(arrayWithDuplicates);
		for(String s : resultStrings) {
			System.out.println(s);
		}
	}

}
