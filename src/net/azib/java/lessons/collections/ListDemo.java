package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * ListDemo
 *
 * @author anton
 */
public class ListDemo {
	public static void main(String[] args) {
		testList(new ArrayList());
		testList(new LinkedList());
	}
	
	private static void testList(List c) {
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
