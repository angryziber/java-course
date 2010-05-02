package net.azib.java.lessons.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DecoratorDemo
 *
 * @author anton
 */
public class DecoratorDemo {
	public static void main(String[] args) {
		List list = new ArrayList();		
		list = Collections.unmodifiableList(list);
		list = Collections.synchronizedList(list);
	}
}
