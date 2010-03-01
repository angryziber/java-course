package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * GenericsDemo
 *
 * @author anton
 */
public class BrokenGenericsDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("a", "b"));
		// list = Collections.checkedList(list, String.class);
		
		List list2 = list;
		list2.add(0, 10);		
		
		String s = list.get(0);
		System.out.println(s);
	}
}
