package net.azib.java.students.t020648;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

public class DuplicateRemoverImpl implements DuplicateRemover{

		
	public String [] removeDuplicateStrings(String [] array){
		
		Set<String> set = new LinkedHashSet();
		set.addAll(Arrays.asList(array));	
		
		return (String [])set.toArray(new String [0]);
	}
}
