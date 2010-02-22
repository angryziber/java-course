package net.azib.java.lessons.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * CollectionDemo
 *
 * @author anton
 */
public class CollectionDemo {
	public static void main(String[] args) {
		Collection c = System.getProperties().entrySet();
		System.out.println("Size: " + c.size());
		
		Iterator i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
