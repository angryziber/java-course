package net.azib.java.lessons.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * SetDemo
 *
 * @author anton
 */
public class SetDemo {
	public static void main(String[] args) {
		testSet(new HashSet<String>());
		testSet(new TreeSet<String>());
		testSet(new LinkedHashSet<String>());
	}

	private static void testSet(Set<String> c) {
		c.add("C");
		c.add("A");
		c.add("D");
		c.add("B");
		c.add("E");
				
		System.out.println(c.contains("A") ? "contains A" : "doesn't contain A");
		
		System.out.println(c.getClass().getSimpleName() + " has " + c.size() + " elements");
		for (Object o : c) {
			System.out.println(o);
		}
	}
}
