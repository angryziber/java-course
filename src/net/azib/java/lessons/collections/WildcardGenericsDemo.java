package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * WildcardGenericsDemo
 *
 * @author anton
 */
public class WildcardGenericsDemo {
	static void print(Collection<? extends Number> c) {
		for (Number o : c) {
			System.out.println(o);
		}
	}
	
	static void add5(Collection<? super Number> c) {
		c.add(5);
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		print(list);

		List<Object> list2 = new ArrayList<Object>();
		add5(list2);
	}
}
