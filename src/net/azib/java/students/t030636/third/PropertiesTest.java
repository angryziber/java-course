package net.azib.java.students.t030636.third;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;


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
		
		Map<String, String> map = new HashMap(System.getProperties());
		for(Map.Entry<String, String> me : map.entrySet()){
			System.out.println(me.getKey() + " = " + me.getValue());
		}

	}

}
