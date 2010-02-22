package net.azib.java.lessons.collections;

import java.util.Collection;
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
		testSet(new HashSet());
		testSet(new TreeSet());
		testSet(new LinkedHashSet());
	}

	private static void testSet(Set c) {
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
