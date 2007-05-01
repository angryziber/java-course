package net.azib.java.students.t020544;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

/**
 * PropertiesTest
 * 
 * @author Julija Kondratjeva
 */
public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		// for (Object key : sysprops.keySet()) {
		// System.out.println(key + "=" + sysprops.get(key));
		// }

		Collection c = sysprops.keySet();
		for (Iterator i = c.iterator(); i.hasNext();) {
			Object key = i.next();
			System.out.println(key);
		}
		//to zhe samoe
		for (Object key : c) {
			System.out.println(key);
		}
	}
}
