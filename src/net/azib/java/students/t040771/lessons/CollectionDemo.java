package net.azib.java.students.t040771.lessons;

//import java.util.ArrayList;
import java.util.Collection;
//import java.util.HashSet;
import java.util.LinkedHashSet;
//import java.util.TreeSet;

/**
 * CollectionDemo
 *
 * @author t040771
 */
public class CollectionDemo {
public static void main(String[] args) {
	Collection<String> c = new LinkedHashSet<String>();
	c.add("abc");
	c.add("123");
	c.add("bde");
	System.out.println(c.size());
	
	for(Object o : c) {
		System.out.println(o);
	}
}
}
