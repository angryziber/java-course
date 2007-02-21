package net.azib.java.students.t030675;


import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

/**
 * PropertiesTest
 *
 * @author t030675
 */
public class PropertiesTest {
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		
		Collection c = sysprops.keySet();
		
		for (Iterator i = c.iterator(); i.hasNext();) {
			Object key = (Object) i.next();
			System.out.println(key);
		}
		
		
//		Sama:		
//		for (Object key : c) {
//			System.out.println(key);
//		}
	}
}
