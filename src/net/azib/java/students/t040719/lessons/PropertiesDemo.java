package net.azib.java.students.t040719.lessons;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author t040719
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties props = System.getProperties();
		System.out.println(props);
		System.out.println(props.getProperty("os.name"));
	}
}
