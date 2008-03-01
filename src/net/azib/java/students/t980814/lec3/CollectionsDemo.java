package net.azib.java.students.t980814.lec3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * CollectionsDemo
 *
 * @author dell
 */
public class CollectionsDemo {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("123");
		c.add("abc");
		System.out.println(c.size());
		
		// Collection on Iterable
		// On implementeeritud meetod iterator()
		for (Object o : c) {
			System.out.println(o);
		}
		
		// Enne Java 1.5 oli kasutusel järgmine konstruktsioon itereerimiseks
		for (Iterator<String> i = c.iterator(); i.hasNext(); ) {
			Object o = i.next();
			System.out.println(o);
		}

		System.out.println("----------------------");
		
		Collection<String> c2 = new HashSet<String>();
		c2.add("123");
		c2.add("abc");
		c2.add("000");
		c2.add("qqq");
		c2.add("aa");
		c2.add("000");

		c2 = Collections.unmodifiableCollection(c2);
		
		for (Object o : c2) {
			System.out.println(o);
		} // Järjekord sõltub, millist Set-i kasutada HashSet, TreeSet, LinkedHashSet
	}
	
}
