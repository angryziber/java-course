package net.azib.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * SetLearning
 *
 * @author anton
 */
public class CollectionLearning {
	public static void main(String[] args) {
		List<String> c = new ArrayList(Arrays.asList(new String[] {"a", "b", "z", "x", "z"}));
		List<String> c2 = Collections.unmodifiableList(c);
		c2.add("m");
		
		String s = (String) c.get(0);
		
		System.out.println(c.lastIndexOf("z"));
		
		for (Object e : c) {
			System.out.println(e);
		}
		
		Map<String, String> map = new HashMap(System.getProperties());
		for (Map.Entry<String, String> me : map.entrySet()) {
			System.out.println(me.getKey() + "=" + me.getValue());
		}
		
	}
}
