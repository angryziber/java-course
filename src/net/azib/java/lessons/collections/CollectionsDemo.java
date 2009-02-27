package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
		List l = Arrays.asList("c", "d", "e");
		Collections.sort(l);
		
		Collection c = l;

		for (Object object : c) {
			
		}
		
		Map m = new Properties();
		m.put("a", "c");
		m.get("a");
	}
}
