package net.azib.java.lessons.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * CollectionsDemo
 *
 * @author anton
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		List<String> l = Arrays.asList("c", "d", "e");
		Collections.sort(l);
		
		Collection<String> c = l;

		for (String s : c) {
			System.out.print(s);
		}
		
		Map<Object, Object> m = new Properties();
		m.put("a", "c");
		m.get("a");
		
		List<Object> lo = null;
		List<String> ls = null;
		Collection<String> cs = null;
		cs = ls;
//		lo = ls; - forbidden
//		lo.add(5);
//		String s = ls.get(0);
	}
}
