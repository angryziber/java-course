package net.azib.java.lessons.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * GenericMethodDemo
 *
 * @author anton
 */
public class GenericMethodDemo {
	public static void main(String[] args) {
		Set<Integer> s = newHashSet();
	}

	private static <T> Set<T> newHashSet() {
		return new HashSet<T>();
	}
}
