package net.azib.java.lessons.collections;

import net.azib.java.lessons.basic.Dog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SetDemo
 *
 * @author anton
 */
public class SetDemo {
	public static void main(String[] args) {
		Set s1 = new HashSet();
		Set s2 = new TreeSet();
		Set s3 = new LinkedHashSet();
		List l1 = new ArrayList();
		List l2 = new LinkedList();
		
		fill(s1);
		fill(s2);
		fill(s3);
		fill(l1);
		fill(l2);
		
		l2.add("g");
		l2 = Collections.unmodifiableList(l2);
		// l2.add("h"); - can't do that!
		
		Set s = new HashSet();
		s.add(new Dog("Dog", 1));
		System.out.println(s.contains(new Dog("Dog", 1)));
	}

	private static void fill(Collection s) {
		s.add("d");
		s.add("e");
		s.add("a");
		s.add("d");
		s.add("b");
		s.add("e");
		s.add("e");
		s.add("f");
		System.out.println("size: " + s.size());
		System.out.println(s.getClass().getSimpleName() + ": " + s);
	}
}
