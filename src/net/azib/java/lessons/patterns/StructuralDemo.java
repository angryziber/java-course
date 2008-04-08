package net.azib.java.lessons.patterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * StructuralDemo
 *
 * @author anton
 */
public class StructuralDemo {
	public static void main(String[] args) {
		String[] source = new String[] {"a", "b", "c"};
		System.out.println(source[0]);

		// adapter (from array to List)
		List<String> sourceList = Arrays.asList(source);
		System.out.println(sourceList.get(0));
		// changing this
		source[0] = "z";
		// will affect this
		System.out.println(sourceList.get(0));
		
		// decorator: make existing list immutable
		sourceList = Collections.unmodifiableList(sourceList);
		System.out.println(sourceList.get(0));
		sourceList.set(0, "a");
	}
}
