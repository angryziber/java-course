package net.azib.java.students.t020632;

import java.util.Properties;

/**
 * PropertiesTest
 *
 * @author t020632
 */
public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		
		for(Object key : sysprops.keySet()){
			System.out.println(key + " = " + sysprops.get(key));
		}
	}

}
