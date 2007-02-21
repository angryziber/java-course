package net.azib.java.students.t030636.third;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.LinkedList;
import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;


public class SetLearning {

	public static void main(String[] args) {
//		Set set = new HashSet();
//		Set set = new LinkedHashSet();
		List<Object> c = new ArrayList<Object>(Arrays.asList(new String[] {"a", "b", "z", "x", "z"}));
		c.add("a");
//		c.add("b");
//		c.add("z");
//		c.add("x");
//		c.add("z");
		System.out.println(c.lastIndexOf("z"));
		
		
		for (Object e : c) {
			System.out.println(e);
		}

	}

}
