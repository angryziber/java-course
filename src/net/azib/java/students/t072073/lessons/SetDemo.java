package net.azib.java.students.t072073.lessons;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * SetDemo
 *
 * @author janika
 * equals ja hashCode alati koos!!
 */
public class SetDemo {
	public static void main(String[] args) {
		Set s1 = new HashSet();
		Set s2 = new TreeSet();
		Set s3 = new LinkedHashSet();
		
		fill(s1);
		fill(s2);
		fill(s3);
	}
	
	private static void fill(Set s){
		s.add("a");
		s.add("b");
		s.add("e");
		s.add("f");
		s.add("g");
		s.add("e");
		s.add("e");
		s.add("s");
		s.add("k");
		System.out.println("size: " +  s.size());
		System.out.println(s.getClass().getSimpleName() + " = " + s);
		
	}
}
