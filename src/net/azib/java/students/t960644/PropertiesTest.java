package net.azib.java.students.t960644;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

/**
 * PropertiesTest
 *
 * @author t960644
 */
public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(System.getProperties());
		//for (Object key: System.getProperties().keySet()){
			//System.out.println(key + "=" + System.getProperties().get(key));
		//}
		Properties sysprops = System.getProperties();
		Collection c = sysprops.keySet();
/*		for (Iterator i = c.iterator(); i.hasNext(); ){
			Object key = i.next();
			System.out.println(key);
		}*/
		
		for (Object key : c ) {
			System.out.println(key);			
		}
	}

}
