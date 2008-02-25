package net.azib.java.students.t040771.lessons;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author t040771
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		System.out.println(prop);
		prop.setProperty("hello.string", "Hei");
		String osName = prop.getProperty("hello.string");
		System.out.println(osName);
	}
}
