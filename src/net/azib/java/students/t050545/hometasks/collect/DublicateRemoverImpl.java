package net.azib.java.students.t050545.hometasks.collect;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DublicateRemoverImpl
 *
 * @author libricon
 */
public class DublicateRemoverImpl implements DuplicateRemover {
	
	public String[] removeDuplicateStrings(String ... array){
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}
    
	
}
