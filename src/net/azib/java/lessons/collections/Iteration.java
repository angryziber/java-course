package net.azib.java.lessons.collections;

import java.util.*;

public class Iteration {
	public static void main(String[] args) {
		demo(new HashSet());
		demo(new LinkedHashSet());
		demo(new TreeSet());
		demo(new TreeSet(new DescendingComparator()));
		demo(new LinkedList());
	}

	private static void demo(Collection c) {
		System.out.println(c.getClass().getSimpleName());
		c.add("C");
		c.add("A");
		c.add("B");
		c.add("D");
		c.add("A");

		Iterator iterator = c.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	private static class DescendingComparator implements Comparator<Comparable> {
		public int compare(Comparable o1, Comparable o2) {
			return -o1.compareTo(o2);
		}
	}
}
