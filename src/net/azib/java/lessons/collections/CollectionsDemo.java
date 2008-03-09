package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * CollectionsDemo
 *
 * @author anton
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("abc");
		c.add("123");
		c.add("765");
		c.add("765");
		c.add("000");
		
		List<String> l = (List<String>) c;
		l.add(1, "zzzz");
		
		System.out.println(c.size());
		
		for (Object o : c) {
			System.out.println(o);
		}
	}
}
