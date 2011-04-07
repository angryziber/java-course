package net.azib.java.students.t104540.hometask4;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateRemoverImpl implements DuplicateRemover{
	public String[] removeDuplicateStrings(String ... array){
		Set<String> set = new HashSet<String>(Arrays.asList(array));
		return  set.toArray(new String[set.size()]);
	}
}
