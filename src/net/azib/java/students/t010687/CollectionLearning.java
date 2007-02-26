package net.azib.java.students.t010687;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Remover
 *
 * @author t010687
 */
public class CollectionLearning {
	
	public static void main(String[] args) {
	Collection col = new ArrayList(Arrays.asList (new String[] {"a","b","c"}));
	col.add("x");
	//System.out.println(col);
	;
	
	Map<String,String> map = new HashMap (System.getProperties());
	
	for (Map.Entry<String, String> me: map.entrySet()){
		System.out.println(me.getKey());
	}
	}
	

}
