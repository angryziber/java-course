package net.azib.java.students.t010687;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
/**
 * PropertiesTest
 *
 * @author t010687
 */
public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		Collection c = sysprops.keySet();	
		
		for (Object key : c) {
			System.out.println(key);
		}
		/*for (Iterator i = c.iterator();i.hasNext();) {
			Object key = i.next();
			System.out.println(key);	
		}*/
		/*Properties sysprops = System.getProperties();
		for (Object Key : sysprops.keySet()) {
			System.out.println(Key + "=" + sysprops.get(Key));
		}*/
	}

}
