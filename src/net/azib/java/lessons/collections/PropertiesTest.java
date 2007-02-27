package net.azib.java.lessons.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

/**
 * PropertiesTest
 *
 * @author anton
 */
public class PropertiesTest {
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		
		Collection c = sysprops.keySet();
		for (Iterator i = c.iterator(); i.hasNext(); ) {
			Object key = i.next();
			System.out.println(key);
		}
		
		for (Object key : c) {
			System.out.println(key);
		}
	}
}
