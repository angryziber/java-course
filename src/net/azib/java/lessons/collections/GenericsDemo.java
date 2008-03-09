package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.List;


/**
 * GenericsDemo
 *
 * @author anton
 */
public class GenericsDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		int s = list.get(0);
		
		System.out.println(s);
	}
}
