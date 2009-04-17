package net.azib.java.lessons.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * CollectionsDemo
 *
 * @author anton
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		Collection c = new HashSet();
		Collection threadSafeC = Collections.synchronizedCollection(c);
		
		Collection concurrentReadC = new ConcurrentSkipListSet();
	}
}
