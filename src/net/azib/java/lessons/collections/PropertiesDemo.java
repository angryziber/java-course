package net.azib.java.lessons.collections;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author anton
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		System.out.println(properties.getProperty("hello.string"));
	}
}
