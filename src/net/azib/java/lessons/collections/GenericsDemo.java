package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsDemo {
	public static void printCollection(Collection<?> c) {
		for (Object o : c) {
			System.out.println(o);
		}
	}

	public static void addPI(Collection<? super Double> c) {
		c.add(Math.PI);
	}


	public static void main(String[] args) {
		String[] array = {"Hello"};
		String hello = array[0];

		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");

		printCollection(list);

//		addPI(list);
		addPI(new ArrayList<Object>());
		addPI(new ArrayList<Number>());
		addPI(new ArrayList<Double>());
//		addPI(new ArrayList<Integer>());
	}
}
