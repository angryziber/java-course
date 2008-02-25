package net.azib.java.students.t001370.lectures.lec3;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author t001370
 */
public class PropertiesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");
		System.out.println(osName);
		
		System.out.println(properties);
		
	}

}
