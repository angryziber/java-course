package net.azib.java.students.t030633.lessons;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * CollectionsDemo
 * 
 * @author t030633
 */
public class CollectionsDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TreeSet, HashSet, LinkedHashSet
		Collection c = new LinkedHashSet();
		c.add("esimene");
		c.add("teine");
		c.add("kolmas");
		
		LinkedList l = new LinkedList();
		l.add("xzz");

		System.out.println("Elemente: " + c.size());

		for (Object o : c) {
			System.out.println(o);
		}

		// alternative way to do the same,
		// using interface Iterator
		// for (Iterator i = c.iterator(); i.hasNext();) {
		// Object o = i.next();
		// }
	}
}
