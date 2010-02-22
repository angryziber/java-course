package net.azib.java.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * HelpersDemo
 *
 * @author anton
 */
public class HelpersDemo {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("A");
		
		list = Collections.unmodifiableList(list);
		list.add("B");
		
		list = Arrays.asList("A", "B", "C");
	}
}
