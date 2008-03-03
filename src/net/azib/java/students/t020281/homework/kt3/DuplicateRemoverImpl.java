package net.azib.java.students.t020281.homework.kt3;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * DuplicateRemoverImpl
 *
 * @author Trial
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	public String[] removeDuplicateStrings(String[] array) {
		// TODO Auto-generated method stub
		
		Set<String> mySet = new LinkedHashSet<String>(array.length);
		
		for (String a: array) {
			mySet.add(a);
		}
		
		String[] myArray = new String[mySet.size()];
		mySet.toArray(myArray);
		
		return myArray;
	}
	
	public static void main(String[] args) {
		
		String[] myStringArray = new String[] {
				"TTU" , "Rektor" , 
				"PLD" , "TTU", 
				"Java" ,  "Azib" , 
				"PLD" , "NET" , 
				"Rektor", "Azib"};
		
		DuplicateRemoverImpl myRemover = new DuplicateRemoverImpl();
		
	    for (String a: myRemover.removeDuplicateStrings(myStringArray)) {
	    	
	    	System.out.println(a);
	    }
		
	}
}
