package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * CollectionsDemo
 *
 * @author anton
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		List c = new ArrayList();
		
		c.add("abc");
		c.add("123");
		c.add("765");
		c.add("765");
		c.add("000");
		
		c.add(1, "zzzz");
		
		System.out.println(c.size());
		
		for (Object o : c) {
			System.out.println(o);
		}
	}
}
