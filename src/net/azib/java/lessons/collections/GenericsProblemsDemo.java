package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericsProblemsDemo {

	public static void main(String[] args) {
		List list = new ArrayList();
		// list = Collections.checkedList(list, Integer.class);

		List<Integer> listOfIntegers = list;
		listOfIntegers.add(5);
		listOfIntegers.add(3);

		List<String> listOfStrings = list;
		listOfStrings.add("Hello");

		for (Integer i : listOfIntegers) {
			System.out.println(i);
		}

		List<Object> listOfObjects = new ArrayList<Object>();
		listOfObjects.add(new Date());
		listOfObjects.add(1234);

		// listOfStrings = listOfObjects;
		// String element1 = listOfStrings.get(0);
	}
}
