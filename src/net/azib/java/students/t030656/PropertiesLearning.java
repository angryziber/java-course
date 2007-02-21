package net.azib.java.students.t030656;

import java.util.Properties;

/**
 * PropertiesLearning
 *
 * @author t030656
 */
public class PropertiesLearning {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		
		for(Object key : System.getProperties().keySet()){
			System.out.println(key + "=" + sysprops.get(key));
		}
	}
}
