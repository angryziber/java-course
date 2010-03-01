package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ListDemo
 *
 * @author anton
 */
public class ListDemo {
	public static void main(String[] args) {
		testList(new ArrayList<String>());
		testList(new LinkedList<String>());
	}
	
	private static void testList(List<String> c) {
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
